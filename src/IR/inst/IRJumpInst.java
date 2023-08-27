package IR.inst;

import IR.IRBasicBlock;
import IR.IRVisitor;

public class IRJumpInst extends IRTerminalInst {
    public IRBasicBlock to;

    public IRJumpInst(IRBasicBlock block, IRBasicBlock to) {
        super(block);
        this.to = to;
    }

    @Override
    public String toString() {
        return "br label %" + to.name;
    }

    @Override 
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
