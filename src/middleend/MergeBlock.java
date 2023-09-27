package middleend;

import java.util.HashSet;
import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRProgram;

public class MergeBlock {
    IRProgram prog;

    public MergeBlock(IRProgram prog) {
        this.prog = prog;
    }

    public void work() {
        prog.funcDefs.forEach(func -> {
            solve(func.entryBlock);
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

    HashSet<IRBasicBlock> visit = new HashSet<>();
    void solve(IRBasicBlock node) {
        visit.add(node);
        if (node.preds.size() == 1) {
            IRBasicBlock pre = node.preds.get(0);
            if (pre.succs.size() == 1) {
                // System.err.println(node.name);
                for (var inst : node.insts) 
                    pre.insts.add(inst);
                pre.succs = node.succs;
                pre.terminal = node.terminal;
                for (var block : node.succs) {
                    for (var phi : block.phiInsts) {
                        for (int i = 0; i < phi.labels.size(); i++)
                            if (phi.labels.get(i).equals(node.name))
                                phi.labels.set(i, pre.name);
                    }
                }
                node.preds.clear();
                node.succs.clear();
                node = pre;
            }
        }
        for (var block : node.succs)
            if (!visit.contains(block)) 
                solve(block);
    }
}
