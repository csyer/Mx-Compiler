package ASM.inst;

import ASM.operand.Imm;
import ASM.operand.Reg;

public class ASMStoreInst extends ASMInst {
    public ASMStoreInst(Reg rs2, Reg rs1, Imm imm) {
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.imm = imm;
    }

    @Override
    public String toString() {
        return "sw " + rs2 + ", " + imm + "(" + rs1 + ")\n";
    }
    
}
