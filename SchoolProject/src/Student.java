public abstract class Student {

        protected static int studentCount = 0;
        protected static double totalFees = 0;
        protected static double avgFee = 0;

        protected String fname;
        protected String lname;
        protected int idNum;
        protected int gradeLevel;
        protected double testAvg;
        protected double projectAvg;
        protected double homeworkAvg;
        protected double fees;

        private static Dictionary d = new Dictionary();

        public Student(){
            fname = getFName();
            lname = getLName();
            idNum = getIdNum();
            testAvg = getTestAvg();
            projectAvg = getProjectAvg();
            homeworkAvg = getHomeworkAvg();
        }
        public Student(String fname, String lname, int gradeLevel, double testAvg, double projectAvg, double homeworkAvg,
                        double fees){
            this.fname = fname;
            this.lname = lname;
            idNum = getIdNum();
            this.gradeLevel = gradeLevel;
            this.testAvg = testAvg;
            this.projectAvg = projectAvg;
            this.homeworkAvg = homeworkAvg;
            this.fees = fees;
        }

        public static int getStudentCount(){
            return studentCount;
        }
        public static double getTotalFees(){
            return roundNum(totalFees);
        }
        public static double getAvgFee(){
            return roundNum(avgFee);
        }

        public static String getFName() {
            return d.getRFName();

        }
        public static String getLName() {
            return d.getRLName();
        }
        public static int getIdNum(){
            return (100000 + studentCount);
        }
        public static double getTestAvg(){
            return roundNum(Math.random() * 60 + 40);
        }
        public static double getProjectAvg(){
            return roundNum(Math.random() * 50 + 50);
        }
        public static double getHomeworkAvg(){
            return roundNum(Math.random() * 50 + 50);
        }

        protected static double roundNum(double num){
            return Math.round(num * 100.0) /100.0;
        }

        public String toString() {
            return ("Name: " +  fname + " " + lname + " | ID: " + idNum + " | Grade Level: " + gradeLevel +
            " | Test Average: " + testAvg + " | Project Average: " + projectAvg + " | Homework Average: " +
            homeworkAvg + " | Fees: " + fees + " | Grade: " + findGrade() + " | Letter Grade: " + findLetterGrade());
        }

        public abstract String findLetterGrade();
        public abstract double findGrade();
        public abstract double findFees();
        public abstract int findGradeLevel();

}