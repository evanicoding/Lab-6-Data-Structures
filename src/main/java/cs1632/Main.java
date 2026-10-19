package cs1632;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PlayingCardDeck deck = new PlayingCardDeck();
        Player player1 = new Player();
        Player player2 = new Player();
        ArrayList<PlayingCard> playedCards = new ArrayList<>();

        System.out.println(deck.toString());

        while (!deck.isEmpty()) {
            PlayingCard a = deck.nextCard();
            player1.giveCard(a);

            PlayingCard b = deck.nextCard();
            player2.giveCard(b);
        }

        System.out.println(player1.getPlayerCards().toString());
        System.out.println(player2.getPlayerCards().toString());


        /*while(!player1.isEmpty()||!player2.isEmpty()){
            playedCards.add(player1.playCard());
            playedCards.add(player2.playCard());

            if(playedCards.get(0).playingCardValue() > playedCards.get(1).playingCardValue()){
                for(PlayingCard card:playedCards){
                    player1.giveCard(card);
                }
                playedCards.clear();
            }
            else if(playedCards.get(1).playingCardValue() > playedCards.get(0).playingCardValue()){
                for(PlayingCard card:playedCards){
                    player2.giveCard(card);
                }
                playedCards.clear();
            }
        }*/


    }
}