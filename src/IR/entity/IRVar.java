package IR.entity;

import IR.type.IRType;

public abstract class IRVar extends IREntity {
    public String name;

    public IRVar(IRType type, String name) {
        super(type);
        this.name = name;
    }
}
