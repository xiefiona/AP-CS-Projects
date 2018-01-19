package Polygon;

public class Point {
	//sets the points
		
	//x and y coordinates for a point
	int x,y;
		
	//default constructor
	public Point() {
		x = 0;
		y = 0;
	}
		
	//fill constructor
	public Point(int x1, int y1) {
		x = x1;
		y = y1;
	}
		
	//gets the X value point
	public int getX() {
		return x;
	}
		
	//gets the Y value point
	public int getY() {
		return y;
	}
	
	//sets the X value point
	public void setX(int x1) {
		x= x1;
	}
	
	//sets the Y value point
	public void setY(int y1) {
		y = y1;
	}
}
