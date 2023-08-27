package IR.type;

import IR.entity.IRBoolConst;
import IR.entity.IRConst;
import IR.entity.IRIntConst;

public class IRIntType extends IRType {
    boolean isBool = false;
    public IRIntType(int bit) {
        super("i" + String.valueOf(bit), 4);
        if (bit == 1) isBool = true;
    }

    @Override
    public IRConst defaultValue() {
        if (!isBool)
            return new IRIntConst(0);
        else return new IRBoolConst(false);
    }
}
