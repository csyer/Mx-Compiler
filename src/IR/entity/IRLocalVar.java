package IR.entity;

import IR.type.IRType;

public class IRLocalVar extends IRVar {
    public IRLocalVar(IRType type, String name) {
        super(type, name);
    }

    @Override
    public String toString() {
        return "%" + name;
    }
}
