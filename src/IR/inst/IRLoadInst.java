package IR.inst;

import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;
import IR.type.IRType;

public class IRLoadInst extends IRInst {
    public IRType type;
    public IRVar var;
    public IREntity ptr;

    public IRLoadInst(IRBasicBlock block, IRVar var, IREntity ptr) {
        super(block);
        this.var = var;
        this.ptr = ptr;
        this.type = var.type;
    }

    @Override
    public String toString() {
        return var + " = load " + type + ", " + ptr.type + " " + ptr;
    }

    @Override
    public LinkedList<IREntity> getUse() {
        return new LinkedList<>() {
            {
                add(ptr);
            }
        };
    }
    @Override
    public IRVar getDef() {
        return var;
    }
    @Override
    public void renameUse(IREntity ori, IREntity lat) {
        if (ptr == ori) ptr = lat;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
