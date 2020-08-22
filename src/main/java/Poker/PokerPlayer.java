package Poker;

import Domain.Status;
import Domain.TrumpCard;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static Domain.Status.*;

@Getter
public class PokerPlayer {
    private String name;
    private List<TrumpCard> hands;
    private Status status;

    public PokerPlayer(String name) {
        this.name = name;
        this.hands = new ArrayList<>();
        this.status = ALIVE;
    }

    public void receiveCard(TrumpCard card) {
        hands.add(card);
        if(hands.size() == 5) Pokers.cardSort(hands);
    }

    public TrumpCard draw() {
        return hands.remove(0);
    }

    public void showHands(List<PokerPlayer> pokerPlayers) {
        System.out.println(name + "님의 패 : " + Pokers.toStringHands(hands));
        System.out.println(name + "님의 핸드랭킹 : " + Pokers.getHandRanking(hands));

        for(PokerPlayer pokerPlayer : pokerPlayers) {
            pokerPlayer.compareWith(hands);
        }

    }

    public void compareWith(List<TrumpCard> otherHands) {
        if(Pokers.isWeaker(this.hands, otherHands)) this.status = TODEAD;
    }

    public boolean is(Status status) {
        return this.status == status;
    }

    public void die() {
        System.out.println(name + "님이 죽습니다.");
        status = DEAD;
    }

    public boolean hasCard() {
        return hands.size() != 0;
    }
}
