package sprilgenerator;

import elaboration.Checker;
import elaboration.Generator;
import elaboration.ParseException;
import grammar.LavaLexer;
import grammar.LavaParser;
import model.Address;
import model.Op;
import model.OpCode;
import model.Program;
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
     * The constant computationsOpcodes.
     */
    public static final OpCode[] computationsOpcodes = {OpCode.Add, OpCode.Sub, OpCode.Mul, OpCode.Equal, OpCode.NEQ,
            OpCode.Gt, OpCode.GtE, OpCode.Lt, OpCode.LtE, OpCode.And, OpCode.Or, OpCode.Xor, OpCode.LShift, OpCode.RShift};


    /**
     * Write file.
     *
     * @param text the text
     * @param path the path
     */
    public void writeFile(String text, String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Format spril string.
     *
     * @param instruction the instruction
     * @return the string
     */
    public String formatSpril(List<List<String>> instruction) {
        StringBuilder builder = new StringBuilder();
        builder.append("module Main where\n" +
                "\n" +
                "import BasicFunctions\n" +
                "import HardwareTypes\n" +
                "import Sprockell\n" +
                "import System\n" +
                "import Simulation\n" +
                "\n");

        List<String> progNames = new ArrayList<>();
        for (int i = 0; i < instruction.size(); i++) {

            String progName = "prog" + i;
            progNames.add(progName);
            builder.append(progName + " :: [Instruction]\n");
            builder.append(progName + " = [\n");
            List<String> instrs = instruction.get(i);
            for (int j = 0; j < instrs.size() - 1; j++) {
                builder.append("          " + instrs.get(j) + ", \n");

            }
            builder.append("          " + instrs.get(instrs.size() - 1) + " \n");

            builder.append("       ] \n");
        }

        builder.append("main = sysTest " + progNames.toString());
        return builder.toString();

    }


    /**
     * Print spril.
     *
     * @param list the list
     */
    public void printSpril(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * Generate spril list.
     *
     * @param program the program
     * @return the list
     */
    public List<String> generateSpril(Program program) {

        List<Op> instructions = program.getOpList();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < instructions.size(); i++) {

//            computations
            Op instr = instructions.get(i);
            OpCode opcode = instr.getOpCode();
            if (Arrays.asList(computationsOpcodes).contains(opcode)) {
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
                        result.add("Branch " + instr.reg(0).toString() + " (Abs " + program.getLine(instr.label(1)) + ")");
                        break;
                    case Jump:
                        result.add("Jump " + "(Abs " + program.getLine(instr.label(0)) + ")");
                        break;
                    case JumpI:
                        result.add("Jump " + "(" + instr.target(0).toString() + ")");
                        break;
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


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Checker checker = new Checker();
        Generator generator = new Generator();
        CharStream input;

        File file = new File("src/main/java/testprograms/doublefunctions.magma");
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
        RegisterMinimizer minimizer = new RegisterMinimizer();
        SPRILGenerator sprilgen = new SPRILGenerator();
        List<List<String>> sprils = new ArrayList<>();
        try {
            List<Program> programs = generator.generate(tree, checker.check(tree));
            for (Program prog : programs) {
                prog = minimizer.minimizeRegisters(prog);
                sprils.add(sprilgen.generateSpril(prog));
            }

            sprilgen.writeFile(sprilgen.formatSpril(sprils), "./src/main/java/sprockell/Program.hs");
        } catch (ParseException e) {
            System.err.println(e.getMessages());
        }


    }
}
