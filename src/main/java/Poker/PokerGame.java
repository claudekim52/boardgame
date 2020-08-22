package Poker;

import Domain.Game;

import java.util.ArrayList;
import java.util.List;

import static Domain.Status.*;

public class PokerGame extends Game {

    private PokerDealer pokerDealer;
    private List<PokerPlayer> pokerPlayers;

    public PokerGame() {
        this.pokerDealer = new PokerDealer();
        this.pokerPlayers = new ArrayList<>();
    }

    @Override
    public boolean join(String name) {
        System.out.println(name + "님이 포커게임에 참가하셨습니다.");
        return this.pokerPlayers.add(new PokerPlayer(name));
    }

    @Override
    public boolean leave(String name) {
        for(PokerPlayer pokerPlayer  : pokerPlayers) {
            if(pokerPlayer.getName().equals(name)) {
                System.out.println(name + "님이 포커게임을 떠났습니다.");
                pokerPlayers.remove(pokerPlayer);
                return true;
            }
        }
        return false;
    }

    @Override
    protected void initializeGame() {
        System.out.println("************************    ");
        System.out.println("    포커 게임을 시작합니다.       ");
        System.out.println("************************    ");
        pokerDealer.prepareCardDeck();
        pokerDealer.shuffleCardDeck();

        System.out.println("딜러가 플레이어들에게 카드를 5장씩 나눠줍니다.");
        for(int n = 0; n < 5; n++) {
            for(PokerPlayer pokerPlayer : pokerPlayers) {
                pokerPlayer.receiveCard(pokerDealer.draw());
            }
        }

    }

    @Override
    protected void winOrLose() {
        System.out.println("게임 승패를 가립니다.");

        for(PokerPlayer pokerPlayer : pokerPlayers) {
            if(!pokerPlayer.is(DEAD))
                pokerPlayer.showHands(pokerPlayers);
        }

        for(PokerPlayer pokerPlayer : pokerPlayers) {
            if(pokerPlayer.is(TODEAD))
                pokerPlayer.die();
        }

    }

    @Override
    protected boolean isEnd() {
        System.out.println("게임을 계속 해야하는지 결정합니다..");

        return pokerDealer.decideGameIsEnd(pokerPlayers);
    }

    @Override
    protected void reInitailizeGame() {

        for(PokerPlayer pokerPlayer : pokerPlayers) {
            if(pokerPlayer.hasCard()) {
                pokerDealer.receiveCard(pokerPlayer.draw());
                pokerDealer.receiveCard(pokerPlayer.draw());
                pokerDealer.receiveCard(pokerPlayer.draw());
                pokerDealer.receiveCard(pokerPlayer.draw());
                pokerDealer.receiveCard(pokerPlayer.draw());
            }
        }

        pokerDealer.shuffleCardDeck();

        for(int n = 0; n < 5; n++) {
            for(PokerPlayer pokerPlayer : pokerPlayers) {
                if(pokerPlayer.is(ALIVE)) pokerPlayer.receiveCard(pokerDealer.draw());
            }
        }


    }
}
