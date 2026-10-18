package cs1632;

import java.util.ArrayDeque;
import java.util.Queue;

public class Player {
    private Queue<PlayingCard> playerCards;

    public Player(){
        playerCards = new ArrayDeque<>();
    }

    public void giveCard(PlayingCard c){
        playerCards.offer(c);

    }

    public PlayingCard playCard(){
        return playerCards.poll();
    }
}
