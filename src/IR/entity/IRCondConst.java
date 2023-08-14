package IR.entity;

import IR.type.IRIntType;

public class IRCondConst extends IRConst {
    public boolean value;

    public IRCondConst(boolean value) {
        super(new IRIntType(1));
        this.value = value;
    }

    @Override
    public String toString() {
        return value ? "true" : "false";
    }
}
