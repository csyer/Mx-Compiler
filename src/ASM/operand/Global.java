package ASM.operand;

public abstract class Global extends Reg {
    public String name;
    public Global(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
