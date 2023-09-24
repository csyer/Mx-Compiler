package IR.inst;

import java.util.ArrayList;
import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
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

    @Override
    public LinkedList<IREntity> getUse() {
        return new LinkedList<>() {
            {
                add(ptr);
                for (var idx : list)
                    add(idx);
            }
        };
    }
    @Override
    public IRVar getDef() {
        return dest;
    }
    @Override
    public void renameUse(IREntity ori, IREntity lat) {
        if (ptr == ori) ptr = lat;
        for (int i = 0; i < list.size(); i++)
          if (list.get(i) == ori)
            list.set(i, lat);
    }

    @Override 
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}