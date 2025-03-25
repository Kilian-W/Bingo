import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColPatternTest {
    @Test
    void testGetBingo() {
        ColPattern bingoPattern = new ColPattern();

        ArrayList<Coordinates> caseOne = new ArrayList<Coordinates>();
        caseOne.add(new Coordinates(0,0));
        caseOne.add(new Coordinates(1,0));
        caseOne.add(new Coordinates(2,0));
        caseOne.add(new Coordinates(3,0));
        caseOne.add(new Coordinates(4,0));
        BingoCard testCardOne = new BingoCard();
        testCardOne.setMarkedSpaces(caseOne);
        boolean testOne = bingoPattern.getBingo(testCardOne);

        ArrayList<Coordinates> caseTwo = new ArrayList<Coordinates>();
        caseTwo.add(new Coordinates(0,3));
        caseTwo.add(new Coordinates(1,3));
        caseTwo.add(new Coordinates(2,3));
        caseTwo.add(new Coordinates(3,3));
        caseTwo.add(new Coordinates(4,3));
        BingoCard testCardTwo = new BingoCard();
        testCardTwo.setMarkedSpaces(caseTwo);
        boolean testTwo = bingoPattern.getBingo(testCardTwo);

        ArrayList<Coordinates> caseThree = new ArrayList<Coordinates>();
        caseThree.add(new Coordinates(0,4));
        caseThree.add(new Coordinates(1,4));
        caseThree.add(new Coordinates(2,4));
        caseThree.add(new Coordinates(3,4));
        caseThree.add(new Coordinates(4,4));
        BingoCard testCardThree = new BingoCard();
        testCardThree.setMarkedSpaces(caseThree);
        boolean testThree = bingoPattern.getBingo(testCardThree);

        ArrayList<Coordinates> caseFour = new ArrayList<Coordinates>();
        caseFour.add(new Coordinates(0,0));
        caseFour.add(new Coordinates(0,1));
        caseFour.add(new Coordinates(0,2));
        caseFour.add(new Coordinates(0,3));
        caseFour.add(new Coordinates(0, 4));
        BingoCard testCardFour = new BingoCard();
        testCardFour.setMarkedSpaces(caseFour);
        boolean testFour = bingoPattern.getBingo(testCardFour);

        ArrayList<Coordinates> caseFive = new ArrayList<Coordinates>();
        caseFive.add(new Coordinates(0,1));
        caseFive.add(new Coordinates(2,1));
        caseFive.add(new Coordinates(3,1));
        caseFive.add(new Coordinates(4, 1));
        BingoCard testCardFive = new BingoCard();
        testCardFive.setMarkedSpaces(caseFive);
        boolean testFive = bingoPattern.getBingo(testCardFive);

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
            Assertions.assertFalse(!testThree);
        }catch(Exception e) {
            e.printStackTrace();
            Assertions.fail("Test Three Not Expected To Fail");
        }

        try {
            Assertions.assertFalse(testFour);
        }catch(Exception e) {
            Assertions.fail("Test Four Expected To Fail");
        }

        try {
            Assertions.assertFalse(testFive);
        }catch(Exception e) {
            Assertions.fail("Test Four Expected To Fail");
        }
        
    }
}
