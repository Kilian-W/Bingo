import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class CustomPatternTest {
    @Test
    void testGetBingo() {
        CustomPattern bingoPatternOne = new CustomPattern();
        ArrayList<Coordinates> patternOne = new ArrayList<Coordinates>();
        patternOne.add(new Coordinates(4, 0));
        patternOne.add(new Coordinates(4, 1));
        patternOne.add(new Coordinates(4, 2));
        patternOne.add(new Coordinates(4, 3));
        patternOne.add(new Coordinates(4, 4));
        patternOne.add(new Coordinates(3, 2));
        patternOne.add(new Coordinates(2, 2));
        patternOne.add(new Coordinates(1, 2));
        patternOne.add(new Coordinates(0, 2));

        CustomPattern bingoPatternTwo = new CustomPattern();
        ArrayList<Coordinates> patternTwo = new ArrayList<Coordinates>();
        patternTwo.add(new Coordinates(4, 0));
        patternTwo.add(new Coordinates(4, 1));
        patternTwo.add(new Coordinates(4, 2));
        patternTwo.add(new Coordinates(4, 3));
        patternTwo.add(new Coordinates(4, 4));
        patternTwo.add(new Coordinates(0, 0));
        patternTwo.add(new Coordinates(0, 1));
        patternTwo.add(new Coordinates(0, 2));
        patternTwo.add(new Coordinates(0, 3));
        patternTwo.add(new Coordinates(0, 4));
        patternTwo.add(new Coordinates(1, 0));
        patternTwo.add(new Coordinates(2, 0));
        patternTwo.add(new Coordinates(3, 0));
        patternTwo.add(new Coordinates(1, 4));
        patternTwo.add(new Coordinates(2, 4));
        patternTwo.add(new Coordinates(3, 4));


        ArrayList<Coordinates> caseOne = new ArrayList<Coordinates>();
        caseOne.add(new Coordinates(4,4));
        caseOne.add(new Coordinates(3,3));
        caseOne.add(new Coordinates(2,2));
        caseOne.add(new Coordinates(1,1));
        caseOne.add(new Coordinates(0,0));
        BingoCard testCardOne = new BingoCard();
        testCardOne.setMarkedSpaces(caseOne);
        boolean testOne = bingoPattern.getBingo(testCardOne);

        ArrayList<Coordinates> caseTwo = new ArrayList<Coordinates>();
        caseTwo.add(new Coordinates(0,4));
        caseTwo.add(new Coordinates(1,3));
        caseTwo.add(new Coordinates(2,2));
        caseTwo.add(new Coordinates(3,1));
        caseTwo.add(new Coordinates(4,0));
        BingoCard testCardTwo = new BingoCard();
        testCardTwo.setMarkedSpaces(caseTwo);
        boolean testTwo = bingoPattern.getBingo(testCardTwo);

        ArrayList<Coordinates> caseThree = new ArrayList<Coordinates>();
        caseThree.add(new Coordinates(2,0));
        caseThree.add(new Coordinates(2,1));
        caseThree.add(new Coordinates(2,2));
        caseThree.add(new Coordinates(2,3));
        caseThree.add(new Coordinates(2,4));
        BingoCard testCardThree = new BingoCard();
        testCardThree.setMarkedSpaces(caseThree);
        boolean testThree = bingoPattern.getBingo(testCardThree);
    }
}
