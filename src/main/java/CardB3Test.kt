import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CardB3Test {
    @Test
    fun toStringTest() {
        Assertions.assertEquals(CardB3(14, "diamonds").toString(), "diamonds Joker")
        Assertions.assertEquals(CardB3(8, "clubs").toString(), "clubs 8")
        Assertions.assertEquals(CardB3(12, "hearts").toString(), "hearts Queen")
    }

    @Test
    fun validatorTest() {
        Assertions.assertFalse(CardB3(0, "diamonds").validate())
        Assertions.assertFalse(CardB3(14, "diamonds").validate())
        Assertions.assertTrue(CardB3(1, "clubs").validate())
        Assertions.assertTrue(CardB3(14, "hearts").validate())
        Assertions.assertTrue(CardB3(9, "spades").validate())
    }

    @Test
    fun isHigherTest() {
        Assertions.assertTrue(CardB3(14, "hearts").isHigher(CardB3(8, "diamonds")))
        Assertions.assertTrue(CardB3(14, "spades").isHigher(CardB3(8, "clubs")))
        Assertions.assertTrue(CardB3(10, "hearts").isHigher(CardB3(8, "hearts")))
        Assertions.assertFalse(CardB3(13, "hearts").isHigher(CardB3(13, "diamonds")))
        Assertions.assertFalse(CardB3(8, "spades").isHigher(CardB3(8, "clubs")))
        Assertions.assertFalse(CardB3(8, "spades").isHigher(CardB3(11, "spades")))
    }

    @Test
    fun compareTest() {
        Assertions.assertTrue(CardB3(8, "spades").compareTo(CardB3(8, "clubs")) > 0)
        Assertions.assertTrue(CardB3(8, "hearts").compareTo(CardB3(8, "diamonds")) > 0)
        Assertions.assertTrue(CardB3(14, "diamonds").compareTo(CardB3(8, "hearts")) > 0)
        Assertions.assertTrue(CardB3(14, "clubs").compareTo(CardB3(8, "spades")) > 0)
        Assertions.assertTrue(CardB3(13, "hearts").compareTo(CardB3(13, "diamonds")) > 0)
        Assertions.assertTrue(CardB3(8, "spades").compareTo(CardB3(11, "spades")) < 0)
        Assertions.assertEquals(CardB3(8, "spades").compareTo(CardB3(8, "spades")), 0)
        Assertions.assertTrue(CardB3.compare(CardB3(8, "spades"), CardB3(9, "clubs")) < 0)
    }

    @Test
    fun equalsTest() {
        Assertions.assertTrue(CardB3(12, "hearts") == CardB3(12, "hearts"))
        Assertions.assertFalse(CardB3(8, "hearts") == CardB3(12, "hearts"))
    }
}