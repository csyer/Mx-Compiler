package IR;

import java.util.ArrayList;

import IR.inst.IRInst;

public class IRBasicBlock {
    public String name;
    public ArrayList<IRInst> insts = new ArrayList<IRInst>();

    public IRBasicBlock(String name) {
        this.name = name;
    }

    public String toString() {
        String res = name + ":\n";
        for (var inst : insts) 
            res += "  " + inst + "\n";
        return res;
    }
}
