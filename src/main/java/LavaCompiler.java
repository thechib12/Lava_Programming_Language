import elaboration.Checker;
import elaboration.Generator;
import elaboration.ParseException;
import grammar.LavaLexer;
import grammar.LavaParser;
import model.Program;
import optimization.RegisterMinimizer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import sprilgenerator.SPRILGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogier on 30-06-16 in Enschede.
 */
public class LavaCompiler implements ActionListener {
    private JFrame frame;
    private JButton chooseInputButton;
    private JButton chooseOutputButton = new JButton("Choose file");
    private final JButton runButton = new JButton("");
    private final JTextArea messages = new JTextArea();
    private final JPanel panel = new JPanel();
    private final JFileChooser inputFileChooser = new JFileChooser();
    private final JFileChooser outputFileChooser = new JFileChooser();
    private File inputFile;
    private File outputFile;


    public void setupGUI() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setContentPane(panel);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        outputFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        outputFileChooser.setAcceptAllFileFilterUsed(false);

    }

    public void run() {
        Checker checker = new Checker();
        Generator generator = new Generator();
        CharStream input;

        if (inputFile == null) {
            messages.append("No file selected\n");
        }
        input = null;
        try {
            input = new ANTLRInputStream(new FileReader(inputFile));
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

            sprilgen.writeFile(sprilgen.formatSpril(sprils), outputFile.getPath());
        } catch (ParseException e) {
            System.err.println(e.getMessages());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getText().equals("Choose file")) {
            int returnVal = inputFileChooser.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                inputFile = inputFileChooser.getSelectedFile();
            }

        } else if (((JButton) e.getSource()).getText().equals("Choose output folder")) {
            int returnVal = inputFileChooser.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                outputFile = inputFileChooser.getSelectedFile();
            }

        } else {
            this.run();
        }


    }

    public static void main(String[] args) {
        LavaCompiler compiler = new LavaCompiler();
        compiler.setupGUI();
    }
}
