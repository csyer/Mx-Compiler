package IR.inst;

import IR.IRBasicBlock;

public abstract class IRTerminalInst extends IRInst {
    public IRTerminalInst(IRBasicBlock block) {
        super(block);
    }

    public abstract void replace(IRBasicBlock ori, IRBasicBlock lat);
}
