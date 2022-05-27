package comp1721.cwk2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import comp1721.cwk2.Card.Rank;


/**
 * A class to represent a pokerhand.
 *
 * <p>The intent is that this should form a pokerhand
 * which will be used in card game. It will be initialised and
 * the methods in it will be used after being initialised.</p>
 *
 * <p>Provided for use in COMP1721 Coursework 2.</p>
 *
 * @author Wanrong Xie
 */
public class PokerHand extends CardCollection{
	
	/**
	 * Creates a PokerHand object that 
	 * creates an empty hand.
	 *
	 */
	public PokerHand(){
		super();
	}
	/**
	 * Creates a PokerHand object.
	 *
	 * @param name Name of a pokerhand
	 *
	 */
	public PokerHand(String name) throws CardException{
		super();
        String[] parts = name.split(" ");
        if (parts.length <= 5){
        	 for (int i = 0; i < parts.length; i++) {
             	cards.add(new Card(parts[i]));
                 //System.out.println(parts[i]);
             }
        }else{
        	throw new CardException("A pokerhand contains at most 5 cards!\n");
        }
       
	}
	
	/**
	 * Creates a two-character form string representation of this pokerhand.
	 *
	 * <p>In every card of the pokerhand, the first character represents rank, 
	 * the second represents suit. Cards are separated by spaces.
	 * Special Unicode symbols will be used for the latter if
	 * <code>Card.fancySymbols</code> is set to <code>true</code>.</p>
	 *
	 * @return String representation of this pokerhand
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String str = "";
		if (cards.size()==0){
			return str;
		}
		else{
			for (int i=0; i<cards.size()-1; i++){
				str = cards.get(i).toString() + " ";
				sb.append(str);
			}
			sb.append(cards.get(cards.size()-1).toString());
			return sb.toString();
		}	
	}
	
	/**
	 * Discards all the cards from this pokerhand.
	 */
	@Override
	public void discard() throws CardException{
		// TODO Auto-generated method stub
		if(!super.isEmpty()){
			super.discard();
		}else{
			throw new CardException("The hand is empty now, it cannot be discarded.\n");
		}
		
	}
	
	/**
	 * Provides the number of cards in this pokerhand.
	 *
	 * @return Number of cards
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size();
	}
	
	/**
	 * Empties the hand of cards and 
	 * returns each of them to the specified deck.
	 *
	 * @param deck The deck object to receive the discarded pokerhand 
	 */
	public void discardTo(Deck deck){
		for (Card card: cards){
			deck.add(card);
		}
		this.discard();
	}
	
	/**
	 * Adds the given card to this pokerhand.
	 *
	 * @param card Card to be added
	 */
	@Override
	public void add(Card card) throws CardException{
		// TODO Auto-generated method stub
		if (this.size()<5 && this.size()>=0){
			for(Card iter: cards){
				if(iter.equals(card)){
					throw new CardException("You cannot add a duplicate card into the pokerhand.\n");
				}
			}
			super.add(card);
		}else{
			throw new CardException("The pokerhand is already full, you cannot add any card\n");
		}	
	}
	
	/**
	 * Sorts this pokerhand's cards In ascending order of rank.
	 */
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		Collections.sort(cards, new Comparator<Card>() {
	            public int compare(Card c1, Card c2) {               
	                return c1.getRank().compareTo(c2.getRank());
	            }
	    });

	}
	
	/**
	 * Predicate function to judge whether
	 * the poker hand is one pair or not
	 * 
	 * @return boolean result of the predicate
	 */
	public boolean isPair(){
		if (cards.size() == 5){
			Map<Rank, Integer> map = new HashMap<Rank, Integer>();
			int count1 = 0;
			int count2 = 0;
			for (Card item : cards) {
				if (map.containsKey(item.getRank())) {
					map.put(item.getRank(), map.get(item.getRank()).intValue() + 1);
				} else {
					map.put(item.getRank(), new Integer(1));
				}
			}
			for (Integer value : map.values()) {
				if(value == 2){
					count1++;
				}
				if(value == 3){
					count2++;
				}
			}
			if(count1 == 1 && count2 == 0){
				return true;
			}
			else{
				return false;
			}	
		}
		else{
			return false;
		}
		
	}
	
	/**
	 * Predicate function to judge whether
	 * the poker hand is two pairs or not
	 * 
	 * @return boolean result of the predicate
	 */
	public boolean isTwoPairs(){
		if (cards.size() == 5){
			Map<Rank, Integer> map = new HashMap<Rank, Integer>();
			int count = 0;
			for (Card item : cards) {
				if (map.containsKey(item.getRank())) {
					map.put(item.getRank(), map.get(item.getRank()).intValue() + 1);
				} else {
					map.put(item.getRank(), new Integer(1));
				}
			}
			for (Integer value : map.values()) {
				if(value == 2){
					count++;
				}
			}
			if(count == 2){
				return true;
			}
			else{
				return false;
			}	
		}else{
			return false;
		}
		
	}
	
	/**
	 * Predicate function to judge whether
	 * the poker hand is three of a kind or not
	 * 
	 * @return boolean result of the predicate
	 */
	public boolean isThreeOfAKind(){
		if (cards.size() == 5){
			Map<Rank, Integer> map = new HashMap<Rank, Integer>();
			int count1 = 0, count2 = 0;
			for (Card item : cards) {
				if (map.containsKey(item.getRank())) {
					map.put(item.getRank(), map.get(item.getRank()).intValue() + 1);
				} else {
					map.put(item.getRank(), new Integer(1));
				}
			}
			for (Integer value : map.values()) {
				if(value == 3){
					count1++;
				}
				if(value == 2){
					count2++;
				}
			}
			if(count1 == 1 && count2 == 0){
				return true;
			}
			else{
				return false;
			}	
		}else{
			return false;
		}
		
	}
	
	/**
	 * Predicate function to judge whether
	 * the poker hand is four of a kind or not
	 * 
	 * @return boolean result of the predicate
	 */
	public boolean isFourOfAKind(){
		if (cards.size() == 5){
			Map<Rank, Integer> map = new HashMap<Rank, Integer>();
			int count = 0;
			for (Card item : cards) {
				if (map.containsKey(item.getRank())) {
					map.put(item.getRank(), map.get(item.getRank()).intValue() + 1);
				} else {
					map.put(item.getRank(), new Integer(1));
				}
			}
			for (Integer value : map.values()) {
				if(value == 4){
					count++;
				}
			}
			if(count == 1){
				return true;
			}
			else{
				return false;
			}	
		}else{
			return false;
		}
		
	}
	
	/**
	 * Predicate function to judge whether
	 * the poker hand is full house or not
	 * 
	 * @return boolean result of the predicate
	 */
	public boolean isFullHouse(){
		if (cards.size() == 5){
			Map<Rank, Integer> map = new HashMap<Rank, Integer>();
			int count1 = 0, count2 = 0;
			for (Card item : cards) {
				if (map.containsKey(item.getRank())) {
					map.put(item.getRank(), map.get(item.getRank()).intValue() + 1);
				} else {
					map.put(item.getRank(), new Integer(1));
				}
			}
			for (Integer value : map.values()) {
				if(value == 3){
					count1++;
				}
				if(value == 2){
					count2++;
				}
			}
			if(count1 == 1 && count2 == 1){
				return true;
			}
			else{
				return false;
			}	
		}else{
			return false;
		}
		
	}

	/**
	 * Predicate function to judge whether
	 * the poker hand is straight or not
	 * 
	 * @return boolean result of the predicate
	 */
	public boolean isStraight(){
		if (cards.size() == 5){
			int count = 0;
			this.sort();
			for (int i=0; i<cards.size()-1; i++){
				if (cards.get(i).getRank().ordinal() 
				== cards.get(i+1).getRank().ordinal() -1){
					count++;
				}
			}
			if(count == 4){
				return true;
			}
			if (count == 3 && 
				cards.get(0).getRank().ordinal() 
				== cards.get(1).getRank().ordinal() -9){
				return true;
			}
			else{
				return false;
			}	
		}else{
			return false;
		}
			
	}
	
	/**
	 * Predicate function to judge whether
	 * the poker hand is flush or not
	 * 
	 * @return boolean result of the predicate
	 */
	public boolean isFlush(){
		if (cards.size() == 5){
			for (int i=0; i<cards.size()-1; i++){
				if(cards.get(i).getSuit() != cards.get(i+1).getSuit()){
					return false;
				}
			}
			return true;
		}else{
			return false;
		}
		
		
	}

}
