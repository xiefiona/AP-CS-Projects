import java.util.*;
import java.io.*;

public class Dictionary {
    private ArrayList<String> arrFFName = new ArrayList<>();
    private ArrayList<String> arrMFName = new ArrayList<>();
    private ArrayList<String> arrLName = new ArrayList<>();

    public Dictionary(){
        try {
            Scanner fReader1 = new Scanner(new File("src/Female.txt"));
            Scanner fReader2 = new Scanner(new File("src/Male.txt"));
            Scanner fReader3 = new Scanner(new File("src/LastName.txt"));

            while(fReader1.hasNextLine()){
                arrFFName.add(fReader1.nextLine());
            }
            while(fReader2.hasNextLine()){
                arrMFName.add(fReader2.nextLine());
            }
            while (fReader3.hasNextLine()){
                arrLName.add(fReader3.nextLine());
            }
        } catch (IOException e){
            System.out.println("You Failed :(");
        }

    }

    public String getRFName(){
        if (new Random().nextBoolean()){
            return arrFFName.get(new Random().nextInt(arrFFName.size()));
        } else {
            return arrMFName.get(new Random().nextInt(arrMFName.size()));
        }
    }
    public String getRLName(){
        return arrLName.get(new Random().nextInt(arrLName.size()));
    }
}
