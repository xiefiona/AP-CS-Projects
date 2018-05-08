import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
    //output books, readers, add/remove, recommend, most similar
    private JList books = new JList();              //list of all books
    private DefaultListModel ImBooks = new DefaultListModel();
    private JScrollPane scrollPane = new JScrollPane();

    private JList readers = new JList();            //list of all readers
    private DefaultListModel ImReaders = new DefaultListModel();
    private JScrollPane scrollPane2 = new JScrollPane();

    private JTextArea methodB = new JTextArea();    //Most common reader and book with method B

    private JMenuBar menubar = new JMenuBar();				//menu
    private JMenu book = new JMenu("Book");
    private JMenuItem add = new JMenuItem("Add");
    private JMenuItem delete = new JMenuItem("Delete");
    private JMenuItem replace = new JMenuItem("Replace");
    private JMenu reader = new JMenu("Reader");
    private JMenuItem addR = new JMenuItem("Add");
    private JMenuItem deleteR = new JMenuItem("Delete");
    private JMenuItem replaceR = new JMenuItem("Replace");

    private JPanel mainPane = new JPanel(new GridLayout(2,2));

    public GUI(){
        setTitle("Book Recommendation Project");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(mainPane);
        mainPane.add(books);
        mainPane.add(methodB);
        mainPane.add(readers);
        mainPane.add(scrollPane);
        scrollPane.setViewportView(books);

        mainPane.add(scrollPane2);
        scrollPane2.setViewportView(readers);

        book.add(add);
        book.add(delete);
        book.add(replace);
        reader.add(addR);
        reader.add(deleteR);
        reader.add(replaceR);
        menubar.add(book);
        menubar.add(reader);
        setJMenuBar(menubar);


        Booklist book = new Booklist("src/books.txt");
        for (int i=0;i<book.getNumBooks();i++){
            ImBooks.addElement(book.getBook(i).toString());
        }
        books.setModel(ImBooks);

        ReaderList reader = new ReaderList("src/readers.txt");
        for (int i = 0;i<reader.getNumReaders();i++){
            ImReaders.addElement(reader.getReader(i).toString());
        }
        readers.setModel(ImReaders);

        setVisible(true);

        //change the 2 lists
    }
}
