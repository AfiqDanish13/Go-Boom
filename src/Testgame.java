import java.util.*;

public class Testgame {
    private static Card winner;

    public static Card createCards(String suit, String rank) {
        Card cardii = new Card(suit, rank);
        return cardii;
    }

    public static void initGameSet(int amount, ArrayList<Card> deck, ArrayList<Card> playerCards) {
        playerCards.addAll(deck.subList(0, amount));
        deck.subList(0, amount).clear();
    }

    public static String eachRound(int roundNum, Game p1, Game p2, Game p3, Game p4, ArrayList<Card> center,
            ArrayList<Card> deck, String playerturns) {
        if (playerturns != null) {
            return "\nTrick #" + roundNum + "\n" +
                    "Player1: " + p1.getPlayCards() + "\n" +
                    "Player2: " + p2.getPlayCards() + "\n" +
                    "Player3: " + p3.getPlayCards() + "\n" +
                    "Player4: " + p4.getPlayCards() + "\n" +
                    "Center : " + center + "\n" +
                    "Deck   : " + deck + "\nScore  : Player1 = " + p1.getScore() + " | Player2 = " + p2.getScore()
                    + " | Player3 = " + p3.getScore() + " | Player4 = " + p4.getScore() +
                    "\nTurns  : " + playerturns + "\n> ";
        } else {
            return "\nTrick #" + roundNum + "\n" +
                    "Player1: " + p1.getPlayCards() + "\n" +
                    "Player2: " + p2.getPlayCards() + "\n" +
                    "Player3: " + p3.getPlayCards() + "\n" +
                    "Player4: " + p4.getPlayCards() + "\n" +
                    "Center : " + center + "\n" +
                    "Deck   : " + deck + "\nScore  : Player1 = " + p1.getScore() + " | Player2 = " + p2.getScore()
                    + " | Player3 = " + p3.getScore() + " | Player4 = " + p4.getScore();
        }
    }

    // start new game
    public static void startNewGame(ArrayList<Card> copyCards, ArrayList<Card> p1, ArrayList<Card> p2,
            ArrayList<Card> p3, ArrayList<Card> p4, ArrayList<Card> deck, ArrayList<Card> center) {
        Collections.shuffle(copyCards);
        ArrayList<Card> copyCards2 = new ArrayList<>(copyCards);
        deck.clear();
        deck.addAll(copyCards2);
        center.clear();
        center.add(deck.get(0));
        copyCards2.subList(0, 1).clear();
        p1.clear();
        p2.clear();
        p3.clear();
        p4.clear();
        initGameSet(7, deck, p1);
        initGameSet(7, deck, p2);
        initGameSet(7, deck, p3);
        initGameSet(7, deck, p4);
        Game.deterFirstTurns(center.get(0).rank, Game.turns, Game.playerTurns);
        Game.tricksNum = 1;
    }

    // draw cards
    public static void drawCards(ArrayList<Card> deck, ArrayList<Card> playCards) {
        playCards.addAll(deck.subList(0, 1));
        deck.subList(0, 1).clear();
    }

    public static void winnerStart(ArrayList<Card> winnerCards){
    }

    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<Card>();
        String suit, rank;
        Card initCenter;
        ArrayList<Card> p1 = new ArrayList<Card>();
        ArrayList<Card> p2 = new ArrayList<Card>();
        ArrayList<Card> p3 = new ArrayList<Card>();
        ArrayList<Card> p4 = new ArrayList<Card>();
        Scanner input = new Scanner(System.in);
        String userInput;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                if (j == 10)
                    rank = "X";
                else if (j == 11)
                    rank = "J";
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
        ArrayList<Card> copyCards = new ArrayList<Card>(cards);

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

        // set the player who starts the game
        Game.deterFirstTurns(game.getCenter().get(0).rank, Game.turns, Game.playerTurns);

        // start gameplay
        while (true) {
            // find winner
            String leadCardSuit = Game.center.get(0).suit;
            Card leadCard = Game.center.get(0);
            Card winnerCard = leadCard;
            int preValue = 0;
            if (Game.center.size() == 5) {

            }

            ArrayList<Card> arrCards = new ArrayList<>();
            if (Game.turns == 1)
                arrCards = player1.getPlayCards();
            else if (Game.turns == 2)
                arrCards = player2.getPlayCards();
            else if (Game.turns == 3)
                arrCards = player3.getPlayCards();
            else if (Game.turns == 4)
                arrCards = player4.getPlayCards();
            System.out.print(eachRound(Game.tricksNum, player1, player2, player3, player4, game.getCenter(), game.getDeck(), Game.playerTurns));

            userInput = input.nextLine();
            if (userInput.equals("x")) {
                break;
            } else if (userInput.equals("s")) {
                startNewGame(copyCards, player1.getPlayCards(), player2.getPlayCards(), player3.getPlayCards(),
                        player4.getPlayCards(), Game.deck, Game.center);
            } else if (userInput.equals("d")) {
                if (Game.deck.size() != 0) {
                    ArrayList<Card> passArr = new ArrayList<>();
                    if (Game.turns == 1)
                        passArr = player1.getPlayCards();
                    else if (Game.turns == 2)
                        passArr = player2.getPlayCards();
                    else if (Game.turns == 3)
                        passArr = player3.getPlayCards();
                    else if (Game.turns == 4)
                        passArr = player4.getPlayCards();
                    drawCards(Game.deck, passArr);
                } else {
                    if (Game.turnsNum == 4) {
                        Game.turns = 1;
                        Game.turnsNum = 1;
                        Game.tricksNum++;
                        Game.deterPlayerTurn();// should end the tricks num and start a new lead card
                    } else {
                        Game.turns++;
                        Game.turnsNum++;
                        Game.tricksNum++;
                        Game.deterPlayerTurn();// next player turns
                    }
                }
            } else if (userInput.length() == 2 && (userInput.substring(0, 1).equals(Game.center.get(0).suit)
                    || userInput.substring(1, 2).equals(Game.center.get(0).rank))
                    && (Game.center.size() != 0)) {
                int foundInd = 0;
                for (int i = 0; i < arrCards.size(); i++) {
                    String element = String.valueOf(arrCards.get(i));
                    int comparison = userInput.compareTo(element);
                    if (comparison == 0) {
                        Game.center.add(arrCards.get(i));
                        arrCards.remove(i);
                        foundInd = 1;
                        if (Game.turnsNum == 4) { // every player already make a move - this part is yet to determine
                                                  // the winner of the tricks // part ni kene ubah
                                                  // reset turnsNum = 0 // reset turns to the winner of the tricks //
                                                  // increase the tricksNum // determine winner of tricks // clear the
                                                  // center
                            for (int k = 1; k <= 4; k++) {
                                // System.out.println(i + ": card : " + Game.center.get(i));
                                if (leadCardSuit.equals(Game.center.get(k).suit)) { // compare suit
                                    int value = Game.compareCard(Game.center.get(k)); // compare rank
                                    if (value > preValue) {
                                        winnerCard = Game.center.get(k);
                                    }
                                    preValue = value;
                                }
                            }
                            // System.out.println("Winner is : " + winner);
                            if (p1.contains(winnerCard)) {
                                System.out.println("\n\n*** Player1 wins Trick #1 ***");
                                System.out.println("Card winner: " + winnerCard);
                                Game winner = player1;
                                Game.turns = 1;
                                Game.deterPlayerTurn();
                                arrCards = player1.getPlayCards();
                            }
                            else if (p2.contains(winnerCard)) {
                                System.out.println("\n\n*** Player2 wins Trick #1 ***");
                                System.out.println("Card winner: " + winnerCard);
                                Game.turns = 2;
                                Game.deterPlayerTurn();
                                arrCards = player2.getPlayCards();
                            } else if (p3.contains(winnerCard)) {
                                System.out.println("\n\n*** Player3 wins Trick #1 ***");
                                System.out.println("Card winner: " + winnerCard);
                                Game.turns = 3;
                                Game.deterPlayerTurn();
                                arrCards = player3.getPlayCards();
                            } else if (p4.contains(winnerCard)) {
                                System.out.println("\n\n*** Player4 wins Trick #1 ***");
                                System.out.println("Card winner: " + winnerCard);
                                Game.turns = 4;
                                Game.deterPlayerTurn();
                                arrCards = player4.getPlayCards();

                            }
                            Game.turnsNum = 0;
                            Game.tricksNum++;
                            Game.winner = winner;
                            Game.center.clear();
                            // winner place lead card
                            if (Game.center.size() == 0)
                                System.out.println();
                                System.out.println(eachRound(Game.tricksNum, player1, player2, player3, player4, game.getCenter(), game.getDeck(), Game.playerTurns));
                                String userInput2 = input.nextLine();
                                for (int j = 0; j < arrCards.size(); j++) {
                                    String element2 = String.valueOf(arrCards.get(j));
                                    int comparison2 = userInput2.compareTo(element2);
                                    if (comparison2 == 0) {
                                        Game.center.add(arrCards.get(j));
                                        arrCards.remove(arrCards.get(j));
                                        Game.turns++;
                                        Game.deterPlayerTurn();
                                    }
                                }
                                
                                Game.turnsNum++;
                        } else {
                            if (Game.turns == 4) {
                                Game.turns = 1;
                                Game.turnsNum++;
                                Game.deterPlayerTurn();
                            } else {
                                Game.turns++;
                                Game.turnsNum++;
                                Game.deterPlayerTurn();// next player turns
                            }
                        }
                    }
                }
                if (foundInd == 0) {
                    System.out.println("You have no specific cards.");
                }
            } else if ((Game.center.size() == 0) && (Game.turnsNum == 1) && (userInput.length() == 2)) {
                int foundInd = 0;
                for (int i = 0; i < arrCards.size(); i++) {
                    String element = String.valueOf(arrCards.get(i));
                    int comparison = userInput.compareTo(element);
                    if (comparison == 0) {
                        Game.center.add(arrCards.get(i));
                        arrCards.remove(i);
                        foundInd = 1;
                        if (Game.turns == 4) {
                            Game.turns = 1;
                            Game.turnsNum++;
                            Game.deterPlayerTurn();
                        } else {
                            Game.turns++;
                            Game.turnsNum++;
                            Game.deterPlayerTurn();// next player turns
                        }
                    }
                }
                if (foundInd == 0) {
                    System.out.println("Card not found.");
                }
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
