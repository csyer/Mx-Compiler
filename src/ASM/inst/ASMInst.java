package ASM.inst;

import java.util.HashSet;

import ASM.operand.*;

public abstract class ASMInst {
    public Reg rd, rs1, rs2;
    public Imm imm;
    public abstract String toString();

    public HashSet<Reg> use() {
        return new HashSet<>() {
            {
                if (rs1 != null) add(rs1);
                if (rs2 != null) add(rs2);
            }
        };
    }
    public HashSet<Reg> def() {
        return new HashSet<>() {
            {
                if (rd != null) add(rd);
            }
        };
    }
}
