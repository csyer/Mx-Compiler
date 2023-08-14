package IR.entity;

import IR.type.IRType;

public class IRGlobalVar extends IRVar {
    public IREntity initial = null;
    public IRGlobalVar(IRType type, String name) {
        super(type, name);
    }
    public IRGlobalVar(IRType type, String name, IREntity initial) {
        super(type, name);
        this.initial = initial;
    }

    @Override
    public String toString() {
        return "@" + name;
    }
}
