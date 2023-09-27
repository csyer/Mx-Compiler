package backend;

import java.util.HashSet;
import java.util.LinkedList;

import ASM.ASMBasicBlock;
import ASM.ASMFunction;
import ASM.operand.Reg;

public class LivenessAnalyzer {
    ASMFunction func;

    public LivenessAnalyzer(ASMFunction func) {
        this.func = func;
        func.blocks.forEach(block -> {
            block.liveIn.clear();
            block.liveOut.clear();
            block.def.clear();
            block.use.clear();
        });

        func.blocks.forEach(block -> {
            block.insts.forEach(inst -> {
                HashSet<Reg> use = new HashSet<>(inst.use());
                use.removeAll(block.def);
                block.use.addAll(use);
                block.def.addAll(inst.def());
            });
        });
    }

    LinkedList<ASMBasicBlock> worklist = new LinkedList<>();
    HashSet<ASMBasicBlock> inWorklist = new HashSet<>();
    public void work() {
        worklist.clear();
        inWorklist.clear();

        worklist.add(func.returnBlock);
        inWorklist.add(func.returnBlock);
        while (!worklist.isEmpty()) {
            ASMBasicBlock node = worklist.removeFirst();
            inWorklist.remove(node);

            System.err.println(node.name);

            HashSet<Reg> in = new HashSet<>(),
                         out = new HashSet<>();
            node.succs.forEach(succ -> out.addAll(succ.liveIn));
            in.addAll(node.use);
            in.addAll(out);
            in.removeAll(node.def);

            for (var i : node.use) System.err.print(i + ", "); System.err.println("");
            for (var i : node.def) System.err.print(i + ", "); System.err.println("");

            if (!node.liveIn.equals(in) || !node.liveOut.equals(out)) {
                node.liveIn = in;
                node.liveOut = out;
                node.preds.forEach(pred -> {
                    if (!inWorklist.contains(pred)) {
                        System.err.println("BFS " + pred.name);
                        worklist.add(pred);
                        inWorklist.add(pred);
                    }
                });
            }
        }
    }
}
