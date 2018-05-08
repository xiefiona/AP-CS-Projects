package Activity2;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] rank1 = {"Jack", "Queen", "King"};
		String[] suit1 = {"Spades", "Spades", "Diamonds"};
		int[] value1 = {11, 12, 13};
		Deck deck1 = new Deck(rank1, suit1, value1);
		System.out.println("Size of first deck: " + deck1.size());
		System.out.println("Is the first deck empty:  " + deck1.isEmpty());
		String[] rank2 = {"3", "4", "King"};
		String[] suit2 = {"Hearts", "Hearts", "Clubs"};
		int[] value2 = {3, 4, 13};
		Deck deck2 = new Deck(rank2, suit2, value2);
		System.out.println("Size of second deck: " + deck2.size());
		System.out.println("Is the second deck empty:  " + deck2.isEmpty());
		String[] rank3 = {"Queen", "5", "7"};
		String[] suit3 = {"Hearts", "Clubs", "Diamonds"};
		int[] value3 = {12, 5, 7};
		Deck deck3 = new Deck(rank3, suit3, value3);
		System.out.println("Deck3 dealt card is: " + deck3.deal());

		System.out.println("if deck 1 is empty: " + deck1.isEmpty());
		System.out.println("new card: " + deck1.deal().toString());
	}
}
