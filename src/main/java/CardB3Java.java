import java.util.Objects;

public class CardB3Java implements Comparable<CardB3Java>{
    private int rank;
    private SuitJava suitJava;

    public CardB3Java(int rank, String suit){
        try {
            this.suitJava = SuitJava.valueOf(suit);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Некорректное значение поля suit");
        }
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suitJava.name();
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
        CardB3Java cardB3Java = (CardB3Java) o;
        return rank == cardB3Java.rank && suitJava == cardB3Java.suitJava;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suitJava);
    }

    /* Джокеры в колоде обычно бывают красными и черными и не привязаны к масти.
    Но чтобы не вводить цвета для джокеров, было принято решение заполнятьь поле suit для них
    сильной мастью из черных(spades) и из красных(hearts).
     */
    public boolean validate() {
        return (rank > 0 && rank < 14) || (rank == 14 && (suitJava == SuitJava.spades || suitJava == SuitJava.hearts));
    }

    public boolean isHigher(CardB3Java anotherCard) {
        boolean isRedJoker = this.rank == 14 && suitJava == SuitJava.hearts;
        boolean isBlackJoker = this.rank == 14 && suitJava == SuitJava.spades;
        return ((this.suitJava.equals(anotherCard.suitJava) || (isRedJoker && anotherCard.suitJava == SuitJava.diamonds)
                || (isBlackJoker && anotherCard.suitJava == SuitJava.clubs)) && this.rank > anotherCard.rank);
    }

    /* В задании предполагалось использование массива, что было бы актуально для ситуации,
     когда Suit хранится в строковом варианте. Так как изначально я использовала перечисляемый тип для этого,
     то при выполнении задания я смогла отказаться от массивов, используя индексы элементов перечисляемого типа.
     */
    @Override
    public int compareTo(CardB3Java anotherCard){
        return (rank - anotherCard.rank) * 4 + (suitJava.ordinal() - anotherCard.suitJava.ordinal());
    }

    public static int compare(CardB3Java firstCard, CardB3Java secondCard) {
        return firstCard.compareTo(secondCard);
    }

}
