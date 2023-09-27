package IR.entity;

import IR.type.IRVoidType;

public class IRVoidConst extends IRConst {
    public IRVoidConst() {
      super(new IRVoidType());
    }
  
    @Override
    public boolean equals(Object obj) {
        return obj instanceof IRVoidConst;
    }

    @Override
    public String toString() {
      return "";
    }
}
