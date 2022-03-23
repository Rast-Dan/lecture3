public class DeckTest {
    public static void main(String[] args) {
        Deck myDeckWithJokers = Deck.createDeckWithJokers();
        //вытаскиваем 6 карт из колоды
        for (int i = 0; i < 6; i++)
            System.out.println(myDeckWithJokers.getCard());
        //вытаскиваем и запоминаем карты, чтобы вернуть их в колоду
        CardB3 card1 = myDeckWithJokers.getCard();
        System.out.println(card1);
        CardB3 card2 = myDeckWithJokers.getCard();
        System.out.println(card2);

        myDeckWithJokers.addCard(card1);
        myDeckWithJokers.addCard(card1);
        myDeckWithJokers.addCard(card2);

        System.out.println(myDeckWithJokers);

        myDeckWithJokers.shake();

        System.out.println(myDeckWithJokers);

        myDeckWithJokers.sort();

        System.out.println(myDeckWithJokers);

        while (!myDeckWithJokers.isEmpty()) {
            myDeckWithJokers.getCard();
        }

        System.out.println(myDeckWithJokers);
    }
}
