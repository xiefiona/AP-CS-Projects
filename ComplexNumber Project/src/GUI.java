import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
	private JTextField txt1 = new JTextField("");	//textboxes to input the complex numbers
	private JTextField txt2 = new JTextField("");
	private JLabel lbl1 = new JLabel("Num 1:");		//labels to show what to input into the textboxes
	private JLabel lbl2 = new JLabel("Num 2:");
	private JButton cmdclear = new JButton("Clear");	//buttons to clear the textboxes
	private JButton cmdquit = new JButton("Quit");
	private JPanel panel = new JPanel(new GridLayout(3,2));	//panel
	private JMenuBar menubar = new JMenuBar();				//menu
	private JMenu calculate = new JMenu("Calculate");
	private JMenuItem all = new JMenuItem("All");
	private DefaultListModel model = new DefaultListModel();	//list for output
	private JList list = new JList(model);
	
	public GUI() {
	//sets up the JFrame: creating it, setting a size, and making sure it closes
		setTitle("Complex Number Project");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//Setup with the panel with textboxes and labelboxes and buttons
		panel.add(lbl1);
		panel.add(lbl2);
	    panel.add(txt1); 
		panel.add(txt2);
	    panel.add(cmdclear);
	    panel.add(cmdquit);
	//adds the panel onto the JFrame
		add(panel);
		
	//creates the menu
        calculate.add(all);
        menubar.add(calculate);
        setJMenuBar(menubar);
        
    //list for output
        JScrollPane pane = new JScrollPane(list);
        add(pane, BorderLayout.SOUTH);	//adds the pane and list onto the JFrame
    
    //makes the Frame visible
        setVisible(true);    
        
	//makes the clear button work
		cmdclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		txt1.setText("");
            		txt2.setText("");
            		model.clear();
            		list.setModel(model);
            }
		});
	//make the end button
		cmdquit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	//all menu option
		all.addActionListener((ActionEvent event) -> {
			ComplexNum num = new ComplexNum(txt1.getText());
			ComplexNum num2 = new ComplexNum(txt2.getText());
			
			list.setModel(model);
			model.addElement("+: "+num.addNum(num2).toString());
			model.addElement("-: "+num.subtractNum(num2).toString());
			model.addElement("x: "+num.multiplyNum(num2).toString());
			model.addElement("/: "+num.divideNum(num2).toString());
			model.addElement("^2 of num1: " + num.powers(2).toString());
			model.addElement("^2 of num2: " + num2.powers(2).toString());
			model.addElement("sqrt of num1: " + num.roots().toString());
			model.addElement("sqrt of num2: " + num2.roots().toString());
		});
	}
}
