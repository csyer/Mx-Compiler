package ASM;

import java.util.ArrayList;

public class ASMFunction {
    public String name;
    public ArrayList<ASMBasicBlock> blocks = new ArrayList<ASMBasicBlock>();

    public int stackSize = 0, 
               paramSize = 0, 
               allocaSize = 4;

    public ASMFunction(String name) {
        this.name = name;
    }

    public String toString() {
        String res = "    .globl " + name + "\n";
        res += "    .type " + name + ",@function\n";
        res += name + ":\n";
        for (var block : blocks) 
            res += block;
        return res;
    }
}
