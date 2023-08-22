package IR.type;

import IR.entity.IRConst;
import IR.entity.IRVoidConst;

public class IRVoidType extends IRType {
    public IRVoidType() {
        super("void", 0);
    }

    @Override
    public IRConst defaultValue() {
        return new IRVoidConst();
    }
}
