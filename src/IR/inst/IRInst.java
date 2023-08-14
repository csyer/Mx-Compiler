package IR.inst;

import IR.IRBasicBlock;

public abstract class IRInst {
    public IRBasicBlock parentBlock = null;

    public IRInst(IRBasicBlock parentBlock) {
        this.parentBlock = parentBlock;
    }

    public abstract String toString();
}
