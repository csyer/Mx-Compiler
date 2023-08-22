package IR.type;

import IR.entity.IRConst;
import IR.entity.IRNullConst;

public class IRPtrType extends IRType {
    public IRType type;
    public IRPtrType(IRType type) {
        super("ptr", 4);
        this.type = type;
    }
    
    public IRType baseType() {
        if (type instanceof IRPtrType)
            return ((IRPtrType) type).baseType();
        return type;
    }

    @Override
    public IRConst defaultValue() {
        return new IRNullConst();
    }
}
