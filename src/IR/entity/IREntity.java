package IR.entity;

import IR.type.IRType;
import utils.BuiltinElements;

public abstract class IREntity implements BuiltinElements {
    public IRType type;

    IREntity(IRType type) {
        this.type = type;
    }

    public abstract String toString();
}
