public class MiddleStu extends Student {
    private double courseworkAverage;

    public MiddleStu(){
        super();
        studentCount++;
        courseworkAverage = roundNum(Math.random() * 70 + 30);
        System.out.println(fees);
        fees = findFees();
        totalFees += fees;
        avgFee = totalFees/studentCount;
        gradeLevel = findGradeLevel();
    }
    public MiddleStu(String fname, String lname, int gradeLevel, double testAvg, double projectAvg, double homeworkAvg,
                   double fees){
        super(fname, lname, gradeLevel, testAvg, projectAvg, homeworkAvg, fees);
        totalFees += fees;
        avgFee = totalFees/studentCount;
        studentCount++;
    }

    public String findLetterGrade(){
        if (findGrade() > 89.5){
            return "A";
        } else if (findGrade() > 79.5){
            return "B";
        } else if (findGrade() > 69.5){
            return "C";
        } else{
            return "D";
        }
    }
    public double findGrade(){
        double grade;
        grade = (testAvg * .30) + (projectAvg * .20) + (courseworkAverage * .30) + (homeworkAvg * .20);
        return roundNum(grade);
    }
    public double findFees(){
        return roundNum(Math.random() * 50 + 50);
    }
    public int findGradeLevel(){
        return (int)(Math.random() * 1 + 7);
    }

    @Override
    public String toString() {
        return super.toString() + " | Coursework Average: " + courseworkAverage + "\n";
    }
}
