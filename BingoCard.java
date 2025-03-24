/*
 * This Class Represents A Bingo Card, It Has The Ability To Store And Mark Bingo Spaces
 * Author: Kilian Wilinski
 * Date: 2/18/2025
 */
import java.util.ArrayList;

public class BingoCard {
    private BingoSpace[][] spaces = new BingoSpace[5][5];
    private ArrayList<Coordinates> markedSpaces = new ArrayList<Coordinates>();

    //Assigns a space on the board at the specified location with the specified value
    //@Param X-coordinate, Y-coordinate, Value to assign
    public void setSpace(int X, int Y, int value) {
        spaces[X][Y] = new BingoSpace(value);
    }

    public ArrayList<Coordinates> getMarkedSpaces() {
        return markedSpaces;
    }

    //Marks a space on the board as drawn
    //@param X-coordinate, Y-coordinate
    public void markSpace(int X, int Y) {
        spaces[X][Y].mark();
        markedSpaces.add(new Coordinates(X, Y));
    }

    //Prints the card information to the console
    public void printCard() {
        System.out.println("  B  I  N  G  O");
        for(int x = 0; x < 5; x++) {
            System.out.println(" ----------------");
            switch(x) {
                case 0:
                System.out.print("B");
                break;
                case 1:
                System.out.print("I");
                break;
                case 2:
                System.out.print("N");
                break;
                case 3:
                System.out.print("G");
                break;
                case 4:
                System.out.print("O");
                break;
            }
            System.out.print("|");
            for(int y = 0; y < 5; y++) {
                System.out.print(spaces[x][y].spaceToString() + "|");
            }
            System.out.println();
        }
    }

    //Checks if a specific value exists within the card and returns its coordinates
    //@param Value to search for
    //@return The coordinate associated with the found value
    public Coordinates checkForValue(int value) {
        if(value < 16) {
            for(int i = 0; i < 5; i++) {
                if(spaces[i][0].getValue() == value) {
                    return new Coordinates(i, 0);
                }
            }
        }else if(value < 31) {
            for(int i = 0; i < 5; i++) {
                if(spaces[i][1].getValue() == value) {
                    return new Coordinates(i, 1);
                }
            }
        }else if(value < 46) {
            for(int i = 0; i < 5; i++) {
                if(spaces[i][2].getValue() == value) {
                    return new Coordinates(i, 2);
                }
            }
        }else if(value < 61) {
            for(int i = 0; i < 5; i++) {
                if(spaces[i][3].getValue() == value) {
                    return new Coordinates(i, 3);
                }
            }
        }else {
            for(int i = 0; i < 5; i++) {
                if(spaces[i][4].getValue() == value) {
                    return new Coordinates(i, 4);
                }
            }
        }
        return new Coordinates(-1, -1);
    }
}
