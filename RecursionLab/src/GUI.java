import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JPanel panel = new JPanel(new GridLayout(2,1));
    private JLabel lbl1 = new JLabel();
    private JLabel lbl2 = new JLabel();
    private JMenuBar menubar = new JMenuBar();				//menu
    private JMenu calculate = new JMenu("Operations");
    private JMenuItem summation = new JMenuItem("Summation");
    private JMenuItem exponentiation = new JMenuItem("Exponentiation");
    private JMenuItem fibonacci = new JMenuItem("Fibonacci");
    private JMenuItem isEven = new JMenuItem("isEven");
    private JMenuItem isOdd = new JMenuItem("isOdd");
    private JMenuItem palindrome = new JMenuItem("Palindrome");
    private JMenuItem reverse = new JMenuItem("Reverse");

    public GUI(){
        setTitle("Matrix");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(lbl1);
        panel.add(lbl2);

        add(panel);

        //creates the menu
        calculate.add(summation);
        calculate.add(exponentiation);
        calculate.add(fibonacci);
        calculate.add(isEven);
        calculate.add(isOdd);
        calculate.add(palindrome);
        calculate.add(reverse);
        menubar.add(calculate);
        setJMenuBar(menubar);

        setVisible(true);

        summation.addActionListener(new menulistener());
        exponentiation.addActionListener(new menulistener());
        fibonacci.addActionListener(new menulistener());
        isEven.addActionListener(new menulistener());
        isOdd.addActionListener(new menulistener());
        palindrome.addActionListener(new menulistener());
        reverse.addActionListener(new menulistener());

    }

    private class menulistener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == summation){
                int num = Integer.parseInt(JOptionPane.showInputDialog("Enter number: "));
                lbl1.setText("Summation(I): " + new Iterative().summation(num));
                lbl2.setText("Summation(R): " + new Recursive().summation(num));
            } else if (e.getSource() == exponentiation){
                int base = Integer.parseInt(JOptionPane.showInputDialog("Enter base: "));
                int power = Integer.parseInt(JOptionPane.showInputDialog("Enter power: "));
                lbl1.setText("Exponentiation(I): " + new Iterative().exponentiation(base,power));
                lbl2.setText("Exponentiation(R): " + new Recursive().exponentiation(base,power));
            } else if (e.getSource() == fibonacci){
                int k = Integer.parseInt(JOptionPane.showInputDialog("Enter nth: "));
                lbl1.setText("Fibonacci(I): " + new Iterative().fibonacci(k));
                lbl2.setText("Fibonacci(R): " + new Recursive().fibonacci(k));
            } else if (e.getSource() == isEven){
                int num = Integer.parseInt(JOptionPane.showInputDialog("Enter number: "));
                lbl1.setText("isEven(I): " + new Iterative().isEven(num));
                lbl2.setText("isEven(R): " + new Recursive().isEven(num));
            } else if (e.getSource() == isOdd){
                int num = Integer.parseInt(JOptionPane.showInputDialog("Enter number: "));
                lbl1.setText("isOdd(I): " + new Iterative().isOdd(num));
                lbl2.setText("isOdd(R): " + new Recursive().isOdd(num));
            } else if (e.getSource() == palindrome){
                String string = JOptionPane.showInputDialog("Enter string: ");
                lbl1.setText("Palindrome(I): " + new Iterative().palindrome(string));
                lbl2.setText("Palindrome(R): " + new Recursive().palindrome(string));
            } else if (e.getSource() == reverse){
                String string = JOptionPane.showInputDialog("Enter string: ");
                lbl1.setText("Reverse(I): " + new Iterative().reverse(string));
                lbl2.setText("Reverse(R): " + new Recursive().reverse(string));
            }
        }
    }
}

