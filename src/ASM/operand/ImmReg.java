package ASM.operand;

import IR.entity.*;

public class ImmReg extends Reg {
    int value;
    
    public ImmReg(int value) {
        this.value = value;
    }

    public ImmReg(IRConst c) {
        if (c instanceof IRIntConst) 
            this.value = ((IRIntConst) c).value;
        else if (c instanceof IRBoolConst) 
            this.value = ((IRBoolConst) c).value ? 1 : 0;
        else this.value = 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
