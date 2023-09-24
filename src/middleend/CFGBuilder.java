package middleend;

import java.util.LinkedList;

import IR.*;
import IR.inst.*;

public class CFGBuilder {
    IRProgram prog;
    public CFGBuilder(IRProgram prog) {
        this.prog = prog;
    }

    public void work() {
        prog.funcDefs.forEach(func -> build(func));
    }

    void build(IRFunction func) {
        func.blocks.forEach(block -> {
            if (block.terminal instanceof IRJumpInst) {
                IRBasicBlock nextBlock = ((IRJumpInst) block.terminal).to;
                block.succs.add(nextBlock);
                nextBlock.preds.add(block);
            } else if (block.terminal instanceof IRBranchInst)  {
                IRBasicBlock thenBlock = ((IRBranchInst) block.terminal).iftrue,
                             elseBlock = ((IRBranchInst) block.terminal).iffalse;
                block.succs.add(thenBlock);
                block.succs.add(elseBlock);
                thenBlock.preds.add(block);
                elseBlock.preds.add(block);
            }
        });

        LinkedList<IRBasicBlock> blockList = new LinkedList<>();
        for (var block : func.blocks) {
            if (!block.preds.isEmpty() || block == func.entryBlock)
                blockList.add(block);
            else {
                for (var succ : block.succs)
                    succ.preds.remove(block);
            }
        }
        func.blocks = blockList;
    }
}
