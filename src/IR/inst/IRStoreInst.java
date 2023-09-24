package IR.inst;

import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;

public class IRStoreInst extends IRInst {
    public IREntity value;
    public IRVar ptr;
    int param_idx = -1;

    public IRStoreInst(IRBasicBlock block, IREntity value, IRVar ptr) {
        super(block);
        this.value = value;
        this.ptr = ptr;
    }
    public IRStoreInst(IRBasicBlock block, IREntity value, IRVar ptr, int param_idx) {
        this(block, value, ptr);
        this.param_idx = param_idx;
    }

    @Override
    public String toString() {
        return "store " + value.type + " " + value + ", ptr " + ptr;
    }

    @Override
    public LinkedList<IREntity> getUse() {
        return new LinkedList<>() {
            {
                add(value);
                add(ptr);
            }
        };
    }
    @Override
    public IRVar getDef() {
        return null;
    }
    @Override
    public void renameUse(IREntity ori, IREntity lat) {
        if (value == ori) value = lat;
        if (ptr == ori) ptr = (IRVar) lat;
    }

    @Override 
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
