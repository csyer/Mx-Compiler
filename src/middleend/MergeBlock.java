package middleend;

import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRFunction;
import IR.IRProgram;
import IR.entity.IREntity;
import IR.inst.IRInst;
import IR.inst.IRJumpInst;
import IR.inst.IRPhiInst;

public class MergeBlock {
    IRProgram prog;

    public MergeBlock(IRProgram prog) {
        this.prog = prog;
    }

    IRFunction curFunc;
    public void work() {
        prog.funcDefs.forEach(func -> {
            curFunc = func;
            combineList(func);
            removeJumpBlock(func);
            LinkedList<IRBasicBlock> blockList = new LinkedList<>();
            for (int i = 0; i < func.blocks.size(); i++) {
                IRBasicBlock block = func.blocks.get(i);
                if (!block.preds.isEmpty() || block == func.entryBlock)
                    blockList.add(block);
                else {
                    for (var succ : block.succs)
                        succ.preds.remove(block);
                }
            }
            func.blocks = blockList;
        });
    }

    void combineList(IRFunction func) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (var node : func.blocks) {
                if (node.succs.size() == 1) {
                    IRBasicBlock suc = node.succs.getFirst();
                    if (suc.preds.size() != 1) continue;
                    flag = true;
                    node.succs = suc.succs;
                    node.terminal = suc.terminal;
                    suc.insts.forEach(inst -> node.insts.add(inst));
                    suc.succs.forEach(s -> {
                        s.insts.forEach(i -> {
                            if (i instanceof IRPhiInst phi) {
                                for (int k = 0; k < phi.labels.size(); k++)
                                    if (phi.labels.get(k).equals(suc.name))
                                        phi.labels.set(k, node.name);
                            }
                        });
                    });
                    func.blocks.remove(suc);
                    node.succs.forEach(succ -> simplifyPhi(succ));
                    break;
                }
            }
        }
    }

    void removeJumpBlock(IRFunction func) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (var node : func.blocks) {
                if (node.preds.isEmpty()) continue;
                if (node.insts.isEmpty() && node.terminal instanceof IRJumpInst j) {
                    IRBasicBlock to = j.to;
                    boolean tag = false;
                    for (var pred : node.preds)
                        if (pred.succs.contains(to)) {
                            tag = true;
                            break;
                        }
                    if (tag) continue;
                    flag = true;
                    node.preds.forEach(pred -> {
                        pred.terminal.replace(node, to);
                        pred.succs.remove(node);
                        pred.succs.add(to);
                        to.preds.add(pred);
                    });
                    to.preds.remove(node);
                    to.insts.forEach(inst -> {
                        if (inst instanceof IRPhiInst phi) {
                            IREntity value = null;
                            for (int i = 0; i < phi.labels.size(); i++)
                                if (phi.labels.get(i).equals(node.name)) {
                                    phi.labels.remove(i);
                                    value = phi.values.get(i);
                                    phi.values.remove(i);
                                }
                            for (var pred : node.preds)
                                phi.addLabel(value, pred.name);
                        }
                    });
                    func.blocks.remove(node);
                    simplifyPhi(to);
                    break;
                }
            }
        }
    }

    void simplifyPhi(IRBasicBlock block) {
        boolean[] isDeleted = new boolean[block.insts.size()];
        for (int i = 0; i < block.insts.size(); i++) {
            isDeleted[i] = false;
            if (block.insts.get(i) instanceof IRPhiInst phi) {
                IREntity val = phi.values.get(0);
                boolean flag = true;
                for (int j = 1; j < phi.values.size(); ++j)
                    if (!phi.values.get(j).equals(val)) {
                        flag = false;
                        break;
                    }
                if (flag) {
                    isDeleted[i] = true;
                    curFunc.blocks.forEach(b -> {
                        b.insts.forEach(inst -> inst.renameUse(phi.dest, val));
                        b.phiInsts.forEach(inst -> inst.renameUse(phi.dest, val));
                        b.terminal.renameUse(phi.dest, val);
                    });
                }
            }
        };
        LinkedList<IRInst> newInsts = new LinkedList<>();
        for (int i = 0; i < block.insts.size(); i++)
            if (!isDeleted[i]) newInsts.add(block.insts.get(i));
        block.insts = newInsts;
    }
}
