import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiagPatternTest {
    @Test
    void testGetBingo() {
        DiagPattern bingoPattern = new DiagPattern();

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

        try {
            Assertions.assertFalse(!testOne);
        }catch(Exception e) {
            e.printStackTrace();
            Assertions.fail("Test One Not Expected To Fail");
        }

        try {
            Assertions.assertFalse(!testTwo);
        }catch(Exception e) {
            e.printStackTrace();
            Assertions.fail("Test Two Not Expected To Fail");
        }

        try {
            Assertions.assertFalse(testThree);
        }catch(Exception e) {
            e.printStackTrace();
            Assertions.fail("Test Three Expected To Fail");
        }
    }
}
