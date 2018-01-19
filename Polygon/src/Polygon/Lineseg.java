package Polygon;

public class Lineseg{
	//sets a line and finds distance
		Point point1;
		Point point2;
		
		//default constructor
		public Lineseg() {
			point1 = new Point(0,0);
			point2 = new Point(0,0);
		}
		
		//fill constructor
		public Lineseg(int x1, int y1, int x2, int y2) {
			point1 = new Point(x1, y1);
			point2 = new Point(x2, y2);
		}

		//finds the distance of the linesegment
		public double getDistance() {
			int a;
			int b;
			a = point1.getY() - point2.getY();	//y distance
			b = point1.getX() - point2.getX();	//x distance
			return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));	//finds the distance using the pythagorean theorem
		}
		
		//toString
		public String toString() {
			return "Point 1: (" + point1.getX() + ", " + point1.getY() + ") Point 2: (" + 
					point2.getX() + ", " + point2.getY() + ") Distance: " + getDistance();
		}
}
