package sprilgenerator;

import elaboration.Checker;
import elaboration.Generator;
import grammar.LavaLexer;
import grammar.LavaParser;
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
    private static final OpCode[] computationsOpcodes = {OpCode.Add, OpCode.Sub, OpCode.Mul, OpCode.Equal, OpCode.NEQ,
            OpCode.Gt, OpCode.GtE, OpCode.Lt, OpCode.LtE, OpCode.And, OpCode.Or, OpCode.Xor, OpCode.LShift, OpCode.RShift};

    public SPRILGenerator() {


    }    //Load from address a1, store at a2
//    LoadD(1, ADDR, REG),
//    LoadInd(1, ADDR, REG),
//    //Load Immediate value from address a1, store at a2
//    LoadIm(1, ADDR, REG),
//    StoreD(1, REG, ADDR),
//    StoreInd(1, REG, ADDR),
//
//    Branch(1, REG, LABEL),
//    BranchI(1, REG, TARGET),
//    Jump(0, LABEL),
//    JumpI(0,TARGET),
//    Push(1, REG),
//    Pop(0, REG),
//    Nop(0),
//    EndProg(0),
//
//
//    //System instructions
//    ReadD(1, ADDR),
//    ReadInd(1, ADDR),
//    Receive(0, REG),
//    WriteD(1, REG, ADDR),
//    WriteInd(1, REG, ADDR),
//    TestAndSetD(1, ADDR),
//    TestAndSetInd(1, ADDR);

    public void writeFile(String text) {
        try {
            FileWriter writer = new FileWriter("./src/main/java/sprockell/Program.hs");
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String formatSpril(List<String> instruction) {
        StringBuilder builder = new StringBuilder();
        builder.append("module Program where\n" +
                "\n" +
                "import BasicFunctions\n" +
                "import HardwareTypes\n" +
                "import Sprockell\n" +
                "import System\n" +
                "import Simulation\n" +
                "\n" +
                "prog :: [Instruction]\n");

        builder.append("prog = [\n");
        for (String instr : instruction) {
            if (instruction.indexOf(instr) == instruction.size() - 1) {
                builder.append("          " + instr + " \n");
            } else {
                builder.append("          " + instr + ", \n");
            }

        }
        builder.append("       ] \n");

        builder.append("demoTest = sysTest [prog]");


        return builder.toString();

    }


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
                        result.add("Load " + "(" + instr.addr(0) + ") " + instr.reg(1).toString());

                }
            }

        }

        return result;
    }


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
        Program program = generator.generate(tree, checker.check(tree));
        RegisterMinimizer minimizer = new RegisterMinimizer();
        Program program2 = minimizer.minimizeRegisters(program);
        SPRILGenerator sprilgen = new SPRILGenerator();
        List<String> spril = sprilgen.generateSpril(program2);
        sprilgen.writeFile(sprilgen.formatSpril(spril));

    }
}
