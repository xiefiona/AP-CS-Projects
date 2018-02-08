public class ElementaryStu extends Student{
    private double happinessAverage;

    public ElementaryStu(){
        super();
        studentCount++;
        happinessAverage = roundNum(Math.random() * 90 + 10);
        System.out.println(fees);
        fees = findFees();
        totalFees += fees;
        avgFee = totalFees/studentCount;
        gradeLevel = findGradeLevel();
    }
    public ElementaryStu(String fname, String lname, int gradeLevel, double testAvg, double projectAvg, double homeworkAvg,
                   double fees){
        super(fname, lname, gradeLevel, testAvg, projectAvg, homeworkAvg, fees);
        studentCount++;
        totalFees += fees;
        avgFee = totalFees/studentCount;
    }

    public String findLetterGrade(){
        if (findGrade() > 60){
            return ":)";
        } else {
            return ":(";
        }

    }
    public double findGrade(){
        double grade;
        grade = (testAvg * .20) + (projectAvg * .10) + (happinessAverage * .30) + (homeworkAvg * .40);
        return roundNum(grade);
    }
    public double findFees(){
        return roundNum(Math.random() * 20 + 1);
    }
    public int findGradeLevel(){
        return (int)(Math.random() * 2 + 1);
    }

    @Override
    public String toString() {
        return super.toString() + " | Happiness Average: " + happinessAverage + "\n";
    }

}
