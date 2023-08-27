package ASM.inst;

import ASM.operand.Imm;
import ASM.operand.Reg;

public class ASMCalcImmInst extends ASMInst {
    String op;

    public ASMCalcImmInst(String op, Reg rd, Reg rs1, Imm imm) {
        this.op = op;
        this.rd = rd;
        this.rs1 = rs1;
        this.imm = imm;
    }

    @Override
    public String toString() {
        return op + " " + rd + ", " + rs1 + ", " + imm + "\n";
    }
}
