package IR.inst;

import IR.IRBasicBlock;
import IR.entity.IRVar;
import IR.type.IRType;

public class IRAllocaInst extends IRInst {
    public IRVar var;
    public IRType type;

    public IRAllocaInst(IRBasicBlock parentBlock, IRVar var, IRType type) {
        super(parentBlock);
        this.var = var;
        this.type = type;
    }

    @Override
    public String toString() {
        return var + " = alloca " + type;
    }
}
