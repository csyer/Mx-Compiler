package ASM.inst;

import ASM.operand.Reg;

public class ASMCalcInst extends ASMInst {
    public String op;

    public ASMCalcInst(String op, Reg rd, Reg rs1, Reg rs2) {
        this.op = op;
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
    }

    @Override
    public String toString() {
        return op + " " + rd + ", " + rs1 + ", " + rs2 + "\n";
    }
}
