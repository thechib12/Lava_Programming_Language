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
import java.util.Map;

import static model.OpCode.*;


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

    public final static int SHARED_OFFSET = 4;

    public final static Addr LOCK = new Addr(Addr.AddrType.DirAddr, 4);


    private int forkcount = 0;

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

    private String currentFunction;

    private List<Program> programs;

    private Map<String, Label> funcmap;

    private static final Reg REG_ZERO = new Reg("reg0");

    private ParseTree tree;


    protected void init(ParseTree tree, CheckerResult checkResult) {
        this.tree = tree;
        this.prog = new Program();
        this.checkResult = checkResult;
        this.regs = new ParseTreeProperty<>();
        this.labels = new ParseTreeProperty<>();
        programs = new ArrayList<>();
        programs.add(prog);
        this.funcmap = new FunctionLabeler().labelFunc(tree);
        this.regCount = 0;
    }



    /**
     * Generates Lava IR from the {@link CheckerResult} and {@link ParseTree}. Generating is done by visiting nodes
     * in the parse tree.
     * @param tree given parse tree from the {@link LavaParser}.
     * @param checkResult the result of the type checking phase.
     * @return a Program object containing all instructions in Lava IR language.
     */
    public List<Program> generate(ParseTree tree, CheckerResult checkResult) {
        this.init(tree, checkResult);

        tree.accept(this);
        return this.programs;
    }


    @Override
    public Op visitIfStat(LavaParser.IfStatContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }

//        TODO Look at label
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
            emit(Branch, reg(ctx), label3);
            visit(ctx.block(0));
        } else {
            visit(ctx.expr(0));
            emit(Branch, reg(ctx.expr(0)), ifLabels.get(0));
            visit(ctx.block(0));
            emit(Jump, label3);

            for (int i = 1; i < elseifCount; i++) {
                visit(ctx.expr(i));
                emit(Branch, reg(ctx.expr(i)), ifLabels.get(i));
                visit(ctx.block(i));
                emit(Jump, label3);
            }

            if (hasElse){
                visit(ctx.expr(elseifCount));
                emit(Branch, reg(ctx.expr(elseifCount)), ifLabels.get(ifLabels.size() - 1));
                visit(ctx.block(elseifCount));
                emit(Jump, label3);
                visit(ctx.block(elseifCount + 1));


            } else {
                visit(ctx.expr(elseifCount));
                emit(Branch, reg(ctx.expr(elseifCount)), label3);
                visit(ctx.block(elseifCount));
                emit(Jump, label3);
            }


        }


        return emit(label3, Nop);
    }

    @Override
    public Op visitAssignStat(LavaParser.AssignStatContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        labels.put(ctx.expr(),label);
        visit(ctx.expr());
        if (checkResult.getSharedVar(ctx)) {
//            Label label1 = createLabel(ctx, "lock");
//            emit(label1, TestAndSetD, LOCK);
//            emit(Receive, reg(ctx));
//            emit(Branch, reg(ctx), label1);
            return emit(WriteD, reg(ctx.expr()),
                    new Addr(Addr.AddrType.DirAddr, checkResult.getOffset(ctx) + SHARED_OFFSET));
//            return emit(WriteD, REG_ZERO, LOCK);
        } else {
            return emit(StoreD, reg(ctx.expr()), new Addr(Addr.AddrType.DirAddr, checkResult.getOffset(ctx)));
        }
    }

    @Override
    public Op visitFunctionStat(LavaParser.FunctionStatContext ctx) {
        if (ctx.function().ID().getText().equals("fork") && forkcount < 3) {
//            TODO: check for correct func call;
            String forkfunc = ((LavaParser.FunctionExprContext) ctx.function().parameters().expr(0)).function().ID().getText();
            ForkGenerator forkGenerator = new ForkGenerator();
            forkcount++;
            programs.add(forkGenerator.generate(tree, checkResult, forkfunc, forkcount));
            emit(WriteD, REG_ZERO, new Addr(Addr.AddrType.DirAddr, forkcount));
        } else if (ctx.function().ID().getText().equals("fork") && forkcount >= 3) {
//            adderror.
            String error = "to many forks for this sprockell";
        } else if (ctx.function().ID().getText().equals("join")) {
            visit(ctx.function().parameters().expr(0));
            Label label = createLabel(ctx, "join");
            emit(label, TestAndSetD, new Addr(Addr.AddrType.IndAddr, reg(ctx.function().parameters().expr(0))));
            emit(Receive, reg(ctx));
            emit(Branch, reg(ctx), label);
        } else if (ctx.function().ID().getText().equals("lock")) {
            Label label1 = createLabel(ctx, "lock");
            emit(label1, TestAndSetD, LOCK);
            emit(Receive, reg(ctx));
            emit(Branch, reg(ctx), label1);
        } else if (ctx.function().ID().getText().equals("unlock")) {
            emit(WriteD, REG_ZERO, LOCK);
        }

        return null;
    }

    @Override
    public Op visitWhileStat(LavaParser.WhileStatContext ctx) {
        Label label1 = createLabel(ctx,"while");
        labels.put(ctx.expr(),label1);
        Label label2 = createLabel(ctx, "body");
        labels.put(ctx.block(),label2);
        Label label3 = createLabel(ctx,"endwhile");
        visit(ctx.expr());
        emit(Branch, reg(ctx.expr()), label3);
        visit(ctx.block());
        emit(Jump, label1);
        return emit(label3, Nop);
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

    public Program getProg() {
        return prog;
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
            if (checkResult.getSharedVar(ctx)) {
//                Label label1 = createLabel(ctx, "lock");
//                emit(label1, TestAndSetD, LOCK);
//                emit(Receive, reg(ctx));
//                emit(Branch, reg(ctx), label1);
                return emit(WriteD, reg(ctx.expr()),
                        new Addr(Addr.AddrType.DirAddr, checkResult.getOffset(ctx) + SHARED_OFFSET));
//                return emit(WriteD, REG_ZERO, LOCK);
            } else {
                return emit(StoreD, reg(ctx.expr()), new Addr(Addr.AddrType.DirAddr, checkResult.getOffset(ctx)));
            }

        } else {
            if (checkResult.getSharedVar(ctx)) {
//                Label label1 = createLabel(ctx, "lock");
//                emit(label1, TestAndSetD, LOCK);
//                emit(Receive, reg(ctx));
//                emit(Branch, reg(ctx), label1);
                return emit(WriteD, REG_ZERO,
                        new Addr(Addr.AddrType.DirAddr, checkResult.getOffset(ctx) + SHARED_OFFSET));
//                return emit(WriteD, REG_ZERO, LOCK);
            } else {
                return emit(StoreD, REG_ZERO, new Addr(Addr.AddrType.DirAddr, checkResult.getOffset(ctx)));
            }
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
        for (LavaParser.LocalVariableDeclarationStatementContext decl : ctx.localVariableDeclarationStatement()) {
            visit(decl);
        }
        visit(ctx.main());
        for (LavaParser.FunctionDeclContext func : ctx.functionDecl()) {
            visit(func);
        }
        return null;
    }

    @Override
    public Op visitMain(LavaParser.MainContext ctx) {
        visitChildren(ctx);
        return emit(EndProg);
    }

    @Override
    public Op visitParExpr(LavaParser.ParExprContext ctx) {
        if (hasLabel(ctx)){
            labels.put(ctx.expr(),labels.get(ctx));
        }
        visit(ctx.expr());

        return emit(Add, reg(ctx.expr()), REG_ZERO, reg(ctx));
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
            opCode = Mul;
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
            opCode = Add;
        } else {
            opCode = Sub;
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
            opCode = And;
        } else if (ctx.boolOp().XOR() != null) {
            opCode = Xor;
        } else {
            opCode = Or;
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
                opCode = LtE;
                break;
            case LavaParser.LT:
                opCode = Lt;
                break;
            case LavaParser.GE:
                opCode = GtE;
                break;
            case LavaParser.GT:
                opCode = Gt;
                break;
            case LavaParser.EQ:
                opCode = Equal;
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
            emit(LoadIm, new Addr(Addr.AddrType.ImmValue, 0), reg(ctx));
            operation = emit(Sub, reg(ctx), reg(ctx.expr()), reg(ctx));
        } else {
            emit(LoadIm, new Addr(Addr.AddrType.ImmValue, 1), reg(ctx));
            operation = emit(Sub, reg(ctx), reg(ctx.expr()), reg(ctx));
        }
        return operation;
    }


    @Override
    public Op visitCharExpr(LavaParser.CharExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        return emit(label, LoadIm, new Addr(Addr.AddrType.ImmValue, Character.getNumericValue(ctx.CHARACTER().getText().charAt(1))), reg(ctx));
    }

    @Override
    public Op visitTrueExpr(LavaParser.TrueExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        return emit(label, LoadIm, TRUE_VALUE, reg(ctx));
    }

    @Override
    public Op visitNumExpr(LavaParser.NumExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        return emit(label, LoadIm, new Addr(Addr.AddrType.ImmValue, Integer.parseInt(ctx.NUM().getText())), reg(ctx));
    }

    @Override
    public Op visitFalseExpr(LavaParser.FalseExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        return emit(label, LoadIm, FALSE_VALUE, reg(ctx));
    }

    @Override
    public Op visitIdExpr(LavaParser.IdExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)){
            label = labels.get(ctx);
        }
        if (checkResult.getSharedVar(ctx)) {
//            Label label1 = createLabel(ctx, "lock");
//            emit(label, Nop);
//            emit(label1, TestAndSetD, LOCK);
//            emit(Receive, reg(ctx));
//            emit(Branch, reg(ctx), label1);
            emit(ReadD, new Addr(Addr.AddrType.DirAddr, checkResult.getOffset(ctx) + SHARED_OFFSET));
            return emit(Receive, reg(ctx));
//            return emit(WriteD, REG_ZERO, LOCK);
        } else {
            return emit(label, LoadD, new Addr(Addr.AddrType.DirAddr, checkResult.getOffset(ctx)), reg(ctx));
        }

    }

    @Override
    public Op visitFunctionExpr(LavaParser.FunctionExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        visitChildren(ctx);
        emit(LoadIm, new Addr(Addr.AddrType.ImmValue, prog.size() + SHARED_OFFSET), reg(ctx));
        emit(Push, reg(ctx));
        emit(label, Jump, funcmap.get(ctx.function().ID().getText()));
        return emit(Pop, reg(ctx));
    }

    @Override
    public Op visitReturnStat(LavaParser.ReturnStatContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        labels.put(ctx.expr(), label);
        visit(ctx.expr());
        emit(Pop, reg(ctx));
        emit(Push, reg(ctx.expr()));
        return emit(JumpI, new Target(reg(ctx)));
    }


    @Override
    public Op visitFunctionDecl(LavaParser.FunctionDeclContext ctx) {
        currentFunction = ctx.ID().getText();
        Label label = funcmap.get(currentFunction);

        List<Reg> regs = new ArrayList<>();
        emit(label, Pop, reg(ctx));
        for (int i = 0; i < ctx.parametersDecl().VARID().size(); i++) {
            Reg reg = new Reg("r_1_" + i);
            regs.add(reg);
            emit(Pop, reg);
        }
        emit(Push, reg(ctx));
        for (Reg reg : regs) {
            emit(Push, reg);
        }


        visitParametersDecl(ctx.parametersDecl());
        visitBlock(ctx.block());
        return emit(JumpI, new Target(reg(ctx)));
    }

    @Override
    public Op visitParametersDecl(LavaParser.ParametersDeclContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        Op operation = null;
        if (ctx.VARID().size() > 0) {
            for (int i = 0; i < ctx.VARID().size(); i++) {
                emit(Pop, reg(ctx));

                operation = emit(StoreD, reg(ctx), new Addr(Addr.AddrType.DirAddr, checkResult.getOffset(ctx.VARID(i))));
            }
        }


        return operation;
    }

    @Override
    public Op visitParameters(LavaParser.ParametersContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        Op operation = null;
        if (ctx.expr().size() > 0) {
            labels.put(ctx.expr(0), label);
            for (int i = 0; i < ctx.expr().size(); i++) {
                visit(ctx.expr(i));
                operation = emit(Push, reg(ctx.expr(i)));
            }
        }

        return operation;
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
    protected Op emit(Label label, OpCode opCode, Operand... args) {
        Op result = new Op(label, opCode, args);
        if (prog == null) {
            System.out.println("fout");
        }
        this.prog.addInstr(result);
        return result;
    }

    /** Constructs an operation from the parameters
     * and adds it to the program under construction. */
    protected Op emit(OpCode opCode, Operand... args) {
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

    private int offset(ParseTree node) {

        return this.checkResult.getOffset(node);
    }



    public static void main(String[] args) {
        Checker checker = new Checker();
        Generator generator = new Generator();
        CharStream input;

        File file = new File("src/main/java/testprograms/tester.magma");
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
        CheckerResult result = checker.check(tree);
        System.out.println(checker.getErrors());
        List<Program> program = generator.generate(tree, result);
        System.out.println(program.toString());
    }

}
