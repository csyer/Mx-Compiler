package IR.inst;

import java.util.ArrayList;
import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;

public class IRPhiInst extends IRInst {
    public IRVar dest;
    public ArrayList<IREntity> values = new ArrayList<IREntity>();
    public ArrayList<String> labels = new ArrayList<String>();

    public IRVar src = null;
    public IRPhiInst(IRBasicBlock block, IRVar dest) {
        super(block);
        this.dest = dest;
    }

    public void addLabel(IREntity value, String label) {
        values.add(value == null ? dest.type.defaultValue() : value);
        labels.add(label);
    }

    @Override
    public String toString() {
        String res = dest + " = phi " + dest.type + " ";
        for (int i = 0; i < values.size(); i++) {
            if (i != 0) res += ", ";
            res += "[ " + values.get(i) + ", %" + labels.get(i) + " ]";
        }
        return res;
    }

    @Override
    public LinkedList<IREntity> getUse() {
        return new LinkedList<>() {
            {
                for (var value : values)
                    add(value);
            }
        };
    }
    @Override
    public IRVar getDef() {
        return dest;
    }
    @Override
    public void renameUse(IREntity ori, IREntity lat) {
        for (var value : values)
            if (value == ori) value = lat;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
