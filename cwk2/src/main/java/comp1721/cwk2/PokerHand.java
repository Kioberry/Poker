package comp1721.cwk2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import comp1721.cwk2.Card.Rank;

public class PokerHand extends CardCollection{
	public PokerHand(){
		super();
	}
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
	@Override
	public void discard() throws CardException{
		// TODO Auto-generated method stub
		if(!super.isEmpty()){
			super.discard();
		}else{
			throw new CardException("The hand is empty now, it cannot be discarded.\n");
		}
		
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size();
	}
	public void discardTo(Deck deck){
		for (Card card: cards){
			deck.add(card);
		}
		this.discard();
	}
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
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		Collections.sort(cards, new Comparator<Card>() {
	            public int compare(Card c1, Card c2) {               
	                return c1.getRank().compareTo(c2.getRank());
	            }
	    });

	}
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
