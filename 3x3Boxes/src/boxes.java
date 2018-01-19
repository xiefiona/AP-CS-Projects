//Name: Fiona Xie
//Purpose: to create a 3x3 of black and white tiles. I am creating a 3x3 panel of random colors

import javax.swing.*;	//access JFrame
import java.awt.*;		//use color and container
import java.util.Random;	//Random colors

public class boxes {

	public static void main (String[] args) {
			
		//Frame setup
			JFrame theGUI = new JFrame();			//creates the Frame
			theGUI.setTitle("3x3 Program");	//titles the frame
			theGUI.setSize(300,300);				//sets the size of the frame
			theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//makes sure the frame closes
			
		//creates panels
			JPanel[] panel = new JPanel[100];
			
		//creates a pane and sets layout
			Container pane = theGUI.getContentPane();	//creates a pane
			pane.setLayout(new GridLayout(10,10));		//sets the layout into a 10 by 10
		
		//sets the random color and outputs it
			for (int i=0;i<100;i++) {
				panel[i] = new JPanel();
				panel[i].setBackground(SetNewColor());
				pane.add(panel[i]);
			}
			
		//makes the GUI visible
			theGUI.setVisible(true);
	}
		
	public static Color SetNewColor() {	//creates a random color
			Random random = new Random();				//makes an object: random
			
			int r = random.nextInt(256);
			int g = random.nextInt(256);
			int b = random.nextInt(256);
			return new Color(r,g,b);
	}
}
