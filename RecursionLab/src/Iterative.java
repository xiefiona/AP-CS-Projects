public class Iterative extends Operations{

    public long summation(int num){
        long sum = 0;
        for (int i = num; i > 0; i--){
            sum += i;
        }
        return sum;
    }
    public long exponentiation(int base, int power){
        long exponential = 1;
        for (int i = 0; i < power; i++){
            exponential *= base;
        }

        if (power == 0){
            return 1;
        }

        return exponential;
    }
    public long fibonacci(int k){
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

    public boolean isEven(int num){
        if (num % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
    public boolean isOdd(int num){
        if (num % 2 == 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean palindrome(String string){
        String newString = string.replaceAll(" ", "").toLowerCase();
        int start = 0;
        int end = newString.length() -1;
        while (start < end){
            if (newString.charAt(start) != newString.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public String reverse(String string){
        String reverseWord = "";
        for (int i = string.length() - 1; i >= 0; i--){
            reverseWord += string.charAt(i);
        }
        return reverseWord;
    }
}
