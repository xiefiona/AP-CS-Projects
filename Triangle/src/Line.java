
public class Line {
	//sets a line and finds distance, slope, midpoint
	Point point1;
	Point point2;
	
	//default constructor
	public Line() {
		point1 = new Point(0,0);
		point2 = new Point(0,0);
	}
	
	//fill constructor
	public Line(int x1, int y1, int x2, int y2) {
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
	
	//checks to see if there is a slope (if it's a vertical line)
	public boolean isSlope() {
		if (point1.getX() - point2.getX() == 0){
			return false;
		} else {
			return true;
		}
	}
	
	//finds the slope of the line segment
	public double getSlope() {
		return (double)(point1.getY() - point2.getY())/(point1.getX() - point2.getX());
	}
	
	//finds the midpoint of the line(X value)
	public double getMidpointX() {
		return (point1.getX() + point2.getX()) / 2;
	}
	
	//finds the midpoint of the line(Y value)
	public double getMidpointY() {
		return (point1.getY() + point2.getY()) / 2;
	}
	
	//find the equation of the line segment
	public String getEquation() {
		return ("Equation: y = " + getSlope() + "x + " + (point1.getY() - (getSlope() * point1.getX()) ));
	}
	
	//toString
	public String toString() {
		if (isSlope() == false) {
			return "Point 1: (" + point1.getX() + ", " + point1.getY() + ") Point 2: (" + 
					point2.getX() + ", " + point2.getY() + ") Distance: " + getDistance() + 
					" Slope: N/A" + " Midpoint: (" + getMidpointX() + ", " + getMidpointY() +") " + "Equation: N/A";
		} else {
		return "Point 1: (" + point1.getX() + ", " + point1.getY() + ") Point 2: (" + 
				point2.getX() + ", " + point2.getY() + ") Distance: " + getDistance() + 
				" Slope: " + getSlope() + " Midpoint: (" + getMidpointX() + ", " + getMidpointY() +") " + getEquation();
		}
	}
}
