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
            System.out.println("Player 1 plays " + card1.playingCardValue());
            PlayingCard card2 = player2.playCard();
            System.out.println("Player 2 plays " + card2.playingCardValue());

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
                    winner = "Tie";
                    gameOver = true;
                    break;
                }

                // if player 1 runs out of cards
                else if (player1.isEmpty()){
                    winner = "Player 2";
                    gameOver = true;
                    break;
                }

                // if player 2 runs out of cards
                else if (player2.isEmpty()){
                    winner = "Player 1";
                    gameOver = true;
                    break;
                }

                System.out.println("Round: " + rounds);
                card1 = player1.playCard();
                System.out.println("Player 1 plays " + card1.playingCardValue());
                card2 = player2.playCard();
                System.out.println("Player 2 plays " + card2.playingCardValue());


                rounds++;
                playedCards.add(card1);
                playedCards.add(card2);

            }

            if (gameOver){break;}

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
        if (winner == "Player 1"){
            System.out.println(winner + " wins after " + rounds + " rounds");
        }
        else if (winner == "Player 2"){
            System.out.println(winner + " wins after " + rounds + " rounds");
        }
        else if (winner == "Tie"){
            System.out.println("Game ends in a tie after " + rounds + " rounds");

        }




    }
}