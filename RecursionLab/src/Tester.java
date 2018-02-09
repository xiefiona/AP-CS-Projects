import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

public class Tester {
    public static void main(String[] args){
        System.out.println(Iterative.summation(5));
        System.out.println(Recursive.summation(5));
        System.out.println(Iterative.exponentiation(2,5));
        System.out.println(Recursive.exponentiation(2,5));
        System.out.println(Iterative.fibonacci(5));
        System.out.println(Recursive.fibonacci(5));

        /*
        System.out.println(Iterative.isEven(4));
        System.out.println(Iterative.isOdd(4));
        System.out.println(Iterative.palindrome("racecar"));
        System.out.println(Iterative.reverse("hello"));
        */
    }
}
