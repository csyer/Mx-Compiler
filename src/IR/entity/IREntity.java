package IR.entity;

import IR.type.IRType;

public abstract class IREntity {
    public IRType type;

    IREntity(IRType type) {
        this.type = type;
    }

    public abstract String toString();
}
