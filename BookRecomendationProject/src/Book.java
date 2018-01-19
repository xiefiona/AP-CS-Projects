public class Book {
    String myTitle;
    String myAuthor;

    public Book(){
        Book("","");
    }
    public Book(String title, String author){
        myTitle = title;
        myAuthor = author;
    }

    public void setTitle(String title){
        myTitle = title;
    }
    public void setAuthor(String author){
        myAuthor = author;
    }

    public String getTitle(){
        return myTitle;
    }
    public String getAuthor(){
        return myAuthor;
    }

    public String toString(){
        return (myAuthor + " - " + myTitle);
    }
}
