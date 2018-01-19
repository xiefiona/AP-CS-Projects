import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class GUI extends JFrame{
    private JPanel panel = new JPanel(new GridLayout(2,1));
    private JTextArea textInput = new JTextArea("Enter in text");
    private JTextArea output = new JTextArea();

    private JMenuBar menubar = new JMenuBar();				//menu
    private JMenu file = new JMenu("File");
    private JMenuItem open = new JMenuItem("Open file");
    private JMenuItem calculate = new JMenuItem("Calculate");

    public GUI(){
        setTitle("Text Analyzer");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        output.setEditable(false);

        panel.add(textInput);
        panel.add(output);
        add(panel);

        //creates the menu
        file.add(open);
        file.add(calculate);
        menubar.add(file);
        setJMenuBar(menubar);

        setVisible(true);

        open.addActionListener((ActionEvent event) -> {
            File fName = new File("src/" +
                    JOptionPane.showInputDialog(this, "Enter File Name:") + ".txt");
            TextAnalyzer textAnalyzer =  new TextAnalyzer(fName);

            output.setText("");
            output.append("File Name: " + fName + "\n");
            output.append("Readability Score: " + textAnalyzer.getFleschIndex() + "\n");
            output.append("Educational Level: " + textAnalyzer.calculateEducationalLevel() + "\n");
            output.append("Syllables: " + textAnalyzer.getNumSyllables() + "\n");
            output.append("Words: " +  textAnalyzer.getNumWords() + "\n");
            output.append("Sentences: " + textAnalyzer.getNumSentences() + "\n");
            output.append("Coleman Liau: " + textAnalyzer.getColemanLiau());
        });
        calculate.addActionListener((ActionEvent event) -> {
            TextAnalyzer textAnalyzer =  new TextAnalyzer(textInput.getText());

            output.setText("");
            output.append("File Name: N/A \n");
            output.append("Readability Score: " + textAnalyzer.getFleschIndex() + "\n");
            output.append("Educational Level: " + textAnalyzer.calculateEducationalLevel() + "\n");
            output.append("Syllables: " + textAnalyzer.getNumSyllables() + "\n");
            output.append("Words: " +  textAnalyzer.getNumWords() + "\n");
            output.append("Sentences: " + textAnalyzer.getNumSentences() + "\n");
        });

    }
}

//6th grade:
//83 readability
//35 syllables
//27 words
//2 sentences

//college grad:
//20 readability score
//41 syllables
//21 words
//1 sentence