package middleend;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import IR.*;
import IR.entity.*;
import IR.inst.*;
import IR.type.IRPtrType;

public class Mem2Reg {
    IRProgram prog;

    LinkedHashSet<IRVar> removeAllocas = new LinkedHashSet<>();
    HashMap<IRVar, HashSet<IRBasicBlock>> RegDefs = new HashMap<>();
    HashMap<IRVar, IREntity> updateMap = new HashMap<>();
    HashMap<IREntity, HashSet<IRInst>> useMap = new HashMap<>();

    public Mem2Reg(IRProgram prog) {
        this.prog = prog;
    }

    public void work() {
        new DomTreeBuilder(prog).work();
        prog.funcDefs.forEach(func -> build(func));
    }

    IRFunction curFunc = null;

    void build(IRFunction func) {
        curFunc = func;
        collectUses();
        collectAllocas();
        for (var alloca : removeAllocas)
            addPhiInst(alloca);
        updateMap.clear();
        renameVar(func.entryBlock);
        new MergeBlock(prog).work();
        simplifyPhi(func.entryBlock);
    }

    void collectUses() {
        for (var block : curFunc.blocks) {
            for (var inst : block.insts) {
                for (var use : inst.getUse()) {
                    if (useMap.get(use) == null) 
                        useMap.put(use, new HashSet<IRInst>());
                    useMap.get(use).add(inst);
                }
            }
            for (var use : block.terminal.getUse()) {
                if (useMap.get(use) == null) 
                    useMap.put(use, new HashSet<IRInst>());
                useMap.get(use).add(block.terminal);
            }
        }
    }

    boolean allocaRemovable(IRAllocaInst inst) {
        if (inst.param_idx >= 8)
            return false;
        IRVar reg = inst.dest;
        for (var block : curFunc.blocks) {
            for (var ins : block.insts) {
                if (!(ins instanceof IRStoreInst) && !(ins instanceof IRLoadInst) && ins.getUse().contains(reg))
                    return false;
                if (ins instanceof IRStoreInst && reg == ((IRStoreInst) ins).ptr)
                    RegDefs.get(reg).add(block);
            }
        }
        return true;
    }

    void collectAllocas() {
        for (var inst : curFunc.allocaInsts) {
            IRVar reg = inst.dest;
            RegDefs.put(reg, new HashSet<>());
            if (allocaRemovable(inst))
                removeAllocas.add(inst.dest);
        }
    }

    void addPhiInst(IRVar reg) {
        HashSet<IRBasicBlock> visit = new HashSet<>();
        HashSet<IRBasicBlock> inQueue = new HashSet<>(RegDefs.get(reg));
        LinkedList<IRBasicBlock> queue = new LinkedList<>(inQueue);
        while (!queue.isEmpty()) {
            IRBasicBlock block = queue.removeFirst();
            inQueue.remove(block);
            // System.err.println(block.name);
            for (var frontier : block.domFrontier) {
                if (!visit.contains(frontier)) {
                    // System.err.println("  " + frontier.name);
                    IRPhiInst phi = new IRPhiInst(frontier, new IRLocalVar(((IRPtrType) reg.type).type, ""));
                    phi.src = reg;
                    frontier.addInst(phi);
                    visit.add(frontier);
                    if (!inQueue.contains(frontier)) {
                        queue.add(frontier);
                        inQueue.add(frontier);
                    }
                }
            }
        }
    }

    void renameVar(IRBasicBlock block) {
        HashMap<IRVar, IREntity> historyMap = new HashMap<>(updateMap);
        LinkedList<IRInst> newInsts = new LinkedList<>();
        for (var inst : block.phiInsts)
            updateMap.put(inst.src, inst.dest);
        for (int i = 0; i < block.insts.size(); i++) {
            var inst = block.insts.get(i);
            if (inst instanceof IRAllocaInst && removeAllocas.contains(((IRAllocaInst) inst).dest))
                continue;
            if (inst instanceof IRLoadInst && removeAllocas.contains(((IRLoadInst) inst).ptr)) {
                IRLoadInst loadInst = (IRLoadInst) inst;
                if (useMap.get(loadInst.var) != null) {
                    for (var ins : useMap.get(loadInst.var))
                        ins.renameUse(loadInst.var, updateMap.get(loadInst.ptr));
                }
            } else if (inst instanceof IRStoreInst && removeAllocas.contains(((IRStoreInst) inst).ptr)) {
                IRStoreInst storeInst = (IRStoreInst) inst;
                updateMap.put(storeInst.ptr, storeInst.value);
            } else {
                newInsts.add(inst);
            }
        }
        block.insts = newInsts;

        block.succs.forEach(succ -> {
            succ.phiInsts.forEach(phi -> phi.addLabel(updateMap.get(phi.src), block.name));
        });

        block.domChildren.forEach(child -> renameVar(child));
        updateMap = historyMap;
    }

    void simplifyPhi(IRBasicBlock block) {
        boolean[] isDeleted = new boolean[block.phiInsts.size()];
        for (int i = 0; i < block.phiInsts.size(); i++) {
            isDeleted[i] = false;
            IRPhiInst phi = block.phiInsts.get(i);
            IREntity val = phi.values.get(0);
            boolean flag = true;
            for (int j = 1; j < phi.values.size(); ++j)
                if (phi.values.get(j) != val) {
                    flag = false;
                    break;
                }
            if (flag) {
                isDeleted[i] = true;
                block.insts.forEach(inst -> inst.renameUse(phi.dest, val));
            }
        };
        for (int i = block.phiInsts.size() - 1; i >= 0; i--)
            if (!isDeleted[i]) block.insts.addFirst(block.phiInsts.get(i));
        block.domChildren.forEach(child -> simplifyPhi(child));
    }
}
