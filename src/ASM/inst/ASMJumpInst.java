package ASM.inst;

import ASM.ASMBasicBlock;

public class ASMJumpInst extends ASMInst {
    ASMBasicBlock toBlock;

    public ASMJumpInst(ASMBasicBlock toBlock) {
        this.toBlock = toBlock;
    }

    @Override
    public String toString() {
        return "j " + toBlock.name + "\n";
    }
}
