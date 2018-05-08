import java.io.*;
import java.util.*;

public class Booklist {
    Book[] arrBooks = new Book[100];
    int numBooks;       //number of books

    public Booklist(){
        for (int i = 0; i<100; i++){
            arrBooks[i] = new Book();
        }
        numBooks = 0;
    }

    public Booklist(String path){
        String string = "";
        numBooks = 0;
        try{
            Scanner Freader = new Scanner(new File(path));
            while (Freader.hasNextLine()) {
                string = Freader.nextLine();
                for (int i = 0; i<string.length(); i++) {
                    if (string.substring(i, i + 1).equals(",")) {
                        arrBooks[numBooks] = new Book(string.substring(0, i), string.substring(i + 1));
                        numBooks++;
                        continue;
                    }
                }
            }
            Freader.close();
        }
        catch (IOException e){
            System.err.println("You failed");
        }
    }

    public void setBook(int pos, String name, String author){
        arrBooks[pos] = new Book(name, author);
    }
    public Book getBook(int pos){
        return arrBooks[pos];
    }
    public int getNumBooks(){
        return numBooks;
    }

    public void addBook(String name, String author){
        numBooks++;
        arrBooks[numBooks] = new Book(name, author);
    }
    public void deleteBook(int pos){
        numBooks--;
        for (int i = pos; i<numBooks; i++) {
            arrBooks[i] = arrBooks[i + 1];
        }
    }

    public String toString(){
        String string = "";
        for (int i = 0;i<numBooks;i++){
            string += arrBooks[i].toString();
        }
        return string;
    }

    public void Save(String Path) {
        try {
            PrintWriter FWriter = new PrintWriter(new File(Path));  //creates a file writer and opens the file
            for (int i = 0; i < numBooks; i++) {
                FWriter.println(arrBooks[i].toString());     //inputs each player into the file
            }
            FWriter.close();
        } catch (IOException e) {
            System.err.println("You Failed");
        }
    }
}

//open the file
//save the books to the Booklist
//open the file
//save the readers to the readerlist
//method B