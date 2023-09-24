package IR.inst;

import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;
import IR.type.IRType;

public class IRAllocaInst extends IRInst {
    public IRVar dest;
    public IRType type;

    public int param_idx = -1;

    public IRAllocaInst(IRBasicBlock block, IRVar dest, IRType type) {
        super(block);
        this.dest = dest;
        this.type = type;
    }
    public IRAllocaInst(IRBasicBlock block, IRVar dest, IRType type, int param_idx) {
        this(block, dest, type);
        this.param_idx = param_idx;
    }

    @Override
    public String toString() {
        return dest + " = alloca " + type;
    }

    @Override
    public LinkedList<IREntity> getUse() {
        return new LinkedList<>();
    }
    @Override
    public IRVar getDef() {
        return dest;
    }
    @Override
    public void renameUse(IREntity ori, IREntity lat) {}

    @Override 
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
