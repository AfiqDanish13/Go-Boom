import java.util.*;

public class Testgame {
    public static Card createCards(String suit, String rank){
        Card cardii = new Card(suit , rank);
        return cardii;
    }
    public static void initGameSet(int amount, ArrayList<Card> deck, ArrayList<Card> playerCards){
        playerCards.addAll(deck.subList(0, amount));
        deck.subList(0, amount).clear();
    }
    public static void main(String[] args){
        ArrayList<Card> cards = new ArrayList<Card>(); 
        String suit, rank; 
        Card initCenter; 
        ArrayList<Card> p1 = new ArrayList<Card>(); 
        ArrayList<Card> p2 = new ArrayList<Card>();  
        ArrayList<Card> p3 = new ArrayList<Card>(); 
        ArrayList<Card> p4 = new ArrayList<Card>(); 
        for(int i = 0; i < 4; i++){
            for(int j = 2; j < 15; j++){
                if(j == 11) rank = "J";
                else if(j == 10) rank = "X";
                else if(j == 12) rank = "Q";
                else if(j == 13) rank = "K";
                else if(j == 14) rank = "A";
                else rank = "" + j;
                switch(i){
                    case 0:
                        suit = "c";
                        cards.add(createCards(suit,rank));
                        break;
                    case 1:
                        suit = "d";
                        cards.add(createCards(suit,rank));
                        break;
                    case 2:
                        suit = "h";
                        cards.add(createCards(suit,rank));
                        break;
                    case 3:
                        suit = "s";
                        cards.add(createCards(suit,rank));
                        break;
                }
            }
        }
        Collections.shuffle(cards);
        System.out.println(cards);

        // center card / determine who starts first
        initCenter = cards.get(0);
        cards.remove(0);

        // draw the card to the 4 players
        initGameSet(7, cards, p1);
        initGameSet(7, cards, p2);
        initGameSet(7, cards, p3);
        initGameSet(7, cards, p4);

        // Create object for each player
        Game player1 = new Game(cards, initCenter, p1);
        Game player2 = new Game(cards, initCenter, p2);
        Game player3 = new Game(cards, initCenter, p3);
        Game player4 = new Game(cards, initCenter, p4);

        // test if all player share the same cards deck
        System.out.println(player1.getDeck());
        System.out.println(player2.getDeck());
        System.out.println(player3.getDeck());
        System.out.println(player4.getDeck());

        // test if all player share the same cards center
        System.out.println("Center: " + player1.getCenter());
        System.out.println("Center: " + player2.getCenter());
        System.out.println("Center: " + player3.getCenter());
        System.out.println("Center: " + player4.getCenter());

        // list out all cards that each player possessed
        System.out.println("Player 1: "+ player1.getPlayCards());
        System.out.println("Player 2: "+player2.getPlayCards());
        System.out.println("Player 3: "+player3.getPlayCards());
        System.out.println("Player 4: "+player4.getPlayCards());

        

        Scanner input = new Scanner(System.in);
        System.out.print("> ");
        String addedCard = input.next();
        String firstString = addedCard.substring(0, 1);
        String secondString = addedCard.substring(1);

        for(int i =0; i<p1.size(); i++){
            String element = String.valueOf(p1.get(i));
            //System.out.println(element);
            int comparison = addedCard.compareTo(element);
            if (comparison == 0) {
                System.out.println("Add");
                p1.remove(i);
                player1.addCenter(createCards(firstString, secondString));
            } 
        }
        System.out.println(p1);
        System.out.println("Center: " + player3.getCenter());

        
    
        // add card from player into center

    }

}
