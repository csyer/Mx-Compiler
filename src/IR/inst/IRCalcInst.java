package IR.inst;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;

public class IRCalcInst extends IRInst {
    public IRVar dest;
    public IREntity lhs, rhs;
    public String op;

    public IRCalcInst(IRBasicBlock block, String op, IRVar dest, IREntity lhs, IREntity rhs) {
        super(block);
        this.op = op;
        this.dest = dest;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public String toString() {
        return dest + " = " + op + " " + lhs.type + " " + lhs + ", " + rhs;
    }

    @Override 
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
