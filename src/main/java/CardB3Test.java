import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardB3Test {

    @Test
    public void toStringTest() {
        assertEquals(new CardB3(14,"diamonds").toString(), "diamonds Joker");
        assertEquals(new CardB3(8,"clubs").toString(), "clubs 8");
        assertEquals(new CardB3(12,"hearts").toString(), "hearts Queen");
    }

    @Test
    public void validatorTest() {
        assertFalse(new CardB3(0, "diamonds").validate());
        assertFalse(new CardB3(14, "hearts").validate());
        assertTrue(new CardB3(1,"clubs").validate());
        assertTrue(new CardB3(14, "diamonds").validate());
        assertTrue(new CardB3(9,"spades").validate());
    }

    @Test
    public void isHigherTest(){
        assertTrue(new CardB3(14,"diamonds").isHigher(new CardB3(8, "hearts")));
        assertTrue(new CardB3(14,"clubs").isHigher(new CardB3(8, "spades")));
        assertTrue(new CardB3(10,"hearts").isHigher(new CardB3(8, "hearts")));
        assertFalse(new CardB3(13,"hearts").isHigher(new CardB3(13, "diamonds")));
        assertFalse(new CardB3(8,"spades").isHigher(new CardB3(8, "clubs")));
        assertFalse(new CardB3(8,"spades").isHigher(new CardB3(11, "spades")));
    }

    @Test
    public void compareTest(){
        assertTrue(new CardB3(8,"spades").compareTo(new CardB3(8, "clubs")) > 0);
        assertTrue(new CardB3(8,"hearts").compareTo(new CardB3(8, "diamonds")) > 0);
        assertTrue(new CardB3(14,"diamonds").compareTo(new CardB3(8, "hearts")) > 0);
        assertTrue(new CardB3(14,"clubs").compareTo(new CardB3(8, "spades")) > 0);
        assertTrue(new CardB3(13,"hearts").compareTo(new CardB3(13, "diamonds")) > 0);
        assertTrue(new CardB3(8,"spades").compareTo(new CardB3(11, "spades")) < 0);
        assertEquals(new CardB3(8,"spades").compareTo(new CardB3(8,"spades")), 0);
        assertTrue(CardB3.compare(new CardB3(8, "spades"), new CardB3(9, "clubs")) < 0);
    }

    @Test
    public void  equalsTest(){
        assertTrue(new CardB3(12, "hearts").equals(new CardB3(12, "hearts")));
        assertFalse(new CardB3(8, "hearts").equals(new CardB3(12, "hearts")));
    }

}
