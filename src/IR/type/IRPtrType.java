package IR.type;

public class IRPtrType extends IRType {
    public IRType type;
    public IRPtrType(IRType type) {
        super("ptr", 4);
        this.type = type;
    }
}
