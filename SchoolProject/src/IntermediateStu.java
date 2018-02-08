public class IntermediateStu extends Student {
    private double participationAverage;

    public IntermediateStu(){
        super();
        studentCount++;
        participationAverage = roundNum(Math.random() * 80 + 20);
        System.out.println(fees);
        fees = findFees();
        totalFees += fees;
        avgFee = totalFees/studentCount;
        gradeLevel = findGradeLevel();
    }
    public IntermediateStu(String fname, String lname, int gradeLevel, double testAvg, double projectAvg, double homeworkAvg,
                   double fees){
        super(fname, lname, gradeLevel, testAvg, projectAvg, homeworkAvg, fees);
        totalFees += fees;
        avgFee = totalFees/studentCount;
        studentCount++;
    }

    public String findLetterGrade(){
        if(findGrade() > 70){
            return "A";
        } else if (findGrade() > 50){
            return "B";
        } else {
            return "C";
        }
    }
    public double findGrade(){
        double grade;
        grade = (testAvg * .25) + (projectAvg * .20) + (participationAverage * .30) + (homeworkAvg * .25);
        return roundNum(grade);
    }
    public double findFees(){
        return roundNum(Math.random() * 30 + 30);
    }
    public int findGradeLevel(){
        return (int)(Math.random() * 2 + 4);
    }

    @Override
    public String toString() {
        return super.toString() + " | Participation Average: " + participationAverage + "\n";
    }
}
