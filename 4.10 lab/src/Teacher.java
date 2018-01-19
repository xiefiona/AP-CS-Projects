//Fiona Xie
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Teacher {

	public static void main(String[] args) {
		int ans = 1;
		Scanner reader = new Scanner(System.in);
		
		do {

		//sets the variables
		double indexB = 1.000;	//index for a bachelor's degree
		double indexM = 1.100;
		double indexP = 1.150;
		int salaryB = 0, salaryM = 0, salaryP = 0; 	//salaries for all of the degrees
				
		//intput beginning salary through an input box
		double bs;
		JFrame frame = new JFrame("Teacher input: ");
		bs = Integer.parseInt(JOptionPane.showInputDialog(frame, "What is your beginning salary? "));
		
		//input degree through an input box
		String degree;
		degree = JOptionPane.showInputDialog(frame, "What degree do you have?(B,M,P) ");
		
		//input years worked through input box
		int years;
		years = Integer.parseInt(JOptionPane.showInputDialog(frame, "How many years of experience do you have?(max = 20) "));
		
		//output salary
		int salary = 0;
		if (degree.equals("B")||degree.equals("b")) {
			salary = (int)(bs * (indexB + (years*.05)));
			JOptionPane.showMessageDialog(frame, "The index is: " + (indexB + (years*.05)));
			System.out.println("Jackpot!!!");
		} else if (degree.equals("M")||degree.equals("m")) {
			salary = (int)(bs * (indexM + (years*.14)));
			JOptionPane.showMessageDialog(frame, "The index is: " + (indexM + (years*.14)));
		} else if (degree.equals("P")|| degree.equals("p")) {
			salary = (int)(bs * (indexP + (years*.21)));
			JOptionPane.showMessageDialog(frame, "The index is: " + (indexP + (years*.21)));
		}
		JOptionPane.showMessageDialog(frame, "The salary is: " + salary);
		
		//title of the table
		System.out.format("%16s%16s%16s%16s%16s%16s%16s", "Step", "Index(Ba)", "Salary(Ba)", "Index(M)",
				"Salary(M)", "Index(Phd)", "Salary(Phd)");
		System.out.println("");
		
		//the rest of the table
		for (int step = 0; step<=20; step++) {
			
			//salary  = base salary * index of your degree
			salaryB = (int) (bs * indexB);
			salaryM = (int)(bs * indexM);
			salaryP = (int)(bs * indexP);
			System.out.format("%16d%16f%16d%16f%16d%16f%16d", step, indexB , salaryB, indexM, salaryM, indexP, salaryP);
			System.out.println("");
			indexB += 0.05;
			indexM += .14;
			indexP += .21;
		}
		
		System.out.println("Run again? (1 = yes, 0 = no): ");
		ans = reader.nextInt();
		}while (ans == 1 );	
	}
}