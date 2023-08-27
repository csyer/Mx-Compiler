package IR.entity;

public class IRStringConst extends IRConst {
    public String value;
    public int idx, length;
    static int cnt = 0;

    public IRStringConst(String value) {
        super(irStringtType);
        this.length = value.length();
        this.value = value ;
        this.idx = cnt++;
    }

    public String trans() {
        return value.replace("\\", "\\\\").replace("\n", "\\0A").replace("\"", "\\22") + "\\00";
    }

    @Override 
    public String toString() {
        return "@.str." + String.valueOf(idx);
    }
}
