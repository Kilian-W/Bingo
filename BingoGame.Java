/*
 * This Class Contains The Main Method And Starts The Game Loop
 * Author: Kilian Wilinski
 * Date: 2/18/2025
 */

import java.util.Scanner;

public class BingoGame {

    public static void main(String[] args) {
        Caller caller = new Caller();
        Scanner input = new Scanner(System.in);
        System.out.println("Would You Like To Play Manual Or Random?");
        System.out.println("For Manual Play Enter: 'M', For Random Play Enter: 'R'");

        boolean callerAssigned = false;
        while(!callerAssigned) {
            String inputString = input.nextLine();
            if(inputString.equals("M")) {
                caller = new ManualCaller();
                callerAssigned = true;
            }else if(inputString.equals("R")){
                caller = new RandomCaller();
                callerAssigned = true;
            }else {
                System.out.println("Invalid Entry Try Again");
            } 
        }     

        caller.printAllCards();
        System.out.println("Select Number of Cards: 1 - 4");
        caller.assignCards(input.nextInt(), input);
        input.nextLine();

        System.out.println("Here Are Your Cards");
        caller.printPlayerCards();

        String playing = "Y";
        while (playing.equals("Y") || playing.equals("y")) {
            caller.playRound(input);
            System.out.println("Would You Like To Keep Playing? Type 'Y' If Yes");
            playing = input.nextLine();
        }

        System.out.println("Goodbye, Thanks For Playing");

        input.close();
    }
}