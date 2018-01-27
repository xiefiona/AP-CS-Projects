public class PartTimeEmp extends Employee {
    private int season;

    public PartTimeEmp(){
        super();
        season = (int)(Math.random() * 3) + 1;
        employeeCount++;
        totalPay += findGrosspay();
    }
    public PartTimeEmp(double hours, double rate){
        super(hours, rate);
        season = (int)(Math.random() * 3) + 1;
        employeeCount++;
        totalPay += findGrosspay();
    }

    public double findGrosspay(){
        return roundNum(hours * rate);
    }

    @Override
    public String toString() {
        return super.toString() + "season: " + season + "\n";
    }
}

