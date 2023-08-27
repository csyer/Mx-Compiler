package IR.entity;

import ASM.operand.Reg;
import IR.type.IRType;
import utils.BuiltinElements;

public abstract class IREntity implements BuiltinElements {
    public IRType type;

    public Reg asmReg = null;

    IREntity(IRType type) {
        this.type = type;
    }

    public abstract String toString();
}
