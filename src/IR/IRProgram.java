package IR;

import java.util.ArrayList;

import IR.entity.IRGlobalVar;
import IR.type.IRClassType;
import utils.BuiltinElements;

public class IRProgram implements BuiltinElements {
    public ArrayList<IRFunction> funcs = new ArrayList<IRFunction>();
    public ArrayList<IRGlobalVar> vars = new ArrayList<IRGlobalVar>();
    public ArrayList<IRClassType> classes = new ArrayList<IRClassType>();

    public IRFunction initFunc = null;
    public IRBasicBlock initBlock = null;

    public String toString() {
        String res = "";

        res += "declare dso_local i8* @malloc(i32)\n";
        res += "declare dso_local i8* @strcpy(i8*, i8*)\n";
        res += "declare dso_local i8* @strcat(i8*, i8*)\n";
        res += "declare dso_local i32 @strlen(i8*)\n";
        res += "declare void @print(i8*)\n";
        res += "declare void @println(i8*)\n";
        res += "declare void @printInt(i32)\n";
        res += "declare void @printlnInt(i32)\n";
        res += "declare i8* @getString()\n";
        res += "declare i32 @getInt()\n";
        res += "declare i8* @toString(i32)\n";
        res += "declare i8* @__mx_substring(i8*, i32, i32)\n";
        res += "declare i32 @__mx_parseInt(i8*)\n";
        res += "declare i32 @__mx_ord(i8*, i32)\n";
        res += "declare i8 @__mx_strlt(i8*, i8*)\n";
        res += "declare i8 @__mx_strle(i8*, i8*)\n";
        res += "declare i8 @__mx_strgt(i8*, i8*)\n";
        res += "declare i8 @__mx_strge(i8*, i8*)\n";
        res += "declare i8 @__mx_streq(i8*, i8*)\n";
        res += "declare i8 @__mx_strneq(i8*, i8*)\n\n";

        return res;
    }
}
