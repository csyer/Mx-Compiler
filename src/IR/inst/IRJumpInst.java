package IR.inst;

import IR.IRBasicBlock;

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
}
