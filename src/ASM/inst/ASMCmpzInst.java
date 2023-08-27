package ASM.inst;

import ASM.operand.Reg;

public class ASMCmpzInst extends ASMInst {
    public String op; // seqz snez sgtz sltz

    public ASMCmpzInst(String op, Reg rd, Reg rs1) {
        this.op = op;
        this.rd = rd;
        this.rs1 = rs1;
    }

    @Override
    public String toString() {
        return op + " " + rd + ", " + rs1 + "\n";
    }
}
