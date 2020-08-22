package Poker;

import lombok.Getter;

@Getter
public enum PokerHandRanking {

	ROYALFLUSH(1),
	STRAIGHTFLUSH(2),
	FOUROFAKIND(3),
	FULLHOUSE(4),
	FLUSH(5),
	STRAIGHT(6),
	THREEOFAKIND(7),
	TWOPAIR(8),
	ONEPAIR(9),	
	HIGHCARD(10);
	
	private final int tier;

	PokerHandRanking(int tier) {
		this.tier = tier;
	}

	public boolean is(PokerHandRanking pokerHandRanking) {
		return this.equals(pokerHandRanking);
	}
}
