import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardC2Test {

    @Test
    public void suitExceptionTest() {
        Throwable thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CardC2("12345");
        });
        Assertions.assertNotNull(thrown.getMessage());
    }

    @Test
    public void correctSuitTest() {
        Assertions.assertEquals(new CardC2("diamonds").getSuit(), "diamonds");
        Assertions.assertEquals(new CardC2("hearts").getSuit(), "hearts");
        Assertions.assertEquals(new CardC2(1,"spades").getSuit(), "spades");
        Assertions.assertEquals(new CardC2(9,"clubs").getSuit(), "clubs");
    }

    @Test
    public void maxRankTest() {
        Assertions.assertEquals(new CardC2(4,"clubs").getRank(), 4);
        Assertions.assertEquals(new CardC2("clubs").getRank(), 5);
        Assertions.assertEquals(new CardC2("diamonds").getRank(), 1);
        Assertions.assertEquals(new CardC2(7,"spades").getRank(), 7);
        Assertions.assertEquals(new CardC2("spades").getRank(), 8);
        Assertions.assertEquals(new CardC2("hearts").getRank(), 1);
    }
}