import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    //output books, readers, add/remove, recommend, most similar
    private JList books = new JList();              //list of all books
    private JList readers = new JList();            //list of all readers
    private JTextArea methodB = new JTextArea();    //Most common reader and book with method B

    private JMenuBar menubar = new JMenuBar();				//menu
    private JMenu calculate = new JMenu("File");
    private JMenuItem add = new JMenuItem("Add");
    private JMenuItem delete = new JMenuItem("Delete");
    private JMenuItem replace = new JMenuItem("Replace");
    private JMenuItem clear = new JMenuItem("Clear");

    private JLabel lbl1 = new JLabel("Books: ");
    private JLabel lbl2 = new JLabel("Readers: ");
    private JLabel lbl3 = new JLabel("Recommendation (Method B): ");

    private JPanel mainPane = new JPanel(new GridLayout(1,4));  //for the list of books and readers
    private JPanel outputPane = new JPanel(new GridLayout(1,2));    //for the output of recommendations

    public GUI(){
        setTitle("Book Recommendation Project");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(mainPane, BorderLayout.NORTH);
        mainPane.add(lbl1);
        mainPane.add(books);
        mainPane.add(lbl2);
        mainPane.add(readers);

        add(outputPane, BorderLayout.SOUTH);
        outputPane.add(lbl3);
        outputPane.add(methodB);

        calculate.add(add);
        calculate.add(delete);
        calculate.add(replace);
        calculate.add(clear);
        menubar.add(calculate);
        setJMenuBar(menubar);

        setVisible(true);
    }
}
