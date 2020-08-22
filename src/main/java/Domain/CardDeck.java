package Domain;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CardDeck<T extends Card> {
	
	private Stack<T> deck;

	public CardDeck() {
		this.deck = new Stack<T>();
	}
	
	public Stack<T> setCardDeck(List<T> cards) {		
		for(T t : cards) {
			this.deck.add(t);
		}
		return this.deck;
	}
	
	public Stack<T> shuffle() {
		Collections.shuffle(deck);
		return this.deck;
	}
	
	public T draw() {
		return this.deck.pop();
	}

	public void add(T card) {
		this.deck.push(card);
	}
}
