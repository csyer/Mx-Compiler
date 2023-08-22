package IR;

import java.util.ArrayList;
import java.util.HashMap;

import IR.entity.*;
import IR.inst.*;
import IR.type.*;
import utils.BuiltinElements;

public class IRProgram implements BuiltinElements {
    public ArrayList<IRFunction> funcDefs = new ArrayList<IRFunction>();
    public ArrayList<IRClassType> classDefs = new ArrayList<IRClassType>();
    public ArrayList<IRGlobalVar> gVars = new ArrayList<IRGlobalVar>();

    public HashMap<String, IRStringConst> strConsts = new HashMap<>();

    public IRFunction initFunc = new IRFunction(irVoidType, "_init"), mainFunc;
    public IRBasicBlock initBlock = new IRBasicBlock(initFunc, "entry");

    public IRProgram() {
        IRBasicBlock exitBlock = new IRBasicBlock(initFunc, "return");
        initBlock.terminal = new IRJumpInst(initBlock, exitBlock);
        exitBlock.terminal = new IRRetInst(exitBlock, new IRVoidConst());
        initFunc.blocks.add(initBlock);
        initFunc.returnBlock = exitBlock;
    }

    public String toString() {
        String res = "";

        res += "target datalayout = \"e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128\"\n";
        res += "target triple = \"riscv32-unknown-unknown-elf\"\n";

        for (var def : classDefs) 
            res += def.declare() + "\n";
        for (var str : strConsts.values()) 
            res += str + " = private unnamed_addr constant [" + String.valueOf(str.value.length() + 1) + " x i8] c\"" + str.printStr() + "\" \n";
        for (var var : gVars)
            res += var + " = global " + ((IRPtrType) var.type).type + " " + var.initial + "\n"; 

        res += "\ndeclare dso_local void @print(ptr)\n";
        res += "declare dso_local void @println(ptr)\n";
        res += "declare dso_local void @printInt(i32)\n";
        res += "declare dso_local void @printlnInt(i32)\n";
        res += "declare dso_local ptr @getString()\n";
        res += "declare dso_local i32 @getInt()\n";
        res += "declare dso_local ptr @toString(i32)\n";
        res += "declare dso_local i32 @__str_length(ptr)\n";
        res += "declare dso_local ptr @__str_substring(ptr, i32, i32)\n";
        res += "declare dso_local i32 @__str_parseInt(ptr)\n";
        res += "declare dso_local i32 @__str_ord(ptr, i32)\n";
        res += "declare dso_local ptr @__str_add(ptr, ptr)\n";
        res += "declare dso_local zeroext i1 @__str_eq(ptr, ptr)\n";
        res += "declare dso_local zeroext i1 @__str_ne(ptr, ptr)\n";
        res += "declare dso_local zeroext i1 @__str_lt(ptr, ptr)\n";
        res += "declare dso_local zeroext i1 @__str_le(ptr, ptr)\n";
        res += "declare dso_local zeroext i1 @__str_gt(ptr, ptr)\n";
        res += "declare dso_local zeroext i1 @__str_ge(ptr, ptr)\n";
        res += "declare dso_local i32 @__array.size(ptr)\n";
        res += "declare dso_local ptr @__new_array(i32, i32)\n";
        res += "declare dso_local ptr @__new_var(i32)\n\n";

        if (initFunc != null)
            res += initFunc + "\n";
        for (IRFunction func : funcDefs)
            res += func + "\n";

        return res;
    }
}
