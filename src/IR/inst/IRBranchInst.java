package IR.inst;

import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;

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

    @Override
    public LinkedList<IREntity> getUse() {
        return new LinkedList<>() {
            {
                add(cond);
            }
        };
    }
    @Override
    public IRVar getDef() {
        return null;
    }
    @Override
    public void renameUse(IREntity ori, IREntity lat) {
        if (cond == ori) cond = lat;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
