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

    
}
