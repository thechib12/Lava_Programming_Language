package sprilgenerator;

import elaboration.Checker;
import elaboration.ErrorListener;
import elaboration.Generator;
import elaboration.ParseException;
import grammar.LavaLexer;
import grammar.LavaParser;
import model.*;
import optimization.RegisterMinimizer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rogier on 21-06-16 in Enschede.
 */
public class SPRILGenerator {
    /**
     * The constant COMPUTATIONS_OPCODES.
     */
    private static final OpCode[] COMPUTATIONS_OPCODES = {OpCode.Add, OpCode.Sub,
            OpCode.Mul, OpCode.Equal, OpCode.NEQ, OpCode.Gt, OpCode.GtE, OpCode.Lt,
            OpCode.LtE, OpCode.And, OpCode.Or, OpCode.Xor, OpCode.LShift, OpCode.RShift};

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(final String[] args) {
        Checker checker = new Checker();
        Generator generator = new Generator();
        CharStream input;

        File file = new File("src/main/java/testprograms/voidtest.magma");
        input = null;
        try {
            input = new ANTLRInputStream(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new LavaLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        LavaParser parser = new LavaParser(tokens);

        RegisterMinimizer minimizer = new RegisterMinimizer();
        SPRILGenerator sprilgen = new SPRILGenerator();
        List<List<String>> sprils = new ArrayList<>();
        try {
            parser.removeErrorListeners();
            ErrorListener errorListener = new ErrorListener();
            parser.addErrorListener(errorListener);
            ParseTree tree = parser.program();
            errorListener.throwException();
            List<Program> programs = generator.generate(tree, checker.check(tree));
            for (Program prog : programs) {
                prog = minimizer.minimizeRegisters(prog);
                sprils.add(sprilgen.generateSprill(prog));
            }

            sprilgen.writeFile(sprilgen.formatSprill(sprils), "./src/main/java/sprockell/Program.hs");
        } catch (ParseException e) {
            System.err.println(e.getMessages());
        }


    }

    /**
     * Write the sprill file to the specified path.
     *
     * @param text the text
     * @param path the path
     */
    public final void writeFile(final String text, final String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Format sprill file which contains the instructions of all sprockells and a helpful function to start program.
     *
     * @param instruction the instruction
     * @return the string
     */
    public final String formatSprill(final List<List<String>> instruction) {
        StringBuilder builder = new StringBuilder();
        builder.append("module Main where\n").append("\n").append("import BasicFunctions\n");
        builder.append("import HardwareTypes\n").append("import Sprockell\n");
        builder.append("import System\n").append("import Simulation\n").append("\n");
        List<String> programNames = new ArrayList<>();
        for (int i = 0; i < instruction.size(); i++) {

            String progName = "prog" + i;
            programNames.add(progName);
            builder.append(progName).append(" :: [Instruction]\n");
            builder.append(progName).append(" = [\n");
            List<String> instructions = instruction.get(i);
            for (int j = 0; j < instructions.size() - 1; j++) {
                builder.append("          ").append(instructions.get(j)).append(", \n");

            }
            builder.append("          ").append(instructions.get(instructions.size() - 1)).append(" \n");

            builder.append("       ] \n");
        }

        builder.append("main = sysTest ").append(programNames.toString());
        return builder.toString();

    }

    /**
     * Generate sprill list by iterating through the Lava IR Program.
     *
     * @param program the program
     * @return the list
     */
    public final List<String> generateSprill(final Program program) {

        List<Op> instructions = program.getOpList();
        List<String> result = new ArrayList<>();

        for (Op instr : instructions) {

//            computations
            OpCode opcode = instr.getOpCode();
            if (Arrays.asList(COMPUTATIONS_OPCODES).contains(opcode)) {
                result.add("Compute " + opcode.toString() + " " + instr.reg(0).toString()
                        + " " + instr.reg(1).toString() + " " + instr.reg(2).toString());
            } else {
                switch (opcode) {
                    case LoadD:
                    case LoadIm:
                    case LoadInd:
                        Address address = instr.addr(0);
                        if (address.getPrefix() == Address.AddressType.ImmValueLab) {
                            int line = program.getLine(address.getLabel());
                            result.add("Load (" + "ImmValue " + line + ") " + instr.reg(1).toString());
                        } else {
                            result.add("Load (" + address.toString() + ") " + instr.reg(1).toString());
                        }
                        break;
                    case StoreD:
                    case StoreInd:
                        result.add("Store " + instr.reg(0).toString() + " (" + instr.addr(1).toString() + ")");
                        break;
                    case Branch:
                        result.add("Branch " + instr.reg(0).toString()
                                + " (Abs " + program.getLine(instr.label(1)) + ")");
                        break;
                    case Jump:
                        if (instr.target(0).getPrefix() == Target.TargetType.Abs) {
                            result.add("Jump " + "(" + instr.target(0).getPrefix() + " "
                                    + program.getLine(instr.target(0).getLabel()) + ")");
                            break;
                        } else {
                            result.add("Jump " + "(" + instr.target(0).getPrefix() + " "
                                    + instr.target(0).getRegister() + ")");
                            break;
                        }
                    case Push:
                        result.add("Push " + instr.reg(0).toString());
                        break;
                    case Pop:
                        result.add("Pop " + instr.reg(0).toString());
                        break;
                    case IncrSP:
                        result.add("IncrSP");
                        break;
                    case DecrSP:
                        result.add("DecrSP");
                        break;
                    case I2I:
                        result.add("I2I " + instr.reg(0).toString() + " " + instr.reg(1).toString());
                        break;
                    case Nop:
                        result.add("Nop");
                        break;
                    case EndProg:
                        result.add("EndProg");
                        break;
                    case ReadD:
                    case ReadInd:
                        result.add("ReadInstr " + " (" + instr.addr(0).toString() + ")");
                        break;
                    case Receive:
                        result.add("Receive " + instr.reg(0).toString());
                        break;
                    case WriteD:
                    case WriteInd:
                        result.add("WriteInstr " + instr.reg(0).toString() + " (" + instr.addr(1) + ")");
                        break;
                    case TestAndSetD:
                    case TestAndSetInd:
                        result.add("TestAndSet (" + instr.addr(0).toString() + ")");
                        break;
                }
            }
        }
        return result;
    }
}
