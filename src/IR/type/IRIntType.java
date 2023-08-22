package IR.type;

import IR.entity.IRBoolConst;
import IR.entity.IRConst;
import IR.entity.IRIntConst;

public class IRIntType extends IRType {
    public IRIntType(int bit) {
        super("i" + String.valueOf(bit), (bit + 7) / 8);
    }

    @Override
    public IRConst defaultValue() {
        if (size == 4)
            return new IRIntConst(0);
        else return new IRBoolConst(false);
    }
}
