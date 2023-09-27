package backend;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

import ASM.ASMFunction;
import ASM.ASMProgram;
import ASM.inst.ASMInst;
import ASM.inst.ASMLoadInst;
import ASM.inst.ASMMvInst;
import ASM.inst.ASMStoreInst;
import ASM.operand.BaseReg;
import ASM.operand.Imm;
import ASM.operand.MemReg;
import ASM.operand.Reg;

public class GraphColoring {
    public ASMProgram prog;

    static int K = 27;
    static BaseReg regSp = BaseReg.regMap.get("sp");
    static BaseReg regZero = BaseReg.regMap.get("zero");

    public GraphColoring(ASMProgram prog) {
        this.prog = prog;
    }

    public void work() {
        prog.funcDefs.forEach(func -> {
            curFunc = func;
            newTemps.clear();
            solve(func);
            for (var block : func.blocks) {
                LinkedList<ASMInst> newInsts = new LinkedList<>();
                for (ASMInst inst : block.insts) {
                    if (inst.rd instanceof MemReg)
                        inst.rd = BaseReg.idReg.get(color.get(inst.rd));
                    if (inst.rs1 instanceof MemReg)
                        inst.rs1 = BaseReg.idReg.get(color.get(inst.rs1));
                    if (inst.rs2 instanceof MemReg)
                        inst.rs2 = BaseReg.idReg.get(color.get(inst.rs2));
                    if (!(inst instanceof ASMMvInst) || inst.rd != inst.rs1)
                        newInsts.add(inst);
                }
                block.insts = newInsts;
            }
        });
    }

    HashSet<Reg> precolored = new HashSet<>();
    HashSet<Reg> initial = new HashSet<>();
    LinkedList<Reg> simplifyWorklist = new LinkedList<>();
    LinkedList<Reg> freezeWorklist = new LinkedList<>();
    LinkedList<Reg> spillWorklist = new LinkedList<>();
    HashSet<Reg> spilledNodes = new HashSet<>();
    HashSet<Reg> coalescedNodes = new HashSet<>();
    HashSet<Reg> coloredNodes = new HashSet<>();
    Stack<Reg> selecStack = new Stack<>();

    HashSet<ASMMvInst> coalescedMoves = new HashSet<>();
    HashSet<ASMMvInst> constrainedMoves = new HashSet<>();
    HashSet<ASMMvInst> frozenMoves = new HashSet<>();
    HashSet<ASMMvInst> worklistMoves = new HashSet<>();
    HashSet<ASMMvInst> activeMoves = new HashSet<>();

    ASMFunction curFunc;
    void solve(ASMFunction func) {
        new LivenessAnalyzer(func).work();
        System.err.println(func.name);
        for (var block : func.blocks) {
            System.err.println(block.name);
            System.err.print("liveIn: ");
            for (var n : block.liveIn)
                System.err.print(n + ", ");
            System.err.println("");
            System.err.print("liveOut: ");
            for (var n : block.liveOut)
                System.err.print(n + ", ");
            System.err.println("");
        }
        // if (true) return;
        init();
        build();
        System.err.println(func.name);
        for (var e : adjSet) 
            if (e.u instanceof MemReg || e.v instanceof MemReg)
                System.err.println("edge " + e.u + ", " + e.v);
        // if (true) return;
        makeWorklist();
        do {
            if (!simplifyWorklist.isEmpty()) simplify();
            else if (!worklistMoves.isEmpty()) coalesce();
            else if (!freezeWorklist.isEmpty()) freeze();
            else if (!spillWorklist.isEmpty()) selectSpill();
        } while (!simplifyWorklist.isEmpty() ||
                 !worklistMoves.isEmpty() ||
                 !freezeWorklist.isEmpty() || 
                 !spillWorklist.isEmpty());
        assignColors();
        if (spilledNodes.isEmpty()) return;
        rewriteProgram();
        solve(func);
    }

    public static class Edge {
        public Reg u, v;
        
        public Edge (Reg u, Reg v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Edge))
                return false;
            Edge e = (Edge) obj;
            return (u == e.u && v == e.v) || (u == e.v && v == e.u);
        }

        @Override
        public int hashCode() {
            return u.hashCode() ^ v.hashCode();
        }
    }

    HashSet<Edge> adjSet = new HashSet<>();
    HashMap<Reg, LinkedList<Reg>> adjList = new HashMap<>();
    HashMap<Reg, Integer> degree = new HashMap<>();
    HashMap<Reg, LinkedList<ASMMvInst>> moveList = new HashMap<>();
    HashMap<Reg, Reg> alias = new HashMap<>();
    HashMap<Reg, Integer> color = new HashMap<>();

    void addEdge(Reg u, Reg v) {
        Edge e = new Edge(u, v);
        if (u == v || adjSet.contains(e)) return;
        adjSet.add(e);
        if (!precolored.contains(u)) {
            adjList.get(u).add(v);
            degree.put(u, degree.get(u) + 1);
        }
        if (!precolored.contains(v)) {
            adjList.get(v).add(u);
            degree.put(v, degree.get(v) + 1);
        }
    }

    void init() {
        precolored.clear();
        initial.clear();
        simplifyWorklist.clear();
        freezeWorklist.clear();
        spillWorklist.clear();
        spilledNodes.clear();
        coalescedNodes.clear();
        coloredNodes.clear();
        selecStack.clear();

        coalescedMoves.clear();
        constrainedMoves.clear();
        frozenMoves.clear();
        worklistMoves.clear();
        activeMoves.clear();

        adjSet.clear();
        adjList.clear();
        degree.clear();
        moveList.clear();
        alias.clear();
        color.clear();

        for (var block : curFunc.blocks)
            for (var inst : block.insts) {
                initial.addAll(inst.def());
                initial.addAll(inst.use());
            }
        for (var n : BaseReg.regMap.values()) {
            precolored.add(n);
            adjList.put(n, new LinkedList<>());
            degree.put(n, 1000000007);
            moveList.put(n, new LinkedList<>());
            alias.put(n, null);
            color.put(n, n.id);
        }
        initial.removeAll(precolored);
        for (var n : initial) {
            adjList.put(n, new LinkedList<>());
            degree.put(n, 0);
            moveList.put(n, new LinkedList<>());
            alias.put(n, null);
            color.put(n, null);
        }
    }

    void build() {
        curFunc.blocks.forEach(block -> {
            HashSet<Reg> live = new HashSet<>(block.liveOut);
            for (int i = block.insts.size() - 1; i >= 0; i--) {
                ASMInst inst = block.insts.get(i);
                if (inst instanceof ASMMvInst mv) {
                    live.removeAll(inst.use());
                    inst.def().forEach(reg -> moveList.get(reg).add(mv));
                    inst.use().forEach(reg -> moveList.get(reg).add(mv));
                    worklistMoves.add(mv);
                }
                live.addAll(inst.def());

                inst.def().forEach(d -> {
                    live.forEach(l -> addEdge(l, d));
                });
                live.removeAll(inst.def());
                live.addAll(inst.use());
            }
        });
    }

    void makeWorklist() {
        for (var n : initial) {
            if (degree.get(n) >= K)
                spillWorklist.add(n);
            else if (moveRelated(n))
                freezeWorklist.add(n);
            else simplifyWorklist.add(n);
        }
        initial.clear();
    }   

    HashSet<Reg> adjacent(Reg n) {
        return new HashSet<>(adjList.get(n)) {
            {
                removeAll(selecStack);
                removeAll(coalescedNodes);
            }
        };
    }

    HashSet<ASMMvInst> nodeMoves(Reg n) {
        return new HashSet<>() {
            {
                addAll(activeMoves);
                addAll(worklistMoves);
                removeIf(i -> !moveList.get(n).contains(i));
            }
        };
    }

    boolean moveRelated(Reg n) {
        return !nodeMoves(n).isEmpty();
    }

    void simplify() {
        while (!simplifyWorklist.isEmpty()) {
            Reg n = simplifyWorklist.removeFirst();
            selecStack.push(n);
            adjacent(n).forEach(m -> decrementDegree(m));
        }
    }

    void decrementDegree(Reg m) {
        int d = degree.get(m);
        degree.put(m, d - 1);
        if (d == K) {
            enableMoves(new HashSet<>() {
                {
                    addAll(adjacent(m));
                    add(m);
                }
            });
            spillWorklist.remove(m);
            if (moveRelated(m)) 
                freezeWorklist.add(m);
            else simplifyWorklist.add(m);
        }
    }

    void enableMoves(HashSet<Reg> nodes) {
        nodes.forEach(n -> {
            nodeMoves(n).forEach(m -> {
                if (activeMoves.contains(m)) {
                    activeMoves.remove(m);
                    worklistMoves.add(m);
                }
            });
        });
    }

    void coalesce() {
        ASMMvInst m = worklistMoves.iterator().next();
        Reg x = getAlias(m.rd), y = getAlias(m.rs1);
        Reg u = x, v = y;
        if (precolored.contains(y)) {
            u = y;
            v = x;
        }
        worklistMoves.remove(m);
        if (u == v) {
            coalescedMoves.add(m);
            addWorklist(u);
        } else if (precolored.contains(v) || adjSet.contains(new Edge(u, v)) || u == regZero || v == regZero) {
            constrainedMoves.add(m);
            addWorklist(u);
            addWorklist(v);
        } else {
            boolean flag = true;
            for (var t : adjacent(v))
                flag &= OK(t, u);
            HashSet<Reg> uv = new HashSet<>();
            uv.addAll(adjacent(u));
            uv.addAll(adjacent(v));
            if (precolored.contains(u) && flag || !precolored.contains(u) && conservative(uv)) {
                coalescedMoves.add(m);
                combine(u, v);
                addWorklist(u);
            } else {
                activeMoves.add(m);
            }
        }
    }

    void addWorklist(Reg u) {
        if (!precolored.contains(u) && !moveRelated(u) && degree.get(u) < K) {
            freezeWorklist.remove(u);
            simplifyWorklist.add(u);
        }
    }

    boolean OK(Reg t, Reg r) {
        return degree.get(t) < K || precolored.contains(t) || adjSet.contains(new Edge(t, r));
    }

    boolean conservative(HashSet<Reg> nodes) {
        int k = 0;
        for (var n : nodes) 
            k += (degree.get(n) >= K ? 1 : 0);
        return k < K;
    }

    Reg getAlias(Reg n) {
        if (coalescedNodes.contains(n)) {
            Reg a = getAlias(alias.get(n));
            alias.put(n, a);
            return a;
        }
        return n;
    }

    void combine(Reg u, Reg v) {
        if (freezeWorklist.contains(v))
            freezeWorklist.remove(v);
        else spillWorklist.remove(v);
        coalescedNodes.add(v);
        alias.put(v, u);
        moveList.get(u).addAll(moveList.get(v));
        enableMoves(new HashSet<>() {
            { add(v); }
        });
        adjacent(v).forEach(t -> {
            addEdge(t, u);
            decrementDegree(t);
        });
        if (degree.get(u) >= K && freezeWorklist.contains(u)) {
            freezeWorklist.remove(u);
            spillWorklist.add(u);
        }
    }

    void freeze() {
        Reg u = freezeWorklist.removeFirst();
        simplifyWorklist.add(u);
        freezeMoves(u);
    }

    void freezeMoves(Reg u) {
        for (var m : nodeMoves(u)) {
            Reg x = m.rd, y = m.rs1, v;
            if (getAlias(y) == getAlias(u))
                v = getAlias(x);
            else v = getAlias(y);
            activeMoves.remove(m);
            frozenMoves.add(m);
            if (nodeMoves(v).isEmpty() && degree.get(v) < K) {
                freezeWorklist.remove(v);
                simplifyWorklist.add(v);
            }
        }
    }

    void selectSpill() {
        Reg m = null;
        for (var reg : spillWorklist)
            if (!newTemps.contains(reg)) {
                m = reg;
                break;
            }
        spillWorklist.remove(m);
        simplifyWorklist.add(m);
        freezeMoves(m);
    }

    void assignColors() {
        while (!selecStack.isEmpty()) {
            Reg n = selecStack.pop();
            HashSet<Integer> okColors = new HashSet<Integer>() {
                { for (int i = 5; i < 32; i++) add(i); }
            };
            for (var w : adjList.get(n)) {
                Reg a = getAlias(w);
                if (coloredNodes.contains(a) || precolored.contains(a)) 
                    okColors.remove(color.get(a));
            }
            if (okColors.isEmpty()) 
                spilledNodes.add(n);
            else {
                coloredNodes.add(n);
                color.put(n, okColors.iterator().next());
            }
        }
        coalescedNodes.forEach(n -> color.put(n, color.get(getAlias(n))));
    }

    HashSet<Reg> newTemps = new HashSet<>();
    void rewriteProgram() {
        for (Reg reg : spilledNodes) {
            ((MemReg) reg).stackOffset = curFunc.paramSize + curFunc.allocaSize + curFunc.spillSize;
            curFunc.spillSize += 4;
        }

        for (var block : curFunc.blocks) {
            LinkedList<ASMInst> newInsts = new LinkedList<>();
            for (var inst : block.insts) {
                MemReg temp = null;
                if (inst.rs1 != null && inst.rs1.stackOffset != null) {
                    MemReg reg = new MemReg(4);
                    newTemps.add(reg);
                    newInsts.add(new ASMLoadInst(reg, regSp, new Imm(inst.rs1.stackOffset)));
                    if (inst.rs1 == inst.rs2) 
                        inst.rs2 = reg;
                    if (inst.rs1 == inst.rd)
                        temp = reg;
                    inst.rs1 = reg;
                }
                if (inst.rs2 != null && inst.rs2.stackOffset != null) {
                    MemReg reg = new MemReg(4);
                    newTemps.add(reg);
                    newInsts.add(new ASMLoadInst(reg, regSp, new Imm(inst.rs2.stackOffset)));
                    if (inst.rs2 == inst.rd)
                        temp = reg;
                    inst.rs2 = reg;
                }
                newInsts.add(inst);
                if (inst.rd != null && inst.rd.stackOffset != null) {
                    MemReg reg = temp == null ? new MemReg(4) : temp;
                    newTemps.add(reg);
                    newInsts.add(new ASMStoreInst(reg, regSp, new Imm(inst.rd.stackOffset)));
                    inst.rd = reg;
                }
            }
            block.insts = newInsts;
        }
    }
}
