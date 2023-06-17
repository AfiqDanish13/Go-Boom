import java.lang.reflect.Array;
import java.util.*;

public class Game extends Card implements java.io.Serializable{
    protected static ArrayList<Card> deck = new ArrayList<>();
    protected static ArrayList<Card> center = new ArrayList<>();
    private ArrayList<Card> dupCenter = new ArrayList<>();
    private ArrayList<Card> dupDeck = new ArrayList<>();
    private int dupTurns = 0;
    private int dupTurnsNum = 0;
    private int dupTricksNum = 0;
    private String dupPlayerTurns = "";
    private ArrayList<Card> playCards = new ArrayList<>();
    static int countInsert = 0;
    private int score;
    public static int tricksNum = 1;
    public static Card winner = null;
    public static int turns = 0;
    public static String playerTurns = "";
    public static int turnsNum = 1;
    public static String userInput = "";

    public Game() {
    };

    public Game(ArrayList<Card> deck, Card center, ArrayList<Card> playCards) {
        if (countInsert == 0) {
            Game.deck.addAll(deck);
            Game.center.add(0, center);
            this.playCards.addAll(playCards);
            countInsert++;
        } else {
            this.playCards.addAll(playCards);
        }
    }

    public static void deterFirstTurns(String r, int turns, String playerTurns) {
        switch (r) {
            case "A":
            case "5":
            case "9":
            case "K":
                Game.turns = 1;
                Game.playerTurns = "Player1";
                break;
            case "2":
            case "6":
            case "X":
                Game.turns = 2;
                Game.playerTurns = "Player2";
                break;
            case "3":
            case "7":
            case "J":
                Game.turns = 3;
                Game.playerTurns = "Player3";
                break;
            case "4":
            case "8":
            case "Q":
                Game.turns = 4;
                Game.playerTurns = "Player4";
                break;
        }
    }

    public static void deterPlayerTurn() {
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

    public static int compareCard(Card card) {
        String[] Rank = { "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K", "A" };
        int[] RankValues = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        for (int i = 0; i < Rank.length; i++) {
            if (card.getRank().equals(Rank[i])) {
                return RankValues[i];
            }
        }
        // card not found
        return -1;
    }

    // public static void cardInsertion(ArrayList<Card> player){

    // }

    // public static void gameOn(){
    // Scanner input = new Scanner(System.in);
    // System.out.print("> "); userInput = input.nextLine();
    // userInput.toLowerCase();
    // if(userInput.equals("s")){

    // }

    // }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> getPlayCards() {
        return playCards;
    }

    public ArrayList<Card> getCenter() {
        return center;
    }

    public ArrayList<Card> getDupCenter(){
        return this.dupCenter;
    }

    public ArrayList<Card> getDupdeck(){
        return this.dupDeck;
    }

    public int getDupTurns(){
        return this.dupTurns;
    }

    public int getDupTurnsNum(){
        return this.dupTurnsNum;
    }

    public int getDupTrickNum(){
        return this.dupTricksNum;
    }

    public String getPlayerTurns(){
        return this.dupPlayerTurns;
    }

    public int getIndScore(){
        return score;
    }

    public void setPlayCards(ArrayList<Card> loadedCards){
        this.playCards = loadedCards;
    }

    public void setScore(int loadedInt){
        this.score = loadedInt;
    }

    public void setGameDeck(ArrayList<Card> loadedCards){
        Game.deck = loadedCards;
    }

    public void setGameCenter(ArrayList<Card> loadedCards){
        Game.center = loadedCards;
    }

    public void setDupCenter(ArrayList<Card> loadedCards){
        for(Card card: loadedCards){
            String dupSuit = card.getSuit();
            String dupRank = card.getRank();
            Card dupCard = new Card(dupSuit,dupRank);
            this.dupCenter.add(dupCard);
        }
    }

    public void setDupDeck(ArrayList<Card> loadedCards){
        for(Card card: loadedCards){
            String dupSuit = card.getSuit();
            String dupRank = card.getRank();
            Card dupCard = new Card(dupSuit,dupRank);
            this.dupDeck.add(dupCard);
        }
    }

    public void setDupTurns(int loadedint){
        this.dupTurns = loadedint;
    }

    public void setDupTurnsNum(int loadedint){
        this.dupTurnsNum = loadedint;
    }

    public void setDupTricksNum(int loadedint){
        this.dupTricksNum = loadedint;
    }

    public void setDupPlayerTurns(String loadedstring){
        this.dupPlayerTurns = loadedstring;
    }
    
    public void setTurns(int loadedInt){
        Game.turns = loadedInt;
    }

    public void setTurnsNum(int loadedInt){
        Game.turnsNum = loadedInt;
    }

    public void setPlayersTurns(String loadedString){
        Game.playerTurns = loadedString;
    }

    public void getScore(ArrayList<Card> p1Cards, ArrayList<Card> p2Cards, ArrayList<Card> p3Cards,
            ArrayList<Card> p4Cards) {
        int p1Score = calculateScore(p1Cards);
        int p2Score = calculateScore(p2Cards);
        int p3Score = calculateScore(p3Cards);
        int p4Score = calculateScore(p4Cards);
        int highestScore = Math.max(Math.max(p1Score, p2Score), Math.max(p3Score, p4Score));

        String winner;

        if (highestScore == p1Score) {
            winner = "Player 1";
        } else if (highestScore == p2Score) {
            winner = "Player 2";
        } else if (highestScore == p3Score) {
            winner = "Player 3";
        } else {
            winner = "Player 4";
        }

        System.out.println("---------------------------");
        System.out.println("Player 1 Score: " + p1Score);
        System.out.println("Player 2 Score: " + p2Score);
        System.out.println("Player 3 Score: " + p3Score);
        System.out.println("Player 4 Score: " + p4Score);
        System.out.println("Round 1 is over , the winner is " + winner);


    }

    private int calculateScore(ArrayList<Card> cards) {
    int score = 0;
    for (Card card : cards) {
        String rank = card.getRank();
        int rankValue;

        // Convert rank to numerical value
        if (rank.equals("A")) {
            rankValue = 1;
        } else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
            rankValue = 10;
        } else if (rank.equals("X")) {
            rankValue = 10;
        } else {
            rankValue = Integer.parseInt(rank);
        }

        if (rankValue >= 2 && rankValue <= 10) {
            // Face cards (2-10) have a value equal to their rank
            score += rankValue;
        } else if (rankValue >= 11 && rankValue <= 13) {
            // Face cards (K, Q, J) have a value of 10
            score += 10;
        } else if (rankValue == 1) {
            // Ace has a value of 1
            score += 1;
        }
    }
    return score;
}


}
