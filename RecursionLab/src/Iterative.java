public class Iterative {

    public static long summation(int num){
        long sum = 0;
        for (int i = num; i > 0; i--){
            sum += i;
        }
        return sum;
    }
    public static long exponentiation(int base, int power){
        long exponential = 1;
        for (int i = 0; i < power; i++){
            exponential *= base;
        }

        if (power == 0){
            return 1;
        }

        return exponential;
    }
    public static long fibonacci(int k){
        int low = 0;
        int high = 1;
        int sum;
        for (int i = 0; i < k; i++) {
            sum = low + high;
            low = high;
            high = sum;
        }
        return low;
    }

    public static boolean isEven(int num){
        if (num % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
    public static boolean isOdd(int num){
        if (num % 2 == 1){
            return true;
        } else {
            return false;
        }
    }

    public static boolean palindrome(String string){
        boolean ans = true;
        String[] splitArr = string.split("");
        for (int i = 0; i < string.length(); i++){
            if (splitArr[i].equals(splitArr[string.length() - 1 - i])){

            } else {
                ans = false;
            }
        }
        return ans;
    }
    public static String reverse(String string){
        String[] splitArr = string.split("");
        String reverseWord = "";
        for (int i = string.length() - 1; i >= 0; i--){
            reverseWord += splitArr[i];
        }
        return reverseWord;
    }
}
