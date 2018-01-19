
public class book {

	String author;	//author's name
	String title;	//title of the book
	 public boolean filled = false;	//if there is a book in the slot
	
	public book() {
		author = "";
		title = "";
		filled = false;
	}

	public book(String myauthor, String mytitle) {
		author = myauthor;
		title = mytitle;
		filled = true;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}

	public String toString() {
		return "Title: " + title + "\n" + "Author: " + author;
	}
}
