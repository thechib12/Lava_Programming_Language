package optimization;

import elaboration.Checker;
import elaboration.Generator;
import elaboration.ParseException;
import grammar.LavaLexer;
import grammar.LavaParser;
import model.Operand;
import model.Program;
import model.Reg;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Rogier on 21-06-16 in Enschede.
 */
public class RegisterMinimizer {
    private Program program;
    /**
     * The constant sprilRegisters.
     */
    public final static List<String> sprilRegisters = new ArrayList<>();
    /**
     * The Errors.
     */
    List<String> errors = new ArrayList<>();
    static {
        sprilRegisters.add("regA");
        sprilRegisters.add("regB");
        sprilRegisters.add("regC");
        sprilRegisters.add("regD");
        sprilRegisters.add("regE");
        sprilRegisters.add("regF");
        sprilRegisters.add("regG");
        sprilRegisters.add("regH");
        sprilRegisters.add("regI");
        sprilRegisters.add("regJ");
        sprilRegisters.add("regK");
        sprilRegisters.add("regL");
        sprilRegisters.add("regM");
        sprilRegisters.add("regN");
        sprilRegisters.add("regO");
        sprilRegisters.add("regP");
        sprilRegisters.add("regQ");
        sprilRegisters.add("regR");
        sprilRegisters.add("regS");
        sprilRegisters.add("regA1");
        sprilRegisters.add("regB1");
        sprilRegisters.add("regC1");
        sprilRegisters.add("regD1");
        sprilRegisters.add("regE1");
        sprilRegisters.add("regF1");
        sprilRegisters.add("regG1");
        sprilRegisters.add("regH1");
        sprilRegisters.add("regI1");
        sprilRegisters.add("regJ1");
        sprilRegisters.add("regK1");
        sprilRegisters.add("regL1");
        sprilRegisters.add("regM1");
        sprilRegisters.add("regN1");
        sprilRegisters.add("regO1");
        sprilRegisters.add("regP1");
        sprilRegisters.add("regQ1");
        sprilRegisters.add("regR1");
        sprilRegisters.add("regS1");
    }


    /**
     * Minimize registers program.
     *
     * @param programx the programx
     * @return the program
     * @throws ParseException the parse exception
     */
    public Program minimizeRegisters(Program programx) throws ParseException {
        this.program = programx;
        int i = 0;
        if (program.getRegisters().size() >= 40) {
            errors.add("Too much registers used!");
            throw new ParseException(errors);
        }
        renameRegisters();
        return program;
    }

    private void renameSingleRegister(String oldReg, String newReg) {
        Set<Integer> lines = program.getRegLines().get(oldReg);
        for (Integer i : lines) {
            for (Operand operand : program.getOpList().get(i).getArgs()) {
                if (operand.getType() == Operand.Type.REG) {
                    if (((Reg) operand).getName().equals(oldReg)) {
                        ((Reg) operand).setName(newReg);
                    }

                }
            }
        }
    }

    private void renameRegisters() {
        List<String> programRegisters = program.getRegisters();
        List<String> tempRegisters = new ArrayList<>(sprilRegisters);
        Map<String, String> registerMapping = new HashMap<>();

        for (String reg : programRegisters) {

            if (!reg.equals("reg0")) {
                registerMapping.put(reg, tempRegisters.remove(0));
            }

        }
        for (String reg : registerMapping.keySet()) {
            renameSingleRegister(reg, registerMapping.get(reg));

        }

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

        File file = new File("./src/main/java/testprograms/gauss.magma");
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
        try {
            Program program = generator.generate(tree, checker.check(tree)).get(0);
            System.out.println(program.toString());
            program = minimizer.minimizeRegisters(program);
            System.out.println(program);
        } catch (ParseException e) {
            System.err.println(e.getMessages());
        }


    }
}
