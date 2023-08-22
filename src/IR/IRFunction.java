package IR;

import java.util.ArrayList;
import java.util.LinkedList;

import IR.entity.IRVar;
import IR.inst.IRAllocaInst;
import IR.type.IRType;

public class IRFunction {
    public String name;
    public IRType returnType;
    public IRVar returnAddr;
    public IRBasicBlock returnBlock;

    public ArrayList<IRVar> params = new ArrayList<IRVar>();
    public LinkedList<IRBasicBlock> blocks = new LinkedList<IRBasicBlock>();
    public ArrayList<IRAllocaInst> allocaInsts = new ArrayList<IRAllocaInst>();

    public IRFunction(IRType returnType, String name) {
        this.returnType = returnType;
        this.name = name;
    }

    public void finish() {
        IRBasicBlock entryBlock = blocks.getFirst();
        for (IRAllocaInst inst : allocaInsts)
            entryBlock.insts.addFirst(inst);
        blocks.add(returnBlock);
    }

    public String toString() {
        String res = "define " + returnType + " @" + name + "(";
        boolean comma = false;
        for (var param : params) {
            if (comma) res += ", ";
            comma = true;
            res += param.type + " " + param;
        }
        res += ") {\n";

        for (var block : blocks) 
            res += block;

        res += "}\n";

        return res;
    }
}
