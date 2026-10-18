package cs1632;

public class Main {
    public static void main(String[] args) {
        PlayingCardDeck deck = new PlayingCardDeck();
        Player player1 = new Player();
        Player player2 = new Player();
        while (!deck.isEmpty()) {
            PlayingCard c = deck.nextCard();

            System.out.println("Card is " + c.cardName());
        }
    }
}