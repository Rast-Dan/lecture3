import java.util.Objects;

public class CardB3 implements Comparable<CardB3>{
    private int rank;
    private Suit suit;

    public CardB3 (int rank, String suit){
        try {
            this.suit = Suit.valueOf(suit);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Некорректное значение поля suit");
        }
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit.name();
    }

    @Override
    public String toString() {
        String stringRank = switch (rank) {
            case 1 -> "Ace";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            case 14 -> "Joker";
            default -> Integer.toString(rank);
        };
        return this.getSuit() + " " + stringRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || hashCode() != o.hashCode()) return false;
        CardB3 cardB3 = (CardB3) o;
        return rank == cardB3.rank && suit == cardB3.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    /* Джокеры в колоде обычно бывают красными и черными и не привязаны к масти.
    Но чтобы не вводить цвета для джокеров, было принято решение заполнятьь поле suit для них
    сильной мастью из черных(clubs) и из красных(diamonds).
     */
    public boolean validate() {
        return (rank > 0 && rank < 14) || (rank == 14 && (suit == Suit.spades || suit == Suit.hearts));
    }

    public boolean isHigher(CardB3 anotherCard) {
        boolean isRedJoker = this.rank == 14 && suit == Suit.hearts;
        boolean isBlackJoker = this.rank == 14 && suit == Suit.spades;
        return ((this.suit.equals(anotherCard.suit) || (isRedJoker && anotherCard.suit == Suit.diamonds)
                || (isBlackJoker && anotherCard.suit == Suit.clubs)) && this.rank > anotherCard.rank);
    }

    /* В задании предполагалось использование массива, что было бы актуально для ситуации,
     когда Suit хранится в строковом варианте. Так как изначально я использовала перечисляемый тип для этого,
     то при выполнении задания я смогла отказаться от массивов, используя индексы элементов перечисляемого типа.
     */
    @Override
    public int compareTo(CardB3 anotherCard){
        return (rank - anotherCard.rank) * 4 + (suit.ordinal() - anotherCard.suit.ordinal());
    }

    public static int compare(CardB3 firstCard, CardB3 secondCard) {
        return firstCard.compareTo(secondCard);
    }

}
