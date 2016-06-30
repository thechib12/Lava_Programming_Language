import elaboration.Checker;
import elaboration.ErrorListener;
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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
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
    private final JButton chooseInputButton = new JButton("Choose file");
    private final JButton chooseOutputButton = new JButton("Choose output folder");
    private final JButton runButton = new JButton("Run");
    private JTextArea messages;
    private final JPanel panel = new JPanel(new GridBagLayout());
    private final JFileChooser inputFileChooser = new JFileChooser();
    private JFileChooser outputFileChooser;
    private File inputFile;
    private File outputFile;


    public void setupGUI() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setContentPane(panel);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        outputFileChooser = new JFileChooser();
        outputFileChooser.setCurrentDirectory(new java.io.File("."));
        outputFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        outputFileChooser.setAcceptAllFileFilterUsed(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputFileChooser.setCurrentDirectory(new java.io.File("."));
        FileFilter fileFilter = new FileNameExtensionFilter("Lava file", ".magma");
        inputFileChooser.addChoosableFileFilter(fileFilter);
        inputFileChooser.setAcceptAllFileFilterUsed(false);
        chooseInputButton.addActionListener(this);
        panel.add(chooseInputButton, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        chooseOutputButton.addActionListener(this);
        panel.add(chooseOutputButton, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        runButton.addActionListener(this);
        panel.add(runButton, gbc);
        gbc = new GridBagConstraints();
        JLabel label = new JLabel("Output");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        panel.add(label, gbc);
        gbc = new GridBagConstraints();
        messages = new JTextArea();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        messages.setLineWrap(true);
        messages.setEditable(false);
        panel.add(messages, gbc);


        frame.setVisible(true);

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

        try {
            Lexer lexer = new LavaLexer(input);
            TokenStream tokens = new CommonTokenStream(lexer);
            LavaParser parser = new LavaParser(tokens);
            parser.removeErrorListeners();
            ErrorListener errorListener = new ErrorListener();
            parser.addErrorListener(errorListener);

            ParseTree tree = parser.program();
            errorListener.throwException();
            RegisterMinimizer minimizer = new RegisterMinimizer();
            SPRILGenerator sprilgen = new SPRILGenerator();
            List<List<String>> sprils = new ArrayList<>();
            List<Program> programs = generator.generate(tree, checker.check(tree));
            for (Program program : programs) {
                program = minimizer.minimizeRegisters(program);
                sprils.add(sprilgen.generateSpril(program));
            }

            sprilgen.writeFile(sprilgen.formatSpril(sprils), outputFile.getPath() + "/Program.hs");
            messages.append("Compiled with 0 errors\n");
        } catch (ParseException e) {
            messages.append(e.getMessages().toString() + "\n");
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
            int returnVal = outputFileChooser.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                outputFile = outputFileChooser.getSelectedFile();
            }

        } else {
            messages.setText("");
            if (inputFile == null) {
                messages.append("Please choose an input file\n");
            } else if (outputFile == null) {
                messages.append("Please choose an output directory\n");
            } else {
                this.run();
            }

        }


    }

    public static void main(String[] args) {
        LavaCompiler compiler = new LavaCompiler();
        compiler.setupGUI();
    }
}
