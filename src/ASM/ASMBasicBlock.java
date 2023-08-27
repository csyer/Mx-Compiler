package ASM;

import java.util.LinkedList;

import ASM.inst.ASMInst;

public class ASMBasicBlock {
    public String name;
    public LinkedList<ASMInst> insts = new LinkedList<ASMInst>();

    public ASMBasicBlock(String name) {
        this.name = name;;
    }

    public void addInst(ASMInst inst) {
        insts.add(inst);
    }

    public String toString() {
        String res = name + ":\n";
        for (var inst : insts) 
            res += "    " + inst;
        return res;
    }
}
