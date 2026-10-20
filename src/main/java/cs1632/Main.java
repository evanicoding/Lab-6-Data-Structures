package cs1632;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PlayingCardDeck deck = new PlayingCardDeck();
        Player player1 = new Player();
        Player player2 = new Player();
        ArrayList<PlayingCard> playedCards = new ArrayList<>();

        int rounds = 0;

        String winner = null;
        boolean gameOver = false;

        //checking cards in deck

        /*System.out.println(deck.toString());*/

        System.out.println("Dealing cards to players");
        while (!deck.isEmpty()) {
            PlayingCard a = deck.nextCard();
            player1.giveCard(a);

            PlayingCard b = deck.nextCard();
            player2.giveCard(b);
        }
        System.out.println("Cards dealt to players");

        //checking if players are dealt alternating cards until deck is empty

        /*System.out.println(player1.getPlayerCards().toString());
        System.out.println(player2.getPlayerCards().toString());*/

        // while both players still have cards
        while(!player1.isEmpty()&&!player2.isEmpty()){
            System.out.println("Round: " + rounds);

            PlayingCard card1 = player1.playCard();
            PlayingCard card2 = player2.playCard();
            rounds++;
            playedCards.add(card1);
            playedCards.add(card2);

            // war case
            if (card1.playingCardValue()==card2.playingCardValue()){

                System.out.println("War!!!");
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
                    System.out.println("The game ends in a tie after " + rounds + " rounds. Both ran out of cards during a war");
                    break;
                }

                // if player 1 runs out of cards
                else if (player1.isEmpty()){
                    winner = "Player 2";
                    System.out.println(winner + " wins the war after " + rounds + " rounds");
                    break;
                }

                // if player 2 runs out of cards
                else if (player2.isEmpty()){
                    winner = "Player 1";
                    System.out.println(winner+ " wins the war after " + rounds + " rounds");
                    break;
                }

                System.out.println("Round: " + rounds);
                card1 = player1.playCard();
                card2 = player2.playCard();
                rounds++;
                playedCards.add(card1);
                playedCards.add(card2);

            }

            // Higher card wins and is added to winners deck
            boolean p1Wins = card1.playingCardValue()>card2.playingCardValue();
            Player roundWinner = p1Wins ? player1:player2;
            for (PlayingCard card:playedCards){
                roundWinner.giveCard(card);
            }
            System.out.println( (p1Wins ? "Player 1":"Player 2") + " wins " + playedCards.size() + " cards." );
            playedCards.clear();
        }

        // one player ran out of cards
        if (winner == null && !(player1.isEmpty() && player2.isEmpty()) ){
            winner = player1.isEmpty() ? "Player 2":"Player 1";
            System.out.println(winner + " wins after " + rounds + " rounds");

        }




    }
}