import java.awt.*;

public class Recursive extends Operations {

    public static final int WHITE_TREE = 1;
    public static final int RAINBOW_TREE = 0;

    public static final double LEN_RATIO_1 = .75;
    public static final double LEN_RATIO_2 = .66;
    public static final int THETA_CONSTANT_1 = 30;
    public static final int THETA_CONSTANT_2 = -50;

    public long Factorial(int n) {
        return (n == 1) ? n : n * Factorial(n - 1);
    }

    public long Fibonacci(int n) {
        return (n <= 1) ? n : Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public long Summation(int n) {
        return (n < 0) ? 0 : n + Summation(n - 1);
    }

    public long Exponentiation(int x, int n) {
        return (n < 1) ? 1 : x * Exponentiation(x, n - 1);
    }

    public String Reverse(String str) {
        return (str.length() <= 1 || str == null) ? str : Reverse(str.substring(1)) + str.charAt(0);
    }

    public boolean Palindrome(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }
        else if(str.charAt(0) == str.charAt(str.length() - 1)) {
            return Palindrome(str.substring(1, str.length() - 1));
        }
        return false;
    }

    public String toBinary(int n) {
        if (n <= 0) {
            return "";
        }
        else {
            return toBinary(n / 2) + ((n % 2) == 0 ? "0" : "1");
        }
    }

    public int fromBinary(String n) {
        if (n.length() <= 0) {
            return 0;
        }
        else {
            return (n.charAt(0) == '1') ? (int) Math.pow(2, n.length() - 1) + fromBinary(n.substring(1)) : fromBinary(n.substring(1));
        }
    }

    public long GCD(int k, int j) {
        return (j == 0) ? k : GCD(j, k % j);
    }

    public void BinaryTree(Graphics g, int colorMode, double XStart, double YStart, double branchLength, double Theta) {
        if (branchLength > 2) {
            double NextX = XStart + branchLength * Math.cos(Math.toRadians(Theta));
            double NextY = YStart - branchLength * Math.sin(Math.toRadians(Theta));
            g.setColor((colorMode == Recursive.WHITE_TREE) ? Color.WHITE : new Color((int)(Math.random() * 0x1000000)).brighter());
            g.drawLine((int)XStart, (int)YStart, (int)NextX, (int)NextY);
            BinaryTree(g, colorMode, NextX, NextY, branchLength * LEN_RATIO_1, Theta + THETA_CONSTANT_1);
            BinaryTree(g, colorMode, NextX, NextY, branchLength * LEN_RATIO_2, Theta + THETA_CONSTANT_2);
        }
    }

}
