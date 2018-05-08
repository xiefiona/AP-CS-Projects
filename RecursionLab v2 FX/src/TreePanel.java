import java.awt.*;
import javax.swing.*;

public class TreePanel extends JPanel {

    private boolean Mirrored;
    private int Mode;
    private int bl, ba;

    public TreePanel() {
        setBackground(Color.BLACK);
    }

    public TreePanel(int colorMode) {
        setBackground(Color.BLACK);
        Mode = colorMode;
        bl = 150;
        ba = 90;
    }

    public TreePanel(int colorMode, int bl, boolean Mirrored) {
        setBackground(Color.BLACK);
        Mode = colorMode;
        this.bl = bl;
        this.Mirrored = Mirrored;
        ba = 90;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (Mirrored) {
            new Recursive().BinaryTree(g,  Mode, this.getSize().getWidth() / 2, this.getSize().getHeight() / 2, bl, ba);
            new Recursive().BinaryTree(g,  Mode, this.getSize().getWidth() / 2, this.getSize().getHeight() / 2, bl, 180);
            new Recursive().BinaryTree(g,  Mode, this.getSize().getWidth() / 2, this.getSize().getHeight() / 2, bl, 270);
            new Recursive().BinaryTree(g,  Mode, this.getSize().getWidth() / 2, this.getSize().getHeight() / 2, bl, 0);
        }
        else {
            new Recursive().BinaryTree(g,  Mode, this.getSize().getWidth() / 2, this.getSize().getHeight(), bl, ba);
        }
    }

}
