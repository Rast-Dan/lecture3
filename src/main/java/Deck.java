import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Deck {
    private ArrayList<CardB3> cards;

    private Deck() {
        this.cards = new ArrayList<>();
    }

    public static Deck createDeck()
    {
        Deck deck = new Deck();
        for (int i = 1; i < 14; i++){
            for (Suit suit : Suit.values()){
                deck.cards.add(new CardB3(i, suit.name()));
            }
        }
        return deck;
    }

    public static Deck createDeckWithJokers() {
        Deck deck = createDeck();
        deck.cards.add(new CardB3(14,"spades"));
        deck.cards.add(new CardB3(14,"hearts"));
        return deck;
    }

    public static CardB3 randomCard() {
        Deck deck = createDeckWithJokers();
        return deck.cards.get((int) (Math.random() * deck.cards.size()));
    }

    public void shake() {
        for (int i = 0; i < cards.size(); i++) {
            Collections.swap(cards, i, (int) (Math.random() * cards.size()));
        }
    }

    public void sort() {
        Collections.sort(cards);
    }

    public CardB3 getCard() {
        return cards.remove(cards.size() - 1);
    }

    public void addCard (CardB3 card) {
        if (cards.contains(card))
            return;
        cards.add(card);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public String toString() {
        return cards.stream().map(CardB3::toString).collect(Collectors.joining(", "));
    }
}


