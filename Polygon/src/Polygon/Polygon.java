package Polygon;
public class Polygon {
	static int num;
	Point[] points = new Point[200];
	Lineseg[] lines = new Lineseg[100];
	double area;
	double perimeter;
	int interior;
	
	//default constructor
	public Polygon() {
		for (int i=0;i<200;i++) {		//fills the positions in the array with nothing
			points[i] = new Point();
		}
		area = 0;
		perimeter = 0;
		interior = 0;
	}
	
	//fill constructor
	public Polygon(Point[] mypoints, int number) {
		num = number;
		for (int i=0;i<num;i++) {
			points[i] = mypoints[i];
		}
		for (int i=0;i<num-1;i++) {
			lines[i] = new Lineseg(points[i].getX(), points[i].getY(), points[i+1].getX(), points[i+1].getY());
		}
	}

	public void findPerimeter() {		//finds the perimeter of the polyon
		
		for (int i=0;i<num-1;i++) {
			perimeter += lines[i].getDistance();
		}
	}
	
	public void findArea() {			//finds the area of the polygon
		double a=0, b=0;
		
		for (int i=0;i<num-1;i++) {
			a += points[i].getX() * points[i+1].getY();	
			b += points[i].getY() * points[i+1].getX();
		}
		
		area = .5 * Math.abs(a-b);
	}
	
	public void findInterior() {
		interior = (num - 3) * 180;
		System.out.println(num);
	}
	
	public String toString() {			//outputs the information as a string
		perimeter = (int)(perimeter * 100.0) / 100.0;
		area = (int)(area * 100.0) / 100.0;
		return ("Perimeter: " + perimeter + " Area: " + area + " Sum of Interior Angles: " + interior + " degrees");
	}
}
