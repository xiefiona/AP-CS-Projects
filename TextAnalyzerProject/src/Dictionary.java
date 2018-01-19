import java.io.*;
import java.util.*;

public class Dictionary {
    //opens the text file and stores it into an array list
    ArrayList<String> arrDict = new ArrayList<String>();
    ArrayList<Integer> arrSyll = new ArrayList<Integer>();
    long num;   //the number of words in the file

    //constructor
    public Dictionary(){
        try{
            Scanner Freader = new Scanner(new File("src/dictionary.txt"));
            while (Freader.hasNextLine()) {
                String ArrSplit[] = Freader.nextLine().split(",");
                arrDict.add(ArrSplit[0]);
                arrSyll.add(Integer.parseInt(ArrSplit[1]));
                num++;
            }
            Freader.close();
        } catch (IOException e){
            System.err.println("You failed");
        }
    }

    //checks word with dictionary
    public void checkSyllable(Word word){
        //checks with the dictionary
        for(int x=0; x<num; x++){
            if (arrDict.get(x).equals(word.getWord())){
                word.setSyllables(arrSyll.get(x));
            }
        }
    }
}
