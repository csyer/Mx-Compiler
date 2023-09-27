package backend;

import java.util.HashMap;

import ASM.*;
import ASM.inst.*;
import ASM.operand.*;
import IR.*;
import IR.entity.*;
import IR.inst.*;
import IR.type.IRClassType;
import IR.type.IRPtrType;
import utils.BuiltinElements;

public class InstSelector implements IRVisitor, BuiltinElements {
    ASMProgram prog;

    ASMFunction currentFunc;
    ASMBasicBlock currentBlock;

    HashMap<String, ASMBasicBlock> blockMap = new HashMap<>();

    int funcCnt = 0;

    public InstSelector(ASMProgram prog) {
        this.prog = prog;
    }

    Reg getReg(IREntity entity) {
        if (entity.asmReg == null) {
            if (entity instanceof IRConst c) {
                if (c instanceof IRIntConst && ((IRIntConst) c).value == 0)
                    entity.asmReg = BaseReg.regMap.get("zero");
                else if (c instanceof IRBoolConst && !((IRBoolConst) c).value)
                    entity.asmReg = BaseReg.regMap.get("zero");
                else {
                    Reg reg = new MemReg(4);
                    currentBlock.addInst(new ASMLiInst(reg, new ImmReg(c)));
                    return reg;
                }
            }
            else if (entity instanceof IRVar)
                entity.asmReg = new MemReg(4);
        } else if (entity.asmReg instanceof Global) {
            MemReg reg = new MemReg(4);
            String name = ((Global) entity.asmReg).name;
            currentBlock.addInst(new ASMLuiInst(reg, new RelocationFunc("hi", name)));
            currentBlock.addInst(new ASMCalcImmInst("addi", reg, reg, new RelocationFunc("lo", name)));
            return reg;
        }
        return entity.asmReg;
    }
    void storeMem(Reg value, Reg dest, int offset) { // M[dest + offset] = value
        currentBlock.addInst(new ASMStoreInst(value, dest, new Imm(offset)));
    }
    void loadMem(Reg dest, Reg src, int offset) { // dest = M[src + offset]
        currentBlock.addInst(new ASMLoadInst(dest, src, new Imm(offset)));
    }

    public void visit(IRProgram node) {
        node.gVars.forEach(gVar -> {
            gVar.asmReg = new GlobalVar(gVar);
            prog.gVars.add((GlobalVar) gVar.asmReg);
        });
        node.strConsts.values().forEach(gStr -> {
            gStr.asmReg = new GlobalString(".L.str." + String.valueOf(gStr.idx), gStr.value);
            prog.gStrings.add((GlobalString) gStr.asmReg);
        });
        node.funcDefs.forEach(func -> {
            currentFunc = new ASMFunction(func.name);
            prog.funcDefs.add(currentFunc);
            func.accept(this);
        });
    }

    public void visit(IRBasicBlock node) {
        node.insts.forEach(inst -> {
            inst.accept(this);
        });
        node.terminal.accept(this);
    }

    public void visit(IRFunction node) {
        blockMap.clear();
        MemReg.cnt = 0;

        int argNum = 0, blockCnt = 0;
        for (var block : node.blocks) {
            blockMap.put(block.name, new ASMBasicBlock(".LBB" + String.valueOf(funcCnt) + "_" + String.valueOf(blockCnt++)));
            for (var inst : block.insts) {
                if (inst instanceof IRCallInst call)
                    argNum = Math.max(argNum, call.args.size());
            };
        }
        currentFunc.paramSize = Math.max(argNum - 8, 0) * 4;

        for (int i = 0; i < node.params.size() && i < 8; i++)
            node.params.get(i).asmReg = new MemReg(node.params.get(i).type.size);

        for (int i = 0; i < node.blocks.size(); i++) {
            currentBlock = blockMap.get(node.blocks.get(i).name);
            if (i == 0)
                storeMem(BaseReg.regMap.get("ra"), BaseReg.regMap.get("sp"), currentFunc.paramSize);
            node.blocks.get(i).accept(this);
            currentFunc.blocks.add(currentBlock);
        }
        ASMBasicBlock entryBlock = currentFunc.blocks.get(0),
                      returnBlock = currentFunc.blocks.get(currentFunc.blocks.size() - 1);
        for (int i = 0; i < node.params.size() && i < 8; i++)
            entryBlock.insts.addFirst(new ASMMvInst(node.params.get(i).asmReg, BaseReg.regMap.get("a" + i)));

        if (!node.name.equals("main"))
            for (var reg : BaseReg.calleeSave) {
                MemReg storeReg = new MemReg(4);
                entryBlock.insts.addFirst(new ASMMvInst(storeReg, reg));
                returnBlock.insts.addLast(new ASMMvInst(reg, storeReg));
            }

        currentFunc.stackSize = currentFunc.spillSize + currentFunc.paramSize + currentFunc.allocaSize + MemReg.cnt * 4;
        currentFunc.stackSize = (currentFunc.stackSize / 16 + 1) * 16;

        entryBlock.insts.addFirst(new ASMCalcImmInst("addi", BaseReg.regMap.get("sp"), BaseReg.regMap.get("sp"), new Imm(-currentFunc.stackSize)));
        returnBlock.addInst(new ASMCalcImmInst("addi", BaseReg.regMap.get("sp"), BaseReg.regMap.get("sp"), new Imm(currentFunc.stackSize)));
        returnBlock.addInst(new ASMRetInst());

        currentFunc.entryBlock = entryBlock;
        currentFunc.returnBlock = returnBlock;

        for (var block : currentFunc.blocks) {
            block.insts.addAll(block.phiInsts);
            block.insts.addAll(block.jumpInsts);
        }

        funcCnt++;
    }

    public void visit(IRAllocaInst node) {
        currentBlock.addInst(new ASMCalcImmInst("addi", getReg(node.dest), BaseReg.regMap.get("sp"), new Imm(currentFunc.paramSize + currentFunc.allocaSize)));
        currentFunc.allocaSize += 4;
    }

    public void visit(IRBranchInst node) {
        currentBlock.addInst(new ASMBranchInst("beq", getReg(node.cond), BaseReg.regMap.get("zero"), blockMap.get(node.iffalse.name)));
        currentBlock.addInst(new ASMJumpInst(blockMap.get(node.iftrue.name)));

        currentBlock.succs.add(blockMap.get(node.iftrue.name));
        blockMap.get(node.iftrue.name).preds.add(currentBlock);
        currentBlock.succs.add(blockMap.get(node.iffalse.name));
        blockMap.get(node.iffalse.name).preds.add(currentBlock);
    }

    public void visit(IRCalcInst node) {
        String op = "null";
        switch(node.op) {
            case "and": op = "and"; break;
            case "or": op = "or"; break;
            case "xor": op = "xor"; break;
            case "add": op = "add"; break;
            case "sub": op = "sub"; break;
            case "mul": op = "mul"; break;
            case "sdiv": op = "div"; break;
            case "srem": op = "rem"; break;
            case "shl": op = "sll"; break;
            case "ashr": op = "sra"; break;
        }
        currentBlock.addInst(new ASMCalcInst(op, getReg(node.dest), getReg(node.lhs), getReg(node.rhs)));
    }

    public void visit(IRCallInst node) {
        ASMCallInst call = new ASMCallInst(node.funcName);
        for (int i = 0; i < node.args.size(); i++) {
            IREntity arg = node.args.get(i);
            if (i < 8) {
                currentBlock.addInst(new ASMMvInst(BaseReg.regMap.get("a" + i), getReg(arg)));
                call.add(BaseReg.regMap.get("a" + i));
            } else storeMem(getReg(arg), BaseReg.regMap.get("sp"), (i - 8) * 4);
        }
        currentBlock.addInst(call);
        if (node.dest != null)
            currentBlock.addInst(new ASMMvInst(getReg(node.dest), BaseReg.regMap.get("a0")));
    }

    public void visit(IRGetElementPtrInst node) {
        Reg idx;
        if (((IRPtrType) node.ptr.type).type instanceof IRClassType) 
            idx = getReg(node.list.get(1));
        else idx = getReg(node.list.get(0));
        MemReg tmp = new MemReg(4);
        currentBlock.addInst(new ASMCalcImmInst("slli", tmp, idx, new Imm(2)));
        currentBlock.addInst(new ASMCalcInst("add", getReg(node.dest), getReg(node.ptr), tmp));
    }

    public void visit(IRIcmpInst node) {
        MemReg tmp = new MemReg(4);
        switch (node.cond) {
            case "eq":
                currentBlock.addInst(new ASMCalcInst("sub", tmp, getReg(node.lhs), getReg(node.rhs)));
                currentBlock.addInst(new ASMCmpzInst("seqz", getReg(node.dest), tmp));
                break;
            case "ne":
                currentBlock.addInst(new ASMCalcInst("sub", tmp, getReg(node.lhs), getReg(node.rhs)));
                currentBlock.addInst(new ASMCmpzInst("snez", getReg(node.dest), tmp));
                break;
            case "slt":
                currentBlock.addInst(new ASMCalcInst("slt", getReg(node.dest), getReg(node.lhs), getReg(node.rhs)));
                break;
            case "sgt":
                currentBlock.addInst(new ASMCalcInst("slt", getReg(node.dest), getReg(node.rhs), getReg(node.lhs)));
                break;
            case "sle":
                currentBlock.addInst(new ASMCalcInst("slt", tmp, getReg(node.rhs), getReg(node.lhs)));
                currentBlock.addInst(new ASMCmpzInst("seqz", getReg(node.dest), tmp));
                break;
            case "sge":
                currentBlock.addInst(new ASMCalcInst("slt", tmp, getReg(node.lhs), getReg(node.rhs)));
                currentBlock.addInst(new ASMCmpzInst("seqz", getReg(node.dest), tmp));
                break;
        }
    }

    public void visit(IRJumpInst node) {
        currentBlock.addInst(new ASMJumpInst(blockMap.get(node.to.name)));
        currentBlock.succs.add(blockMap.get(node.to.name));
        blockMap.get(node.to.name).preds.add(currentBlock);
    }

    public void visit(IRLoadInst node) {
        loadMem(getReg(node.var), getReg(node.ptr), 0);
    }

    public void visit(IRRetInst node) {
        if (node.value != irVoidConst)
            currentBlock.addInst(new ASMMvInst(BaseReg.regMap.get("a0"), getReg(node.value)));
        loadMem(BaseReg.regMap.get("ra"), BaseReg.regMap.get("sp"), currentFunc.paramSize);
    }

    public void visit(IRStoreInst node) {
        storeMem(getReg(node.value), getReg(node.ptr), 0);
    }

    public void visit(IRPhiInst node) {
        MemReg tmp = new MemReg(node.dest.type.size);
        ASMBasicBlock block = currentBlock;
        currentBlock.addInst(new ASMMvInst(getReg(node.dest), tmp));
        for (int i = 0; i < node.values.size(); ++i) {
            IREntity val = node.values.get(i);
            currentBlock = blockMap.get(node.labels.get(i));
            if (val instanceof IRConst && !(val instanceof IRStringConst))
                blockMap.get(node.labels.get(i)).phiInsts.add(new ASMLiInst(tmp, new ImmReg((IRConst) val)));
            else blockMap.get(node.labels.get(i)).phiInsts.add(new ASMMvInst(tmp, getReg(val)));
        }
        currentBlock = block;
    }

}
