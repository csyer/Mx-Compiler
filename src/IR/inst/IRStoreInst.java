package IR.inst;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;

public class IRStoreInst extends IRInst {
    public IREntity value, ptr;

    public IRStoreInst(IRBasicBlock block, IREntity value, IREntity ptr) {
        super(block);
        this.value = value;
        this.ptr = ptr;
    }

    @Override
    public String toString() {
        return "store " + value.type + " " + value + ", ptr " + ptr;
    }

    @Override 
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
