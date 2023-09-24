package IR.inst;

import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;

public abstract class IRInst {
    public IRBasicBlock parentBlock = null;

    public IRInst(IRBasicBlock parentBlock) {
        this.parentBlock = parentBlock;
    }

    public abstract String toString();
    public abstract void accept(IRVisitor visitor);

    public abstract LinkedList<IREntity> getUse();
    public abstract IRVar getDef();
    public abstract void renameUse(IREntity ori, IREntity lat);
}
