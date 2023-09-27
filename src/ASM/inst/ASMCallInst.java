package ASM.inst;

import java.util.HashSet;

import ASM.operand.BaseReg;
import ASM.operand.Reg;

public class ASMCallInst extends ASMInst {
    String symbol;
    HashSet<Reg> uses = new HashSet<>();
    static HashSet<Reg> defs = new HashSet<>(BaseReg.callerSave);

    public ASMCallInst(String symbol) {
        this.symbol = symbol;
    }
    
    public void add(Reg arg) {
        uses.add(arg);
    }

    @Override
    public HashSet<Reg> use() {
        return uses;
    }
    @Override
    public HashSet<Reg> def() {
        return defs;
    }

    @Override
    public String toString() {
        return "call " + symbol + "\n";
    }
}
