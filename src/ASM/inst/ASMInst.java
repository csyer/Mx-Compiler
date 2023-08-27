package ASM.inst;

import ASM.operand.*;

public abstract class ASMInst {
    public Reg rd, rs1, rs2;
    public Imm imm;
    public abstract String toString();
}
