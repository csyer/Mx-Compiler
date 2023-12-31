package IR;

import java.util.LinkedList;

import IR.inst.IRAllocaInst;
import IR.inst.IRInst;
import IR.inst.IRPhiInst;
import IR.inst.IRTerminalInst;

public class IRBasicBlock {
    public String name;
    public LinkedList<IRInst> insts = new LinkedList<IRInst>();

    public IRTerminalInst terminal = null;
    public IRFunction currentFunc = null;
    public boolean isFinished = false;

    public LinkedList<IRBasicBlock> succs = new LinkedList<>(), preds = new LinkedList<>();
    public IRBasicBlock idom = null;
    public LinkedList<IRBasicBlock> domChildren = new LinkedList<>(),
                                    domFrontier = new LinkedList<>();

    public LinkedList<IRPhiInst> phiInsts = new LinkedList<>();

    public static int cnt = 0;

    public IRBasicBlock(IRFunction currentFunc, String name) {
        this.currentFunc = currentFunc;
        this.name = name + "." + String.valueOf(cnt++) ;
    }

    public void addInst(IRInst inst) {
        if (inst instanceof IRPhiInst) {
            phiInsts.add((IRPhiInst) inst);
        } else {
            if (isFinished) return;
            if (inst instanceof IRAllocaInst) {
                currentFunc.allocaInsts.add((IRAllocaInst) inst);
            } else if (inst instanceof IRTerminalInst) {
                terminal = (IRTerminalInst) inst;
            } else {
                insts.add(inst);
            }
        }
    }

    public String toString() {
        String res = name + ":\n";
        for (var inst : insts) 
            res += "  " + inst + "\n";
        if (terminal != null)
            res += "  " + terminal + "\n";
        return res;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
