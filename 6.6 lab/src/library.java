import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class library {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		patron person = new patron();
		String name;
		String t1, t2, t3, n1, n2, n3;
		boolean hasB;	//if the person has borrowed the book
		int action=0;		//how to manipulate the data
		
		//fills up the patron class
		System.out.println("Enter your name: ");
		name = reader.nextLine();
		System.out.println("Enter title of book: ");
		t1 = reader.nextLine();
		System.out.println("Enter author of book: ");
		n1 = reader.nextLine();
		System.out.println("Enter title of book: ");
		t2 = reader.nextLine();
		System.out.println("Enter author of book: ");
		n2 = reader.nextLine();
		System.out.println("Enter title of book: ");
		t3 = reader.nextLine();
		System.out.println("Enter author of book: ");
		n3 = reader.nextLine();
		person = new patron(name, t1, n1, t2, n2, t3, n3);
		
		do {
			JFrame f = new JFrame("Book title ");
			action = Integer.parseInt(JOptionPane.showInputDialog(f, "Actions(1: check borrowed | 2: borrow | 3: return | 4: exit"
					+ " | 5: create book | 6: retrieve book): "));
			if (action == 1) {
				
				JFrame frame = new JFrame("Book title ");
				t1 = JOptionPane.showInputDialog(frame, "Enter the title of the book: ");
				
				System.out.println(t1);
				hasB = person.hasBorrowed(t1);
				if (hasB == false) {
					System.out.println("You have NOT borrowed this book");
				} else if (hasB == true) {
					System.out.println("You HAVE borrowed this book");
				}
			} else if (action == 2) {
				JFrame frame1 = new JFrame("Book title ");
				t1 = JOptionPane.showInputDialog(frame1, "Enter the title of the book: ");
				
				JFrame frame2 = new JFrame("Author name ");
				n1 = JOptionPane.showInputDialog(frame2, "Enter the author of the book: ");

				person.borrowBook(t1, n1);
			} else if (action == 3) {
				JFrame frame3 = new JFrame("Book title ");
				n1 = JOptionPane.showInputDialog(frame3, "Enter the title of the book you want to return: ");
				
				person.returnBook(t1);
			} 
		} while (action != 4);
		
	}
}
