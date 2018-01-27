public abstract class Employee {

    protected static int employeeCount = 0;
    protected static double totalPay = 0;

    protected double hours;
    protected int idNum;
    protected double rate;


    public Employee(){
        hours = getRandomHours();
        idNum = getIdNum();
        rate = getRandomRate();
    }
    public Employee(double hours, double rate){
        this.hours = hours;
        idNum = getIdNum();
        this.rate = rate;
    }

    public static double getTotalPay() {
        return roundNum(totalPay);
    }
    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static double getRandomHours(){
        return roundNum(Math.random() * 100 + 1);
    }
    public static int getIdNum(){
        return (100000 + employeeCount);
    }
    public static double getRandomRate(){
        return roundNum(Math.random() * 150 + 8.15);
    }
    protected static double roundNum(double num){
        return Math.round(num * 100.0) /100.0;
    }

    public String toString() {
        return "idNum: " + idNum + "\n" + "hours: " + hours + "\n" + "rate: " + rate + "\n";
    }

    public abstract double findGrosspay();

}
