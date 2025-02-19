/*
 * A class representing a single space on a bingo card, storing a value and marked state
 * Author: Kilian Wilinski
 * Date: 2/18/2025
 */

public class BingoSpace {
    private int value;
    private boolean marked = false;

    //Constructor assigning the value to the space
    //@param Value to store
    public BingoSpace(int value) {
        this.value = value;
    }

    //Returns the information about the BingoSpace as a String
    //@return String representing BingoSpace information
    public String spaceToString() {
        if(!marked) {
            if(value < 10) {
                return " " + value;
            }
            return "" + value;
        }
        return "XX";
    }

    //Marks the space
    public void mark() {
        marked = true;
    }

    //Returns the stored value
    public int getValue() {
        return value;
    }
}
