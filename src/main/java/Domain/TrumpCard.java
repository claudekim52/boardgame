package Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrumpCard implements Card {
	
	SPADEA(Suit.SPADE, Rank.ACE),
	SPADE2(Suit.SPADE, Rank.TWO),
	SPADE3(Suit.SPADE, Rank.THREE),
	SPADE4(Suit.SPADE, Rank.FOUR),
	SPADE5(Suit.SPADE, Rank.FIVE),
	SPADE6(Suit.SPADE, Rank.SIX),
	SPADE7(Suit.SPADE, Rank.SEVEN),
	SPADE8(Suit.SPADE, Rank.EIGHT),
	SPADE9(Suit.SPADE, Rank.NINE),
	SPADE10(Suit.SPADE, Rank.TEN),
	SPADEJ(Suit.SPADE, Rank.JACK),
	SPADEQ(Suit.SPADE, Rank.QUEEN),
	SPADEK(Suit.SPADE, Rank.KING),
	
	CLOVERA(Suit.CLOVER, Rank.ACE),
	CLOVER2(Suit.CLOVER, Rank.TWO),
	CLOVER3(Suit.CLOVER, Rank.THREE),
	CLOVER4(Suit.CLOVER, Rank.FOUR),
	CLOVER5(Suit.CLOVER, Rank.FIVE),
	CLOVER6(Suit.CLOVER, Rank.SIX),
	CLOVER7(Suit.CLOVER, Rank.SEVEN),
	CLOVER8(Suit.CLOVER, Rank.EIGHT),
	CLOVER9(Suit.CLOVER, Rank.NINE),
	CLOVER10(Suit.CLOVER, Rank.TEN),
	CLOVERJ(Suit.CLOVER, Rank.JACK),
	CLOVERQ(Suit.CLOVER, Rank.QUEEN),
	CLOVERK(Suit.CLOVER, Rank.KING),
	
	HEARTA(Suit.HEART, Rank.ACE),
	HEART2(Suit.HEART, Rank.TWO),
	HEART3(Suit.HEART, Rank.THREE),
	HEART4(Suit.HEART, Rank.FOUR),
	HEART5(Suit.HEART, Rank.FIVE),
	HEART6(Suit.HEART, Rank.SIX),
	HEART7(Suit.HEART, Rank.SEVEN),
	HEART8(Suit.HEART, Rank.EIGHT),
	HEART9(Suit.HEART, Rank.NINE),
	HEART10(Suit.HEART, Rank.TEN),
	HEARTJ(Suit.HEART, Rank.JACK),
	HEARTQ(Suit.HEART, Rank.QUEEN),
	HEARTK(Suit.HEART, Rank.KING),
	
	DIAMONDA(Suit.DIAMOND, Rank.ACE),
	DIAMOND2(Suit.DIAMOND, Rank.TWO),
	DIAMOND3(Suit.DIAMOND, Rank.THREE),
	DIAMOND4(Suit.DIAMOND, Rank.FOUR),
	DIAMOND5(Suit.DIAMOND, Rank.FIVE),
	DIAMOND6(Suit.DIAMOND, Rank.SIX),
	DIAMOND7(Suit.DIAMOND, Rank.SEVEN),
	DIAMOND8(Suit.DIAMOND, Rank.EIGHT),
	DIAMONDT9(Suit.DIAMOND, Rank.NINE),
	DIAMOND10(Suit.DIAMOND, Rank.TEN),
	DIAMONDJ(Suit.DIAMOND, Rank.JACK),
	DIAMONDQ(Suit.DIAMOND, Rank.QUEEN),
	DIAMONDK(Suit.DIAMOND, Rank.KING),
	
	JOKER(Suit.JOKER, Rank.JOKER);

	public enum Suit {
		SPADE, CLOVER, HEART, DIAMOND, JOKER
	}

	public enum Rank  {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, JOKER

	}
	
	private final Suit suit;
	private final Rank rank;

	public boolean is(Suit suit) {
		return this.suit.equals(suit);
	}

	public boolean is(Rank rank) {
		return this.rank.equals(rank);
	}

}
