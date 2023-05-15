import java.util.*;

public class Card {
    private String suit;
    private String rank;
    public Card(){};
    public Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }

    public String toString(){
        return suit + rank;
    }
}
