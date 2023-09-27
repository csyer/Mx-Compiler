package ASM;

import java.util.ArrayList;

import ASM.operand.GlobalString;
import ASM.operand.GlobalVar;

public class ASMProgram {
    public ArrayList<ASMFunction> funcDefs = new ArrayList<ASMFunction>();
    public ArrayList<GlobalVar> gVars = new ArrayList<GlobalVar>();
    public ArrayList<GlobalString> gStrings = new ArrayList<GlobalString>();

    public String toString() {
        String res = "    .section text\n";
        for (var def : funcDefs)
            res += def;
        if (gVars.size() > 0)
            res += "\n    .section data\n";
        for (var gVar : gVars)
            res += gVar.declare();
        if (gStrings.size() > 0)
            res += "\n    .section rodata\n";
        for (var gStr : gStrings)
            res += gStr.declare();
        return res;
    }
}
