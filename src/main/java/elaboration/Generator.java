package elaboration;

import grammar.LavaBaseVisitor;
import grammar.LavaParser;
import model.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogier on 20-06-16 in Enschede.
 */
public class Generator extends LavaBaseVisitor<Op>{
    /** The representation of the boolean value <code>false</code>. */
    public final static Num FALSE_VALUE = new Num(0);
    /** The representation of the boolean value <code>true</code>. */
    public final static Num TRUE_VALUE = new Num(-1);


    private ParseTreeProperty<Label> labels;

    /** The outcome of the checker phase. */
    private CheckerResult checkResult;

    /** The program being built. */
    private Program prog;
    /** Register count, used to generate fresh registers. */
    private int regCount;
    /** Association of expression and target nodes to registers. */
    private ParseTreeProperty<Reg> regs;

    public Program generate(ParseTree tree, CheckerResult checkResult) {
        this.prog = new Program();
        this.checkResult = checkResult;
        this.regs = new ParseTreeProperty<>();
        this.labels = new ParseTreeProperty<>();
        this.regCount = 0;
        tree.accept(this);
        return this.prog;
    }


    @Override
    public Op visitIfStat(LavaParser.IfStatContext ctx) {
//        Label label = null;
//        if (hasLabel(ctx)){
//            label = labels.get(ctx);
//        }
//        labels.put(ctx.expr(0), label);
//        int statCount = ctx.block().size();
//        Label label1 = createLabel(ctx,"then");
//        labels.put(ctx.block(0),label1);
//        Label label3 = createLabel(ctx,"endif");
//        Label label2;
//        if (statCount > 2){
//            label2 = createLabel(ctx, "elseif");
//        } else if (statCount == 2){
//            label2 = createLabel(ctx,"else");
//            labels.put(ctx.block(1),label2);
//        } else {
//            label2 = label3;
//        }
//        visit(ctx.expr(0));
//        emit(OpCode.Branch,reg(ctx.expr(0)), label2);
//        visit(ctx.block(0));
//        emit(OpCode.Jump,label3);
//        if (statCount == 2){
//            visit(ctx.stat(1));
//        }


        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        labels.put(ctx.expr(0), label);
        int statCount = ctx.block().size();
        List<Label> ifLabels = new ArrayList<>();
        for (int i = 1; i < statCount - 1; i++) {
            Label label1 = createLabel(ctx.expr(i),"elseif");
            ifLabels.add(label1);
            labels.put(ctx.block(i),label1);
        }
        if (ctx.ELSE() != null && ctx.ELSE().size() == ctx.IF().size()){
            Label label1 = createLabel(ctx.block(statCount-1),"else");
            labels.put(ctx.block(statCount-1),label1);
        }
        Label label3 = createLabel(ctx,"endif");
        if (statCount == 1){
            visit(ctx.expr(0));
            emit(OpCode.Branch,reg(ctx.expr(0)), label3);
        } else {
            visit(ctx.expr(0));


        }




        return emit(label3, OpCode.Nop);
    }

    @Override
    public Op visitAssignStat(LavaParser.AssignStatContext ctx) {
        return super.visitAssignStat(ctx);
    }

    @Override
    public Op visitWhileStat(LavaParser.WhileStatContext ctx) {
        return super.visitWhileStat(ctx);
    }

    @Override
    public Op visitParExpr(LavaParser.ParExprContext ctx) {
        if (hasLabel(ctx)){
            labels.put(ctx.expr(),labels.get(ctx));
        }
        visit(ctx.expr());
        return super.visitParExpr(ctx);
    }

    @Override
    public Op visitMultExpr(LavaParser.MultExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        labels.put(ctx.expr(0),label);
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        OpCode opCode = null;
        if (ctx.multOp().STAR() != null){
            opCode = OpCode.Mul;
        }
        return emit(opCode,reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
    }


    @Override
    public Op visitPlusExpr(LavaParser.PlusExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        labels.put(ctx.expr(0),label);
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        OpCode opCode;
        if (ctx.plusOp().PLUS() != null){
            opCode = OpCode.Add;
        } else {
            opCode = OpCode.Sub;
        }

        return emit(opCode,reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
    }

    @Override
    public Op visitBoolExpr(LavaParser.BoolExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        labels.put(ctx.expr(0),label);
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        OpCode opCode;
        if (ctx.boolOp().AND() != null){
            opCode = OpCode.And;
        } else if (ctx.boolOp().XOR() != null) {

            opCode = OpCode.Xor;
        } else {
            opCode = OpCode.Or;
        }

        return emit(opCode,reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
    }

    @Override
    public Op visitCompExpr(LavaParser.CompExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        labels.put(ctx.expr(0),label);
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        int ruleIndex = ((TerminalNode) ctx.compOp().getChild(0)).getSymbol().getType();
        OpCode opCode = null;
        switch (ruleIndex){
            case LavaParser.LE:
                opCode = OpCode.LtE;
                break;
            case LavaParser.LT:
                opCode = OpCode.Lt;
                break;
            case LavaParser.GE:
                opCode = OpCode.GtE;
                break;
            case LavaParser.GT:
                opCode = OpCode.Gt;
                break;
            case LavaParser.EQ:
                opCode = OpCode.Equal;
                break;


        }

        return emit(opCode, reg(ctx.expr(0)),reg(ctx.expr(1)),reg(ctx));
    }

    @Override
    public Op visitNotExpr(LavaParser.NotExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        labels.put(ctx.expr(),label);
        visit(ctx.expr());
        Op operation;
        if (ctx.negaOp().MINUS() != null){
            emit(OpCode.LoadIm,new Addr(0,true),reg(ctx));
            operation = emit(OpCode.Sub,reg(ctx),reg(ctx.expr()),reg(ctx));
        } else {
            emit(OpCode.LoadIm,new Addr(0,true),reg(ctx));
            operation = emit(OpCode.Equal,reg(ctx.expr()),reg(ctx),reg(ctx));
        }
        return operation;
    }

    private boolean hasLabel(ParseTree node){
        return labels.get(node) != null;
    }

    private Label label(ParserRuleContext node) {
        Label result = this.labels.get(node);
        if (result == null) {
            ParserRuleContext entry = this.checkResult.getEntry(node);
            result = createLabel(entry, "n");
            this.labels.put(node, result);
        }
        return result;
    }

    /** Creates a label for a given parse tree node and prefix. */
    private Label createLabel(ParserRuleContext node, String prefix) {
        Token token = node.getStart();
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        String result = prefix + "_" + line + "_" + column;
        return new Label(result);
    }

    // Override the visitor methods
    /** Constructs an operation from the parameters
     * and adds it to the program under construction. */
    private Op emit(Label label, OpCode opCode, Operand... args) {
        Op result = new Op(label, opCode, args);
        this.prog.addInstr(result);
        return result;
    }

    /** Constructs an operation from the parameters
     * and adds it to the program under construction. */
    private Op emit(OpCode opCode, Operand... args) {
        return emit((Label) null, opCode, args);
    }

    /** Retrieves the offset of a variable node from the checker result,
     * wrapped in a {@link Num} operand. */
    private Num offset(ParseTree node) {
        return new Num(this.checkResult.getOffset(node));
    }

    /** Returns a register for a given parse tree node,
     * creating a fresh register if there is none for that node. */
    private Reg reg(ParseTree node) {
        Reg result = this.regs.get(node);
        if (result == null) {
            result = new Reg("r_" + this.regCount);
            this.regs.put(node, result);
            this.regCount++;
        }
        return result;
    }





    /** Assigns a register to a given parse tree node. */
    private void setReg(ParseTree node, Reg reg) {
        this.regs.put(node, reg);
    }
}
