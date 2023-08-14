package IR.type;

public class IRArrayType extends IRType {
    public IRType type;
    public int length;

    public IRArrayType(IRType type, int length) {
        super("[ " + String.valueOf(length) + " x " + type.name + " ]", type.size * length);
        this.type = type;
        this.length = length;
    }
}
