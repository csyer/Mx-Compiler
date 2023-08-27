package ASM.inst;

import ASM.operand.Imm;
import ASM.operand.Reg;

public class ASMLoadInst extends ASMInst {
    public ASMLoadInst(Reg rd, Reg rs1, Imm imm) {
        this.rd = rd;
        this.rs1 = rs1;
        this.imm = imm;
    }

    @Override
    public String toString() {
        return "lw " + rd + ", " + imm + "(" + rs1 + ")\n";
    }
}
