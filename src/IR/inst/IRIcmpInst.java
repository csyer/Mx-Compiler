package IR.inst;

import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;

public class IRIcmpInst extends IRInst {
    public IRVar dest;
    public IREntity lhs, rhs;
    public String cond;
    
    public IRIcmpInst(IRBasicBlock block, String cond, IRVar dest, IREntity lhs, IREntity rhs) {
        super(block);
        this.dest = dest;
        this.cond = cond;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public String toString() {
        return dest + " = icmp " + cond + " " + lhs.type + " " + lhs + ", " + rhs;
    }

    @Override
    public LinkedList<IREntity> getUse() {
        return new LinkedList<>() {
            {
                add(lhs);
                add(rhs);
            }
        };
    }
    @Override
    public IRVar getDef() {
        return dest;
    }
    @Override
    public void renameUse(IREntity ori, IREntity lat) {
        if (lhs == ori) lhs = lat;
        if (rhs == ori) rhs = lat;
    }

    @Override 
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
