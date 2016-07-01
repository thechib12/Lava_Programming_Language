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
 * Register minimizer which translates Lava IR register to actual SPROCKELL registers.
 */
public class RegisterMinimizer {
    /**
     * The constant SPRING_REGISTERS.
     */
    private final static List<String> SPRING_REGISTERS = new ArrayList<>();

    /**
     * List of all usable registers in SPROCKELL.
     */
    static {
        SPRING_REGISTERS.add("regA");
        SPRING_REGISTERS.add("regB");
        SPRING_REGISTERS.add("regC");
        SPRING_REGISTERS.add("regD");
        SPRING_REGISTERS.add("regE");
        SPRING_REGISTERS.add("regF");
        SPRING_REGISTERS.add("regG");
        SPRING_REGISTERS.add("regH");
        SPRING_REGISTERS.add("regI");
        SPRING_REGISTERS.add("regJ");
        SPRING_REGISTERS.add("regK");
        SPRING_REGISTERS.add("regL");
        SPRING_REGISTERS.add("regM");
        SPRING_REGISTERS.add("regN");
        SPRING_REGISTERS.add("regO");
        SPRING_REGISTERS.add("regP");
        SPRING_REGISTERS.add("regQ");
        SPRING_REGISTERS.add("regR");
        SPRING_REGISTERS.add("regS");
        SPRING_REGISTERS.add("regA1");
        SPRING_REGISTERS.add("regB1");
        SPRING_REGISTERS.add("regC1");
        SPRING_REGISTERS.add("regD1");
        SPRING_REGISTERS.add("regE1");
        SPRING_REGISTERS.add("regF1");
        SPRING_REGISTERS.add("regG1");
        SPRING_REGISTERS.add("regH1");
        SPRING_REGISTERS.add("regI1");
        SPRING_REGISTERS.add("regJ1");
        SPRING_REGISTERS.add("regK1");
        SPRING_REGISTERS.add("regL1");
        SPRING_REGISTERS.add("regM1");
        SPRING_REGISTERS.add("regN1");
        SPRING_REGISTERS.add("regO1");
        SPRING_REGISTERS.add("regP1");
        SPRING_REGISTERS.add("regQ1");
        SPRING_REGISTERS.add("regR1");
        SPRING_REGISTERS.add("regS1");
    }

    private Program program;
    /**
     * The Errors.
     */
    private List<String> errors = new ArrayList<>();

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

    /**
     * Minimize registers program.
     *
     * @param program the program
     * @return the program
     * @throws ParseException the parse exception
     */
    public Program minimizeRegisters(Program program) throws ParseException {
        this.program = program;
        int i = 0;
        if (this.program.getRegisters().size() >= 40) {
            errors.add("Too much registers used!");
            throw new ParseException(errors);
        }
        renameRegisters();
        return this.program;
    }

    /**
     * Rename a single register throughout the program.
     *
     * @param oldReg the old register name.
     * @param newReg the new register name.
     */
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

    /**
     * Rename the registers of a {@link Program} to fit the names specified in SPROCKELL.
     */
    private void renameRegisters() {
        List<String> programRegisters = program.getRegisters();
        List<String> tempRegisters = new ArrayList<>(SPRING_REGISTERS);
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
}
