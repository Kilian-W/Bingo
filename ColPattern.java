import java.util.ArrayList;

public class ColPattern extends BingoPattern {
    
    public ColPattern() {
        for(int i = 0; i < 5; i++) {
            ArrayList<Coordinates> newPattern = new ArrayList<Coordinates>();
            for(int j = 0; j < 5; j++) {
                newPattern.add(new Coordinates(j, i));
            }
            validPatterns.add(newPattern);
        }
    }
}
