package Polygon;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;

import java.io.*;
import java.util.Scanner;

public class PolygonTester {
	
	public static void main(String[] args) throws IOException {
		int num;	//number of points
		Point[] points = new Point[200];		//creates an array of points
		for (int i = 0; i<200; i++) {		//initializes the array of points
			points[i] = new Point();
		}
		Polygon poly = new Polygon();
		
		JFrame theGUI = new JFrame();		//sets up the visuals
		theGUI.setTitle("Polygon");
		theGUI.setSize(300,200);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ColorPanel panel = new ColorPanel(Color.white);	//creates a panel with a white backcolor
		Container pane = theGUI.getContentPane();
		pane.add(panel);									//adds the panel onto the pane
		theGUI.setVisible(true);
		
		Graphics g = null;
		panel.setArray(points);
		panel.paintComponent(g);	
	}
}

//xtra credit:
//dynamic points
//perimeter and sum of interior angles
//line segment class
//static variables