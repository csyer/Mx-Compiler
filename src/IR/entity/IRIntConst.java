package IR.entity;

import IR.type.IRIntType;

public class IRIntConst extends IRConst {
    public int value;

    public IRIntConst(int value) {
        super(new IRIntType(32));
        this.value = value;
    }

    @Override 
    public String toString() {
        return String.valueOf(value);
    }
}
