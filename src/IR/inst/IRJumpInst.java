package IR.inst;

import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;

public class IRJumpInst extends IRTerminalInst {
    public IRBasicBlock to;

    public IRJumpInst(IRBasicBlock block, IRBasicBlock to) {
        super(block);
        this.to = to;
    }

    @Override
    public void replace(IRBasicBlock ori, IRBasicBlock lat) {
        if (to == ori) to = lat;
    }

    @Override
    public String toString() {
        return "br label %" + to.name;
    }

    @Override
    public LinkedList<IREntity> getUse() {
        return new LinkedList<>();
    }
    @Override
    public IRVar getDef() {
        return null;
    }
    @Override
    public void renameUse(IREntity ori, IREntity lat) {
    }

    @Override 
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
