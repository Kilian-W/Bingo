import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class RowPatternTest {
    @Test
    void testGetBingo() {

        RowPattern bingoPattern = new RowPattern();

        ArrayList<Coordinates> caseOne = new ArrayList<Coordinates>();
        caseOne.add(new Coordinates(0,0));
        caseOne.add(new Coordinates(0,1));
        caseOne.add(new Coordinates(0,2));
        caseOne.add(new Coordinates(0,3));
        caseOne.add(new Coordinates(0,4));
        BingoCard testCardOne = new BingoCard();
        testCardOne.setMarkedSpaces(caseOne);
        boolean testOne = bingoPattern.getBingo(testCardOne);

        ArrayList<Coordinates> caseTwo = new ArrayList<Coordinates>();
        caseTwo.add(new Coordinates(2,0));
        caseTwo.add(new Coordinates(2,1));
        caseTwo.add(new Coordinates(2,2));
        caseTwo.add(new Coordinates(2,3));
        caseTwo.add(new Coordinates(2,4));
        BingoCard testCardTwo = new BingoCard();
        testCardTwo.setMarkedSpaces(caseTwo);
        boolean testTwo = bingoPattern.getBingo(testCardTwo);

        ArrayList<Coordinates> caseThree = new ArrayList<Coordinates>();
        caseThree.add(new Coordinates(4,0));
        caseThree.add(new Coordinates(4,1));
        caseThree.add(new Coordinates(4,2));
        caseThree.add(new Coordinates(4,3));
        caseThree.add(new Coordinates(4,4));
        BingoCard testCardThree = new BingoCard();
        testCardThree.setMarkedSpaces(caseThree);
        boolean testThree = bingoPattern.getBingo(testCardThree);

        ArrayList<Coordinates> caseFour = new ArrayList<Coordinates>();
        caseFour.add(new Coordinates(0,0));
        caseFour.add(new Coordinates(0,1));
        caseFour.add(new Coordinates(0,2));
        caseFour.add(new Coordinates(0,3));
        BingoCard testCardFour = new BingoCard();
        testCardFour.setMarkedSpaces(caseFour);
        boolean testFour = bingoPattern.getBingo(testCardFour);

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
        
    }
}
