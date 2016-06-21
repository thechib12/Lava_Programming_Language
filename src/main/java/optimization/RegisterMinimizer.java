package optimization;

import elaboration.Checker;
import elaboration.Generator;
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
    public final static Set<String> sprilRegisters = new HashSet<>();

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
    }


    public Program minimizeRegisters(Program programx) {
        this.program = programx;
        int i = 0;
        if (program.getRegisters().size() > 20) {
            i++;
        }
        renameRegisters();
        return program;
    }


    private void renameRegisters() {
        Set<String> programRegisters = program.getRegisters();
        List<String> tempRegisters = new LinkedList<>(sprilRegisters);
        Map<String, String> registerMapping = new HashMap<>();

        for (String reg : programRegisters) {


            registerMapping.put(reg, tempRegisters.remove(0));
        }
        Map<String, Set<Integer>> reglines = program.getRegLines();
        for (String reg : registerMapping.keySet()) {

            Set<Integer> lines = reglines.get(reg);
            for (Integer i : lines) {
                for (Operand operand : program.getOpList().get(i).getArgs()) {
                    if (operand.getType() == Operand.Type.REG) {
                        ((Reg) operand).setName(registerMapping.get(reg));
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        Checker checker = new Checker();
        Generator generator = new Generator();
        CharStream input;

        File file = new File("./src/main/java/testprograms/basic.magma");
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
        System.out.println(program.toString());

        RegisterMinimizer minimizer = new RegisterMinimizer();
        program = minimizer.minimizeRegisters(program);
        System.out.println(program);
    }
}
