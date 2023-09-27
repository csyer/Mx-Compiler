package IR.entity;

import IR.type.IRIntType;

public class IRIntConst extends IRConst {
    public int value;

    public IRIntConst(int value) {
        super(new IRIntType(32));
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof IRIntConst c) && c.value == value;
    }

    @Override 
    public String toString() {
        return String.valueOf(value);
    }
}
