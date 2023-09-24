package ASM;

import java.util.LinkedList;

import ASM.inst.*;

public class ASMBasicBlock {
    public String name;
    public LinkedList<ASMInst> insts = new LinkedList<ASMInst>();

    public LinkedList<ASMInst> phiInsts = new LinkedList<ASMInst>();
    public LinkedList<ASMInst> jumpInsts = new LinkedList<ASMInst>();

    public ASMBasicBlock(String name) {
        this.name = name;;
    }

    public void addInst(ASMInst inst) {
        if (inst instanceof ASMJumpInst || inst instanceof ASMRetInst) 
            jumpInsts.add(inst);
        else insts.add(inst);
    }

    public String toString() {
        String res = name + ":\n";
        for (var inst : insts) 
            res += "    " + inst;
        return res;
    }
}
