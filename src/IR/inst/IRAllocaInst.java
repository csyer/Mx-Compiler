package IR.inst;

import IR.IRBasicBlock;
import IR.entity.IRVar;
import IR.type.IRType;

public class IRAllocaInst extends IRInst {
    public IRVar dest;
    public IRType type;

    public IRAllocaInst(IRBasicBlock parentBlock, IRVar dest, IRType type) {
        super(parentBlock);
        this.dest = dest;
        this.type = type;
    }

    @Override
    public String toString() {
        return dest + " = alloca " + type;
    }
}
