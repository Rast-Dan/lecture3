public class CardC2 {
    private int rank;
    private Suit suit;
    private static int[] maxRank = {0,0,0,0};

    public CardC2 (int rank, String suit) {
        setSuit(suit);
        this.rank = rank;

        int suitIndex = this.suit.ordinal();
        if (rank > maxRank[suitIndex]){
            maxRank[suitIndex] = rank;
        }
    }

    public CardC2 (String suit){
        setSuit(suit);
        this.rank = ++maxRank[this.suit.ordinal()];
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit.name();
    }

    private void setSuit(String suit) {
        try {
            this.suit = Suit.valueOf(suit);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Некорректное значение поля suit");
        }
    }
}
