package IR.type;

import java.util.ArrayList;
import java.util.HashMap;

import IR.entity.IRConst;
import IR.entity.IRNullConst;

public class IRClassType extends IRType {
    public ArrayList<IRType> types = new ArrayList<IRType>();
    public HashMap<String, Integer> memberIdx = new HashMap<>();

    public IRClassType(String name) {
        super("%class." + name, 0);
    }

    public void calcSize() {
        for (var type : types) 
            size += type.size;
    }

    public String declare() {
        String res = name + " = type <{ ";
        for (int i = 0; i < types.size(); i++) {
            if (i != 0) res += ", ";
            res += types.get(i);
        }
        res += " }>";
        return res;
    }
    
    public String natureName() { 
        return name.substring(7);
    }

    @Override
    public IRConst defaultValue() {
        return new IRNullConst(this);
    }
}
