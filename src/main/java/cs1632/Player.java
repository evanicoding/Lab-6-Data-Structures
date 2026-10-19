package cs1632;

import java.util.ArrayDeque;
import java.util.Queue;

public class Player {
    private Queue<PlayingCard> playerCards;

    public Player(){
        playerCards = new ArrayDeque<>();
    }

    //adds card to queue
    public void giveCard(PlayingCard c){
        playerCards.offer(c);
    }

    //returns the card being played and removes it from the queue
    public PlayingCard playCard(){
        return playerCards.poll();
    }

    //gets size of queue
    public int deckSize(){
        return playerCards.size();
    }

    //checks if queue is empty
    public boolean isEmpty(){
        return playerCards.isEmpty();
    }

    public Queue<PlayingCard> getPlayerCards() {
        return playerCards;
    }
}
