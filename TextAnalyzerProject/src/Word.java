import java.util.*;

public class Word {
    private String word;
    private int length;
    private int syllables;

    //constructors
    public Word(){
        word = "";
        length = 0;
        syllables = 0;
    }
    public Word(String myWord, int myLength, int mySyllables){
        word = myWord.toLowerCase();
        length = myLength;
        syllables = mySyllables;
    }
    public Word(String myWord){
        word = myWord.toLowerCase();
        length = myWord.length();
        syllables = this.getSyllables();
    }

    //sets
    public void setSyllables(int mySyllables){
        syllables = mySyllables;
    }
    public void setWord(String myWord){
        word = myWord;
        length = myWord.length();
    }

    //gets
    public String getWord(){
        return word;
    }
    public int getLength(){
        length = word.length();
        return length;
    }
    public int getSyllables(){
        syllables = 0;

        //breaks up the word into an array list
        ArrayList<String> arr = new ArrayList<String>(length);
        for (int i=0; i<length; i++){
            arr.add(word.substring(i,i+1));
        }

        //counts the number of vowels
        for (int i=0; i<length; i++){
            if (arr.get(i).equals("a") || arr.get(i).equals("e") || arr.get(i).equals("i")
                    || arr.get(i).equals("o") || arr.get(i).equals("u") ){
                syllables++;
            }
        }

        //for silent e sounds like kite
        if (arr.size() > 1){
            if (arr.get(arr.size()-1).equals("e")){
                syllables--;
                //System.out.println("silent e");
            }
        }

        //for diphthongs and triphthongs (words with 2 vowels next to each other)
        for (int i=0; i<length-2; i++){
            if (arr.get(i).equals("a") || arr.get(i).equals("e") || arr.get(i).equals("i")
                    || arr.get(i).equals("o") || arr.get(i).equals("u") ){
                if (arr.get(i+1).equals("a") || arr.get(i+1).equals("e") || arr.get(i+1).equals("i")
                        || arr.get(i+1).equals("o") || arr.get(i+1).equals("u") ){
                    if (arr.get(i+2).equals("a") || arr.get(i+2).equals("e") || arr.get(i+2).equals("i")
                            || arr.get(i+2).equals("o") || arr.get(i+2).equals("u") ){
                        //triphthongs
                        syllables-=2;
                        //for if the third letter ends in a "e"
                        if (arr.get(i+2).equals("e")){
                            syllables++;
                        }
                        i+=3;
                    } else {
                        //diphthongs
                        syllables--;
                        if (arr.get(i).equals("i")&& (arr.get(i+1).equals("o") || arr.get(i+1).equals("a"))){
                            syllables++;
                        }
                    }
                    //System.out.println("diphthong");
                }
            }
        }

        //for words that end in -le or -les and have a consonant in front
        if (length > 2){
            if (arr.get(arr.size()-2).equals("l") && arr.get(arr.size()-1).equals("e")){
                if (arr.get(arr.size()-3).equals("a") || arr.get(arr.size()-3).equals("e") ||
                        arr.get(arr.size()-3).equals("i") || arr.get(arr.size()-3).equals("o") ||
                        arr.get(arr.size()-3).equals("u")){
                } else {
                    syllables++;
                    //System.out.println("le");
                }
            }
        }
        if (length > 3){
            if (arr.get(arr.size()-3).equals("l") && arr.get(arr.size()-2).equals("e") && arr.get(arr.size()-1).equals("s")){
                if (arr.get(arr.size()-4).equals("a") || arr.get(arr.size()-4).equals("e") ||
                        arr.get(arr.size()-4).equals("i") || arr.get(arr.size()-4).equals("o") ||
                        arr.get(arr.size()-4).equals("u")){
                } else {
                    syllables++;
                    //System.out.println("les");
                }
            }
        }

        //for words like cycle with a "y" in the middle or end
        for (int i=1; i<length; i++){
            if (arr.get(i).equals("y")){
                syllables++;
                //System.out.println("y");
            }
        }

        //for words like fly with 0 vowels
        if (syllables <= 0){
            syllables = 1;
        }

        Dictionary dictionary = new Dictionary();
        dictionary.checkSyllable(this);
        return syllables;
    }
    public int getCharacters() {
        return word.toCharArray().length;
    }

}
