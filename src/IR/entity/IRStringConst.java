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
    public boolean equals(Object obj) {
        return (obj instanceof IRStringConst c) && c.value.equals(value);
    }

    @Override 
    public String toString() {
        return "@.str." + String.valueOf(idx);
    }
}
