package ASM.inst;

public class ASMCallInst extends ASMInst {
    String symbol;

    public ASMCallInst(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "call " + symbol + "\n";
    }
}
