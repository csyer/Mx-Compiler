package backend;

import java.util.LinkedList;

import ASM.*;
import ASM.inst.*;
import ASM.operand.*;

public class RegAllocator {
    ASMProgram prog;
    int stackSize, memBegin;
    LinkedList<ASMInst> workList;

    BaseReg reg_t0 = BaseReg.regMap.get("t0");
    BaseReg reg_t1 = BaseReg.regMap.get("t1");
    BaseReg reg_t2 = BaseReg.regMap.get("t2");
    BaseReg reg_sp = BaseReg.regMap.get("sp");

    public RegAllocator(ASMProgram prog) {
        this.prog = prog;
    }

    void reallocateSrc(BaseReg reg, Reg src) {
        if (src instanceof ImmReg imm) {
            workList.add(new ASMLiInst(reg, imm));
        } else if (src instanceof MemReg srcReg) {
            int offset, id = srcReg.id;
            if (id != -1)
                offset = memBegin + id * 4;
            else offset = stackSize + srcReg.param_idx * 4;
            workList.add(new ASMLoadInst(reg, reg_sp, new Imm(offset)));
        } else if (src instanceof Global) {
            String name = ((Global) src).name;
            workList.add(new ASMLuiInst(reg, new RelocationFunc("hi", name)));
            workList.add(new ASMCalcImmInst("addi", reg, reg, new RelocationFunc("lo", name)));
        }
    }
    void reallocateDest(BaseReg reg, Reg dest) {
        if (dest instanceof MemReg) {
            MemReg destReg = (MemReg) dest;
            int offset, id = destReg.id;
            if (id != -1)
                offset = memBegin + id * 4;
            else offset = stackSize + destReg.param_idx * 4;
            workList.add(new ASMStoreInst(reg, reg_sp, new Imm(offset)));
        }
    }

    void visitBlock(ASMBasicBlock block) {
        workList = new LinkedList<ASMInst>();
        for (var inst : block.insts) {
            if (inst.rs1 != null && !(inst.rs1 instanceof BaseReg)) {
                reallocateSrc(reg_t1, inst.rs1);
                inst.rs1 = reg_t1;
            }
            if (inst.rs2 != null && !(inst.rs2 instanceof BaseReg)) {
                reallocateSrc(reg_t0, inst.rs2);
                inst.rs2 = reg_t0;
            }
            workList.add(inst);
            if (inst.rd != null && !(inst.rd instanceof BaseReg)) {
                reallocateDest(reg_t0, inst.rd);
                inst.rd = reg_t0;
            }
        }
        block.insts = workList;
    }

    public void work() {
        for (var func : prog.funcDefs) {
            stackSize = func.stackSize;
            memBegin = func.paramSize + func.allocaSize;
            func.blocks.forEach(block -> {
                visitBlock(block);
            });
        }
    }
}
