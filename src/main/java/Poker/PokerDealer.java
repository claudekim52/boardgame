package Poker;

import Domain.CardDeck;
import Domain.TrumpCard;
import Domain.TrumpCards;

import java.util.ArrayList;
import java.util.List;

import static Domain.Status.ALIVE;

public class PokerDealer {

    private CardDeck<TrumpCard> trumpCardCardDeck;

    public PokerDealer() {
        this.trumpCardCardDeck = new CardDeck<>();
    }
    public void prepareCardDeck() {
        System.out.println("딜러가 트럼프카드를 준비합니다.");
        this.trumpCardCardDeck.setCardDeck(TrumpCards.getAllCardsWithoutJoker());
    }

    public void shuffleCardDeck() {
        System.out.println("딜러가 트럼프카드를 셔플합니다.");
        this.trumpCardCardDeck.shuffle();
    }

    public void receiveCard(TrumpCard card) {
        this.trumpCardCardDeck.add(card);
    }

    public TrumpCard draw() {
        return trumpCardCardDeck.draw();
    }


    public boolean decideGameIsEnd(List<PokerPlayer> pokerPlayers) {
        System.out.println("딜러가 무승부가 있는지 봅니다.");
        List<PokerPlayer> winners = new ArrayList<>();
        for(PokerPlayer pokerPlayer : pokerPlayers) {
            if(pokerPlayer.is(ALIVE)) {
                winners.add(pokerPlayer);
            }
        }

        if(winners.size() == 1) {
            PokerPlayer winner = winners.get(0);
            System.out.println(winner.getName() + "님의 우승");
            System.out.println("패 : " + Pokers.toStringHands(winner.getHands()));
            System.out.println("핸드랭킹 : " + Pokers.getHandRanking(winner.getHands()));

            return true;
        } else {
            for(PokerPlayer pokerPlayer : winners) {
                System.out.print(pokerPlayer.getName() + " ");
            }
            System.out.println("무승부 재경기를 합니다.");
            return false;
        }

    }
}
