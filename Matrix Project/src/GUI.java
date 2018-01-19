import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
    private JPanel panel = new JPanel(new GridLayout(3,2));
    private JLabel lbl1 = new JLabel("Enter your first matrix: ");
    private JLabel lbl2 = new JLabel("Enter your second matrix: ");
    private JLabel lbl3 = new JLabel("Answer: ");
    private JMenuBar menubar = new JMenuBar();				//menu
    private JMenu calculate = new JMenu("Calculate");
    private JMenuItem all = new JMenuItem("All");
    private JTextArea txtMatrix1 = new JTextArea();  //text area for Matrix input
    private JTextArea txtMatrix2 = new JTextArea();
    private JTextArea txtOutput = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane();

    public GUI(){
        setTitle("Matrix");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(lbl1);
        panel.add(txtMatrix1);
        panel.add(lbl2);
        panel.add(txtMatrix2);
        panel.add(lbl3);
        panel.add(txtOutput);
        panel.add(scrollPane);
        scrollPane.setViewportView(txtOutput);

        add(panel);

        //creates the menu
        calculate.add(all);
        menubar.add(calculate);
        setJMenuBar(menubar);

        setVisible(true);

        all.addActionListener((ActionEvent event) -> {
            Matrix m1 = new Matrix(txtMatrix1.getText());
            Matrix m2 = new Matrix(txtMatrix2.getText());

            if (m1.checkAdd(m2.getRows(), m2.getColumns()) == true){
                txtOutput.append("Add: \n");
                txtOutput.append(m1.add(m2).toString());
                txtOutput.append("Subtract: \n");
                txtOutput.append(m1.subtract(m2).toString());
            } else {
                txtOutput.append("Cannot add or subtract matrices \n");
            }
            if (m1.checkMult(m2.getRows()) == true){
                txtOutput.append("Multiply: \n");
                txtOutput.append(m1.multiply(m2).toString());
            } else {
                txtOutput.append("Cannot multiply matrices+ \"\\n\"");
            }
            txtOutput.append("Scalar Multiplication of Matrix 1 by 2: \n");
            txtOutput.append(m1.scalarMultiplication(2).toString() + "\n");
            if (m1.getRows() == m1.getColumns() && (m1.getRows() == 2 || m1.getRows() == 3)){
                txtOutput.append("Determinant of Matrix 1: ");
                txtOutput.append(String.valueOf(m1.getDeterminant()));
                txtOutput.append("\n");
                txtOutput.append("Inverse of Matrix 1: \n");
                txtOutput.append(m1.getInverse().toString());
            } else {
                txtOutput.append("Cannot retrieve determinant or inverse of Matrix 1" );
            }
            txtOutput.append("Scalar Multiplication of Matrix 2 by 2: \n");
            txtOutput.append(m2.scalarMultiplication(2).toString());
            if (m2.getRows() == m2.getColumns() && (m2.getRows() == 2 || m2.getRows() == 3)){
                txtOutput.append("Determinant of Matrix 2: ");
                txtOutput.append(String.valueOf(m2.getDeterminant()));
                txtOutput.append("\n");
                txtOutput.append("Inverse of Matrix 2: \n");
                txtOutput.append(m2.getInverse().toString());
            } else {
                txtOutput.append("Cannot retrieve determinant or inverse of Matrix 2");
            }
        });
    }
}
