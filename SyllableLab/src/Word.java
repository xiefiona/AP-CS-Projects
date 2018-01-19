//Fiona
//Take a word and break it into syllables

import java.io.*;
import java.util.*;

public class Word {
    public static void main(String[] args ){
        String word;        //user inputted word
        int length;         //length of the word
        int syllables = 0;  //number of syllables in the word
        int ans = 1;        //whether or not to run again (1 is true)
        Scanner reader = new Scanner(System.in);
        long num = 0;           //amount of words in the file

        //opens the text file and stores it into an array list
        ArrayList<String> arrDict = new ArrayList<String>();
        ArrayList<Integer> arrSyll = new ArrayList<Integer>();
        try{
            Scanner Freader = new Scanner(new File("src/dictionary"));
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

        do {
            syllables = 0;

            //stores user inputted words
            System.out.println("Enter a word: ");
            word = reader.nextLine();
            word = word.toLowerCase();
            length = word.length();

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
            if (arr.get(arr.size()-1).equals("e")){
                syllables--;
                //System.out.println("silent e");
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
            if (arr.get(arr.size()-2).equals("l") && arr.get(arr.size()-1).equals("e")){
                if (arr.get(arr.size()-3).equals("a") || arr.get(arr.size()-3).equals("e") ||
                        arr.get(arr.size()-3).equals("i") || arr.get(arr.size()-3).equals("o") ||
                        arr.get(arr.size()-3).equals("u")){
                } else {
                    syllables++;
                    //System.out.println("le");
                }
            }
            if (arr.get(arr.size()-3).equals("l") && arr.get(arr.size()-2).equals("e") && arr.get(arr.size()-1).equals("s")){
                if (arr.get(arr.size()-4).equals("a") || arr.get(arr.size()-4).equals("e") ||
                        arr.get(arr.size()-4).equals("i") || arr.get(arr.size()-4).equals("o") ||
                        arr.get(arr.size()-4).equals("u")){
                } else {
                    syllables++;
                    //System.out.println("les");
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

            //checks with the dictionary
            for(int x=0; x<num; x++){
                if (arrDict.get(x).equals(word)){
                    syllables = arrSyll.get(x);
                }
            }

            //if syllable is plural or not when outputting the number of syllables
            if (syllables > 1){
                System.out.println(syllables + " syllables");
            } else {
                System.out.println(syllables + " syllable");
            }

            //for run again test
            System.out.println("run again(y=1/n=0): ");
            ans = Integer.parseInt(reader.nextLine());

        }while(ans == 1);
    }
}

//edible, piece, beautiful
//basement, quietly, beauty