import java.util.ArrayList;

public class BingoPattern {
    protected ArrayList<ArrayList<Coordinates>> validPatterns = new ArrayList<ArrayList<Coordinates>>();

    public boolean getBingo(BingoCard card) {
        ArrayList<Coordinates> markedSpaces = card.getMarkedSpaces();

        for(int i = 0; i < validPatterns.size(); i++) {
            ArrayList<Coordinates> currentPattern = validPatterns.get(i);
            ArrayList<Coordinates> testList = new ArrayList<Coordinates>();

            for(int j = 0; j < markedSpaces.size(); j++) {
                Coordinates currentMarkedSpace = markedSpaces.get(j);

                for(int k = 0; k < currentPattern.size(); k++) {
                    Coordinates currentCheckSpace = currentPattern.get(k);

                    if(currentMarkedSpace.getX() == currentCheckSpace.getX() && currentMarkedSpace.getY() == currentCheckSpace.getY()){
                        testList.add(currentPattern.get((k)));
                    }
                }
            }
            if(testList.size() == currentPattern.size()) {
                return true;
            }
        }
        return false;
    }
}
