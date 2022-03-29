import java.util.*

class CardB3(val rank_value:Int, val suit_value:String) : Comparable<CardB3> {
    private var rank: Int = rank_value
    private var suit: Suit = Suit.valueOf(suit_value)

    fun getRank() : Int {
        return rank
    }

    fun getSuit() : String {
        return suit.name
    }

    override fun toString():String {
        var stringRank: String = when (rank) {
            1 -> "Ace";
            11 -> "Jack";
            12 -> "Queen";
            13 -> "King";
            14 -> "Joker";
            else -> Integer.toString(rank);
        }
        return this.getSuit() + " " + stringRank
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || hashCode() != other.hashCode()) return false
        return when(other) {
            is CardB3 -> rank == other.rank && suit == other.suit;
            else -> false;
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(rank, suit);
    }

    /* Джокеры в колоде обычно бывают красными и черными и не привязаны к масти.
    Но чтобы не вводить цвета для джокеров, было принято решение заполнять поле suit для них
    сильной мастью из черных(clubs) и из красных(diamonds).
     */
    fun validate(): Boolean {
        return (rank in 1..13) || (rank == 14 && (suit == Suit.spades || suit == Suit.hearts));
    }

    fun isHigher(anotherCard:CardB3):Boolean {
        val isRedJoker:Boolean = this.rank == 14 && suit == Suit.hearts;
        val isBlackJoker:Boolean = this.rank == 14 && suit == Suit.spades;
        return ((this.suit == anotherCard.suit || (isRedJoker && anotherCard.suit == Suit.diamonds)
                || (isBlackJoker && anotherCard.suit == Suit.clubs)) && this.rank > anotherCard.rank);
    }

    companion object {
        fun compare(a: CardB3, b: CardB3):Int = a.compareTo(b)
    }

    override fun compareTo(other: CardB3): Int {
        return (rank - other.rank) * 4 + (suit.ordinal - other.suit.ordinal);
    }
}