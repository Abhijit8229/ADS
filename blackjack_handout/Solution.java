import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Card {
    int card;

    public Card(int card) {
        this.card = card;
    }

    public int getValue() {
        return this.card;
    }

    public void displayCard() {
        System.out.print(card + " ");
    }

    // @Override
    // public String toString() {
    // return card + " ";
    // }
}

class Deck {
    List<Card> cards;
    int currentIndex;
    int temp;

    public Deck(List<Card> cards) {
        this.cards = cards;
        this.currentIndex = 0;
        this.temp = 0;
    }

    public Card drawCard() {
        if (currentIndex < cards.size()) {
            return cards.get(currentIndex++);
        }
        return null;
    }

    public void resetDeck() {
        currentIndex = temp;
    }
}

class Hand {
    List<Card> cardsInHand;
    int totalValue;

    public Hand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
        this.totalValue = 0;
    }

    public void addCard(Card card) {
        cardsInHand.add(card);
    }

    public void calculateScore() {
        totalValue = 0;
        int oneCount = 0;
        for (Card card : cardsInHand) {
            if (card.getValue() == 1) {
                oneCount++;
                totalValue += 11;
            } else {
                totalValue += card.getValue();
            }
        }
        while (totalValue > 21 && oneCount > 0) {
            totalValue -= 10;
            oneCount--;
        }

    }

    public int getTotalValue() {
        return this.totalValue;
    }

    public void displayHand() {
        for (Card card : cardsInHand) {
            card.displayCard();
        }
        System.out.println();
        //
    }

    public boolean isBlackjack() {
        return (this.totalValue == 21) && (cardsInHand.size() == 2);
    }

    public boolean isBusted() {
        return this.totalValue > 21;
    }
}

class Player {
    Hand hand;
    boolean varstand;

    public Player(Hand hand) {
        this.hand = hand;
        this.varstand = false;
    }

    public void hit(Deck deck) {
        hand.addCard(deck.drawCard());
        hand.calculateScore();
    }

    public void stand() {
        // System.out.println("Player Stands");
        varstand = true;
        return;
    }

    public int getScore() {
        return hand.getTotalValue();
    }

    public boolean hasBlackjack() {
        return hand.isBlackjack();
    }

    public boolean hasBusted() {
        return hand.isBusted();
    }

    public void displayHand() {

        hand.displayHand();
    }
}

class Dealer {
    Hand hand;

    public Dealer(Hand hand) {
        this.hand = hand;
    }

    public void hit(Deck deck) {
        hand.addCard(deck.drawCard());
        hand.calculateScore();
    }

    public void playTurn(Scanner scanner, Deck deck) {

        String nextLine = scanner.nextLine();
        // System.out.println(nextLine);
        if (nextLine.equals("h")) {
            this.hit(deck);
            System.out.print("Dealer chooses to hit. (h/s): ");
            displayHand();
            System.out.println("Dealer's total score: " + this.getScore());
            return;
        }

        return;

    }

    public int getScore() {
        return hand.getTotalValue();
    }

    public boolean hasBlackjack() {
        return hand.isBlackjack();
    }

    public boolean hasBusted() {
        return hand.isBusted();
    }

    public void displayHand() {

        hand.displayHand();
    }
}

class Game {
    Deck deck;
    Player player;
    Dealer dealer;

    public Game() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(7));
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                continue;
            }
            cards.add(new Card(i));
        }
        this.deck = new Deck(cards);
        this.player = new Player(new Hand(new ArrayList<Card>()));
        this.dealer = new Dealer(new Hand(new ArrayList<Card>()));
    }

    public void startGame() {
        System.out.println("Game starts:");
        System.out.println("Player's turn:");
        player.hit(deck);
        player.hit(deck);
        dealer.hit(deck);
        dealer.hit(deck);
        player.displayHand();
        System.out.println("Your total score: " + player.getScore());

    }

    public void playerTurn(Scanner scanner) {

        if (!player.varstand) {

            String nextLine = scanner.nextLine();

            // System.out.println(nextLine);
            if (nextLine.equals("s")) {
                player.stand();
                System.out.println("Do you want to hit or stand? (h/s): Dealer's turn:");
                dealer.displayHand();
                System.out.println("Dealer's total score: " + dealer.getScore());
                return;
            }

            player.hit(deck);
            if (player.getScore() > 21) {
                return;
            }
            System.out.println("Do you want to hit or stand? (h/s): Player's turn:");
            player.displayHand();
            System.out.println("Your total score: " + player.getScore());
            return;

        }

    }

    public void dealerTurn(Scanner scanner) {

        dealer.playTurn(scanner, deck);
    }

    public void determineWinner() {

        if (player.hasBusted()) {

            System.out.println("Do you want to hit or stand? (h/s): Player busts!");
            System.out.println("Player's hand: ");
            player.displayHand();
            System.out.println("Player has busted!");
            return;

        }
        if (dealer.hasBusted()) {
            System.out.println("Final results:");
            player.displayHand();
            dealer.displayHand();
            System.out.println("Dealer has busted!");
            return;

        }
        if (player.getScore() > dealer.getScore()) {
            System.out.println("Dealer chooses to hit. (h/s): Dealer's final hand: ");
            dealer.displayHand();
            System.out.println("Dealer's total score: " + dealer.getScore());
            System.out.println();
            System.out.println("Final results:");
            player.displayHand();
            dealer.displayHand();
            System.out.print("Player wins!");
            return;
        }
        if (player.getScore() < dealer.getScore()) {
            System.out.println();
            System.out.println("Final results:");
            player.displayHand();
            dealer.displayHand();
            System.out.print("Dealer wins!");
            return;
        }

    }

    public void playGame(Scanner scanner) {
        startGame();

        while (scanner.hasNextLine()) {
            playerTurn(scanner);
            if (player.varstand) {

                dealerTurn(scanner);
            }
            if (player.hasBusted()) {
                determineWinner();
                return;

            }

        }
        determineWinner();
    }
}

public class Solution {

    public static void main(String[] args) {

        Game game = new Game();
        game.playGame(new Scanner(System.in));
    }

}
