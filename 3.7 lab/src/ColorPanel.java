//Fiona Xie

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{
	
	public ColorPanel(Color backColor) {
		setBackground(backColor);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = getWidth()/2;
		int y = getHeight()/2;
		g.setColor(Color.black);
		g.drawLine(x, 0, x, getHeight());
		g.drawLine(0, y, getWidth(), y);
		g.drawString(x + " , " + y, x + 1, y - 1);
		g.drawString("0, 0", x - 30, y - 20);
		g.fillOval(x-3, y-3, 6, 6);
	}
	
}
