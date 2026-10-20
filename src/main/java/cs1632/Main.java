package cs1632;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PlayingCardDeck deck = new PlayingCardDeck();
        Player player1 = new Player();
        Player player2 = new Player();
        ArrayList<PlayingCard> playedCards = new ArrayList<>();

        int rounds = 0;

        Player winner = null;
        boolean gameOver = false;

        //checking cards in deck

        System.out.println(deck.toString());

        while (!deck.isEmpty()) {
            PlayingCard a = deck.nextCard();
            player1.giveCard(a);

            PlayingCard b = deck.nextCard();
            player2.giveCard(b);
        }

        //checking if players are dealt alternating cards until deck is empty

        System.out.println(player1.getPlayerCards().toString());
        System.out.println(player2.getPlayerCards().toString());

        // while both players still have cards
        while(!player1.isEmpty()&&!player2.isEmpty()){
            PlayingCard card1 = player1.playCard();
            PlayingCard card2 = player2.playCard();

            playedCards.add(card1);
            playedCards.add(card2);

            // war case
            if (card1.playingCardValue()==card2.playingCardValue()){

                // both players play 3 cards
                for (int i = 0; i<3;i++){
                    if(!player1.isEmpty()){
                        playedCards.add(player1.playCard());
                    }
                    if(!player2.isEmpty()){
                        playedCards.add(player2.playCard());
                    }
                }

                // if both run out of cards
                if (player1.isEmpty()&&player2.isEmpty()){
                    winner = null;
                    gameOver = true;
                    break;
                }

                // if player 1 runs out of cards
                else if (player1.isEmpty()){
                    winner = player2;
                    gameOver = true;
                    break;
                }

                // if player 2 runs out of cards
                else if (player2.isEmpty()){
                    winner = player1;
                    gameOver = true;
                    break;
                }

                card1 = player1.playCard();
                card2 = player2.playCard();

                playedCards.add(card1);
                playedCards.add(card2);

            }

            if (gameOver){
                if (winner == null){
                    System.out.println("The game ends in a tie after " + rounds + " rounds");
                }
                else if (winner == player1){
                    System.out.println("Player 1 wins after " + rounds + " rounds");
                }
                else if (winner == player2){
                    System.out.println("Player 2 wins after " + rounds + " rounds");
                }
            }

            // Higher card wins and is added to winners deck
            Player roundWinner = card1.playingCardValue()>card2.playingCardValue() ? player1:player2;
            for (PlayingCard card:playedCards){
                roundWinner.giveCard(card);
            }
            playedCards.clear();
        }

        // one player ran out of cards
        if (winner == null && !(player1.isEmpty() && player2.isEmpty()) ){
            winner = player1.isEmpty() ? player2:player1;
            System.out.println("winner is " + winner);

        }




    }
}