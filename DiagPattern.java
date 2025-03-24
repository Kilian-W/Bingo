import java.util.ArrayList;

public class DiagPattern extends BingoPattern {
    
    public DiagPattern() {
        ArrayList<Coordinates> diagOne = new ArrayList<Coordinates>();
        ArrayList<Coordinates> diagTwo = new ArrayList<Coordinates>();
        for(int i = 0; i < 5; i++) {
            diagOne.add(new Coordinates(i, i));
            diagTwo.add(new Coordinates(i, 4 - i));
        }
        validPatterns.add(diagOne);
        validPatterns.add(diagTwo);
    }
}
