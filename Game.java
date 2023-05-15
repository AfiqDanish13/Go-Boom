import java.util.*;

public class Game{
    protected static ArrayList<Card> deck = new ArrayList<>();
    static int countInsert = 0;
    protected static ArrayList<Card> center = new ArrayList<>();
    private ArrayList<Card> playCards = new ArrayList<>();
    private int score;

    public Game(){};
    public Game(ArrayList<Card> deck, Card center, ArrayList<Card> playCards){
        if(countInsert == 0){
            Game.deck.addAll(deck);
            Game.center.add(0, center);
            this.playCards.addAll(playCards);
            countInsert++;
        }
        else{
            this.playCards.addAll(playCards);
        }
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public ArrayList<Card> getPlayCards(){
        return playCards;
    }

    public ArrayList<Card> getCenter(){
        return center;
    }

    public void removeElemCent(){
        Game.center.clear();
    }
}