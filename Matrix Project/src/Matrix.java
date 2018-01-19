import java.util.*;
import java.io.*;
public class Matrix {
    int[][] myMatrix = new int[10][10];     //the first one is the rows, the second is the columns
    int myRows;
    int myColumns;

    //constructors
    public Matrix(){
        //clears the entire Matrix so it is blank
        myRows = myColumns = 0;
        for (int a = 0; a<100; a++){
            for (int b = 0; b<100; b++){
                myMatrix[a][b] = 0;
            }
        }
    }
    public Matrix(int r, int c){
        myRows = r;
        myColumns = c;
    }
    public Matrix(int r, int c, int[][] matrix){
        myRows = r;
        myColumns = c;
        for (int a = 0;a<r;a++){
            for (int b = 0;b<c;b++){
                myMatrix[a][b] = matrix[a][b];
            }
        }
    }
    public Matrix(File path) throws IOException{
        myRows = myColumns = 0;
        int RC = 0;
        Boolean first = true;
        Scanner Freader = new Scanner(path);
        while (Freader.hasNextLine()) {
            String[] SplitArr = Freader.nextLine().split(" ");
            if (first) {
                LineNumberReader LineR  = new LineNumberReader(new FileReader(path));
                String lineRead = "";
                while ((lineRead = LineR.readLine()) != null) {}
                myColumns = SplitArr.length;
                myRows = LineR.getLineNumber();
                myMatrix = new int[myRows][myColumns];
                first = false;
            }
            for (int i = 0; i < SplitArr.length; i++) {
                myMatrix[RC][i] = Integer.parseInt(SplitArr[i]);
            }
            RC++;
        }
    }
    public Matrix(String string){
        myRows = 0;
        for (String line : string.split("\\n")){
            String[] rows = line.split(" ");        //splits the textArea into rows
            myColumns = rows.length;
            myRows++;
        }

        myMatrix = new int[myRows][myColumns];
        int RC = 0;
        for (String line : string.split("\\n")){
            String[] rows = line.split(" ");
            for (int i = 0; i < rows.length; i++) {
                myMatrix[RC][i] = Integer.parseInt(rows[i]);
            }
            RC++;
        }
    }

    //sets and gets
    public void setRows(int r){
        myRows = r;
    }
    public void setColumns(int c){
        myColumns = c;
    }
    public void setVal(int r, int c, int val){
        myMatrix[r][c] = val;
    }
    public int getRows(){
        return myRows;
    }
    public int getColumns(){
        return myColumns;
    }
    public int getVal(int r, int c){
        return myMatrix[r][c];
    }

    //adding and subtracting 2 matrices
    public Matrix add(Matrix m) {
        Matrix temp = new Matrix(myRows,myColumns);
        int val;    //temporarily stores the sum of the 2 numbers

        //adds the 2 matrices together if they have the same # of rows and columns
        if (checkAdd(m.getRows(),m.getColumns())){
            for (int a = 0; a<myRows; a++){
                for (int b = 0; b<myColumns; b++){
                    val = myMatrix[a][b] + m.getVal(a,b);
                    temp.setVal(a,b,val);
                }
            }
            return temp;
        } else {
            return null;
        }
    }
    public Matrix subtract(Matrix m){
        Matrix temp = new Matrix(myRows,myColumns);
        int val;    //temporarily stores the difference of the 2 numbers

        //subtracts the 2 matrices together if they have the same # of rows and columns
        if (checkAdd(m.getRows(),m.getColumns())){
            for (int a = 0; a<myRows; a++){
                for (int b = 0; b<myColumns; b++){
                    val = myMatrix[a][b] - m.getVal(a,b);
                    temp.setVal(a,b,val);
                }
            }
            return temp;
        } else {
            return null;
        }
    }

    //multiplying matrices
    public Matrix multiply(Matrix m){
        Matrix temp = new Matrix(myRows,m.getColumns());
        int val;    //temporarily stores the product of the 2 numbers

        //multiplies the 2 matrices together if the two matrices can be multiplied
        if (checkMult(m.getRows())){
            for (int a = 0; a<myRows; a++){
                for (int b = 0; b<m.getColumns(); b++){
                    val = 0;
                    for (int c = 0;c<myColumns; c++){
                        val += myMatrix[a][c] * m.getVal(c,b);
                        temp.setVal(a,b,val);
                    }
                }
            }
            return temp;
        } else {
            return null;
        }
    }
    public Matrix scalarMultiplication(int constant){
        Matrix temp = new Matrix(myRows, myColumns);

        for (int a = 0; a<myRows; a++){
            for (int b = 0; b<myColumns; b++){
                temp.setVal(a,b,(this.getVal(a,b)*constant));
            }
        }
        return temp;
    }

    //extra math functions
    public int getDeterminant(){
        int determinant;
        int a,b,c,d,e,f,g,h,i;
        if (myColumns == myRows && myRows == 2){
            determinant = this.getVal(0,0)*this.getVal(1,1);
            determinant -= (this.getVal(0,1)*this.getVal(1,0));
            return determinant;
        } else if (myColumns == myRows && myRows == 3){
            a = this.getVal(0,0);
            b = this.getVal(0,1);
            c = this.getVal(0,2);
            d = this.getVal(1,0);
            e = this.getVal(1,1);
            f = this.getVal(1,2);
            g = this.getVal(2,0);
            h = this.getVal(2,1);
            i = this.getVal(2,2);

            determinant = a*((e*i)-(f*h)) - b*((d*i)-(f*g)) + c*((d*h)-(e*g));
            return determinant;
        } else {
            return 0;
        }
    }
    public Matrix getInverse(){
        Matrix temp = new Matrix(2,2);
        if (myColumns == myRows && myRows == 2){
            temp.setVal(0,0,this.getVal(1,1)/getDeterminant());
            temp.setVal(0,1,-1*this.getVal(0,1)/getDeterminant());
            temp.setVal(1,0,-1*this.getVal(1,0)/getDeterminant());
            temp.setVal(1,1,this.getVal(0,0)/getDeterminant());
            return temp;
        } else{
            return null;
        }
    }

    //checks to see if it is possible to add/multiply the matrices
    public boolean checkAdd(int r, int c){
        return (myRows==r && myColumns==c);
    }
    public boolean checkMult(int r){
        return (myColumns == r);
    }

    //toString of the entire matrix
    public String toString(){
        String temp = "";
        for (int a = 0; a<myRows; a++){
            for (int b = 0; b<myColumns; b++){
                temp += myMatrix[a][b] + " ";
            }
            temp += "\n";
        }
        return temp;
    }
}
