public class Reader {
    String myName;
    int[] myArrScores;
    int myNumScores;

    public Reader(){
        myName = "";
        myNumScores = 0;
        for (int i=0; i<100; i++){
            arrScores[i] = null;
        }
    }
    public Reader(String name, int scores, int[] arrScores){
        myName = name;
        myNumScores = scores;
        return new Reader();
    }
    //manual with array of scores

    public void setName(String name){
        myName = name;
    }
    public void setScore(int i, int score){
        arrScores[i] = score;
    }
    public void setNumScores(int i){
        myNumScores = i;
    }

    public String getName(){
        return myName;
    }
    public int getScore(int i){
        return arrScores[i];
    }
    public int getNumScores(){
        return myNumScores;
    }

    public String toString(){
        String string = "";
        string = myName + ": ";
        for (int i = 0; i <= myNumScores ; i++){
            string += arrScores[i] + " ";
        }
        return string;
    }
}
