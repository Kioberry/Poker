package comp1721.cwk2;

import java.util.Collections;

import comp1721.cwk2.Card.Rank;
import comp1721.cwk2.Card.Suit;

/**
 * A class to represent a deck cards.
 *
 * <p>The intent is that this should form the basis for new classes
 * useful in card games.  It isn't meant to be instantiated itself and
 * is therefore declared as abstract.</p>
 *
 * <p>Provided for use in COMP1721 Coursework 2.</p>
 *
 * @author Nick Efford
 */
// Implement Deck class here
public class Deck extends CardCollection{

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
//		for (Card card: cards){
//			System.out.println(card.fullName());
//		}
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size();
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return super.isEmpty();
	}
	@Override
	public boolean contains(Card card) {
		// TODO Auto-generated method stub
		return super.contains(card);
	}
	@Override
	public void discard() {
		// TODO Auto-generated method stub
		super.discard();
	}
	public void shuffle() {
		// TODO Auto-generated method stub
		 Collections.shuffle(cards);
	}
	public Card deal() {
		// TODO Auto-generated method stub
		Card card = new Card(cards.get(0).getRank(), cards.get(0).getSuit());
		cards.remove(0);
		return card;
	}
	
}
