import java.util.*;
import java.io.*;

public class TextAnalyzer {
    private String text;
    private ArrayList<Word> arrWords = new ArrayList<Word>();


    //constructor
    public TextAnalyzer(String myText){
        text = " " + myText;
        int pos=1;
        for (int i=1; i<text.length(); i++){      //start at 1 b/c all text files start with a " "
            if (text.substring(i, i+1).equals(" ") || text.substring(i, i+1).equals(".")){
                arrWords.add(new Word(text.substring(pos, i)));
                pos = i+1;
                if (i != text.length()-1){
                    //removes the word if it was added twice due to a double space
                    if (text.substring(i+1, i+2).equals(" ")){
                        arrWords.remove(arrWords.size()-1);
                    }
                }
            }
        }
    }
    public TextAnalyzer(File path){
        text = "";
        try{
            Scanner Freader = new Scanner(path);
            while (Freader.hasNextLine()) {
                text = text + " " + Freader.nextLine();
            }
            Freader.close();
            int pos=1;
            for (int i=1; i<text.length(); i++){      //start at 1 b/c all text files start with a " "
                if (text.substring(i, i+1).equals(" ") || text.substring(i, i+1).equals(".")){
                    arrWords.add(new Word(text.substring(pos, i)));
                    pos = i+1;
                    if (i != text.length()-1){
                        //removes the word if it was added twice due to a double space
                        if (text.substring(i+1, i+2).equals(" ")){
                            arrWords.remove(arrWords.size()-1);
                        }
                    }
                }
            }
        } catch (IOException e){
            System.err.println("You failed");
        }
    }

    //gets
    public String getText(){
        return text;
    }
    public int getNumSentences(){
        int numSentences = 0;
        for (int i=0; i<text.length(); i++){
            if (text.substring(i, i+1).equals(".")){
                numSentences++;
            }
        }
        return numSentences;
    }
    public int getNumWords(){
        return arrWords.size();
    }
    public int getNumSyllables(){
        int numSyllables = 0;
        for (int i=0; i<arrWords.size(); i++){
            numSyllables += arrWords.get(i).getSyllables();
        }
        return numSyllables;
    }
    public int getNumCharacters() {
        int numCharacters = 0;
        for (Word w: arrWords) {
            numCharacters += w.getCharacters();
        }
        return numCharacters;
    }
    public int getFleschIndex(){
        double spw = 0; //syllables per word
        double wps = 0; //words per sentence (average sentence length)

        spw = (double)this.getNumSyllables() / (double)this.getNumWords();
        wps = (double)this.getNumWords() / (double)this.getNumSentences();
        double fleschIndex = 206.835 - (1.015 * wps) - (84.6 * spw);
        return (int)Math.round(fleschIndex);
    }
    public int getColemanLiau(){
        return (int)(5.89 * ((double)getNumCharacters()/getNumWords())
                - .3 * ((double)getNumSentences()/getNumWords()) - 15.8);
    }

    public String calculateEducationalLevel(){
        double fleschIndex = getFleschIndex();
        if (fleschIndex >= 91){
            return "5th grade";
        } else if (fleschIndex >= 81){
            return "6th grade";
        } else if (fleschIndex >= 71){
            return "7th grade";
        } else if (fleschIndex >= 61){
            return "8th and 9th grade";
        } else if (fleschIndex >= 51){
            return "10th-12th grade";
        } else if (fleschIndex >= 31){
            return "college student";
        } else if (fleschIndex >= 0){
            return "college graduate";
        } else {
            return "law student";
        }
    }
}

