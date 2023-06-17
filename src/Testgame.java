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
                    "Deck   : " + deck +
                    "\nTurns  : " + playerturns + "\n> ";
        } else {
            return "\nTrick #" + roundNum + "\n" +
                    "Player1: " + p1.getPlayCards() + "\n" +
                    "Player2: " + p2.getPlayCards() + "\n" +
                    "Player3: " + p3.getPlayCards() + "\n" +
                    "Player4: " + p4.getPlayCards() + "\n" +
                    "Center : " + center + "\n" +
                    "Deck   : " + deck;
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
    public static void drawCards(ArrayList<Card> deck, ArrayList<Card> playCards, ArrayList<Card> player1, ArrayList<Card> player2, ArrayList<Card> player3, ArrayList<Card> player4,
    ArrayList<Card> p1,ArrayList<Card> p2,ArrayList<Card> p3,ArrayList<Card> p4) {
        playCards.addAll(deck.subList(0, 1));
        if(playCards.equals(player1)){
            p1.addAll(deck.subList(0, 1));
        }
        else if(playCards.equals(player2)){
            p2.addAll(deck.subList(0, 1));
        }
        else if(playCards.equals(player3)){
            p3.addAll(deck.subList(0, 1));
        }
        else if(playCards.equals(player4)){
            p4.addAll(deck.subList(0, 1));
        }
        deck.subList(0, 1).clear();
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

        boolean trick1bool = true;
        // start gameplay - for round 1 - player place cards
        while (true) {
            // test condition for high score
            // player1.getPlayCards().clear();

            // player2.getPlayCards().remove(0);
            // player2.getPlayCards().remove(1);
            // player2.getPlayCards().remove(2);
            // player2.getPlayCards().remove(3);

            // player3.getPlayCards().remove(0);
            // player3.getPlayCards().remove(1);
            // player3.getPlayCards().remove(2);
            // player3.getPlayCards().remove(3);

            // player4.getPlayCards().remove(0);
            // player4.getPlayCards().remove(1);
            // player4.getPlayCards().remove(2);
            // player4.getPlayCards().remove(3);
            // System.out.print(eachRound(Game.tricksNum, player1, player2, player3,
            // player4, game.getCenter(), game.getDeck(), Game.playerTurns));
            // System.out.println("Game turns: " + Game.turns);
            // System.out.println("Game turnsNum: " + Game.turnsNum);
            // find winner

            String leadCardSuit = Game.center.get(0).suit;
            Card leadCard = Game.center.get(0);
            Card winnerCard = leadCard;

            ArrayList<Card> arrCards = new ArrayList<>();
            if (Game.turns == 1)
                arrCards = player1.getPlayCards();
            else if (Game.turns == 2)
                arrCards = player2.getPlayCards();
            else if (Game.turns == 3)
                arrCards = player3.getPlayCards();
            else if (Game.turns == 4)
                arrCards = player4.getPlayCards();

            // condition if the deck exhausted, skip turn
            // System.out.println("Player turn: " + Game.turns);
            // System.out.println("Player Hand: " + arrCards);
            // if (Game.deck.isEmpty()) {
            // System.out.println("Say hello");

            // Iterator<Card> iterator = arrCards.iterator();

            // while (iterator.hasNext()) {
            // Card card = iterator.next();
            // if (card.suit.equals(leadCard.getSuit()) ||
            // card.rank.equals(leadCard.getRank())) {
            // System.out.println("Card: " + card);
            // iterator.remove();
            // }
            // }
            // } else {
            // System.out.println("The game deck is not empty.");
            // }
            // skip player turn if there is no card to play

            System.out.println(p1);
            System.out.println(player1.getPlayCards());
            System.out.println(p2);
            System.out.println(player2.getPlayCards());
            System.out.println(p3);
            System.out.println(player3.getPlayCards());
            System.out.println(p4);
            System.out.println(player4.getPlayCards());



            if (Game.deck.size() == 0) {
                boolean canPlayCard = false;
                for (int i = 0; i < arrCards.size(); i++) {
                    Card card = arrCards.get(i);
                    if (card.suit.equals(leadCard.getSuit()) || card.rank.equals(leadCard.getRank())) {
                        canPlayCard = true;
                    }
                }
                if (!canPlayCard) {
                    Game.turns++;
                    Game.deterPlayerTurn();
                    Game.turnsNum++;
                    System.out.print(eachRound(Game.tricksNum, player1, player2, player3, player4, game.getCenter(),
                            game.getDeck(), Game.playerTurns));
                    System.out.println(
                            "\nPlayer " + (Game.turns - 1) + " has no cards matching the lead card. Skipping turn.\n");
                    continue;
                }
                // String geString = input.next();
            }
            System.out.print(eachRound(Game.tricksNum, player1, player2, player3, player4, game.getCenter(),
                    game.getDeck(), Game.playerTurns));
            if (player1.getPlayCards().size() == 0 || player2.getPlayCards().size() == 0
                    || player3.getPlayCards().size() == 0 || player4.getPlayCards().size() == 0) {
                game.getScore(player1.getPlayCards(), player2.getPlayCards(), player3.getPlayCards(),
                        player4.getPlayCards());
                break;
            }
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
                    drawCards(Game.deck, passArr, player1.getPlayCards(), player2.getPlayCards(), player3.getPlayCards(), player4.getPlayCards(), p1,p2,p3,p4);
                }
            } else if (userInput.length() == 2
                    && (userInput.substring(0, 1).equals(Game.center.get(0).suit)
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
                        if (Game.turnsNum == 4) {
                            ArrayList<Integer> values = new ArrayList<>();
                            if (trick1bool) {
                                for (int k = 1; k <= 4; k++) {
                                    if (leadCardSuit.equals(Game.center.get(k).suit)) { // compare suit
                                        int value = Game.compareCard(Game.center.get(k)); // compare rank
                                        values.add(value); // Add the value to the ArrayList
                                    }
                                    else{
                                        values.add(0); // Add the value to the ArrayList
                                    }
                                    System.out.println(values);
                                }
                                int highestValueIndex = values.indexOf(Collections.max(values));
                                System.out.println(highestValueIndex);
                                winnerCard = Game.center.get(highestValueIndex+1);
                                trick1bool = false;
                            } else if (trick1bool == false) {
                                for (int k = 1; k < Game.center.size(); k++) {
                                    if ((Game.center.get(0).suit).equals(Game.center.get(k).suit)) { // compare suit
                                        if (leadCardSuit.equals(Game.center.get(k).suit)) { // compare suit
                                            int value = Game.compareCard(Game.center.get(k)); // compare rank
                                            values.add(value); // Add the value to the ArrayList
                                        }
                                        System.out.println(values);
                                    }
                                }
                                int highestValueIndex = values.indexOf(Collections.max(values));
                                System.out.println(highestValueIndex);
                                winnerCard = Game.center.get(highestValueIndex);
                            }

                            System.out.println(p1);
                            System.out.println(player1.getPlayCards());
                            System.out.println(p2);
                            System.out.println(player2.getPlayCards());
                            System.out.println(p3);
                            System.out.println(player3.getPlayCards());
                            System.out.println(p4);
                            System.out.println(player4.getPlayCards());

                            // print winner for the trick
                            if (p1.contains(winnerCard)) {
                                //System.out.println("player1 menang");
                                System.out.println("\n\n*** Player1 wins Trick #1 ***");
                                System.out.println("Card winner: " + winnerCard);
                                Game.turns = 1;
                                Game.deterPlayerTurn();
                                arrCards = player1.getPlayCards();
                            } else if (p2.contains(winnerCard)) {
                                //System.out.println("player2 menang");
                                System.out.println("\n\n*** Player2 wins Trick #1 ***");
                                System.out.println("Card winner: " + winnerCard);
                                Game.turns = 2;
                                Game.deterPlayerTurn();
                                arrCards = player2.getPlayCards();
                            } else if (p3.contains(winnerCard)) {                                
                               //System.out.println("player3 menang");
                                System.out.println("\n\n*** Player3 wins Trick #1 ***");
                                System.out.println("Card winner: " + winnerCard);
                                Game.turns = 3;
                                Game.deterPlayerTurn();
                                arrCards = player3.getPlayCards();
                            } else if (p4.contains(winnerCard)) {
                                //System.out.println("player4 menang");
                                System.out.println("\n\n*** Player4 wins Trick #1 ***");
                                System.out.println("Card winner: " + winnerCard);
                                Game.turns = 0;
                                Game.deterPlayerTurn();
                                arrCards = player4.getPlayCards();
                            }
                            Game.deterPlayerTurn();
                            Game.tricksNum++;
                            Game.winner = winner;
                            Game.center.clear();

                            // winner place lead card and the next trick go on
                            if (Game.center.size() == 0) {
                                boolean continueLoop = true;
                                while (continueLoop) {
                                    System.out.println();
                                    // System.out.println("Game turns: " + Game.turns);
                                    // System.out.println("Game turnsNum: " + Game.turnsNum);
                                    System.out.println();
                                    System.out.println(eachRound(Game.tricksNum, player1, player2, player3, player4,
                                            game.getCenter(), game.getDeck(), Game.playerTurns));
                                    String userInput2 = input.next();

                                    for (int s = 0; s < arrCards.size(); s++) {
                                        comparison = userInput2.compareTo(arrCards.get(s).toString());
                                        if (comparison == 0) {
                                            for (int j = 0; j < arrCards.size(); j++) {
                                                String element2 = String.valueOf(arrCards.get(j));
                                                int comparison2 = userInput2.compareTo(element2);
                                                if (comparison2 == 0) {
                                                    Game.center.add(arrCards.get(j));
                                                    arrCards.remove(arrCards.get(j));
                                                    Game.deterPlayerTurn();
                                                    continueLoop = false;
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }

                                    if (continueLoop) {
                                        System.out.println("You don't have that specific card!");
                                    }
                                }
                                System.out.println();
                                Game.turnsNum = 2;
                                Game.turns++;
                                Game.deterPlayerTurn();
                            }
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
            }
            
        }
        input.close();
        System.out.println("Bye!! ");
    }
}
