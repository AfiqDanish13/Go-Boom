import java.util.*;

public class Testgame {
    public static Card createCards(String suit, String rank) {
        Card cardii = new Card(suit, rank);
        return cardii;
    }

    public static void initGameSet(int amount, ArrayList<Card> deck, ArrayList<Card> playerCards) {
        playerCards.addAll(deck.subList(0, amount));
        deck.subList(0, amount).clear();
    }
    public static void menu(int trick, Game player1, Game player2,Game player3, Game player4, Game game, int turn){
        System.out.println("Trick #" + trick);
        System.out.println("Player 1: " + player1.getPlayCards());
        System.out.println("Player 2: " + player2.getPlayCards());
        System.out.println("Player 3: " + player3.getPlayCards());
        System.out.println("Player 4: " + player4.getPlayCards());
        System.out.println("Center  : " + game.getCenter());
        System.out.println("Deck    : " + game.getDeck());
        System.out.println("Turn    : Player" + turn);
        
    }

    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<Card>();
        String suit, rank;
        Card initCenter;
        //String[] turn = { "p1", "p2", "p3", "p4" };
        ArrayList<Card> p1 = new ArrayList<Card>();
        ArrayList<Card> p2 = new ArrayList<Card>();
        ArrayList<Card> p3 = new ArrayList<Card>();
        ArrayList<Card> p4 = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                if (j == 11)
                    rank = "J";
                else if (j == 10)
                    rank = "X";
                else if (j == 12)
                    rank = "Q";
                else if (j == 13)
                    rank = "K";
                else if (j == 14)
                    rank = "A";
                else
                    rank = "" + j;
                switch (i) {
                    case 0:
                        suit = "c";
                        cards.add(createCards(suit, rank));
                        break;
                    case 1:
                        suit = "d";
                        cards.add(createCards(suit, rank));
                        break;
                    case 2:
                        suit = "h";
                        cards.add(createCards(suit, rank));
                        break;
                    case 3:
                        suit = "s";
                        cards.add(createCards(suit, rank));
                        break;
                }
            }
        }
        Collections.shuffle(cards);
        // System.out.println(cards);

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
        Game game = new Game();


        // p1 start first , 1 start first
        int turn = 2;
        while (true) {
            int trick = 1;
            System.out.println(turn);
            Game playerTurn = null;
            if (turn == 1) playerTurn = player1;
            else if (turn == 2) playerTurn = player2;
            else if (turn == 3) playerTurn = player3;
            else if (turn == 4) playerTurn = player4;
            menu(trick, player1, player2, player3, player4, game, turn);
            Scanner input = new Scanner(System.in);
            System.out.print("> ");

            String command = input.next();
            String firstString = command.substring(0, 1);
            String secondString = command.substring(1);
            if (command == "c") 
                
            for (int i = 0; i < playerTurn.getPlayCards().size(); i++) {
                String element = String.valueOf(playerTurn.getPlayCards().get(i));
                // System.out.println(element);
                int comparison = command.compareTo(element);
                if (comparison == 0) {
                   // System.out.println("Add");
                    playerTurn.getPlayCards().remove(i);
                    playerTurn.addCenter(createCards(firstString, secondString));
                }
            }
            //System.out.println("Center: " + game.getCenter());
            turn = turn+1;
        }
    }
}
