package ASM.inst;

import ASM.operand.Reg;

public class ASMMvInst extends ASMInst {
    public ASMMvInst(Reg rd, Reg rs1) {
        this.rd = rd;
        this.rs1 = rs1;
    }

    @Override
    public String toString() {
        return "mv " + rd + ", " + rs1 + "\n";
    }
}
