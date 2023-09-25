package IR.inst;

import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;

public class IRRetInst extends IRTerminalInst {
    public IREntity value;

    public IRRetInst(IRBasicBlock block, IREntity value) {
        super(block);
        this.value = value;
    }

    @Override
    public void replace(IRBasicBlock ori, IRBasicBlock lat) {}

    @Override
    public String toString() {
        return "ret " + value.type + " " + value;
    }

    @Override
    public LinkedList<IREntity> getUse() {
        return new LinkedList<>() {
            {
                add(value);
            }
        };
    }
    @Override
    public IRVar getDef() {
        return null;
    }
    @Override
    public void renameUse(IREntity ori, IREntity lat) {
        if (value == ori) value = lat;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
