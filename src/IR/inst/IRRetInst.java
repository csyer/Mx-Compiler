package IR.inst;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;

public class IRRetInst extends IRTerminalInst {
    public IREntity value;

    public IRRetInst(IRBasicBlock block, IREntity value) {
        super(block);
        this.value = value;
    }

    @Override
    public String toString() {
        return "ret " + value.type + " " + value;
    }

    @Override 
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
