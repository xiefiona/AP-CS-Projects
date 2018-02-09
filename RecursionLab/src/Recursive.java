public class Recursive {

    public static long summation(int num) {
        if (num < 0) {
            return 0;
        }
        else {
            return num + summation(num - 1);
        }
    }

    public static long exponentiation(int base, int power){
        if (power < 1){
            return 1;
        } else {
            return base * exponentiation(base, power - 1);
        }
    }

    public static long fibonacci(int k){
        if (k < 1){
            return 0;
        } else {
            return k;
        }
    }

    public static boolean isEven(int num){
        return true;
    }

    public static boolean isOdd(int num){
        return true;
    }

    public static boolean palindrome(String string){
        return true;
    }

    public static String reverse(String string){
        return "";
    }
}
