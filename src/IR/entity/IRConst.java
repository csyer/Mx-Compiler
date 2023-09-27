package IR.entity;

import IR.type.IRType;

public abstract class IRConst extends IREntity {
    public IRConst(IRType type) {
        super(type);
    }

    public abstract boolean equals(Object obj);
}
