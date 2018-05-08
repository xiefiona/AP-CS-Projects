public class Iterative extends Operations {

    public long Factorial(int n) {
        long fact = 1;
        for (int i = n; i > 1; i--) {
            fact = fact * i;
        }
        return fact;
    }

    public long Fibonacci(int n) {
        int a = 0, b = 1, c = 1;
        for (int i = 0; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return a;
    }

    public long Summation(int n) {
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public long Exponentiation(int x, int n) {
        long k = x;
        for (int i = 0; i < n - 1; i++) {
            k *= x;
        }
        return (n == 0) ? 1 : k;
    }

    public String Reverse(String str) {
        String Out = "";
        for (int i = str.length(); i > 0; i--) {
            Out += str.substring(i - 1, i);
        }
        return Out;
    }
    public boolean Palindrome(String str) {
        int s = 0, e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public String toBinary(int n) {
        String strB = "";
        while (n > 0) {
            strB = ((n % 2) == 0 ? "0" : "1") + strB;
            n /= 2;
        }
        return strB;
    }

    public int fromBinary(String n) {
        int sum = 0;
        for (int i = n.length() - 1; i >= 0; i--) {
            if (n.charAt(i) == '1') {
                sum += Math.pow(2, n.length() - i - 1);
            }
        }
        return sum;
    }

    public long GCD(int k, int j) {
        while (k != 0 && j !=0) {
            int l = j;
            j = k % j;
            k = l;
        }
        return k + j;
    }

}
