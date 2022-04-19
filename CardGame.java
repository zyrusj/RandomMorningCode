package practice;

import java.util.ArrayList;
import java.util.Arrays;

/*Given a deck of cards of X suits and Y ranks (e.g. normal decks have 4 suits and 13 ranks), 
 *How do you find the highest (if any) five straight flush (i.e., five cards of the same suit) 
 *with contiguous/consecutive numbers)?
 *For this example only numbers will be passed in so don't worry about Rank
 *In case of tie, either is fine
 *Assume the ranks are already sorted
 */

class CardGame {
	
	static final int NUM_SUITS = 4;
	static final int MAX_RANK = 10;
	static final int NUM_CARDS_IN_STRAIGHT = 5;

	static class Card {
		public Card(int suit, int rank) {
			this.suit = suit;
			this.rank = rank;
			
		}
		int suit; // eg. 0-3
		int rank; // eg. 0-13
		
		public String toString() {
			return "S" + Integer.toString(suit) + "R" + Integer.toString(rank);
		}
	}	
	private static ArrayList<Card> sortDeck(ArrayList<Card> deck) {
		deck.sort((a,b) -> {
		      int cmp = Integer.compare(a.suit,b.suit);
		      if(cmp != 0) return cmp;
		      return Integer.compare(a.rank, b.rank);
		      });
		
		return deck;
	}
	
	public static void  findHighFlush(ArrayList<Card> deck) {
		sortDeck(deck);
		int highestFlush = 0;
		int flushSuit = 0;
		int contig = 0;
		for(int i = deck.size()-1; i > 0; i--) {
			if ((deck.get(i).suit == deck.get(i-1).suit) && (deck.get(i).rank - deck.get(i-1).rank == 1) ) {
				contig++;
				if (contig == NUM_CARDS_IN_STRAIGHT && (deck.get(i).rank + NUM_CARDS_IN_STRAIGHT) > highestFlush) {
					highestFlush = deck.get(i).rank + NUM_CARDS_IN_STRAIGHT;
					flushSuit =  deck.get(i).suit;
				}
			}
		}
		if (highestFlush == 0) {
			System.out.println("No flushes");
		} else {
			for (int x = highestFlush - NUM_CARDS_IN_STRAIGHT; x < highestFlush; x ++) {
				System.out.print(new Card(flushSuit, x) + ", ");
			}
		}
	}
	
	private static ArrayList<Card> buildDeck(Card ... cards) {
        return new ArrayList<>(Arrays.asList(cards));
	}
	
	public static void main(String[] args) {
		findHighFlush(buildDeck(new Card(1,2), new Card(1,1), new Card(1,3), new Card(1,4), new Card(1,5), new Card(1,6), new Card(1,7), new Card(2,1), new Card(3,1), new Card(0,1)));
	}
	
	
}
