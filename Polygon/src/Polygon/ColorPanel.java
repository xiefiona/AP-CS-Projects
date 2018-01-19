package Polygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPanel extends JPanel{
	Point[] point = new Point[200];		//creates an array of points
	Polygon poly = new Polygon();
	int count = 0;
	boolean same = false;
	
	
	public ColorPanel(Color backColor) {
		setBackground(backColor);
		addMouseListener(new PanelListener());
	}
	
	public void setArray(Point[] mypoints) {
		for (int i = 0; i<200; i++) {		//initializes the array of points
			point[i] = new Point();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int a = getWidth()/2;	//creates the x and y axis
		int b = getHeight()/2;
		g.setColor(Color.black);
		g.drawLine(a, 0, a, getHeight());
		g.drawLine(0, b, getWidth(), b);
		
		if (point[0].getX() >=0) {
			
			//if the point is the same as the first point
			if (count>1) {
				if (point[count-1].getX() < point[0].getX() + 5 && point[count-1].getX() > point[0].getX() - 5) {		
					if (point[count-1].getY() < point[0].getY() + 5 && point[count-1].getY() > point[0].getY() - 5) {
						same = true;
					}
				}
			}
			
			if (same == true) {	//if the user is done drawing
				//draws points
				for (int i=0;i<count-1;i++) {
					g.drawString("(" + (point[i].getX()-150) + ", " + (100-point[i].getY()) + ")",
							point[i].getX(), point[i].getY());	//draws the current coordinates
					g.fillOval(point[i].getX(), point[i].getY(), 2, 2);	//draws a point
					poly = new Polygon(point, count);
					poly.findArea();
					poly.findPerimeter();
					poly.findInterior();
					g.drawString(poly.toString() , 20, 20);
				}
			}
			else {	//if the user isn't done drawing
				//draws points
				for (int i=0;i<count;i++) {
					g.drawString("(" + (point[i].getX()-150) + ", " + (100 - point[i].getY()) + ")",
							point[i].getX(), point[i].getY());	//draws the current coordinates
					g.fillOval(point[i].getX(), point[i].getY(), 2, 2);	//draws a point
				}
			}
			
			//draws lines
			if (count >= 1) {
				for(int i1=0;i1<count-1;i1++) {
					g.drawLine(point[i1].getX(), point[i1].getY(), point[i1+1].getX(), point[i1+1].getY());	
				}
			}
			//dynamic points
			if (count>=3) {	
				g.drawLine(point[count-1].getX(), point[count-1].getY(), point[0].getX(), point[0].getY());	//draws lines
			}
				
		}
		
	}
	
	private class PanelListener extends MouseAdapter{
		
		public void mousePressed(MouseEvent e) {
			//current mouse coordinates
			point[count].setX(e.getX());
			point[count].setY(e.getY());
			
			count++;
			repaint();
		}
	}
}
