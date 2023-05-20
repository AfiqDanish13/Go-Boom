import java.util.*;

public class Card {
    public String suit;
    public String rank;
    public Card(){};
    public Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }
    public String toString(){
        return suit + rank;
    }
    public String getSuit(){
        return suit;
    }
    public String getRank(){
        return rank;
    }
}