/*
 * A class representing a player storing their cards and allowing them to mark the cards
 * Author: Kilian Wilinski
 * Date: 2/18/2025
 */

import java.util.ArrayList;

public class Player {
    private ArrayList<BingoCard> cards;
    private int numberOfCards;

    //Constructor for player initializing their number of cards
    //@param Number of cards held
    public Player(int numCards) {
        cards = new ArrayList<BingoCard>();
        numberOfCards = numCards;
    }

    //Returns the card held by the player at a specified index
    //@param index of the card
    //@return The BingoCard at that index
    public BingoCard getCard(int cardNumber) {
        return cards.get(cardNumber);
    }

    //Adds a BingoCard to the ArrayList of cards
    //@param The BingoCard to be added
    public void addCard(BingoCard card) {
        cards.add(card);
    }

    //Prints the information of all player cards to the console
    public void printAllCards() {
        for(int i = 0; i < cards.size(); i++) {
            System.out.println("Bingo Card " + (i + 1));
            cards.get(i).printCard();
        }
    }

    //Prints the information of one BingoCard at the specified index to the console
    //@param index of the BingoCard
    public void printOneCard(int cardNumber) {
        cards.get(cardNumber).printCard();
    }

    //returns numberOfCards
    public int getNumberOfCards() {
        return numberOfCards;
    }

    //Marks a specified space on a specified card held by the player
    //@param index of the card, X-coordinate of space, Y-coordinate of space
    public void markSpace(int cardNumber, int x, int y) {
        cards.get(cardNumber).markSpace(x, y);
    }

    //Removes a card from the cards ArrayList
    //@param index of the card to be removed
    public void removeCard(int cardNumber) {
        cards.remove(cardNumber);
        numberOfCards = numberOfCards - 1;
    }
}