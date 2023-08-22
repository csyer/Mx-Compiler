package IR.inst;

import java.util.ArrayList;

import IR.IRBasicBlock;
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
}
