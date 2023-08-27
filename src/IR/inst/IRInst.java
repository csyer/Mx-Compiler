package IR.inst;

import IR.IRBasicBlock;
import IR.IRVisitor;

public abstract class IRInst {
    public IRBasicBlock parentBlock = null;

    public IRInst(IRBasicBlock parentBlock) {
        this.parentBlock = parentBlock;
    }

    public abstract String toString();
    public abstract void accept(IRVisitor visitor);
}
