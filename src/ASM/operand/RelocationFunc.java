package ASM.operand;

public class RelocationFunc extends Imm {
    public String type, symbol;

    public RelocationFunc(String type, String symbol) {
        super(0);
        this.type = type;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "%" + type +  "(" + symbol + ")";
    }
}