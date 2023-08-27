package ASM.inst;

import ASM.operand.*;

public class ASMLiInst extends ASMInst {
    public ASMLiInst(Reg rd, ImmReg imm) {
        this.rd = rd;
        this.imm = new Imm(imm);
    }

    @Override
    public String toString() {
        return "li " + rd + ", " + imm + "\n";
    }
}
