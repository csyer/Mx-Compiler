package IR.entity;

import IR.type.IRPtrType;
import IR.type.IRVoidType;

public class IRNullConst extends IRConst {
    public IRNullConst() {
        super(new IRPtrType(new IRVoidType()));
    }
    
    @Override
    public String toString() {
        return "null";
    }
}
