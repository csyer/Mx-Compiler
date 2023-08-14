package IR;

import java.util.ArrayList;

import IR.entity.IRVar;
import IR.type.IRType;

public class IRFunction {
    public String name;
    public IRType returnType;
    public ArrayList<IRVar> params = new ArrayList<IRVar>();
    public ArrayList<IRBasicBlock> blocks = new ArrayList<IRBasicBlock>();

    public IRFunction(IRType returnType, String name) {
        this.returnType = returnType;
        this.name = name;
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
