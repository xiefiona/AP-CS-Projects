//Fiona Xie

import javax.swing.*;
import java.awt.*;

public class lab {
	public static void main(String[] args) {
		JFrame theGUI = new JFrame();
		theGUI.setTitle("GUI Program");
		theGUI.setSize(300,200);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ColorPanel panel = new ColorPanel(Color.white);
		Container pane = theGUI.getContentPane();
		pane.add(panel);
		theGUI.setVisible(true);
		
		Graphics g = null;
		panel.paintComponent(g);
		
	}
}
//how to use graphics g

//extend JPanel and JFrame
//graphics g: class to draw things with, passed as a parameter from the method in JPanel called paint component
	//x-300, 300-y
	//g.drawLine, g.drawString
//super.paintcomponent.g, tells compiler that you are doing everything(oval, rect, etc.), extend of a method or constructor
//jpanel
//redraw with, repaint evokes paint component, maybe need a flag, import, mouse listener, super.paintcomponent
//pg 221
//mouse adapter, mouse press, mouse of int, get x and get y