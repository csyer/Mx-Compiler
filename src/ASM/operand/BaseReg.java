package ASM.operand;

import java.util.HashMap;
import java.util.HashSet;

public class BaseReg extends Reg {
    public String name;
    public int id = -1;
    public static HashMap<String, BaseReg> regMap = new HashMap<>() {
        {
            put("zero", new BaseReg("zero", 0));
            put("ra", new BaseReg("ra", 1));
            put("sp", new BaseReg("sp", 2));
            put("gp", new BaseReg("gp", 3));
            put("tp", new BaseReg("tp", 4));
            for (int i = 0; i < 3; i++) put("t" + i, new BaseReg("t" + i, i + 5));
            for (int i = 0; i < 2; i++) put("s" + i, new BaseReg("s" + i, i + 8));
            for (int i = 0; i < 8; i++) put("a" + i, new BaseReg("a" + i, i + 10));
            for (int i = 2; i < 12; i++) put("s" + i, new BaseReg("s" + i, i + 16));
            for (int i = 3; i < 7; i++) put("t" + i, new BaseReg("t" + i, i + 25));
        }
    };

    public BaseReg(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static HashSet<Reg> callerSave = new HashSet<>() {
        {
            add(regMap.get("ra"));
            for (int i = 0; i < 7; i++) add(regMap.get("t" + i));
            for (int i = 0; i < 8; i++) add(regMap.get("a" + i));
        }
    };
    public static HashSet<Reg> calleeSave = new HashSet<>() {
        {
            for (int i = 0; i < 12; i++) add(regMap.get("s" + i));
        }
    };
    public static HashMap<Integer, Reg> idReg = new HashMap<>() {
        {
            put(0, regMap.get("zero"));
            put(1, regMap.get("ra"));
            put(2, regMap.get("sp"));
            put(3, regMap.get("gp"));
            put(4, regMap.get("tp"));  
            for (int i = 0; i < 3; i++) put(i + 5,regMap.get("t" + i));
            for (int i = 0; i < 2; i++) put(i + 8, regMap.get("s" + i));
            for (int i = 0; i < 8; i++) put(i + 10, regMap.get("a" + i));
            for (int i = 2; i < 12; i++) put(i + 16, regMap.get("s" + i));
            for (int i = 3; i < 7; i++) put(i + 25, regMap.get("t" + i));
        }
    };

    @Override
    public String toString() {
        return name;
    }
    
}
