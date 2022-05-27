package comp1721.cwk2;

import java.util.Collections;

import comp1721.cwk2.Card.Rank;
import comp1721.cwk2.Card.Suit;

/**
 * A class to represent a deck of cards.
 *
 * <p>The intent is that this should form a deck of cards
 * which will be used in card game. It will be initialised and
 * the methods in it will be used after being initialised.</p>
 *
 * <p>Provided for use in COMP1721 Coursework 2.</p>
 *
 * @author Wanrong Xie
 */
// Implement Deck class here
public class Deck extends CardCollection{

    /**
	 * Creates a Deck object that containing 
	 * the standard 52 playing cards, 
	 * arranged by suits and then in rank order.
	 *
	 */
	public Deck(){
		super();
		Rank[] ranks=new Rank[]{Rank.ACE, Rank.TWO, Rank.THREE, Rank.FOUR,
				Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN,
				Rank.JACK, Rank.QUEEN, Rank.KING};
		Suit[] suits=new Suit[]{Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS,
				Suit.SPADES};
		for (int i=0; i<ranks.length; i++){
			for (int j=0; j<suits.length; j++){
				cards.add(new Card(ranks[i], suits[j]));
			}
		}
	}
	
    /**
	 * Provides the number of cards in this deck.
	 *
	 * @return Number of cards
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size();
	}
	
	/**
	 * Indicates whether this deck is empty or not.
	 *
	 * @return true if deck is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return super.isEmpty();
	}
	
	/**
	 * Indicates whether a particular card is present in this deck.
	 *
	 * @param card Card we are looking for
	 * @return true if the card is present, false otherwise
	 */
	@Override
	public boolean contains(Card card) {
		// TODO Auto-generated method stub
		return super.contains(card);
	}
	
	/**
	 * Discards all the cards from this deck.
	 */
	@Override
	public void discard() {
		// TODO Auto-generated method stub
		super.discard();
	}
	
	/**
	 * Rearranges cards in the deck randomly.
	 */
	public void shuffle() {
		// TODO Auto-generated method stub
		 Collections.shuffle(cards);
	}
	
	/**
	 * Removes the first card in the deck and returns it.
	 * 
	 * @return the card object that has been removed
	 */
	public Card deal() {
		// TODO Auto-generated method stub
		Card card = new Card(cards.get(0).getRank(), cards.get(0).getSuit());
		cards.remove(0);
		return card;
	}
	
}
