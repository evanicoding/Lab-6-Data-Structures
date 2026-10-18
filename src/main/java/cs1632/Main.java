package cs1632;

public class Main {
    public static void main(String[] args) {
        PlayingCardDeck deck = new PlayingCardDeck();
        Player player1 = new Player();
        Player player2 = new Player();
        while (!deck.isEmpty()) {
            PlayingCard a = deck.nextCard();
            player1.giveCard(a);

            PlayingCard b = deck.nextCard();
            player2.giveCard(b);
        }

        System.out.println("Player 1 deck size: " + player1.deckSize());
        System.out.println("Player 2 deck size: " + player2.deckSize());
    }
}