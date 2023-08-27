package ASM.inst;

import ASM.ASMBasicBlock;
import ASM.operand.Reg;

public class ASMBranchInst extends ASMJumpInst {
    public String op;
    public ASMBranchInst(String op, Reg rs1, Reg rs2, ASMBasicBlock toBlock) {
        super(toBlock);
        this.op = op;
        this.rs1 = rs1;
        this.rs2 = rs2;
    }

    @Override
    public String toString() {
        return op + " " + rs1 + ", " + rs2 + ", " + toBlock.name + "\n";
    }
}
