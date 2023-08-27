package ASM.operand;

public class Imm extends Operand {
    public int value;

    public Imm(int value) {
        this.value = value;
    }
    public Imm(ImmReg reg) {
        this.value = reg.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
