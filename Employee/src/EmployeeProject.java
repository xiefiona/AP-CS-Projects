//Fiona Xie
//Employee class that consists of last name, first name, hours worked, rate per hour, and id number,
//2 constructors(default and fill), and a toString. There is an employee tester class that outputs 3 employees

import java.util.Scanner;

public class EmployeeProject {
	
	public static void main (String[] args) {
		//declares all variables and info for an employee
		Emp[] arrEmps = new Emp[3];	//makes an array of employees
		String myfirstname;
		String mylastname;
		String trash;
		double myhours;
		double myrate;	
		int mydependents;
		int myidnum;		
		int myage;
		Scanner reader = new Scanner(System.in);
		
		//initializes all in the array
		for (int i=0;i<3;i++) {
			arrEmps[i] = new Emp();
		}
		
		//asks for all information about the employees
		for (int i=0;i<3;i++) {
			System.out.print("Enter firstname: ");	//2nd iteration: prohibits input for gender
			myfirstname = reader.nextLine();
			arrEmps[i].setFirstname(myfirstname);
			
			System.out.print("Enter lastname: ");
			mylastname = reader.nextLine();
			arrEmps[i].setLastname(mylastname);
			
			System.out.print("Enter hours worked: ");
			myhours = reader.nextDouble();
			arrEmps[i].setHours(myhours);
			
			System.out.print("Enter rate per hour: ");
			myrate = reader.nextDouble();
			arrEmps[i].setRate(myrate);
			
			System.out.print("Enter ID number: ");
			myidnum = reader.nextInt();
			arrEmps[i].setIDnum(myidnum);
			
			System.out.print("Enter number of dependents: ");
			mydependents = reader.nextInt();
			arrEmps[i].setNumdep(mydependents);
			
			System.out.print("Enter age: ");
			myage = reader.nextInt();
			arrEmps[i].setAge(myage);
			
			System.out.println("");
			trash = reader.nextLine();
		}
		
		//finds and outputs grosspay and all information
		for (int i=0;i<3;i++) {
			arrEmps[i].setGrosspay();
			arrEmps[i].setFederaltax();
			arrEmps[i].toString();
		}
		
	}
}
