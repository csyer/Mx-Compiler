package IR.entity;

public class IRStringConst extends IRConst {
    public String value;
    public int idx;
    static int cnt = 0;

    public IRStringConst(String value) {
        super(irStringtType);
        this.value = value;
        this.idx = cnt++;
    }

    public String printStr() {
        String ret = "";
        for (int i = 0; i < value.length(); ++i) {
          char c = value.charAt(i);
          switch (c) {
            case '\n': ret += "\\0A"; break;
            case '\"': ret += "\\22"; break;
            case '\\': ret += "\\\\"; break;
            default: ret += c;
          }
        }
        return ret + "\\00";
      }

    @Override 
    public String toString() {
        return "@.str." + String.valueOf(idx);
    }
}
