package IR.entity;

import IR.type.IRIntType;

public class IRBoolConst extends IRConst {
    public boolean value;

    public IRBoolConst(boolean value) {
        super(new IRIntType(8));
        this.value = value;
    }

    @Override
    public String toString() {
        return value ? "1" : "0";
    }
}
