package ASM.inst;

import ASM.operand.*;

public class ASMLuiInst extends ASMInst {
    public ASMLuiInst(Reg rd, Imm imm) {
        this.rd = rd;
        this.imm = imm;
    }

    @Override
    public String toString() {
        return "lui " + rd + ", " + imm + "\n";
    }
}
