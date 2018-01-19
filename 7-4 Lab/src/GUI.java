import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI extends JFrame{
    private JPanel panel = new JPanel(new GridLayout(2,2));
    private JTextField txtInput = new JTextField();
    private JMenuBar menubar = new JMenuBar();				//menu
    private JMenu menu = new JMenu("File");
    private JMenuItem calculate = new JMenuItem("Calculate");
    private JTextArea txtOutput = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane();

    public GUI(){
        setTitle("Amortization Table");
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(txtInput);
        menubar.add(menu);
        menu.add(calculate);
        setJMenuBar(menubar);
        panel.add(scrollPane);
        scrollPane.setViewportView(txtOutput);
        add(panel);
        txtOutput.setFont( new Font("monospaced", Font.PLAIN, 12) );

        setVisible(true);

        calculate.addActionListener((ActionEvent event) -> {
            AmmortTable data = new AmmortTable(Integer.parseInt(txtInput.getText()));

            System.out.println("Price: " + data.getMyPurchasePrice());
            System.out.println("Down Payment: " + data.getMyDownPayment());
            System.out.println("Monthly Payment: " + data.getMyMonthlyPayment());

            txtOutput.append("Price: " + data.getMyPurchasePrice() + "\n");
            txtOutput.append("Down Payment: " + data.getMyDownPayment() + "\n");
            txtOutput.append("Monthly Payment: " + data.getMyMonthlyPayment() + "\n");
            txtOutput.append("| Month | Total Balance | Interest | Principal   | Payment   | Remaining $   |" + "\n");
            txtOutput.append(data.toString());

        });
    }
}
