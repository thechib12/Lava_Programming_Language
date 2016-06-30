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
public class Generator extends LavaBaseVisitor<Op> {
    /**
     * The representation of the boolean value <code>false</code>.
     */
    private final static Addr FALSE_VALUE = new Addr(Addr.AddrType.ImmValue, 0);
    /** The representation of the boolean value <code>true</code>. */
    private final static Addr TRUE_VALUE = new Addr(Addr.AddrType.ImmValue, 1);

    private final static int MAX_THREADS = 6;

    private final static int SHARED_OFFSET = MAX_THREADS * 2;

    private final static Addr LOCK = new Addr(Addr.AddrType.DirAddr, SHARED_OFFSET);

    private int localVarCount = 0;

    private int forkCount = 0;

    /**
     * All labels belonging mapped to their correct nodes.
     */
    private ParseTreeProperty<Label> labels;

    /**
     * The outcome of the checker phase.
     */
    private CheckerResult checkResult;

    /**
     * The program being built.
     */
    private Program prog;
    /**
     * Register count, used to generate fresh registers.
     */
    private int regCount;
    /**
     * Association of expression and target nodes to registers.
     */
    private ParseTreeProperty<Reg> registers;

    private List<Program> programs;

    private Map<String, Label> functionLabelMapping;

    private static final Reg REG_ZERO = new Reg("reg0");

    private ParseTree tree;

    private List<String> errors;



    protected void init(ParseTree tree, CheckerResult checkResult) {
        this.tree = tree;
        this.errors = new ArrayList<>();
        this.prog = new Program();
        this.checkResult = checkResult;
        this.registers = new ParseTreeProperty<>();
        this.labels = new ParseTreeProperty<>();
        programs = new ArrayList<>();
        programs.add(prog);
        this.functionLabelMapping = new FunctionLabeler().labelFunc(tree);
        this.regCount = 0;
    }


    /**
     * Generates Lava IR from the {@link CheckerResult} and {@link ParseTree}. Generating is done by visiting nodes
     * in the parse tree.
     *
     * @param tree        given parse tree from the {@link LavaParser}.
     * @param checkResult the result of the type checking phase.
     * @return a Program object containing all instructions in Lava IR language.
     */
    public List<Program> generate(ParseTree tree, CheckerResult checkResult) throws ParseException {
        this.init(tree, checkResult);

        tree.accept(this);
        if (errors.size() > 0) {
            throw new ParseException(errors);
        }
        return this.programs;
    }

//    Program ---------------------------------------------------------------------------------------------------------
//    =================================================================================================================
//    -----------------------------------------------------------------------------------------------------------------

    @Override
    public Op visitBody(LavaParser.BodyContext ctx) {
//        First initialize all global variables
        ctx.localVariableDeclarationStatement().forEach(this::visit);
//        Then visit the main function as it is the first to execute.
        if (ctx.main() != null) {
            visit(ctx.main());
        }
//        At last visit all other functions.
        ctx.functionDeclaration().forEach(this::visit);
        return null;
    }

    @Override
    public Op visitMain(LavaParser.MainContext ctx) {
        localVarCount = 0;
        visitChildren(ctx);
        return emit(EndProg);
    }

//    Function --------------------------------------------------------------------------------------------------------
//    =================================================================================================================
//    -----------------------------------------------------------------------------------------------------------------

    @Override
    public Op visitFunctionDeclaration(LavaParser.FunctionDeclarationContext ctx) {
        localVarCount = 0;
        String currentFunction = ctx.ID().getText();
        Label label = functionLabelMapping.get(currentFunction);
//        Rearrange the stack layout
        emit(label, Pop, reg(ctx));
//        Reset stackpointer
        emit(DecrSP);
//        visitParametersDeclaration(ctx.parametersDeclaration());
        visitBlock(ctx.block());
        return emit(JumpI, new Target(reg(ctx)));
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
            for (int i = ctx.expr().size() - 1; i >= 0; i--) {
                visit(ctx.expr(i));
                // push parameters on the stack
                operation = emit(Push, reg(ctx.expr(i)));
            }

        } else {
            emit(label, Nop);
        }

        return operation;
    }

    @Override
    public Op visitFunctionCall(LavaParser.FunctionCallContext ctx) {
        Label label1 = createLabel(ctx, "return_" + ctx.ID().getText());

        visit(ctx.parameters());

        //        Allocate place for return value
        emit(Push, REG_ZERO);
//        Calculate the return address
        emit(LoadIm, new Addr(Addr.AddrType.ImmValueLab, label1), reg(ctx));
//        Push the return address on the stack
        emit(Push, reg(ctx));
//        Jump to the function
        emit(Jump, functionLabelMapping.get(ctx.ID().getText()));
//        Pop the return address
        emit(label1, Pop, REG_ZERO);
//        Pop the return value
        emit(Pop, reg(ctx));
//        Pop the parameters and set the stack pointer to original point
        for (int i = 0; i < ctx.parameters().expr().size(); i++) {
            emit(Pop, REG_ZERO);
        }

        return null;
    }

    //    Block -----------------------------------------------------------------------------------------------------------
//    =================================================================================================================
//    -----------------------------------------------------------------------------------------------------------------

    @Override
    public Op visitBlock(LavaParser.BlockContext ctx) {

        if (hasLabel(ctx)) {
            labels.put(ctx.blockStatement(0), labels.get(ctx));
        }
        return super.visitBlock(ctx);
    }

    @Override
    public Op visitBlockStatement(LavaParser.BlockStatementContext ctx) {
        if (hasLabel(ctx)) {
            labels.put(ctx.getChild(0), labels.get(ctx));
        }

        return super.visitBlockStatement(ctx);
    }


//    Variable declaration and assignment -----------------------------------------------------------------------------
//    =================================================================================================================
//    -----------------------------------------------------------------------------------------------------------------

    @Override
    public Op visitLocalVariableDeclarationStatement(LavaParser.LocalVariableDeclarationStatementContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        labels.put(ctx.localVariableDeclaration(), label);

        return super.visitLocalVariableDeclarationStatement(ctx);
    }



    @Override
    public Op visitPrimitiveDeclaration(LavaParser.PrimitiveDeclarationContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        if (ctx.expr() != null) {
            labels.put(ctx.expr(), label);
            visit(ctx.expr());
            localVarCount++;
            if (isShared(ctx)) {
                return emit(WriteD, reg(ctx.expr()),
                        new Addr(Addr.AddrType.DirAddr, offset(ctx) + SHARED_OFFSET));
            } else if (isLocal(ctx)) {
                return emit(Push, reg(ctx.expr()));
            } else {
                return emit(StoreD, reg(ctx.expr()), new Addr(Addr.AddrType.DirAddr, offset(ctx)));
            }

        } else {
            localVarCount++;
            if (isShared(ctx)) {
                return emit(WriteD, REG_ZERO,
                        new Addr(Addr.AddrType.DirAddr, offset(ctx) + SHARED_OFFSET));
            } else if (isLocal(ctx)) {
                return emit(Push, REG_ZERO);
            } else {
                return emit(StoreD, REG_ZERO, new Addr(Addr.AddrType.DirAddr, offset(ctx)));
            }
        }
    }


//    Statement -------------------------------------------------------------------------------------------------------
//    =================================================================================================================
//    -----------------------------------------------------------------------------------------------------------------

    @Override
    public Op visitIfStat(LavaParser.IfStatContext ctx) {
        if (hasLabel(ctx)) {
            setLabel(ctx.expr(0), labels.get(ctx));
        }

        int numberOfBlocks = ctx.block().size();
        int elseifCount = ctx.IF().size() - 1;
        boolean hasElse = ctx.ELSE() != null && ctx.ELSE().size() == ctx.IF().size();

        List<Label> ifLabels = new ArrayList<>();
        for (int i = 1; i <= elseifCount; i++) {
            Label elseIfLabel = createLabel(ctx.expr(i), "elseif");
            ifLabels.add(elseIfLabel);
            setLabel(ctx.expr(i), elseIfLabel);
        }
        if (hasElse) {
            Label elseLabel = createLabel(ctx.block(numberOfBlocks - 1), "else");
            setLabel(ctx.block(numberOfBlocks - 1), elseLabel);
            ifLabels.add(elseLabel);
        }
        Label label3 = createLabel(ctx, "endif");
        if (numberOfBlocks == 1) {
            visit(ctx.expr(0));
            emit(Branch, reg(ctx.expr(0)), label3);
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
            if (hasElse) {
                if (elseifCount > 0) {
                    visit(ctx.expr(elseifCount));
                    emit(Branch, reg(ctx.expr(elseifCount)), ifLabels.get(ifLabels.size() - 1));
                    visit(ctx.block(elseifCount));
                    emit(Jump, label3);
                }

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
        if (hasLabel(ctx)) {
            setLabel(ctx.expr(), labels.get(ctx));
        }
        visit(ctx.expr());
        if (isShared(ctx)) {
//            Calculate the address of the shared variable
            Addr addr = new Addr(Addr.AddrType.DirAddr, offset(ctx) + SHARED_OFFSET);
//            Write to the shared memory
            return emit(WriteD, reg(ctx.expr()), addr);
        } else {
            if (isParameter(ctx)) {
//                Set the stack pointer to the right variable
                emit(Pop, REG_ZERO);
                for (int i = 1; i < localVarCount + offset(ctx) + 1; i++) {
                    emit(Pop, REG_ZERO);
                }
//                Pop the variable and put in this register
                emit(Pop, REG_ZERO);
//                Push the new variable
                emit(Push, reg(ctx.expr()));
//                Reset the stack pointer
                for (int i = 0; i < localVarCount + offset(ctx) + 1; i++) {
                    emit(DecrSP);
                }
                return null;
            } else if (isLocal(ctx)) {
//                Number of pop needed to access this variable
                int numPops = localVarCount - offset(ctx);
//                Set the stack pointer to the right variable
                for (int i = 0; i < numPops + 1; i++) {
                    emit(Pop, REG_ZERO);
                }
//                Push the new value on the stack
                emit(Push, reg(ctx.expr()));
//                Reset the stack pointer
                for (int i = 0; i < numPops; i++) {
                    emit(DecrSP);
                }

                return null;
            } else {
                return emit(StoreD, reg(ctx.expr()), new Addr(Addr.AddrType.DirAddr, offset(ctx)));
            }


        }
    }

    @Override
    public Op visitFunctionStat(LavaParser.FunctionStatContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        if (ctx.functionCall().ID().getText().equals("fork") && forkCount < MAX_THREADS - 1) {
            String forkFunction = ((LavaParser.FunctionExprContext) ctx.functionCall().parameters().expr(0)).functionCall().ID().getText();
            ForkGenerator forkGenerator = new ForkGenerator();
            forkCount++;
            try {
                programs.add(forkGenerator.generate(tree, checkResult, forkFunction, (forkCount * 2) - 1));
            } catch (ParseException e) {
                errors.addAll(e.getMessages());
            }
            emit(label, LoadIm, new Addr(Addr.AddrType.ImmValue, 1), reg(ctx));
            emit(WriteD, REG_ZERO, new Addr(Addr.AddrType.DirAddr, (forkCount * 2) - 1));
            emit(WriteD, reg(ctx), new Addr(Addr.AddrType.DirAddr, forkCount * 2));
        } else if (ctx.functionCall().ID().getText().equals("fork") && forkCount >= MAX_THREADS - 1) {
            addError(ctx, "Too many forks for this Sprockell");
        } else if (ctx.functionCall().ID().getText().equals("join")) {
            if (hasLabel(ctx)) {
                emit(label, Nop);
            }
            Label joinLabel = createLabel(ctx, "join");
            labels.put(ctx.functionCall().parameters().expr(0), joinLabel);
            visit(ctx.functionCall().parameters().expr(0));
            emit(LoadIm, new Addr(Addr.AddrType.ImmValue, 2), reg(ctx.functionCall()));
            emit(Mul, reg(ctx.functionCall()), reg(ctx.functionCall().parameters().expr(0)), reg(ctx.functionCall()));
            emit(TestAndSetD, new Addr(Addr.AddrType.IndAddr, reg(ctx.functionCall())));
            emit(Receive, reg(ctx));
            emit(Branch, reg(ctx), joinLabel);
        } else if (ctx.functionCall().ID().getText().equals("lock")) {
            if (hasLabel(ctx)) {
                emit(label, Nop);
            }
            Label label1 = createLabel(ctx, "lock");
            emit(label1, TestAndSetD, LOCK);
            emit(Receive, reg(ctx));
            emit(Branch, reg(ctx), label1);
        } else if (ctx.functionCall().ID().getText().equals("unlock")) {
            emit(label, WriteD, REG_ZERO, LOCK);
        } else {
            labels.put(ctx.functionCall().parameters(), label);
            visit(ctx.functionCall());
        }

        return null;
    }

    @Override
    public Op visitWhileStat(LavaParser.WhileStatContext ctx) {
        if (hasLabel(ctx)) {
            emit(labels.get(ctx), Nop);
        }
        Label label1 = createLabel(ctx, "while");
        labels.put(ctx.expr(), label1);
        Label label2 = createLabel(ctx, "body");
        labels.put(ctx.block(), label2);
        Label label3 = createLabel(ctx, "endwhile");
        visit(ctx.expr());
        emit(Branch, reg(ctx.expr()), label3);
        visit(ctx.block());
        emit(Jump, label1);
        return emit(label3, Nop);
    }

    @Override
    public Op visitReturnStat(LavaParser.ReturnStatContext ctx) {
        if (hasLabel(ctx)) {
            setLabel(ctx.expr(), labels.get(ctx));
        }
        visit(ctx.expr());
//        Pop the localvariables from the stack
        for (int i = 0; i < localVarCount; i++) {
            emit(Pop, REG_ZERO);
        }

//        Pop the return address
        emit(Pop, reg(ctx));
//        Pop the return value which should be zero
        emit(Pop, REG_ZERO);
//        Push the return value
        emit(Push, reg(ctx.expr()));
//        Push the return address
        emit(Push, REG_ZERO);
//        Jump back
        return emit(JumpI, new Target(reg(ctx)));
    }

//    Expression ------------------------------------------------------------------------------------------------------
//    =================================================================================================================
//    -----------------------------------------------------------------------------------------------------------------

    @Override
    public Op visitParExpr(LavaParser.ParExprContext ctx) {
        if (hasLabel(ctx)) {
            setLabel(ctx.expr(), labels.get(ctx));
        }
        visit(ctx.expr());

        return emit(Add, reg(ctx.expr()), REG_ZERO, reg(ctx));
    }

    @Override
    public Op visitMultExpr(LavaParser.MultExprContext ctx) {
        if (hasLabel(ctx)) {
            setLabel(ctx.expr(0), labels.get(ctx));
        }
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        OpCode opCode = null;
        if (ctx.multOp().STAR() != null) {
            opCode = Mul;
        } else {
            addError(ctx, "Division is not supported by this Sprockell");
        }
        return emit(opCode, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
    }


    @Override
    public Op visitPlusExpr(LavaParser.PlusExprContext ctx) {
        if (hasLabel(ctx)) {
            setLabel(ctx.expr(0), labels.get(ctx));
        }
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        OpCode opCode;
        if (ctx.plusOp().PLUS() != null) {
            opCode = Add;
        } else {
            opCode = Sub;
        }

        return emit(opCode, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
    }

    @Override
    public Op visitBoolExpr(LavaParser.BoolExprContext ctx) {
        if (hasLabel(ctx)) {
            setLabel(ctx.expr(0), labels.get(ctx));
        }
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        OpCode opCode;
        if (ctx.boolOp().AND() != null) {
            opCode = And;
        } else if (ctx.boolOp().XOR() != null) {
            opCode = Xor;
        } else {
            opCode = Or;
        }

        return emit(opCode, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
    }

    @Override
    public Op visitCompExpr(LavaParser.CompExprContext ctx) {
        if (hasLabel(ctx)) {
            setLabel(ctx.expr(0), labels.get(ctx));
        }
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        int ruleIndex = ((TerminalNode) ctx.compOp().getChild(0)).getSymbol().getType();
        OpCode opCode = null;
        switch (ruleIndex) {
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
        return emit(opCode, reg(ctx.expr(0)), reg(ctx.expr(1)), reg(ctx));
    }

    @Override
    public Op visitNotExpr(LavaParser.NotExprContext ctx) {
        if (hasLabel(ctx)) {
            setLabel(ctx.expr(), labels.get(ctx));
        }

        visit(ctx.expr());
        Op operation;
        if (ctx.negaOp().MINUS() != null) {
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
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        return emit(label, LoadIm, new Addr(Addr.AddrType.ImmValue, Character.getNumericValue(ctx.CHARACTER().getText().charAt(1))), reg(ctx));
    }

    @Override
    public Op visitTrueExpr(LavaParser.TrueExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        return emit(label, LoadIm, TRUE_VALUE, reg(ctx));
    }

    @Override
    public Op visitNumExpr(LavaParser.NumExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        return emit(label, LoadIm, new Addr(Addr.AddrType.ImmValue, Integer.parseInt(ctx.NUM().getText())), reg(ctx));
    }

    @Override
    public Op visitFalseExpr(LavaParser.FalseExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        return emit(label, LoadIm, FALSE_VALUE, reg(ctx));
    }

    @Override
    public Op visitIdExpr(LavaParser.IdExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        if (isShared(ctx)) {
            emit(label, ReadD, new Addr(Addr.AddrType.DirAddr, offset(ctx) + SHARED_OFFSET));
            return emit(Receive, reg(ctx));
        } else {
            if (isParameter(ctx)) {
//                Set the stack pointer to the right variable
                emit(label, Pop, REG_ZERO);
                for (int i = 1; i < localVarCount + offset(ctx) + 1; i++) {
                    emit(Pop, REG_ZERO);
                }
//                Pop the variable and put in this register
                emit(Pop, reg(ctx));
//                Reset the stack pointer
                for (int i = 0; i < localVarCount + offset(ctx) + 2; i++) {
                    emit(DecrSP);
                }
                return null;
            } else if (isLocal(ctx)) {
                if (localVarCount == 1) {
//                    Set label to the first pop which is the variable itself
                    emit(label, Pop, reg(ctx));
//                    Reset stack pointer
                    emit(DecrSP);
                } else {
//                    The amount of pops needed to reach this variable
                    int numPops = localVarCount - offset(ctx);
//                    Set label to the first pop to reg0.
                    if (numPops > 0) {
                        emit(label, Pop, REG_ZERO);
                        for (int i = 1; i < numPops - 1; i++) {
                            emit(Pop, REG_ZERO);
                        }
                        //                    Pop the desired variable
                        emit(Pop, reg(ctx));
                    } else {
                        emit(label, Pop, reg(ctx));
                    }
//                    Reset stack pointer
                    for (int i = 0; i < numPops + 1; i++) {
                        emit(DecrSP);
                    }
                }
                return null;
            } else {
//                Load the global variable from memory
                return emit(label, LoadD, new Addr(Addr.AddrType.DirAddr, offset(ctx)), reg(ctx));
            }

        }

    }

    @Override
    public Op visitFunctionExpr(LavaParser.FunctionExprContext ctx) {
        Label label = null;
        if (hasLabel(ctx)) {
            label = labels.get(ctx);
        }
        labels.put(ctx.functionCall().parameters(), label);

        visitChildren(ctx);

        return null;
    }

//    Types -----------------------------------------------------------------------------------------------------------
//    =================================================================================================================
//    -----------------------------------------------------------------------------------------------------------------


    /**
     * @param node current node.
     * @return if this node has a label
     */
    private boolean hasLabel(ParseTree node) {
        return labels.get(node) != null;
    }


    private void setLabel(ParseTree node, Label label) {
        labels.put(node, label);
    }

    /**
     * Creates a label for a given parse tree node and prefix.
     */
    private Label createLabel(ParserRuleContext node, String prefix) {
        Token token = node.getStart();
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        String result = prefix + "_" + line + "_" + column;
        return new Label(result);
    }

    /**
     * Constructs an operation from the parameters
     * and adds it to the program under construction.
     */
    protected Op emit(Label label, OpCode opCode, Operand... args) {
        Op result = new Op(label, opCode, args);
        if (prog == null) {
            System.out.println("fout");
        }
        this.prog.addInstr(result);
        return result;
    }

    /**
     * Constructs an operation from the parameters
     * and adds it to the program under construction.
     */
    protected Op emit(OpCode opCode, Operand... args) {
        return emit(null, opCode, args);
    }


    /**
     * Returns a register for a given parse tree node,
     * creating a fresh register if there is none for that node.
     */
    private Reg reg(ParseTree node) {
        Reg result = this.registers.get(node);
        if (result == null) {
            result = new Reg("r_" + this.regCount);
            this.registers.put(node, result);
            this.regCount++;
        }
        return result;
    }

    private int offset(ParseTree node) {

        return this.checkResult.getOffset(node);
    }

    private boolean isParameter(ParseTree node) {
        return this.checkResult.getParameterVar(node);
    }

    private boolean isLocal(ParseTree node) {
        return this.checkResult.getLocalVar(node);
    }

    private boolean isShared(ParseTree node) {
        return this.checkResult.getSharedVar(node);}

    public List<String> getErrors() {
        return errors;
    }

    public Program getProg() {
        return prog;
    }

    private void addError(ParserRuleContext node, String message) {
        int line = node.getStart().getLine();
        int column = node.getStart().getCharPositionInLine();
        message = String.format("Line %d:%d - %s", line, column, message);
        this.errors.add(message);
    }

    public static void main(String[] args) {
        Checker checker = new Checker();
        Generator generator = new Generator();
        CharStream input;

        File file = new File("src/main/java/testprograms/simpletest3.magma");
        input = null;
        try {
            input = new ANTLRInputStream(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Lexer lexer = new LavaLexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);
            LavaParser parser = new LavaParser(tokens);
            parser.removeErrorListeners();
            ErrorListener errorListener = new ErrorListener();
            parser.addErrorListener(errorListener);
            ParseTree tree = parser.program();
            errorListener.throwException();
            List<Program> program;
            CheckerResult result = checker.check(tree);
            program = generator.generate(tree, result);
            System.out.println(program.toString());
        } catch (ParseException e) {
            System.err.println(e.getMessages());
        }
    }

}
