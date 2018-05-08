public class Reader {
    String myName;
    int[] myArrScores;
    int myNumScores;        //number of scores

    public Reader(){
        myName = "";
        myNumScores = 0;
        for (int i=0; i<100; i++){
            myArrScores[i] = 0;
        }
    }
    public Reader(String name, int[] arrScores){
        myName = name;
        myNumScores = arrScores.length;
        myArrScores = arrScores;
    }

    public void setName(String name){
        myName = name;
    }
    public void setScore(int i, int score){
        myArrScores[i] = score;
    }
    public void setNumScores(int i){
        myNumScores = i;
    }

    public String getName(){
        return myName;
    }
    public int getScore(int i){
        return myArrScores[i];
    }
    public int getNumScores(){
        return myNumScores;
    }

    public String toString(){
        String string = myName + ": ";
        for (int i = 0; i <= myNumScores ; i++){
            string += myArrScores[i] + " ";
        }
        return string;
    }
}
