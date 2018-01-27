import java.util.*;

public class Tester {
    public static void main(String[] args){
        int numEmployees;
        Random rBool = new Random();
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter the number of employee wanted: ");
        numEmployees = reader.nextInt();

        ArrayList<Employee> arrEmp = new ArrayList<>();
        for(int i=0; i<numEmployees; i++){
            if (rBool.nextBoolean()) {
                arrEmp.add(new FullTimeEmp());
            }
            else {
                arrEmp.add(new PartTimeEmp());
            }
        }

        System.out.println("Part time: ");
        for (Employee e : arrEmp){
            if (e instanceof PartTimeEmp) {
                System.out.println(e.toString());
            }
        }

        System.out.println("Full time: ");
        for (Employee e : arrEmp){
            if (e instanceof FullTimeEmp) {
                System.out.println(e.toString());
            }
        }

        System.out.println("employee count: " + Employee.getEmployeeCount());
        System.out.println("total wage: " + Employee.getTotalPay());
    }
}
