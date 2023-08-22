package IR.inst;

import java.util.ArrayList;

import IR.IRBasicBlock;
import IR.entity.IREntity;
import IR.entity.IRVar;
import IR.type.IRPtrType;

public class IRGetElementPtrInst extends IRInst {
    public IRVar dest;
    public IREntity ptr;
    public ArrayList<IREntity> list = new ArrayList<IREntity>();

    public IRGetElementPtrInst(IRBasicBlock block, IRVar dest, IREntity ptr) {
        super(block);
        this.dest = dest;
        this.ptr = ptr;
    }

    public void addIdx(IREntity idx) {
        list.add(idx);
    }

    @Override
    public String toString() {
        String res = dest + " = getelementptr " + ((IRPtrType) ptr.type).type + ", " + ptr.type + " " + ptr;
        for (var idx : list) 
            res += ", " + idx.type + " " + idx;
        return res;
    }
}