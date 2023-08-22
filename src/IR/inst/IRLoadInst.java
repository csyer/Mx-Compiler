package IR.inst;

import IR.IRBasicBlock;
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
}
