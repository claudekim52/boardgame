
import Domain.Game;
import Poker.PokerGame;

public class Application {
    public static void main(String[] args) {
        Game pokerGame = new PokerGame();
        pokerGame.join("mike");
        pokerGame.join("john");
        pokerGame.join("jane");

        pokerGame.play();
    }
}
