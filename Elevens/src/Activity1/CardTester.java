package Activity1;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card c1 = new Card("1","Diamonds",1);
		Card c2 = new Card("2","Clubs",2);
		Card c3 = new Card("3","Spades",3);

		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());

		System.out.println("if 1 of diamonds matches 2 of clubs: " + c1.matches(c2));
	}
}
