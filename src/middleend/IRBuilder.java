package middleend;

import java.util.ArrayList;
import java.util.HashMap;

import IR.*;
import IR.entity.*;
import IR.inst.*;
import IR.type.*;
import ast.*;
import ast.expr.*;
import ast.stmt.*;
import utils.*;

public class IRBuilder implements ASTVisitor, BuiltinElements {
    IRFunction currentFunc = null;
    IRClassType currentClass = null;
    IRBasicBlock currentBlock = null;

    IRFunction initFunc = new IRFunction(irVoidType, "_init"), mainFunc;
    IRBasicBlock initBlock = new IRBasicBlock(initFunc, "entry");

    globalScope gScope;
    Scope currentScope;
    IRProgram root;

    HashMap<String, IRClassType> classTypes = new HashMap<>();

    public IRBuilder(IRProgram root, globalScope gScope) {
        this.root = root;
        this.currentScope = this.gScope = gScope;
    }

    private IRType toIRType(Type type) {
        if (type.dim > 0) return new IRPtrType(toIRType(new Type(type.typeName, type.dim - 1)));
        IRType irType;
        if (type.typeName.equals("int")) irType = irIntType;
        else if (type.typeName.equals("bool")) irType = irBoolType;
        else if (type.typeName.equals("string")) irType = irStringtType;
        else if (type.typeName.equals("void")) irType = irVoidType;
        else if (type.typeName.equals("null")) irType = irNullType;
        else if (type.typeName.equals("this")) irType = new IRPtrType(currentClass);
        else irType = new IRPtrType(classTypes.get(type.typeName));
        return irType;
    }
    private String strTrans(String str) {
        return str.substring(0, str.length()).replace("\\n", "\n").replace("\\\"", "\"").replace("\\\\", "\\");
    }
    private IREntity loadVal(ExprNode node) {
        if (node.value != null) 
            return node.value;
        else {
            IRVar val = new IRLocalVar(((IRPtrType) node.ptr.type).type, "");
            currentBlock.addInst(new IRLoadInst(currentBlock, val, node.ptr));
            return node.value = val;
        }
    }

    @Override
    public void visit(ProgramNode node) {
        IRBasicBlock exitBlock = new IRBasicBlock(initFunc, "return");
        initBlock.terminal = new IRJumpInst(initBlock, exitBlock);
        exitBlock.terminal = new IRRetInst(exitBlock, new IRVoidConst());
        initFunc.blocks.add(initBlock);
        initFunc.returnBlock = exitBlock;

        for (var def : node.defs) 
            if (def instanceof ClassDefNode) {
                ClassDefNode classDef = (ClassDefNode) def;
                classTypes.put(classDef.className, new IRClassType(classDef.className));
            }
        for (var def : node.defs) 
            if (def instanceof ClassDefNode) 
                def.accept(this);
        for (var def : node.defs) 
            if (def instanceof VarDefNode) 
                def.accept(this);
        for (var def : node.defs) 
            if (def instanceof FuncDefNode) 
                def.accept(this);

        if (initBlock.insts.size() == 0) {
            initFunc = null;
        } else {
            initFunc.finish();
            root.funcDefs.add(initFunc);
            IRBasicBlock mainEntry = mainFunc.blocks.get(0);
            mainEntry.insts.addFirst(new IRCallInst(mainEntry, null, irVoidType, "_init"));
        }
        mainFunc.finish();
    }

    @Override
    public void visit(VarDefUnitNode node) {
        if (currentFunc != null) {
            IRType type = toIRType(node.type);
            IRVar ptr = new IRLocalVar(new IRPtrType(type), node.varName);
            currentBlock.addInst(new IRAllocaInst(currentBlock, ptr, type));
            currentScope.IRVars.put(node.varName, ptr);
            if (node.initial != null) {
                node.initial.accept(this);
                currentBlock.addInst(new IRStoreInst(currentBlock, loadVal(node.initial), ptr));
            } else if (!node.type.isReference()) {
                currentBlock.addInst(new IRStoreInst(currentBlock, type.defaultValue(), ptr));
            }
        } else {
            if (currentClass != null) {
                currentClass.memberIdx.put(node.varName, currentClass.types.size());
                currentClass.types.add(toIRType(node.type));
            } else {
                IRType type = toIRType(node.type);
                IRGlobalVar gVar = new IRGlobalVar(new IRPtrType(type), node.varName);
                gVar.initial = type.defaultValue();
                if (node.initial != null) {
                    if (node.initial instanceof LiteralExprNode && !node.initial.type.equals(stringType)) {
                        node.initial.accept(this);
                        gVar.initial = loadVal(node.initial);
                    } else {
                        IRFunction tempFunc = currentFunc;
                        IRBasicBlock tempBlock = currentBlock;
                        currentFunc = initFunc;
                        currentBlock = initBlock;
                        node.initial.accept(this);
                        currentBlock.addInst(new IRStoreInst(currentBlock, loadVal(node.initial), gVar));
                        initBlock = currentBlock;
                        currentFunc = tempFunc;
                        currentBlock = tempBlock;
                    }
                }
                root.gVars.add(gVar);
                gScope.IRVars.put(node.varName, gVar);
            }
        }
    }

    @Override
    public void visit(VarDefNode node) {
        node.defs.forEach(unit -> unit.accept(this));
    }

    int param_idx = -1;
    @Override
    public void visit(ParameterNode node) {
        if (currentClass != null) 
            param_idx = 0;
        node.list.forEach(unit -> {
            unit.accept(this);
            IRVar input = new IRLocalVar(toIRType(unit.type), "");
            currentFunc.params.add(input);
            currentBlock.addInst(new IRStoreInst(currentBlock, input, currentScope.IRVars.get(unit.varName), param_idx++));
        });
        param_idx = -1;
    }

    @Override
    public void visit(FuncDefNode node) {
        IRBasicBlock.cnt = 0;

        IRType returnType = toIRType(node.returnType);
        String funcName = currentClass != null ? currentClass.getName() + "." + node.funcName : node.funcName;
        currentFunc = new IRFunction(returnType, funcName);
        root.funcDefs.add(currentFunc);
    
        currentScope = new Scope(currentScope);
        currentScope.returnType = node.returnType;
        
        currentBlock = new IRBasicBlock(currentFunc, "entry");
        currentFunc.blocks.add(currentBlock);
        if (currentClass != null) {
            IRPtrType classPtrType = new IRPtrType(currentClass);
            IRLocalVar thisPtr = new IRLocalVar(classPtrType, "this");
            currentFunc.params.add(thisPtr);
            IRLocalVar thisAddr = new IRLocalVar(new IRPtrType(classPtrType), "this.addr");

            currentBlock.addInst(new IRAllocaInst(currentBlock, thisAddr, classPtrType));
            currentBlock.addInst(new IRStoreInst(currentBlock, thisPtr, thisAddr));
            currentScope.IRVars.put("this", thisAddr);
        }

        if (node.param != null) node.param.accept(this);

        IRBasicBlock returnBlock = new IRBasicBlock(currentFunc, "return");
        currentBlock.terminal = new IRJumpInst(currentBlock, returnBlock);
        if (node.returnType.equals(voidType)) {
            returnBlock.terminal = new IRRetInst(returnBlock, irVoidConst);
        } else {
            IRVar retAddr = new IRLocalVar(new IRPtrType(returnType), "retval");
            returnBlock.addInst(new IRAllocaInst(currentBlock, retAddr, returnType));
            IRVar retVal = new IRLocalVar(returnType, "");
            returnBlock.addInst(new IRLoadInst(currentBlock, retVal, retAddr));
            returnBlock.terminal = new IRRetInst(returnBlock, retVal);
            if (funcName.equals("main")) {
                mainFunc = currentFunc;
                currentBlock.addInst(new IRStoreInst(currentBlock, irIntConst0, retAddr));
            }
            currentFunc.returnAddr = retAddr;
        }
        currentFunc.returnBlock = returnBlock;

        node.suite.accept(this);
        if (currentBlock.terminal == null) {
            if (node.returnType.equals(voidType))
                currentBlock.addInst(new IRRetInst(currentBlock, new IRVoidConst()));
            else
                currentBlock.addInst(new IRRetInst(currentBlock, irIntConst0));
        }

        node.irFunc = currentFunc;
        currentScope = currentScope.parentScope;
        if (!(funcName.equals("main") && currentClass == null)) currentFunc.finish();

        currentFunc = null;
        currentBlock = null;
    }

    @Override
    public void visit(ClassConstructorNode node) {
        FuncDefNode funcDef = new FuncDefNode(voidType, node.className, node.pos);
        funcDef.suite = node.suite;
        visit(funcDef);
    }

    @Override
    public void visit(ClassDefNode node) {
        currentScope = new Scope(currentScope);
        currentClass = classTypes.get(node.className);

        root.classDefs.add(currentClass);
        node.varDefs.forEach(def -> def.accept(this));
        currentClass.calcSize();

        if (node.constructor != null) {
            node.constructor.accept(this);
        }
        node.funcDefs.forEach(def -> def.className = node.className);
        node.funcDefs.forEach(def -> def.accept(this));

        currentScope = currentScope.parentScope;
        currentClass = null;
    }

    @Override
    public void visit(SuiteNode node) {
        node.stmts.forEach(stmt -> stmt.accept(this));
    }

    @Override
    public void visit(IfStmtNode node) {
        node.condition.accept(this);
        IREntity cond = loadVal(node.condition);

        IRBasicBlock lastBlock = currentBlock;
        IRBasicBlock endBlock = new IRBasicBlock(currentFunc, "if.end");
        endBlock.terminal = currentBlock.terminal;

        currentScope = new Scope(currentScope);
        IRBasicBlock thenBlock = new IRBasicBlock(currentFunc, "if.then");
        thenBlock.terminal = new IRJumpInst(thenBlock, endBlock);
        currentFunc.blocks.add(thenBlock);
        currentBlock = thenBlock;
        node.trueStmt.accept(this);
        currentScope = currentScope.parentScope;

        if (node.falseStmt != null) {
            thenBlock.isFinished = true;
            currentScope = new Scope(currentScope);
            IRBasicBlock elseBlock = new IRBasicBlock(currentFunc, "if.else");
            elseBlock.terminal = new IRJumpInst(currentBlock, endBlock);
            currentFunc.blocks.add(elseBlock);
            currentBlock = elseBlock;
            node.falseStmt.accept(this);
            currentScope = currentScope.parentScope;
            lastBlock.terminal = new IRBranchInst(lastBlock, cond, thenBlock, elseBlock);
        } else {
            lastBlock.terminal = new IRBranchInst(lastBlock, cond, thenBlock, endBlock);
        }
        lastBlock.isFinished = true;
        currentBlock.isFinished = true;

        currentFunc.blocks.add(endBlock);
        currentBlock = endBlock;
    }

    @Override
    public void visit(WhileStmtNode node) {
        node.condBlock = new IRBasicBlock(currentFunc, "while.cond");
        node.loopBlock = new IRBasicBlock(currentFunc, "while.loop");
        node.nextBlock = new IRBasicBlock(currentFunc, "while.end");
        node.nextBlock.terminal = currentBlock.terminal;
        currentBlock.terminal = new IRJumpInst(currentBlock, node.condBlock);
        currentBlock.isFinished = true;

        currentFunc.blocks.add(node.condBlock);
        currentBlock = node.condBlock;
        node.condition.accept(this);
        currentBlock.terminal = new IRBranchInst(currentBlock, loadVal(node.condition), node.loopBlock, node.nextBlock);

        currentFunc.blocks.add(node.loopBlock);
        currentBlock = node.loopBlock;
        currentScope = new Scope(currentScope);
        currentScope.inLoop = node;
        node.statement.accept(this);
        currentScope = currentScope.parentScope;
        currentBlock.terminal = new IRJumpInst(currentBlock, node.condBlock);
        currentBlock.isFinished = true;

        currentFunc.blocks.add(node.nextBlock);
        currentBlock = node.nextBlock;
    }

    @Override
    public void visit(ForStmtNode node) {
        currentScope = new Scope(currentScope);
        if (node.initial != null) 
            node.initial.accept(this);
        node.condBlock = new IRBasicBlock(currentFunc, "for.cond");
        node.loopBlock = new IRBasicBlock(currentFunc, "for.loop");
        node.stepBlock = new IRBasicBlock(currentFunc, "for.step");
        node.nextBlock = new IRBasicBlock(currentFunc, "for.end");
        node.nextBlock.terminal = currentBlock.terminal;
        currentBlock.terminal = new IRJumpInst(currentBlock, node.condBlock);
        currentBlock.isFinished = true;

        currentFunc.blocks.add(node.condBlock);
        currentBlock = node.condBlock;
        node.condition.accept(this);
        currentBlock.terminal = new IRBranchInst(currentBlock, loadVal(node.condition), node.loopBlock, node.nextBlock);

        currentFunc.blocks.add(node.loopBlock);
        currentBlock = node.loopBlock;
        currentScope = new Scope(currentScope);
        currentScope.inLoop = node;
        node.statement.accept(this);
        currentScope = currentScope.parentScope;
        currentBlock.terminal = new IRJumpInst(currentBlock, node.stepBlock);
        currentBlock.isFinished = true;

        currentFunc.blocks.add(node.stepBlock);
        currentBlock = node.stepBlock;
        if (node.step != null) node.step.accept(this);
        currentBlock.terminal = new IRJumpInst(currentBlock, node.condBlock);
        currentBlock.isFinished = true;

        currentScope = currentScope.parentScope;

        currentFunc.blocks.add(node.nextBlock);
        currentBlock = node.nextBlock;
    }

    @Override
    public void visit(BreakStmtNode node) {
        currentBlock.terminal = new IRJumpInst(currentBlock, currentScope.inLoop.nextBlock);
        currentBlock.isFinished = true;
    }

    @Override
    public void visit(ContinueStmtNode node) {
        if (currentScope.inLoop instanceof ForStmtNode)
            currentBlock.terminal = new IRJumpInst(currentBlock, ((ForStmtNode) currentScope.inLoop).stepBlock);
        else currentBlock.terminal = new IRJumpInst(currentBlock, currentScope.inLoop.condBlock);
        currentBlock.isFinished = true;
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (node.returnValue != null) {
            node.returnValue.accept(this);
            IRStoreInst inst = new IRStoreInst(currentBlock, loadVal(node.returnValue), currentFunc.returnAddr);
            currentBlock.addInst(inst);
        }
        currentBlock.terminal = new IRJumpInst(currentBlock, currentFunc.returnBlock);
        currentBlock.isFinished = true;
    }

    @Override
    public void visit(ExprStmtNode node) {
        if (node.expr != null)
            node.expr.accept(this);
    }

    @Override
    public void visit(ExprListNode node) {
        node.exprs.forEach(expr -> expr.accept(this));
    }

    private IREntity newArray(IRPtrType type, int idx, ArrayList<ExprNode> sizes) {
        IRVar ptr = new IRLocalVar(type, ".arrayptr");

        IREntity size;
        sizes.get(idx).accept(this);
        IRCallInst call = new IRCallInst(currentBlock, ptr, type, "__new_array");
        call.addArg(size = loadVal(sizes.get(idx)));
        call.addArg(new IRIntConst(type.type.size));

        currentBlock.addInst(call);

        IRVar iPtr = new IRLocalVar(new IRPtrType(irIntType), ".i");
        currentBlock.addInst(new IRAllocaInst(currentBlock, iPtr, irIntType));
        currentBlock.addInst(new IRStoreInst(currentBlock, irIntConst0, iPtr));

        IRBasicBlock condBlock = new IRBasicBlock(currentFunc, "while.cond");
        IRBasicBlock loopBlock = new IRBasicBlock(currentFunc, "while.loop");
        IRBasicBlock endBlock = new IRBasicBlock(currentFunc, "while.end");

        endBlock.terminal = currentBlock.terminal;
        currentBlock.terminal = new IRJumpInst(currentBlock, condBlock);
        currentBlock.isFinished = true;

        currentBlock = condBlock;
        currentFunc.blocks.add(condBlock);
        IRVar cmp = new IRLocalVar(irBoolType, "");
        IRVar iVal = new IRLocalVar(irIntType, "");
        currentBlock.addInst(new IRLoadInst(currentBlock, iVal, iPtr));
        if (size instanceof IRIntConst c) {
            IRIntConst size2 = new IRIntConst(c.value);
            currentBlock.addInst(new IRIcmpInst(currentBlock, "slt", cmp, iVal, size2));
        }
        else currentBlock.addInst(new IRIcmpInst(currentBlock, "slt", cmp, iVal, size));
        currentBlock.terminal = new IRBranchInst(currentBlock, cmp, loopBlock, endBlock);
        currentBlock.isFinished = true;

        currentBlock = loopBlock;
        currentFunc.blocks.add(loopBlock);

        IRVar arrayIdx = new IRLocalVar(type, ".arrayidx");
        IRVar iVal2 = new IRLocalVar(irIntType, "");
        currentBlock.addInst(new IRLoadInst(currentBlock, iVal2, iPtr));
        IRGetElementPtrInst gep = new IRGetElementPtrInst(currentBlock, arrayIdx, ptr);
        gep.addIdx(iVal2);
        currentBlock.addInst(gep);
        if (type.type instanceof IRPtrType) {
            if (((IRPtrType) type.type).type instanceof IRClassType) {
                IRClassType classType = (IRClassType) (((IRPtrType) type.type).type);
                if (gScope.getClass(classType.getName()).constructor != null) {
                    IRCallInst callCons = new IRCallInst(currentBlock, null, irVoidType, classType.getName() + "." + classType.getName());
                    callCons.addArg(arrayIdx);
                    currentBlock.addInst(callCons);
                }
            } else {
                if (idx + 1 < sizes.size()) {
                    IREntity innerArray = newArray((IRPtrType) type.type, idx + 1, sizes);
                    currentBlock.addInst(new IRStoreInst(currentBlock, innerArray, arrayIdx));
                } else {
                    currentBlock.addInst(new IRStoreInst(currentBlock, type.type.defaultValue(), arrayIdx));
                }
            }
        } else {
            currentBlock.addInst(new IRStoreInst(currentBlock, type.type.defaultValue(), arrayIdx));
        }

        IRVar add = new IRLocalVar(irIntType, "");
        IRVar iVal3 = new IRLocalVar(irIntType, "");
        currentBlock.addInst(new IRLoadInst(currentBlock, iVal3, iPtr));
        currentBlock.addInst(new IRCalcInst(currentBlock, "add", add, iVal3, irIntConst1));
        currentBlock.addInst(new IRStoreInst(currentBlock, add, iPtr));

        currentBlock.terminal = new IRJumpInst(currentBlock, condBlock);
        currentBlock.isFinished = true;

        currentBlock = endBlock;
        currentFunc.blocks.add(endBlock);

        return ptr;
    }

    @Override
    public void visit(NewExprNode node) {
        IRType type = toIRType(node.type);
        if (node.dim > 0) {
            node.value = node.exprs.size() > 0 ? newArray((IRPtrType) type, 0, node.exprs) : new IRNullConst(type);
        } else {
            IRClassType classType = (IRClassType) ((IRPtrType) type).type;
            node.value = new IRLocalVar(type, "call");
            IRCallInst callFunc = new IRCallInst(currentBlock, (IRVar) node.value, type, "__new_var");
            callFunc.addArg(new IRIntConst(classType.size));
            currentBlock.addInst(callFunc);
            if (gScope.getClass(node.type.typeName).constructor != null) {
                IRCallInst callCons = new IRCallInst(currentBlock, null, irVoidType, node.type.typeName + "." + node.type.typeName);
                callCons.addArg(node.value);
                currentBlock.addInst(callCons);
            }
        }
    }

    @Override
    public void visit(ComponentExprNode node) {
        node.object.accept(this);
        IRType objType = loadVal(node.object).type;
        node.objAddr = (IRLocalVar) node.object.value; 
        objType = ((IRPtrType) objType).type;
        if (objType instanceof IRClassType) {
            Integer Idx = ((IRClassType) objType).memberIdx.get(node.member);
            if (Idx != null) {
                int idx = Idx.intValue();
                IRType memberType = ((IRClassType) objType).types.get(idx);
                node.ptr = new IRLocalVar(new IRPtrType(memberType), node.member);
                IRGetElementPtrInst gep = new IRGetElementPtrInst(currentBlock, node.ptr, loadVal(node.object));
                gep.addIdx(irIntConst0);
                gep.addIdx(new IRIntConst(idx));
                currentBlock.addInst(gep);
            }
        }
    }

    @Override
    public void visit(FunctionExprNode node) {
        node.func.accept(this);
        FuncDefNode funcDef = node.func.funcDef;
        String funcName = funcDef.className == null ? funcDef.funcName : funcDef.className + "." + funcDef.funcName;
        IRType returnType = toIRType(funcDef.returnType);
        IRCallInst call = new IRCallInst(currentBlock, null, returnType, funcName);
    
        if (funcDef == ArraySizeFunc) {
            call.funcName = "__array.size";
            IRVar array = ((ComponentExprNode) node.func).objAddr;
            node.value = new IRLocalVar(irIntType, "");
            call.addArg(array);
            call.dest = (IRVar) node.value;
            currentBlock.addInst(call); 
        } else {
            if (funcDef == stringLengthFunc) call.funcName = "__str_length";
            else if (funcDef == stringSubStringFunc) call.funcName = "__str_substring";
            else if (funcDef == stringParseIntFunc) call.funcName = "__str_parseInt";
            else if (funcDef == stringOrdFunc) call.funcName = "__str_ord";
        
            if (funcDef.className != null) {
                if (node.func instanceof ComponentExprNode)
                    call.args.add(((ComponentExprNode) node.func).objAddr);
                else {
                    IRVar thisPtr = currentScope.getIRVar("this");
                    IRVar thisVal = new IRLocalVar(((IRPtrType) thisPtr.type).type, "");
                    currentBlock.addInst(new IRLoadInst(currentBlock, thisVal, thisPtr));
                    call.args.add(thisVal);
                }
            }
            if (node.args != null) {
                node.args.accept(this);
                node.args.exprs.forEach(arg -> call.args.add(loadVal(arg)));
            }
            if (returnType != irVoidType)
                call.dest = new IRLocalVar(returnType, "");
            currentBlock.addInst(call);
            node.value = call.dest;
        }
    }

    @Override
    public void visit(AccessArrayExprNode node) {
        node.array.accept(this);
        node.index.accept(this);
        IRVar dest = new IRLocalVar(loadVal(node.array).type, "");
        IRGetElementPtrInst gep = new IRGetElementPtrInst(currentBlock, dest, loadVal(node.array));
        gep.addIdx(loadVal(node.index));
        currentBlock.addInst(gep);
        node.ptr = dest;
    }

    @Override
    public void visit(IncExprNode node) {
        node.expr.accept(this);
        IRVar dest = new IRLocalVar(irIntType, "");
        String op = node.op.equals("++") ? "add" : "sub";
        node.value = loadVal(node.expr);
        currentBlock.addInst(new IRCalcInst(currentBlock, op, dest, node.value, irIntConst1));
        currentBlock.addInst(new IRStoreInst(currentBlock, dest, node.expr.ptr));
    }

    @Override
    public void visit(UnaryExprNode node) {
        node.expr.accept(this);
        IRVar dest = new IRLocalVar(node.type.equals(intType) ? irIntType : irBoolType , "");
        String op = null;
        switch (node.op) {
            case "++":
                op = "add";
                currentBlock.addInst(new IRCalcInst(currentBlock, op, dest, loadVal(node.expr), irIntConst1));
                currentBlock.addInst(new IRStoreInst(currentBlock, dest, node.expr.ptr));
                node.value = dest;
                node.ptr = node.expr.ptr;
                break;
            case "--":
                op = "sub";
                currentBlock.addInst(new IRCalcInst(currentBlock, op, dest, loadVal(node.expr), irIntConst1));
                currentBlock.addInst(new IRStoreInst(currentBlock, dest, node.expr.ptr));
                node.value = dest;
                node.ptr = node.expr.ptr;
                break;
            case "-":
                op = "sub";
                currentBlock.addInst(new IRCalcInst(currentBlock, op, dest, irIntConst0, loadVal(node.expr)));
                node.value = dest;
                break;
            case "~":
                op = "xor";
                currentBlock.addInst(new IRCalcInst(currentBlock, op, dest, loadVal(node.expr), irIntConstn1));
                node.value = dest;
                break;
            case "!":
                op = "xor";
                currentBlock.addInst(new IRCalcInst(currentBlock, op, dest, loadVal(node.expr), irTrueConst));
                node.value = dest;
        }
    }

    @Override
    public void visit(BinaryExprNode node) {
        String op = "null";
        switch(node.op) {
            case "+": {
                node.lhs.accept(this);
                node.rhs.accept(this);
                if (node.lhs.type.equals(stringType)) {
                    node.value = new IRLocalVar(irStringtType, "str");
                    IRCallInst call = new IRCallInst(currentBlock, (IRVar) node.value, irStringtType, "__str_add");
                    call.addArg(loadVal(node.lhs));
                    call.addArg(loadVal(node.rhs));
                    currentBlock.addInst(call);
                } else {
                    IREntity lv = loadVal(node.lhs),
                             rv = loadVal(node.rhs);
                    if ((lv instanceof IRIntConst li) && (rv instanceof IRIntConst ri)) {
                        node.value = new IRIntConst(li.value + ri.value);
                    } else {
                        node.value = new IRLocalVar(irIntType, "add");
                        IRCalcInst calc = new IRCalcInst(currentBlock, "add", (IRVar) node.value, lv, rv);
                        currentBlock.addInst(calc);
                    }
                }
                break;
            }

            case "<":
            case ">":
            case "<=":
            case ">=": {
                node.lhs.accept(this);
                node.rhs.accept(this);
                if (node.op.equals("<")) op = "lt";
                else if (node.op.equals(">")) op = "gt";
                else if (node.op.equals("<=")) op = "le";
                else if (node.op.equals(">=")) op = "ge";
                if (node.lhs.type.equals(stringType)) {
                    node.value = new IRLocalVar(irStringtType, "str." + op);
                    IRCallInst call = new IRCallInst(currentBlock, (IRVar) node.value, irStringtType, "__str_" + op);
                    call.addArg(loadVal(node.lhs));
                    call.addArg(loadVal(node.rhs));
                    currentBlock.addInst(call);
                } else {
                    IREntity lv = loadVal(node.lhs),
                             rv = loadVal(node.rhs);
                    if ((lv instanceof IRIntConst li) && (rv instanceof IRIntConst ri)) {
                        if (op.equals("lt")) node.value = new IRBoolConst(li.value < ri.value);
                        if (op.equals("gt")) node.value = new IRBoolConst(li.value > ri.value);
                        if (op.equals("le")) node.value = new IRBoolConst(li.value <= ri.value);
                        if (op.equals("ge")) node.value = new IRBoolConst(li.value <= ri.value);
                    } else {
                        op = "s" + op;
                        node.value = new IRLocalVar(irBoolType, op);
                        IRIcmpInst calc = new IRIcmpInst(currentBlock, op, (IRVar) node.value, lv, rv);
                        currentBlock.addInst(calc);
                    }
                }
                break;
            }
            
            case "==":
            case "!=": {
                node.lhs.accept(this);
                node.rhs.accept(this);
                if (node.op.equals("==")) op = "eq";
                else if (node.op.equals("!=")) op = "ne";
                IREntity lv = loadVal(node.lhs),
                         rv = loadVal(node.rhs);
                if ((lv instanceof IRIntConst li) && (rv instanceof IRIntConst ri)) {
                    if (op.equals("eq")) node.value = new IRBoolConst(li.value == ri.value);
                    if (op.equals("ne")) node.value = new IRBoolConst(li.value != ri.value);
                } else if ((lv instanceof IRBoolConst li) && (rv instanceof IRBoolConst ri)) {
                    if (op.equals("eq")) node.value = new IRBoolConst(li.value == ri.value);
                    if (op.equals("ne")) node.value = new IRBoolConst(li.value != ri.value);
                } else {
                    node.value = new IRLocalVar(irBoolType, op);
                    IRIcmpInst calc = new IRIcmpInst(currentBlock, op, (IRVar) node.value, lv, rv);
                    currentBlock.addInst(calc);
                }
                break;
            }

            case "&&":
            case "||": {
                node.lhs.accept(this);
                if (node.op.equals("&&")) op = "and";
                else op = "or";
                IREntity lv = loadVal(node.lhs);
                if (lv instanceof IRBoolConst lb) {
                    if (op.equals("and") && !lb.value) node.value = new IRBoolConst(false);
                    else if (op.equals("or") && lb.value) node.value = new IRBoolConst(true);
                    else {
                        node.rhs.accept(this);
                        IREntity rv = loadVal(node.rhs);
                        if (rv instanceof IRBoolConst rb)
                            node.value = new IRBoolConst(lb.value);
                        else currentBlock.addInst(new IRStoreInst(currentBlock, rv, node.ptr));
                    }
                    break;
                }
                node.ptr = new IRLocalVar(new IRPtrType(irBoolType), op);
                currentBlock.addInst(new IRAllocaInst(currentBlock, node.ptr, irBoolType));
                IRBasicBlock rhsBlock = new IRBasicBlock(currentFunc, "land.rhs");
                IRBasicBlock trueBlock = new IRBasicBlock(currentFunc, "land.true");
                IRBasicBlock falseBlock = new IRBasicBlock(currentFunc, "land.false");
                IRBasicBlock endBlock = new IRBasicBlock(currentFunc, "land.end");
                endBlock.terminal = currentBlock.terminal;
                if (op.equals("and"))
                    currentBlock.terminal = new IRBranchInst(currentBlock, lv, rhsBlock, falseBlock);
                else
                    currentBlock.terminal = new IRBranchInst(currentBlock, lv, trueBlock, rhsBlock);
                currentBlock.isFinished = true;

                currentBlock = rhsBlock;
                currentFunc.blocks.add(rhsBlock);
                node.rhs.accept(this);
                currentBlock.terminal = new IRBranchInst(currentBlock, loadVal(node.rhs), trueBlock, falseBlock);
                currentBlock.isFinished = true;

                currentBlock = trueBlock;
                currentFunc.blocks.add(trueBlock);
                currentBlock.addInst(new IRStoreInst(currentBlock, irTrueConst, node.ptr));
                currentBlock.terminal = new IRJumpInst(currentBlock, endBlock);
                currentBlock.isFinished = true;

                currentBlock = falseBlock;
                currentFunc.blocks.add(falseBlock);
                currentBlock.addInst(new IRStoreInst(currentBlock, irFalseConst, node.ptr));
                currentBlock.terminal = new IRJumpInst(currentBlock, endBlock);
                currentBlock.isFinished = true;

                currentBlock = endBlock;
                currentFunc.blocks.add(endBlock);

                break;
            }
            
            default: {
                node.lhs.accept(this);
                node.rhs.accept(this);
                if (node.op.equals("-")) op = "sub";
                else if (node.op.equals("*")) op = "mul";
                else if (node.op.equals("/")) op = "sdiv";
                else if (node.op.equals("%")) op = "srem";
                else if (node.op.equals("<<")) op = "shl";
                else if (node.op.equals(">>")) op = "ashr";
                else if (node.op.equals("&")) op = "and";
                else if (node.op.equals("|")) op = "or";
                else if (node.op.equals("^")) op = "xor";
                IREntity lv = loadVal(node.lhs),
                         rv = loadVal(node.rhs);
                if ((lv instanceof IRIntConst li) && (rv instanceof IRIntConst ri)) {
                    if (op.equals("sub")) node.value = new IRIntConst(li.value - ri.value);
                    if (op.equals("mul")) node.value = new IRIntConst(li.value * ri.value);
                    if (op.equals("sdiv")) node.value = new IRIntConst(li.value / ri.value);
                    if (op.equals("srem")) node.value = new IRIntConst(li.value % ri.value);
                    if (op.equals("shl")) node.value = new IRIntConst(li.value << ri.value);
                    if (op.equals("ashr")) node.value = new IRIntConst(li.value >> ri.value);
                    if (op.equals("and")) node.value = new IRIntConst(li.value & ri.value);
                    if (op.equals("or")) node.value = new IRIntConst(li.value | ri.value);
                    if (op.equals("xor")) node.value = new IRIntConst(li.value ^ ri.value);
                } else {
                    node.value = new IRLocalVar(irIntType, op);
                    IRCalcInst calc = new IRCalcInst(currentBlock, op, (IRVar) node.value, lv, rv);
                    currentBlock.addInst(calc);
                }
                break;
            }
        }
    }

    @Override
    public void visit(TernaryExprNode node) {
        node.condition.accept(this);
        IREntity cond = loadVal(node.condition);

        IRVar ptr = null;
        if (!node.type.equals(voidType)) {
            IRType type = toIRType(node.type);
            ptr = new IRLocalVar(new IRPtrType(type), "cond");
            currentBlock.addInst(new IRAllocaInst(currentBlock, ptr, type));
        }

        IRBasicBlock trueBlock = new IRBasicBlock(currentFunc, "cond.true");
        IRBasicBlock falseBlock = new IRBasicBlock(currentFunc, "cond.false");
        IRBasicBlock endBlock = new IRBasicBlock(currentFunc, "cond.end");
        endBlock.terminal = currentBlock.terminal;
        currentBlock.terminal = new IRBranchInst(currentBlock, cond, trueBlock, falseBlock);
        currentBlock.isFinished = true;

        trueBlock.terminal = new IRJumpInst(trueBlock, endBlock);
        currentFunc.blocks.add(trueBlock);
        currentBlock = trueBlock;
        node.trueExpr.accept(this);
        if (!node.trueExpr.type.equals(voidType)) {
            currentBlock.addInst(new IRStoreInst(currentBlock, loadVal(node.trueExpr), ptr));
        }
        currentBlock.isFinished = true;

        falseBlock.terminal = new IRJumpInst(falseBlock, endBlock);
        currentFunc.blocks.add(falseBlock);
        currentBlock = falseBlock;
        node.falseExpr.accept(this);
        if (!node.trueExpr.type.equals(voidType)) {
            currentBlock.addInst(new IRStoreInst(currentBlock, loadVal(node.falseExpr), ptr));
        }
        currentBlock.isFinished = true;

        currentBlock = endBlock;
        currentFunc.blocks.add(endBlock);
        if (!node.type.equals(voidType)) {
            node.ptr = ptr;
        }
    }

    @Override
    public void visit(AssignExprNode node) {
        node.lhs.accept(this);
        node.rhs.accept(this);
        node.ptr = node.lhs.ptr;
        node.value = loadVal(node.rhs);
        currentBlock.addInst(new IRStoreInst(currentBlock, node.value, node.ptr));
    }

    @Override
    public void visit(LiteralExprNode node) {
        if (node.type.equals(intType))
            node.value = new IRIntConst(Integer.parseInt(node.str));
        else if (node.type.equals(boolType))
            node.value = new IRBoolConst(node.str.equals("true"));
        else if (node.type.typeName.equals("null"))
            node.value = new IRNullConst();
        else if (node.type.equals(stringType)) {
            String str = strTrans(node.str.substring(1, node.str.length() - 1));
            IRStringConst strConst = root.strConsts.get(str);
            if (strConst == null) {
                strConst = new IRStringConst(str);
                root.strConsts.put(str, strConst);
            }
            node.value = strConst;
        }
    }

    @Override
    public void visit(AtomExprNode node) {
        node.ptr = currentScope.getIRVar(node.varName);
        if (node.ptr == null) {
            IRVar thisAddr = (IRLocalVar) currentScope.getIRVar("this");
            if (thisAddr != null) { 
                IRType objPtrType =  ((IRPtrType) thisAddr.type).type;
                IRType objRealType = ((IRPtrType) objPtrType).type;
                IRVar thisVal = new IRLocalVar(objPtrType, "this");
                currentBlock.addInst(new IRLoadInst(currentBlock, thisVal, thisAddr));
                Integer Idx = ((IRClassType) objRealType).memberIdx.get(node.varName);
                if (Idx != null) {
                    int idx = Idx.intValue();
                    node.ptr = new IRLocalVar(new IRPtrType(((IRClassType) objRealType).types.get(idx)), "this." + node.varName);
                    IRGetElementPtrInst gep = new IRGetElementPtrInst(currentBlock, node.ptr, thisVal);
                    gep.addIdx(irIntConst0);
                    gep.addIdx(new IRIntConst(((IRClassType) objRealType).memberIdx.get(node.varName)));
                    currentBlock.addInst(gep);
                }
            }
        }
    }
}
