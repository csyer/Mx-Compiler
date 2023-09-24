package middleend;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRFunction;
import IR.IRProgram;

public class DomTreeBuilder {
    IRProgram prog;

    public DomTreeBuilder(IRProgram prog) {
        this.prog = prog;
    }

    public void work() {
        prog.funcDefs.forEach(func -> build(func));
    }

    HashSet<IRBasicBlock> visit = new HashSet<>();
    HashMap<IRBasicBlock, Integer> order = new HashMap<>();
    LinkedList<IRBasicBlock> blockSeq = new LinkedList<>();

    void getOrder(IRBasicBlock block) {
        visit.add(block);
        block.succs.forEach(succ -> {
            if (!visit.contains(succ))
                getOrder(succ);
        });
        order.put(block, blockSeq.size());
        blockSeq.addFirst(block);
    }

    void build(IRFunction func) {
        blockSeq.clear();
        order.clear();
        visit.clear();
        getOrder(func.entryBlock);
        func.entryBlock.idom = func.entryBlock;
        blockSeq.removeFirst();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (IRBasicBlock block : blockSeq) {
                IRBasicBlock newIdom = null;
                for (IRBasicBlock pred : block.preds)
                    if (newIdom == null)
                        newIdom = pred;
                    else if (pred.idom != null)
                        newIdom = intersect(pred, newIdom);
                if (newIdom != block.idom) {
                    block.idom = newIdom;
                    changed = true;
                }
            }
        }

        blockSeq.forEach(block -> block.idom.domChildren.add(block));

        blockSeq.addFirst(func.entryBlock);
        for (IRBasicBlock block : blockSeq) {
            if (block.preds.size() <= 1)
                continue;
            for (IRBasicBlock pred : block.preds) {
                IRBasicBlock runner = pred;
                while (runner != block.idom) {
                    runner.domFrontier.add(block);
                    runner = runner.idom;
                }
            }
        }
    }

    IRBasicBlock intersect(IRBasicBlock x, IRBasicBlock y) {
        while (x != y) {
            while (order.get(x) < order.get(y))
                x = x.idom;
            while (order.get(y) < order.get(x))
                y = y.idom;
        }
        return x;
    }
}
