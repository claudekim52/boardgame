package Domain;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrumpCardsTest {
    @Test
    public void getAllCardsTest() {
        List<TrumpCard> getAllCards = TrumpCards.getAllCards();

        assertThat(getAllCards.size(), is(TrumpCard.values().length));
    }

    @Test
    public void getAllCardsWithoutJokerTest() {
        List<TrumpCard> getAllCardsWithoutJoker = TrumpCards.getAllCardsWithoutJoker();

        assertThat(getAllCardsWithoutJoker.size(), is(TrumpCard.values().length - 1));
        assertThat(getAllCardsWithoutJoker.contains(TrumpCard.JOKER), is(false));

    }
}