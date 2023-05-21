import java.lang.reflect.Array;
import java.util.*;

public class Game extends Card{
    protected static ArrayList<Card> deck = new ArrayList<>();
    protected static ArrayList<Card> center = new ArrayList<>();
    private ArrayList<Card> playCards = new ArrayList<>();
    static int countInsert = 0;
    private int score;
    public static int tricksNum = 1;
    public static Card winner = null;
    public static int turns = 0; public static String playerTurns = "";
    public static int turnsNum = 1;
    public static String userInput = "";

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

    public static void deterFirstTurns(String r, int turns, String playerTurns){
        switch (r) {
            case "A": case "5" : case "9" : case "K":
                Game.turns = 1;
                Game.playerTurns = "Player1";
                break;
            case "2" : case "6" : case "X":
                Game.turns = 2;
                Game.playerTurns = "Player2";
                break;
            case  "3" : case "7" : case "J":
                Game.turns = 3;
                Game.playerTurns = "Player3";
                break;
            case "4": case "8": case "Q":
                Game.turns = 4;
                Game.playerTurns = "Player4";
                break;
        }
    }

    public static void deterPlayerTurn(){
        switch (Game.turns) {
            case 1:
                playerTurns = "Player1";
                break;
            case 2:
                playerTurns = "Player2";
                break;
            case 3:
                playerTurns = "Player3";
                break;
            case 4:
                playerTurns = "Player4";
                break;
        }
    }
    public static int compareCard(Card card){
        String[] Rank = {"2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K", "A"};
        int cardValue = 0;
        for(int i=0; i<Rank.length; i++){
            if((card.getRank()).equals(Rank[i])){
                cardValue = i;
            }
        }
        return cardValue;
    }

    // public static void cardInsertion(ArrayList<Card> player){

    // }

    // public static void gameOn(){
    //     Scanner input = new Scanner(System.in);
    //     System.out.print("> "); userInput = input.nextLine(); userInput.toLowerCase();
    //     if(userInput.equals("s")){

    //     }
        
       
    // }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public ArrayList<Card> getPlayCards(){
        return playCards;
    }

    public ArrayList<Card> getCenter(){
        return center;
    }

    public int getScore(){
        return score;
    }
}
