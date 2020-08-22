package Poker;

import Domain.TrumpCard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Domain.TrumpCard.*;
import static Poker.PokerHandRanking.*;
import static org.junit.Assert.assertEquals;

public class PokersTest {

    @Test
    public void cardSortTest() {
        List<TrumpCard> beforehands = new ArrayList<TrumpCard>(List.of(SPADE5, HEART2, DIAMOND4, CLOVER3, HEARTA));
        List<TrumpCard> afterhands = List.of(HEARTA, HEART2, CLOVER3, DIAMOND4, SPADE5);

        Pokers.cardSort(beforehands);

        assertEquals(beforehands, afterhands);

    }

    @Test
    public void getHandRankingToRoyalFlushTest() {
        List<TrumpCard> hands = new ArrayList<TrumpCard>(List.of(SPADEA, SPADE10, SPADEJ, SPADEK, SPADEQ));

        Pokers.cardSort(hands);

        assertEquals(Pokers.getHandRanking(hands), ROYALFLUSH);
    }

    @Test
    public void getHandRankingToStraigthFlushTest() {
        List<TrumpCard> hands = new ArrayList<TrumpCard>(List.of(HEART4, HEART6, HEART7, HEART5, HEART8));

        Pokers.cardSort(hands);

        assertEquals(Pokers.getHandRanking(hands), STRAIGHTFLUSH);
    }

    @Test
    public void getHandRankingToFourOfAKindTest() {
        List<TrumpCard> hands = new ArrayList<TrumpCard>(List.of(SPADE3, HEART6, CLOVER3, HEART3, DIAMOND3));

        Pokers.cardSort(hands);

        assertEquals(Pokers.getHandRanking(hands), FOUROFAKIND);
    }

    @Test
    public void getHandRankingToFullHouseTest() {
        List<TrumpCard> hands = new ArrayList<TrumpCard>(List.of(CLOVER2, HEART7, CLOVER7, HEART2, DIAMOND7));

        Pokers.cardSort(hands);

        assertEquals(Pokers.getHandRanking(hands), FULLHOUSE);
    }

    @Test
    public void getHandRankingToFlushTest() {
        List<TrumpCard> hands = new ArrayList<TrumpCard>(List.of(CLOVER2, CLOVER7, CLOVERQ, CLOVERJ, CLOVER10));

        Pokers.cardSort(hands);

        assertEquals(Pokers.getHandRanking(hands), FLUSH);
    }

    @Test
    public void getHandRankingToStraightTest() {
        List<TrumpCard> hands = new ArrayList<TrumpCard>(List.of(CLOVER2, HEART5, DIAMOND3, CLOVERA, SPADE4));

        Pokers.cardSort(hands);

        assertEquals(Pokers.getHandRanking(hands), STRAIGHT);
    }
    @Test
    public void getHandRankingToThreeOfAKindTest() {
        List<TrumpCard> hands = new ArrayList<TrumpCard>(List.of(CLOVER8, HEART2, DIAMOND8, CLOVERQ, SPADE8));

        Pokers.cardSort(hands);

        assertEquals(Pokers.getHandRanking(hands), THREEOFAKIND);
    }

    @Test
    public void getHandRankingToTwoPairTest() {
        List<TrumpCard> hands = new ArrayList<TrumpCard>(List.of(CLOVERQ, HEARTK, DIAMOND3, CLOVERQ, SPADEK));

        Pokers.cardSort(hands);

        assertEquals(Pokers.getHandRanking(hands), TWOPAIR);
    }

    @Test
    public void getHandRankingToOnePairTest() {
        List<TrumpCard> hands = new ArrayList<TrumpCard>(List.of(DIAMONDK, HEART5, DIAMOND3, CLOVERK, SPADE4));

        Pokers.cardSort(hands);

        assertEquals(Pokers.getHandRanking(hands), ONEPAIR);
    }
}