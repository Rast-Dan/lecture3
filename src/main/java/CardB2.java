public class CardB2 {
    private int rank;
    private Suit suit;

    public CardB2 (int rank, String suit){
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
}
