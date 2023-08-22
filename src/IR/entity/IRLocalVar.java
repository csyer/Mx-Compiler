package IR.entity;

import IR.type.IRType;

public class IRLocalVar extends IRVar {
    public static int cnt = 0;

    public IRLocalVar(IRType type, String name) {
        super(type, name + "." + String.valueOf(cnt++));
    }

    @Override
    public String toString() {
        return "%" + name;
    }
}
