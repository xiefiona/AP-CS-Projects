import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class GUI extends JFrame {
    private JPanel panel = new JPanel(new GridLayout(3,2));
    private JMenuBar menubar = new JMenuBar();				//menu
    private JMenu file = new JMenu("File");
    private JMenuItem create = new JMenuItem("Generate Students");
    private JTextArea txtElementary = new JTextArea();  //text area for Matrix input
    private JTextArea txtIntermediate = new JTextArea();
    private JTextArea txtMiddle = new JTextArea();
    private JTextArea txtHigh = new JTextArea();
    private JTextArea txtOutput = new JTextArea();
    private JScrollPane scrollPane1 = new JScrollPane();
    private JScrollPane scrollPane2 = new JScrollPane();
    private JScrollPane scrollPane3 = new JScrollPane();
    private JScrollPane scrollPane4 = new JScrollPane();

    public GUI(){
        setTitle("District");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(txtElementary);
        panel.add(txtIntermediate);
        panel.add(txtMiddle);
        panel.add(txtHigh);
        panel.add(txtOutput);
        panel.add(scrollPane1);
        panel.add(scrollPane2);
        panel.add(scrollPane3);
        panel.add(scrollPane4);
        scrollPane1.setViewportView(txtElementary);
        scrollPane2.setViewportView(txtIntermediate);
        scrollPane3.setViewportView(txtMiddle);
        scrollPane4.setViewportView(txtHigh);

        add(panel);

        //creates the menu
        file.add(create);
        menubar.add(file);
        setJMenuBar(menubar);

        setVisible(true);

        create.addActionListener((ActionEvent event) -> {
            int numStudents;
            Random rand = new Random();
            int r;
            numStudents = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the number of students wanted: "));

            ArrayList<Student> arrStu = new ArrayList<>();
            for(int i=0; i<numStudents; i++){
                r = rand.nextInt(4);
                if ( r == 0) {
                    arrStu.add(new ElementaryStu());
                } else if (r == 1){
                    arrStu.add(new IntermediateStu());
                } else if (r == 2){
                    arrStu.add(new MiddleStu());
                } else if (r == 3){
                    arrStu.add(new HighStu());
                }
            }

            txtElementary.append("Elementary Students: \n");
            for (Student s : arrStu){
                if (s instanceof ElementaryStu) {
                    txtElementary.append(s.toString());
                }
            }
            txtIntermediate.append("Intermediate School Students: \n");
            for (Student s : arrStu){
                if (s instanceof IntermediateStu) {
                    txtIntermediate.append(s.toString());
                }
            }
            txtMiddle.append("Middle School Students: \n");
            for (Student s : arrStu){
                if (s instanceof MiddleStu) {
                    txtMiddle.append(s.toString());
                }
            }
            txtHigh.append("High School Students: \n");
            for (Student s : arrStu){
                if (s instanceof HighStu) {
                    txtHigh.append(s.toString());
                }
            }
            txtOutput.append("Student count: " + Student.getStudentCount() + "\n");
            txtOutput.append("Total Fees: " + Student.getTotalFees() + "\n");
            txtOutput.append("Average Fees: " + Student.getAvgFee() + "\n");
        });
    }
}
