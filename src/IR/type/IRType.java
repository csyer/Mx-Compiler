package IR.type;

import IR.entity.IRConst;
import utils.BuiltinElements;

public abstract class IRType implements BuiltinElements {
    public String name;
    public int size;

    public IRType(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String toString() {
        return name;
    }

    public abstract IRConst defaultValue();
}
