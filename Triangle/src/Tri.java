
public class Tri {
	Line line1 = new Line();
	Line line2 = new Line();
	Line line3 = new Line();
	double perimeter, area, typetri, isTri;
	
	//default constructor
	public Tri() {
		line1 = new Line(0,0,0,0);
		line2 = new Line(0,0,0,0);
		line3 = new Line(0,0,0,0);
	}
	
	//fill constructor
	public Tri(int x1, int y1, int x2, int y2, int x3, int y3) {
		line1 = new Line(x1, y1, x2, y2);
		line2 = new Line(x2, y2, x3, y3);
		line3 = new Line(x3, y3, x1, y1);
	}
	
	//area
	public double findArea() {
		//finds the area using Heron's formula
		double p = findPerimeter()/2;
		return Math.sqrt(p * (p - line1.getDistance()) * (p - line2.getDistance()) * (p - line3.getDistance()));
	}
	
	//perimeter
	public double findPerimeter() {
		return line1.getDistance() + line2.getDistance() + line3.getDistance();
	}
	
	//kind of triangle
	public String typeOfTri() {
		int a = 0;		//number of 
		String type;
		if (line1.getDistance() == line2.getDistance()) {
			a++;
		}
		if (line2.getDistance() == line3.getDistance()) {
			a++;
		} 
		if (a == 2) {
			type = "Equilateral";
		} else if (a == 1) {
			type = "Isosceles";
		} else {
			type = "Scalene";
		}
		return type;
	}
	
	//if it is a triangle
	public boolean TriTrue() {
		if (line1.getDistance() + line2.getDistance() > line3.getDistance() && line2.getDistance() + line3.getDistance() > line1.getDistance() && 
				line3.getDistance() + line1.getDistance() > line2.getDistance()) {
			return true;
		} else {
			return false;
		}
	}
	
	//tostring
	public String toString() {
		if (TriTrue() == false) {
			return "Line 1: " + line1.toString() + "\nLine 2: " + line2.toString() + "\nLine 3: " + line3.toString() + "\nThis is not a triangle :(";
		} else {
			return "Line 1: " + line1.toString() + "\nLine 2: " + line2.toString() + "\nLine 3: " + line3.toString() + "\nArea: " + findArea()  +
					" Perimeter: " + findPerimeter() + " Triangle type: " + typeOfTri() ;
		}
	}

	//angles (last)
	//random fill(maybe)
}
