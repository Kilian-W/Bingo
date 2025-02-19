/*
 * This class is the generic caller that will assign cards, call numbers, and check for bingos
 * Author: Kilian Wilinski
 * Date: 2/18/2025
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Caller {
    private final int NUMBER_OF_CARDS = 8;
    protected BingoCard[] cards = new BingoCard[NUMBER_OF_CARDS];
    protected Player player;
    protected int[] calledNumbers = new int[0];

    //Constructor for Caller class reads information from a file and assigns the variables appropriately
    public Caller() {
        try {
            String numbersString = "";
            FileInputStream fis = new FileInputStream("BingoCards.txt"); 
            Scanner fileScan = new Scanner(fis);

            for(int i = 0; i < NUMBER_OF_CARDS; i++) {
                cards[i] = new BingoCard();
                fileScan.nextLine();
                for(int x = 0; x < 5; x++) {
                    numbersString = fileScan.nextLine();
                    Scanner stringScan = new Scanner(numbersString);
                    stringScan.useDelimiter(",");
                    for(int y = 0; y < 5; y++) {
                        int value = stringScan.nextInt();
                        cards[i].setSpace(x, y, value);
                    }
                    stringScan.close();
                }
            }
            fileScan.close();

        }catch(FileNotFoundException e) {
            System.out.println("The file you tried to access was not found");
        }
    }

    //Prints the full list of BingoCards to the console
    public void printAllCards() {
        for(int i = 0; i < NUMBER_OF_CARDS; i++) {
            System.out.println("Card " + (i + 1));
            cards[i].printCard();
        }
    }

    //Assigns random cards to the player (No Repeat Cards)
    //@param Number of cards to assign, Scanner for input
    public void assignCards(int numCards, Scanner input) {
        Random rand = new Random();
        player = new Player(numCards);
        int[] usedCards = new int[1];
        int cardNumber = 0;

        for(int i = 0; i < numCards; i++) {
            boolean usedCard = true;
            while(usedCard) {
                cardNumber = rand.nextInt(8);
                usedCard = false;
                for(int j = 0; j < usedCards.length; j++) {
                    if(cardNumber == usedCards[j]) {
                        usedCard = true;
                        break;
                    }
                }
            }

            player.addCard(cards[cardNumber]);
            
            int[] tempArray = new int[usedCards.length + 1];
            for(int j = 0; j < usedCards.length; j++) {
                tempArray[j] = usedCards[j];
            }
            tempArray[usedCards.length] = cardNumber;
            usedCards = tempArray;
        }
    }

    //Prints all of the cards given to the player to the console
    public void printPlayerCards() {
        player.printAllCards();
    }

    //Empty method overridden in child classes
    public void playRound(Scanner input) {

    }

    //Adds a rolled number to the rolledNumbers array\
    //@param Number that was rolled
    public void addToArray(int newValue) {
        int[] tempArray = new int[calledNumbers.length + 1];
        for(int i = 0; i < calledNumbers.length; i++) {
            tempArray[i] = calledNumbers[i];
        }
        tempArray[calledNumbers.length] = newValue;
        calledNumbers = tempArray;
    }

    //Checks a specified card if it contains a bingo and returns a boolean
    //@param Index of the card in the player's collection
    //@return A boolean for if a bingo was found
    public boolean checkForBingo(int cardNumber) {
        
        ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();
        for(int i = 0; i < calledNumbers.length; i++) {
            Coordinates newCoordinate = player.getCard(cardNumber).checkForValue(calledNumbers[i]);
            if(newCoordinate.getX() != -1) {
                coordinates.add(newCoordinate);
            }
        }

        int diagOne = 0;
        int diagTwo = 0;
        int colB = 0;
        int colI = 0;
        int colN = 0;
        int colG = 0;
        int colO = 0;
        int rowB = 0;
        int rowI = 0;
        int rowN = 0;
        int rowG = 0;
        int rowO = 0;

        for(int i = 0; i < coordinates.size(); i++) {
            switch (coordinates.get(i).getX()) {
                case 0:
                    rowB++;
                    if(coordinates.get(i).getY() == 0) {
                        diagOne++;
                    }
                    if(coordinates.get(i).getY() == 4) {
                        diagTwo++;
                    }
                    break;
                case 1:
                    rowI++;
                    if(coordinates.get(i).getY() == 1) {
                        diagOne++;
                    }
                    if(coordinates.get(i).getY() == 3) {
                        diagTwo++;
                    }
                    break;
                case 2:
                    if(coordinates.get(i).getY() == 2) {
                        diagOne++;
                        diagTwo++;
                    }
                    rowN++;
                    break;
                case 3:
                    if(coordinates.get(i).getY() == 3) {
                        diagOne++;
                    }
                    if(coordinates.get(i).getY() == 1) {
                        diagTwo++;
                    }
                    rowG++;
                    break;
                case 4:
                    if(coordinates.get(i).getY() == 4) {
                        diagOne++;
                    }
                    if(coordinates.get(i).getY() == 0) {
                        diagTwo++;
                    }
                    rowO++;
                    break;
            }
            switch (coordinates.get(i).getY()) {
                case 0:
                    colB++;
                    break;
                case 1:
                    colI++;
                    break;
                case 2:
                    colN++;
                    break;
                case 3:
                    colG++;
                    break;
                case 4:
                    colO++;
                    break;
            }
            if(diagOne == 5 || diagTwo == 5 || rowB == 5 || rowI == 5 || rowN == 5 || rowG == 5 || rowO == 5 || colB == 5 || colI == 5 || colN == 5 || colG == 5 || colO == 5) {
                return true;
            }
        }
        return false;
    }
}
