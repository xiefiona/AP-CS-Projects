package Activity4;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"blue", "red"};
		int[] pointValues = {11, 12, 13};
		Deck d = new Deck(ranks, suits, pointValues);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		String[] fRanks = new String[52];
		String[] fSuits = new String[52];
		int[] fPointValues = new int[52];
		for (int i = 0; i < 52; i++) {
			String rank, suit;
			if ((i+1) % 13 == 11 ) {
				rank = "Jack";
			}
			else if ((i+1) % 13 == 12) {
				rank = "Queen";
			}
			else if ((i+1) % 13 == 0) {
				rank = "King";
			}
			else if ( (i+1) % 13 == 1) {
				rank = "Ace";
			}
			else {
				rank = Integer.toString((i + 1) % 13);
			}
			if (i < 13) {
				suit = "Hearts";
			}
           else if (i < 26) {
				suit = "Diamonds";
			}
			else if (i < 39) {
				suit = "Clubs";
			}
			else {
				suit = "Spades";
			}
			fRanks[i] = rank;
			fSuits[i] = suit;
			fPointValues[i] = ((i+1) % 13);
		}
		Deck full = new Deck(fRanks, fSuits, fPointValues);
		System.out.println(full);
	}
}
