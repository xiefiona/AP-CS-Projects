public class Recursive extends Operations{

    public long summation(int num) {
        if (num < 0) {
            return 0;
        }
        else {
            return num + summation(num - 1);
        }
    }
    public long exponentiation(int base, int power){
        if (power < 1){
            return 1;
        } else {
            return base * exponentiation(base, power - 1);
        }
    }
    public long fibonacci(int k){
        if (k <= 1){
            return k;
        } else {
            return fibonacci(k-1) + fibonacci(k-2);
        }
    }

    public boolean isEven(int num){
        return isOdd(num-1);
    }
    public boolean isOdd(int num){
        if (num == 1){
            return true;
        } else {
            return !isEven(num);
        }
    }

    public boolean palindrome(String string){
        if (string.length() == 0 || string.length() == 1){
            return true;
        } else if (string.charAt(0) == string.charAt(string.length()-1)) {
            return palindrome(string.substring(1,string.length()-1));
        }
        return false;
    }

    public String reverse(String string){
        if (string.length() <= 1 || string == null){
            return string;
        } else {
            return reverse(string.substring(1)) + string.charAt(0);
        }
    }
}
