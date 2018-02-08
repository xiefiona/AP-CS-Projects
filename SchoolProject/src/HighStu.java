public class HighStu extends Student {
    private double labAverage;

    public HighStu(){
        super();
        studentCount++;
        labAverage = roundNum(Math.random() * 60 + 40);
        fees = findFees();
        System.out.println(fees);
        totalFees += fees;
        avgFee = totalFees/studentCount;
        gradeLevel = findGradeLevel();
    }
    public HighStu(String fname, String lname, int gradeLevel, double testAvg, double projectAvg, double homeworkAvg,
                   double fees){
        super(fname, lname, gradeLevel, testAvg, projectAvg, homeworkAvg, fees);
        studentCount++;
        totalFees += fees;
        avgFee = totalFees/studentCount;
    }

    public String findLetterGrade(){
        if (findGrade() > 96.5){
            return "A+";
        } else if (findGrade() > 92.5){
            return "A";
        } else if (findGrade() > 89.5){
            return "A-";
        } else if (findGrade() > 86.5){
            return "B+";
        } else if (findGrade() > 82.5){
            return "B";
        } else if (findGrade() > 79.5){
            return "B-";
        } else if (findGrade() > 76.5) {
            return "C+";
        } else if (findGrade() > 72.5){
            return "C";
        } else if (findGrade() > 69.5){
            return "C-";
        } else if (findGrade() > 62.5) {
            return "C";
        } else if (findGrade() > 50){
            return "D";
        } else {
            return "F";
        }
    }
    public double findGrade(){
        double grade;
        grade = (testAvg * .5) + (projectAvg * .2) + (labAverage * .2) + (homeworkAvg * .1);
        return roundNum(grade);
    }
    public double findFees(){
        return roundNum(Math.random() * 60 + 60);
    }
    public int findGradeLevel(){
        return (int)(Math.random() * 4 + 8);
    }

    @Override
    public String toString() {
        return super.toString() + " | Lab Average: " + labAverage + "\n";
    }
}
