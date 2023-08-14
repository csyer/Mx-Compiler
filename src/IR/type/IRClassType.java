package IR.type;

import java.util.ArrayList;

public class IRClassType extends IRType {
    public String name;
    public ArrayList<IRType> types;

    public IRClassType(String name) {
        super("%class." + name, 0);
        for (var type : types) {
            size += type.size;
        }
    }
}
