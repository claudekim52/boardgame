package Poker;

import Domain.TrumpCard;

import java.util.*;

import static Domain.TrumpCard.Rank;
import static Domain.TrumpCard.Rank.*;
import static Domain.TrumpCard.Suit.*;
import static Poker.PokerHandRanking.*;

public class Pokers {

    private Pokers() {
        throw new AssertionError();
    }

    public static PokerHandRanking getHandRanking(List<TrumpCard> sortedHands) {
        if(isFlush(sortedHands) && isTENJQKACE(sortedHands)) return ROYALFLUSH;
        if(isFlush(sortedHands) && isStraight(sortedHands)) return STRAIGHTFLUSH;
        if(isFourOfAKind(sortedHands)) return FOUROFAKIND;
        if(isFullHouse(sortedHands)) return FULLHOUSE;
        if(isFlush(sortedHands)) return FLUSH;
        if(isStraight(sortedHands)) return STRAIGHT;
        if(isThreeOfAKind(sortedHands)) return THREEOFAKIND;
        if(isTwoPair(sortedHands)) return TWOPAIR;
        if(isOnePair(sortedHands)) return ONEPAIR;
        return HIGHCARD;
    }

    public static void cardSort(List<TrumpCard> hands) {
        Map<Rank, Integer> rankToAmountMap = new HashMap<>();
        for(TrumpCard trumpCard : hands) {
            rankToAmountMap.put(trumpCard.getRank(), rankToAmountMap.getOrDefault(trumpCard.getRank(), 0) + 1);
        }

        Collections.sort(hands, new Comparator<TrumpCard>() {
            @Override
            public int compare(TrumpCard o1, TrumpCard o2) {
                if(rankToAmountMap.get(o1.getRank()) != rankToAmountMap.get(o2.getRank()))
                    return rankToAmountMap.get(o1.getRank()) - rankToAmountMap.get(o2.getRank());

                return getRankPower(o1.getRank()) - getRankPower(o2.getRank());

            }
        });

        if(hands.get(0).getRank() == TWO && hands.get(1).getRank() == THREE && hands.get(2).getRank() == FOUR
                && hands.get(3).getRank() == FIVE && hands.get(4).getRank() == ACE) {
            hands.add(0, hands.remove(4));
        }
    }

    public static boolean isWeaker(List<TrumpCard> sortedMyHands, List<TrumpCard> sortedOtherHands) {
        PokerHandRanking myHandRanking = getHandRanking(sortedMyHands);
        PokerHandRanking otherHandRanking = getHandRanking(sortedOtherHands);

        if(myHandRanking.getTier() > otherHandRanking.getTier()) return true;
        if(myHandRanking.getTier() < otherHandRanking.getTier()) return false;

        for(int idx = 4; idx >= 0; idx--) {
            if(getRankPower(sortedMyHands.get(idx).getRank()) < getRankPower(sortedOtherHands.get(idx).getRank())) return true;
        }

        return false;
    }

    public static String toStringHands(List<TrumpCard> sortedHands) {

        StringBuilder sb = new StringBuilder();
        sb.append(sortedHands.get(0) + " " + sortedHands.get(1) + " " + sortedHands.get(2) + " " + sortedHands.get(3) + " " + sortedHands.get(4));

        return sb.toString();
    }

    private static boolean isOnePair(List<TrumpCard> sortedHands) {
        return sortedHands.get(3).getRank() == sortedHands.get(4).getRank();
    }

    private static boolean isTwoPair(List<TrumpCard> sortedHands) {
        return sortedHands.get(1).getRank() == sortedHands.get(2).getRank() && sortedHands.get(3).getRank() == sortedHands.get(4).getRank();
    }

    private static boolean isThreeOfAKind(List<TrumpCard> sortedHands) {
        return sortedHands.get(2).getRank() == sortedHands.get(3).getRank() && sortedHands.get(3).getRank() == sortedHands.get(4).getRank();
    }

    private static boolean isFullHouse(List<TrumpCard> sortedHands) {
        return (sortedHands.get(0).getRank() == sortedHands.get(1).getRank())
                && (sortedHands.get(2).getRank() == sortedHands.get(3).getRank() && sortedHands.get(3).getRank() == sortedHands.get(4).getRank());
    }

    private static boolean isFourOfAKind(List<TrumpCard> sortedHands) {

        return (sortedHands.get(1).getRank() == sortedHands.get(2).getRank() && sortedHands.get(2).getRank() == sortedHands.get(3).getRank()
                && sortedHands.get(3).getRank() == sortedHands.get(4).getRank());
    }

    private static boolean isFlush(List<TrumpCard> sortedHands) {
        return (sortedHands.get(0).is(SPADE) && sortedHands.get(1).is(SPADE) && sortedHands.get(2).is(SPADE) && sortedHands.get(3).is(SPADE) && sortedHands.get(4).is(SPADE))
                || (sortedHands.get(0).is(CLOVER) && sortedHands.get(1).is(CLOVER) && sortedHands.get(2).is(CLOVER) && sortedHands.get(3).is(CLOVER) && sortedHands.get(4).is(CLOVER))
                || (sortedHands.get(0).is(HEART) && sortedHands.get(1).is(HEART) && sortedHands.get(2).is(HEART) && sortedHands.get(3).is(HEART) && sortedHands.get(4).is(HEART))
                || (sortedHands.get(0).is(DIAMOND) && sortedHands.get(1).is(DIAMOND) && sortedHands.get(2).is(DIAMOND) && sortedHands.get(3).is(DIAMOND) && sortedHands.get(4).is(DIAMOND));
    }

    private static boolean isStraight(List<TrumpCard> sortedHands) {
        return (sortedHands.get(0).is(ACE) && sortedHands.get(1).is(TWO) && sortedHands.get(2).is(THREE) && sortedHands.get(3).is(FOUR) && sortedHands.get(4).is(FIVE))
                || (sortedHands.get(0).is(TWO) && sortedHands.get(1).is(THREE) && sortedHands.get(2).is(FOUR) && sortedHands.get(3).is(FIVE) && sortedHands.get(4).is(SIX))
                || (sortedHands.get(0).is(THREE) && sortedHands.get(1).is(FOUR) && sortedHands.get(2).is(FIVE) && sortedHands.get(3).is(SIX) && sortedHands.get(4).is(SEVEN))
                || (sortedHands.get(0).is(FOUR) && sortedHands.get(1).is(FIVE) && sortedHands.get(2).is(SIX) && sortedHands.get(3).is(SEVEN) && sortedHands.get(4).is(EIGHT))
                || (sortedHands.get(0).is(FIVE) && sortedHands.get(1).is(SIX) && sortedHands.get(2).is(SEVEN) && sortedHands.get(3).is(EIGHT) && sortedHands.get(4).is(NINE))
                || (sortedHands.get(0).is(SIX) && sortedHands.get(1).is(SEVEN) && sortedHands.get(2).is(EIGHT) && sortedHands.get(3).is(NINE) && sortedHands.get(4).is(TEN))
                || (sortedHands.get(0).is(SEVEN) && sortedHands.get(1).is(EIGHT) && sortedHands.get(2).is(NINE) && sortedHands.get(3).is(TEN) && sortedHands.get(4).is(JACK))
                || (sortedHands.get(0).is(EIGHT) && sortedHands.get(1).is(NINE) && sortedHands.get(2).is(TEN) && sortedHands.get(3).is(JACK) && sortedHands.get(4).is(QUEEN))
                || (sortedHands.get(0).is(NINE) && sortedHands.get(1).is(TEN) && sortedHands.get(2).is(JACK) && sortedHands.get(3).is(QUEEN) && sortedHands.get(4).is(KING))
                || (sortedHands.get(0).is(TEN) && sortedHands.get(1).is(JACK) && sortedHands.get(2).is(QUEEN) && sortedHands.get(3).is(KING) && sortedHands.get(4).is(ACE));

    }

    private static boolean isTENJQKACE(List<TrumpCard> sortedHands) {
        return sortedHands.get(0).is(TEN) && sortedHands.get(1).is(JACK) && sortedHands.get(2).is(QUEEN)
                && sortedHands.get(3).is(KING) && sortedHands.get(4).is(ACE);
    }

    private static int getRankPower(Rank rank) {
        if(rank == ACE) return 13;
        if(rank == TWO) return 1;
        if(rank == THREE) return 2;
        if(rank == FOUR) return 3;
        if(rank == FIVE) return 4;
        if(rank == SIX) return 5;
        if(rank == SEVEN) return 6;
        if(rank == EIGHT) return 7;
        if(rank == NINE) return 8;
        if(rank == TEN) return 9;
        if(rank == JACK) return 10;
        if(rank == QUEEN) return 11;
        if(rank == KING) return 12;
        return 0;
    }

}
