package ASM.operand;

import IR.entity.*;

public class GlobalVar extends Global {
    public int word;
    public GlobalVar(IRGlobalVar var) {
        super(var.name);
        if (var.initial instanceof IRIntConst) {
            word = ((IRIntConst) var.initial).value;
        } else if (var.initial instanceof IRBoolConst) {
            word = ((IRBoolConst) var.initial).value ? 1 : 0;
        } else if (var.initial instanceof IRNullConst) {
            word = 0;
        } else {
            throw new Error("GlobalVar: " + var.initial);
        }
    }

    @Override
    public String toString() {
        return "    .globl " + name + "\n" + name + ":\n" + "    .word " + word + "\n";
    }
}
