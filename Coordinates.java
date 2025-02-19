/*
 * A class representing a 2 integer coordinate
 * Author: Kilian Wilinski
 * Date: 2/18/2025
 */

public class Coordinates {
    private int X;
    private int Y;

    //Constructor for the Coordinates assigning the values
    //@param X-coordinate, Y-coordinate
    public Coordinates(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    //Returns X
    public int getX() {
        return X;
    }

    //Returns Y
    public int getY() {
        return Y;
    }
}
