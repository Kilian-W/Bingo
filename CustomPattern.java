import java.util.ArrayList;

public class CustomPattern extends BingoPattern {
    
    public void insertCustomPattern(ArrayList<Coordinates> newPattern) {
        validPatterns.add(newPattern);
    }
}
