import java.util.ArrayList;

public class RowPattern extends BingoPattern {
    
    public RowPattern() {
        for(int i = 0; i < 5; i++) {
            ArrayList<Coordinates> newPattern = new ArrayList<Coordinates>();
            for(int j = 0; j < 5; j++) {
                newPattern.add(new Coordinates(i, j));
            }
            validPatterns.add(newPattern);
        }
    }
}
