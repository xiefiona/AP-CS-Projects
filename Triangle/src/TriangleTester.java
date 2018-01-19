
import java.util.Scanner;
public class TriangleTester {
	
	public static void main(String[] args) {
		Tri[] triangle = new Tri[3];
		Scanner reader = new Scanner(System.in);
		int x1, y1, x2, y2, x3, y3;
		for (int i = 0; i<3; i++) {
			triangle[i] = new Tri();
		}
		int ans = 0;
		int type;
		
		do {
				for (int i=0; i<3; i++) {
					System.out.print("Enter x1: ");
					x1 = reader.nextInt();
					System.out.print("Enter y1: ");
					y1 = reader.nextInt();
					System.out.print("Enter x2: ");
					x2 = reader.nextInt();
					System.out.print("Enter y2: ");
					y2 = reader.nextInt();
					System.out.print("Enter x3: ");
					x3 = reader.nextInt();
					System.out.print("Enter y3: ");
					y3 = reader.nextInt();
				}
			
				for (int i=0; i<3; i++) {
					System.out.println(triangle[i].toString());
				}
			
			System.out.println("Run again?(yes=0, no=1)");
			ans = reader.nextInt();
			
		} while (ans == 0);
	}
}