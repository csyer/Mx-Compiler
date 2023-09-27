package IR.entity;

import IR.type.IRIntType;

public class IRBoolConst extends IRConst {
    public boolean value;

    public IRBoolConst(boolean value) {
        super(new IRIntType(1));
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof IRBoolConst c) && c.value == value;
    }

    @Override
    public String toString() {
        return value ? "true" : "false";
    }
}
