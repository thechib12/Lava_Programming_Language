package elaboration;

import grammar.LavaBaseVisitor;
import model.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by Rogier on 20-06-16 in Enschede.
 */
public class Generator extends LavaBaseVisitor<Op>{
    /** The representation of the boolean value <code>false</code>. */
    public final static Num FALSE_VALUE = new Num(0);
    /** The representation of the boolean value <code>true</code>. */
    public final static Num TRUE_VALUE = new Num(-1);


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
        this.regCount = 0;
        tree.accept(this);
        return this.prog;
    }


    // Override the visitor methods
    /** Constructs an operation from the parameters
     * and adds it to the program under construction. */
    private Op emit(OpCode opCode, Operand... args) {
        Op result = new Op(opCode, args);
        this.prog.addInstr(result);
        return result;
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
