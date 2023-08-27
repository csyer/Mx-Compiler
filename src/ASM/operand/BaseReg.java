package ASM.operand;

import java.util.HashMap;

public class BaseReg extends Reg {
    public String name;
    public static HashMap<String, BaseReg> regMap = new HashMap<>() {
        {
            put("zero", new BaseReg("zero"));
            put("ra", new BaseReg("ra"));
            put("sp", new BaseReg("sp"));
            put("t0", new BaseReg("t0"));
            put("t1", new BaseReg("t1"));
            put("t2", new BaseReg("t2"));
            put("t3", new BaseReg("t3"));
            put("t4", new BaseReg("t4"));
            put("t5", new BaseReg("t5"));
            put("t6", new BaseReg("t6"));
            put("a0", new BaseReg("a0"));
            put("a1", new BaseReg("a1"));
            put("a2", new BaseReg("a2"));
            put("a3", new BaseReg("a3"));
            put("a4", new BaseReg("a4"));
            put("a5", new BaseReg("a5"));
            put("a6", new BaseReg("a6"));
            put("a7", new BaseReg("a7"));
        }
    };

    public BaseReg(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
