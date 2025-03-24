import java.util.ArrayList;

public class BingoPattern {
    protected ArrayList<ArrayList<Coordinates>> validPatterns;

    public boolean getBingo(BingoCard card) {
        ArrayList<Coordinates> markedSpaces = card.getMarkedSpaces();
        for(int i = 0; i < validPatterns.size(); i++) {
            ArrayList<Coordinates> currentPattern = validPatterns.get(i);
            for(int j = 0; j < markedSpaces.size(); j++) {
                Coordinates currentMarkedSpace = markedSpaces.get(j);
                for(int k = 0; k < currentPattern.size(); k++) {
                    Coordinates currentCheckSpace = currentPattern.get(k);
                    if(currentMarkedSpace.getX() == currentCheckSpace.getX() && currentMarkedSpace.getY() == currentCheckSpace.getY()){
                        currentPattern.remove(k);
                        if(currentPattern.isEmpty()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
