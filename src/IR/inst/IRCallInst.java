package IR.inst;

import java.util.ArrayList;
import java.util.LinkedList;

import IR.IRBasicBlock;
import IR.IRVisitor;
import IR.entity.IREntity;
import IR.entity.IRVar;
import IR.type.IRType;

public class IRCallInst extends IRInst {
    public IRVar dest;
    public IRType returnType;
    public String funcName;
    public ArrayList<IREntity> args = new ArrayList<IREntity>();

    public IRCallInst(IRBasicBlock block, IRVar dest, IRType returnType, String funcName) {
        super(block);
        this.dest = dest;
        this.returnType = returnType;
        this.funcName = funcName;
    }

    public void addArg(IREntity arg) {
        args.add(arg);
    }
    
    public String toString() {
        String res = (dest != null ? dest + " = call " : "call ") + returnType + " @" + funcName + "(";
        for (int i = 0; i < args.size(); i++) {
            if (i != 0) res += ", ";
            IREntity arg = args.get(i);
            res += arg.type + " " + arg;
        }
        res += ")";
        return res;
    }

    @Override
    public LinkedList<IREntity> getUse() {
        return new LinkedList<>() {
            {
                for (var arg : args)
                    add(arg);
            }
        };
    }
    @Override
    public IRVar getDef() {
        return dest;
    }
    @Override
    public void renameUse(IREntity ori, IREntity lat) {
        for (int i = 0; i < args.size(); i++)
          if (args.get(i) == ori)
            args.set(i, lat);
    }

    @Override 
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
