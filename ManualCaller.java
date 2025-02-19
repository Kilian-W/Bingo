/*
 * Class representing the manual caller inherits from Caller class
 * Author: Kilian Wilinski
 * Date: 2/18/2025
 */

import java.util.Scanner;

public class ManualCaller extends Caller {
    
    //Overrides Parent Method and assigns the player BingoCards via user input
    //@param Number of cards to assign, Scanner for input
    public void assignCards(int numCards, Scanner input) {
        player = new Player(numCards);
        for(int i = 0; i < numCards; i++) {
            System.out.println("Enter The Number On The Card You Want For Your " + (i + 1) + " Card");
            int cardNumber = input.nextInt();
            input.nextLine();
            player.addCard(cards[cardNumber - 1]);
        }
    }
    
    //Constructor
    public ManualCaller() {
        super();
    }

    //Overrides Parent Method, Simulates a round of bingo by having the user draw a number,
    //mark their card, and declare bingo
    //@param Scanner for input
    public void playRound(Scanner input) {
        System.out.println("Enter The Number Rolled (Without The Letter)");

        int rolledInt = input.nextInt();
        input.nextLine();
        addToArray(rolledInt);

        String rolledString;
        if(rolledInt < 16) {
            rolledString = "B " + rolledInt;
        }else if(rolledInt < 31) {
            rolledString = "I " + rolledInt;
        }else if(rolledInt < 46) {
            rolledString = "N " + rolledInt;
        }else if(rolledInt < 61) {
            rolledString = "G " + rolledInt;
        }else{
            rolledString = "O " + rolledInt;
        }

        for(int i = 0; i < player.getNumberOfCards(); i++) {
            System.out.println("Number Rolled:");
            System.out.println(rolledString);
            System.out.println("Mark Your Card");
            player.printOneCard(i);
            System.out.println("Select A Space To Mark (Row Letter, Column Letter)");
            System.out.println("Example BB");
            System.out.println("If You Do Not Have That Space Type 'None'");

            String userInput = input.nextLine();
            if(!userInput.equals("None")) {
                int x = 0;
                int y = 0;
                switch(userInput.charAt(0)) {
                    case 'B' :
                        x = 0;
                        break;
                    case 'I' :
                        x = 1;
                        break;
                    case 'N' :
                        x = 2;
                        break;
                    case 'G' :
                        x = 3;
                        break;
                    case 'O' :
                        x = 4;
                        break;
                }
                switch(userInput.charAt(1)) {
                    case 'B' :
                        y = 0;
                        break;
                    case 'I' :
                        y = 1;
                        break;
                    case 'N' :
                        y = 2;
                        break;
                    case 'G' :
                        y = 3;
                        break;
                    case 'O' :
                        y = 4;
                        break;
                }
                player.markSpace(i, x, y);
            }
            
            player.printOneCard(i);
            System.out.println("Type 'Bingo' If You Have A Bingo, Otherwise Type Anything To Continue");

            String bingo = input.nextLine();
            if(bingo.equals("Bingo")) {
                boolean hasBingo = checkForBingo(i);
                if(hasBingo) {
                    System.out.println("Congratulations, You Got A Bingo!");
                    System.out.println("Thank You For Playing");
                }else {
                    System.out.println("That Bingo Was Inaccurate, You Lose That Card :("); 
                    player.removeCard(i);
                    if(player.getNumberOfCards() == 0) {
                        System.out.println("Looks Like You Ran Out Of Cards, You Will No Longer Be Able To Continue");
                    }
                }
            }
        }
    }

}
