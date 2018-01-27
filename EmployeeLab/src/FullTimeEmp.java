public class FullTimeEmp extends Employee {
    private double unionDues;

    public FullTimeEmp(){
        super();
        unionDues = roundNum(.01 * findGrosspay());
        employeeCount++;
        totalPay += findGrosspay();
    }
    public FullTimeEmp(double hours, double rate){
        super(hours,rate);
        unionDues = .01 * findGrosspay();
        employeeCount++;
        totalPay += findGrosspay();
    }

    public double findGrosspay(){
        if(hours<=40){
            return roundNum(hours * rate);
        } else {
            return roundNum((40 * rate) + ((hours - 40) * rate));
        }
    }

    @Override
    public String toString() {
        return super.toString() + "union dues: " + unionDues + "\n";
    }
}
