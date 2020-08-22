package Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Domain.TrumpCard.JOKER;

public class TrumpCards {

	private TrumpCards() {
		throw new AssertionError();
	}
	
	public static List<TrumpCard> getAllCards() {
		return Arrays.asList(TrumpCard.values());
	}
	
	public static List<TrumpCard> getAllCardsWithoutJoker() {
		List<TrumpCard> trumpCardList = new ArrayList<>();
		for(TrumpCard trumpCard : TrumpCard.values()) {
			if(!trumpCard.equals(JOKER)) trumpCardList.add(trumpCard);
		}
		return trumpCardList;
	}

}
