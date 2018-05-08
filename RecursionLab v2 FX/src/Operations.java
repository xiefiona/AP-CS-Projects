public abstract class Operations {

    public static final String[] OPERATIONS = {"Factorial", "Fibonacci", "Summation", "Exponentiation", "Reverse", "Palindrome", "from Binary", "to Binary", "GCD", "Binary Tree", "Rainbow Binary Tree", "Binary Tree Mirrored", "Rainbow Binary Tree Mirrored"};
    public static final String[] TOOLTIPS = {"Enter Number", "Enter Number", "Enter Number", "Enter Base, Enter Power", "Enter Word", "Enter Word or Phrase", "Enter Binary Number", "Enter Number", "Enter Number One, Enter Number Two", "Enter Branch Length in Pixels", "Enter Branch Length in Pixels", "Enter Branch Length in Pixels", "Enter Branch Length in Pixels"};

    public abstract long Factorial(int n);

    public abstract long Fibonacci(int n);

    public abstract long Summation(int n);

    public abstract long Exponentiation(int x, int n);

    public abstract String Reverse(String str);

    public abstract boolean Palindrome(String str);

    public abstract int fromBinary(String n);

    public abstract String toBinary(int n);

    public abstract long GCD(int k, int j);

}
