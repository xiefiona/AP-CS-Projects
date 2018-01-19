
public class patron {

	String name;
	public book b1;
	public book b2;
	public book b3;
	
	public patron() {
		name = "";
		b1 = new book();
		b2 = new book();
		b3 = new book();
	}
	
	public patron(String myname, String t1, String n1, String t2, String n2, String t3, String n3) {
		name = myname;
		b1 = new book(n1, t1);
		b2 = new book(n2, t2);
		b3 = new book(n3, t3);
	}
	
	//borrow a book
	public void borrowBook(String title, String author) {
		//if there is space available, borrows the book
		if (b1.filled = false) {
			b1 = new book(author, title);
		} else if (b2.filled = false) {
			b2 = new book(author, title);
		} else if (b3.filled = false) {
			b3 = new book(author, title);
		} else {
			System.out.println("You have already checked out too many books :(");
		}
	}
	
	//return a book
	public void returnBook(String title) {
		//clears the book, if the title exists
		if (b1.getTitle().equals(title)) {
			b1 = new book();
		} else if (b2.getTitle().equals(title)) {
			b2 = new book();
		} else if (b3.getTitle().equals(title)) {
			b3 = new book();
		} else {
			System.out.println("You silly goose, you never borrowed this book :)");
		}
		
	}
	
	//check whether the book has been borrowed
	public boolean hasBorrowed(String title) {
		//if you borrowed the book, it returns true
		if (b1.getTitle().equals(title)) {
			return true;
		} else if (b2.getTitle().equals(title)) {
			return true;
		} else if (b3.getTitle().equals(title)) {
			return true;
		} else {
			return false;
		}
	}
}
