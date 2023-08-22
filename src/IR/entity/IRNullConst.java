package IR.entity;

import IR.type.IRPtrType;
import IR.type.IRType;
import IR.type.IRVoidType;

public class IRNullConst extends IRConst {
    public IRType nullType;

    public IRNullConst() {
        super(new IRPtrType(new IRVoidType()));
    }
    public IRNullConst(IRType type) {
        super(type);
    }
    
    @Override
    public String toString() {
        return "null";
    }
}
