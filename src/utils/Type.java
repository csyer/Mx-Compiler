package utils;

import IR.type.IRType;
import parser.MxParser.TypeContext;

public class Type {
    public String typeName;
    public boolean isClass = true, isAssignable = true, isPrimitive = false;
    public int dim = 0;

    public IRType irType;

    public Type(String typeName) {
        this.typeName = typeName;
        if (typeName.equals("int") || typeName.equals("bool")) {
            this.isPrimitive = true;
        }
        if (typeName.equals("null") || typeName.equals("this")) {
            this.isClass = false;
            this.isAssignable = false;
        }
    }

    public Type(String typeName, int dim) {
        this(typeName);
        this.dim = dim;
    }

    public Type(Type type) {
        this.dim = type.dim;
        this.isClass = type.isClass;
        this.isAssignable = type.isAssignable;
        this.isPrimitive = type.isPrimitive;
        this.typeName = type.typeName;
    }

    public Type(TypeContext ctx) {
        this(ctx.typename().getText(), ctx.LBracket().size());
    }

    public boolean isArray() {
        return this.dim > 0;
    }

    public boolean isReference() {
        return this.isArray() || !this.isPrimitive;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;

        if (!(obj instanceof Type))
            return false;

        Type type = (Type) obj;

        if (this.typeName.equals(type.typeName)) {
            if (this.dim != type.dim)
                return false;
            return true;
        }
        if (this.typeName.equals("null")) {
            if (type.isReference())
                return true;
            else
                return false;
        } else {
            if (type.typeName.equals("null")) {
                if (this.isReference())
                    return true;
                else
                    return false;
            } else {
                return false;
            }
        }
    }
}
