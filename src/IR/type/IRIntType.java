package IR.type;

public class IRIntType extends IRType {
    public int bit;

    public IRIntType(int bit) {
        super("i" + String.valueOf(bit), bit / 8);
        this.bit = bit;
    }
}
