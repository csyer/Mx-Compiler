package ASM.operand;

public class MemReg extends Reg {
    public int id = -1, param_idx = -1, size = 0;
    public static int cnt = 0;

    public MemReg(int size) {
        this.size = size;
        id = cnt++;
    }

    public MemReg(int size, int param_idx) {
        this.size = size;
        this.param_idx = param_idx - 8;
    }

    @Override
    public String toString() {
        return "";
    }
}
