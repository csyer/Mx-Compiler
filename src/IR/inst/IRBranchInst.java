package IR.inst;

import IR.IRBasicBlock;
import IR.entity.IREntity;

public class IRBranchInst extends IRTerminalInst {
    public IREntity cond;
    public IRBasicBlock iftrue, iffalse;

    public IRBranchInst(IRBasicBlock block, IREntity cond, IRBasicBlock iftrue, IRBasicBlock iffalse) {
        super(block);
        this.cond = cond;
        this.iftrue = iftrue;
        this.iffalse = iffalse;
    }

    @Override
    public String toString() {
        return "br " + cond.type + " " + cond + ", label %" + iftrue.name + ", label %" + iffalse.name;
    }
}
