package IR.inst;

import java.util.ArrayList;

import IR.IRBasicBlock;
import IR.entity.IREntity;
import IR.entity.IRVar;

public class IRPhiInst extends IRInst {
    public IRVar dest;
    public ArrayList<IREntity> values = new ArrayList<IREntity>();
    public ArrayList<String> labels = new ArrayList<String>();

    public IRPhiInst(IRBasicBlock block, IRVar dest) {
        super(block);
        this.dest = dest;
    }

    public void addLabel(IREntity value, String label) {
        values.add(value);
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
}
