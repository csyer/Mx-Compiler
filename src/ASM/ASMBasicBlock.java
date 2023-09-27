package ASM;

import java.util.HashSet;
import java.util.LinkedList;

import ASM.inst.*;
import ASM.operand.Reg;

public class ASMBasicBlock {
    public String name;
    public LinkedList<ASMInst> insts = new LinkedList<ASMInst>();

    public LinkedList<ASMInst> phiInsts = new LinkedList<ASMInst>();
    public LinkedList<ASMInst> jumpInsts = new LinkedList<ASMInst>();
    
    public LinkedList<ASMBasicBlock> succs = new LinkedList<>(),
                                     preds = new LinkedList<>();

    public HashSet<Reg> liveIn = new HashSet<>(), liveOut = new HashSet<>();
    public HashSet<Reg> use = new HashSet<>(), def = new HashSet<>();


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
