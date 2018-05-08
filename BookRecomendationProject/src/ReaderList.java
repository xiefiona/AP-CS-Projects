import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReaderList {
    Reader[] arrReaders = new Reader[100];
    int numReaders;

    public ReaderList() {
        for (int i = 0; i<100; i++){
            arrReaders[i] = new Reader();
        }
        numReaders = 0;
    }
    public ReaderList(String path){
        numReaders = 0;
        try{
            Scanner Freader = new Scanner(new File(path));
            while (Freader.hasNextLine()) {
                String tempname = Freader.nextLine();
                String splitArr[] = Freader.nextLine().split(" ");
                int[] tempInt = new int[100];
                for (int i=0;i<splitArr.length;i++){
                    tempInt[i] = Integer.parseInt(splitArr[i]);
                }
                arrReaders[numReaders] = new Reader(tempname,tempInt);
                arrReaders[numReaders].setNumScores(splitArr.length-1);
                numReaders++;
            }
            Freader.close();
        }
        catch (IOException e){
            System.err.println("You failed");
        }
        numReaders--;
    }

    public void setReader(int pos){
        arrReaders[pos] = new Reader();
    }
    public Reader getReader(int pos){
        return arrReaders[pos];
    }
    public int getNumReaders(){
        return numReaders;
    }
}
