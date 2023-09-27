package ASM.operand;

public class GlobalString extends Global {
    public String str;
  
    public GlobalString(String name, String str) {
        super(name);
        this.str = str;
    }
  
    public String declare() {
        return name + ":\n    .asciz \"" + str.replace("\\", "\\\\").replace("\n", "\\n").replace("\0", "").replace("\t", "\\t").replace("\"", "\\\"") + "\"\n";
    }   
}
