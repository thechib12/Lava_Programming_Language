package elaboration;

import grammar.LavaBaseVisitor;
import grammar.LavaLexer;
import grammar.LavaParser;
import model.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogier on 20-06-16 in Enschede.
 * Generator for the Lava IR language. The Lava IR has already the form of the Sprill, but is not one-to-one.
 * It misses some important keywords and uses unlimited registers. The Lava IR is saved into a {@link Program} object.
 */
public class Generator extends LavaBaseVisitor<Op>{
    /** The representation of the boolean value <code>false</code>. */
    public final static Addr FALSE_VALUE = new Addr(Addr.AddrType.ImmValue,0);
    /** The representation of the boolean value <code>true</code>. */
    public final static Addr TRUE_VALUE = new Addr(Addr.AddrType.ImmValue,1);

    /**
     * All labels belonging mapped to their correct nodes.
     */
    private ParseTreeProperty<Label> labels;

    /** The outcome of the checker phase. */
    private CheckerResult checkResult;

    /** The program being built. */
    private Program prog;
    /** Register count, used to generate fresh registers. */
    private int regCount;
    /** Association of expression and target nodes to registers. */
    private ParseTreeProperty<Reg> regs;


    /**
     * Generates Lava IR from the {@link CheckerResult} and {@link ParseTree}. Generating is done by visiting nodes
     * in the parse tree.
     * @param tree given parse tree from the {@link LavaParser}.
     * @param checkResult the result of the type checking phase.
     * @return a Program object containing all instructions in Lava IR language.
     */
    public Program generate(ParseTree tree, CheckerResult checkResult) {
        this.prog = new Program();
        this.checkResult = checkResult;
        this.regs = new ParseTreeProperty<>();
        this.labels = new ParseTreeProperty<>();
        this.regCount = 0;
        tree.accept(this);
        emit(OpCode.EndProg);
        return this.prog;
    }


    @Override
    public Op visitIfStat(LavaParser.IfStatContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        labels.put(ctx.expr(0), label);
        int statCount = ctx.block().size();
        int elseifCount = ctx.IF().size()-1;
        boolean hasElse = ctx.ELSE() != null && ctx.ELSE().size() == ctx.IF().size();

        List<Label> ifLabels = new ArrayList<>();
        for (int i = 1; i <= elseifCount; i++) {
            Label label1 = createLabel(ctx.expr(i),"elseif");
            ifLabels.add(label1);
            labels.put(ctx.expr(i), label1);
        }
        if (hasElse){
            Label label1 = createLabel(ctx.block(statCount-1),"else");
            labels.put(ctx.block(statCount-1),label1);
            ifLabels.add(label1);
        }
        Label label3 = createLabel(ctx,"endif");
        if (statCount == 1){
            visit(ctx.expr(0));
            emit(OpCode.LoadIm, new Addr(Addr.AddrType.ImmValue, 1), reg(ctx));
            emit(OpCode.Sub, reg(ctx), reg(ctx.expr(0)), reg(ctx));
            emit(OpCode.Branch, reg(ctx), label3);
            visit(ctx.block(0));
        } else {
            visit(ctx.expr(0));
            emit(OpCode.LoadIm, new Addr(Addr.AddrType.ImmValue, 1), reg(ctx));
            emit(OpCode.Sub, reg(ctx), reg(ctx.expr(0)), reg(ctx.expr(0)));
            emit(OpCode.Branch,reg(ctx.expr(0)), ifLabels.get(0));
            visit(ctx.block(0));
            emit(OpCode.Jump,label3);

            for (int i = 1; i < elseifCount; i++) {
                visit(ctx.expr(i));
                emit(OpCode.LoadIm, new Addr(Addr.AddrType.ImmValue, 1), reg(ctx));
                emit(OpCode.Sub, reg(ctx), reg(ctx.expr(i)), reg(ctx.expr(i)));
                emit(OpCode.Branch, reg(ctx.expr(i)), ifLabels.get(i));
                visit(ctx.block(i));
                emit(OpCode.Jump, label3);
            }

            if (hasElse){
                visit(ctx.expr(elseifCount));
                emit(OpCode.LoadIm, new Addr(Addr.AddrType.ImmValue, 1), reg(ctx));
                emit(OpCode.Sub, reg(ctx), reg(ctx.expr(elseifCount)), reg(ctx.expr(elseifCount)));
                emit(OpCode.Branch, reg(ctx.expr(elseifCount)), ifLabels.get(ifLabels.size() - 1));
                visit(ctx.block(elseifCount));
                emit(OpCode.Jump, label3);
                visit(ctx.block(elseifCount + 1));


            } else {
                visit(ctx.expr(elseifCount));
                emit(OpCode.LoadIm, new Addr(Addr.AddrType.ImmValue, 1), reg(ctx));
                emit(OpCode.Sub, reg(ctx), reg(ctx.expr(elseifCount)), reg(ctx.expr(elseifCount)));
                emit(OpCode.Branch, reg(ctx.expr(elseifCount)), label3);
                visit(ctx.block(elseifCount));
                emit(OpCode.Jump, label3);
            }


        }



        return emit(label3, OpCode.Nop);
    }

    @Override
    public Op visitAssignStat(LavaParser.AssignStatContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        labels.put(ctx.expr(),label);
        visit(ctx.expr());
        return emit( OpCode.StoreD, reg(ctx.expr()),new Addr(Addr.AddrType.DirAddr,checkResult.getOffset(ctx)));
    }

    @Override
    public Op visitWhileStat(LavaParser.WhileStatContext ctx) {
        Label label1 = createLabel(ctx,"while");
        labels.put(ctx.expr(),label1);
        Label label2 = createLabel(ctx, "body");
        labels.put(ctx.block(),label2);
        Label label3 = createLabel(ctx,"endwhile");
        visit(ctx.expr());
        emit(OpCode.LoadIm, new Addr(Addr.AddrType.ImmValue, 1), reg(ctx));
        emit(OpCode.Sub, reg(ctx), reg(ctx.expr()), reg(ctx));
        emit(OpCode.Branch, reg(ctx), label3);
        visit(ctx.block());
        emit(OpCode.Jump,label1);
        return emit(label3,OpCode.Nop);
    }

    @Override
    public Op visitLocalVariableDeclarationStatement(LavaParser.LocalVariableDeclarationStatementContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        labels.put(ctx.localVariableDeclaration(),label);

        return super.visitLocalVariableDeclarationStatement(ctx);
    }

    @Override
    public Op visitPrimDecl(LavaParser.PrimDeclContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        if (ctx.expr() != null){
            labels.put(ctx.expr(),label);
            visit(ctx.expr());
            return emit( OpCode.StoreD, reg(ctx.expr()),new Addr(Addr.AddrType.DirAddr,checkResult.getOffset(ctx)));
        } else {
            emit(label,OpCode.LoadIm, new Addr(Addr.AddrType.ImmValue,0),reg(ctx));
            return emit( OpCode.StoreD, reg(ctx),new Addr(Addr.AddrType.DirAddr,checkResult.getOffset(ctx)));
        }


    }

    @Override
    public Op visitBlock(LavaParser.BlockContext ctx) {
        if (hasLabel(ctx)){
            labels.put(ctx.blockStatements(),labels.get(ctx));
        }
        return super.visitBlock(ctx);
    }

    @Override
    public Op visitBlockStatements(LavaParser.BlockStatementsContext ctx) {
        if (hasLabel(ctx)){
            labels.put(ctx.blockStatement(0),labels.get(ctx));
        }

        return super.visitBlockStatements(ctx);
    }

    @Override
    public Op visitBlockStatement(LavaParser.BlockStatementContext ctx) {
        if (hasLabel(ctx)){
            labels.put(ctx.getChild(0),labels.get(ctx));
        }

        return super.visitBlockStatement(ctx);
    }

    @Override
    public Op visitBody(LavaParser.BodyContext ctx) {
        return super.visitBody(ctx);
    }

    @Override
    public Op visitProgram(LavaParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    @Override
    public Op visitMain(LavaParser.MainContext ctx) {
        return super.visitMain(ctx);
    }

    @Override
    public Op visitParExpr(LavaParser.ParExprContext ctx) {
        if (hasLabel(ctx)){
            labels.put(ctx.expr(),labels.get(ctx));
        }

        visit(ctx.expr());
        emit(OpCode.LoadIm, new Addr(Addr.AddrType.ImmValue, 0), reg(ctx));
        return emit(OpCode.Add, reg(ctx.expr()), reg(ctx), reg(ctx));
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
            emit(OpCode.LoadIm,new Addr(Addr.AddrType.ImmValue,0),reg(ctx));
            operation = emit(OpCode.Sub,reg(ctx),reg(ctx.expr()),reg(ctx));
        } else {
            emit(OpCode.LoadIm,new Addr(Addr.AddrType.ImmValue,1),reg(ctx));
            operation = emit(OpCode.Sub,reg(ctx),reg(ctx.expr()),reg(ctx));
        }
        return operation;
    }


    @Override
    public Op visitCharExpr(LavaParser.CharExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        return emit(label,OpCode.LoadIm,new Addr(Addr.AddrType.ImmValue,Character.getNumericValue(ctx.CHARACTER().getText().charAt(1))),reg(ctx));
    }

    @Override
    public Op visitTrueExpr(LavaParser.TrueExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        return emit(label,OpCode.LoadIm,TRUE_VALUE,reg(ctx));
    }

    @Override
    public Op visitNumExpr(LavaParser.NumExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        return emit(label,OpCode.LoadIm,new Addr(Addr.AddrType.ImmValue,Integer.parseInt(ctx.NUM().getText())),reg(ctx));
    }

    @Override
    public Op visitFalseExpr(LavaParser.FalseExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        return emit(label,OpCode.LoadIm,FALSE_VALUE,reg(ctx));
    }

    @Override
    public Op visitIdExpr(LavaParser.IdExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        return emit(label,OpCode.LoadD,new Addr(Addr.AddrType.DirAddr,checkResult.getOffset(ctx)),reg(ctx));
    }

    /**
     * @param node current node.
     * @return if this node has a label
     */
    private boolean hasLabel(ParseTree node){
        return labels.get(node) != null;
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
        return emit(null, opCode, args);
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


//    /** Assigns a register to a given parse tree node. */
//    private void setReg(ParseTree node, Reg reg) {
//        this.regs.put(node, reg);
//    }

    public static void main(String[] args) {
        Checker checker = new Checker();
        Generator generator = new Generator();
        CharStream input;

        File file = new File("src/main/java/testprograms/gauss.magma");
        input = null;
        try {
            input = new ANTLRInputStream(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new LavaLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        LavaParser parser = new LavaParser(tokens);


        ParseTree tree = parser.program();
        Program program = generator.generate(tree,checker.check(tree));
        System.out.println(program.toString());
    }

}
