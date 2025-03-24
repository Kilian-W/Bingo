import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class RowPatternTest {
    @Test
    void testGetBingo() {
        ArrayList<Coordinates> caseOne = new ArrayList<Coordinates>();
        caseOne.add(new Coordinates(0,0));
        caseOne.add(new Coordinates(0,1));
        caseOne.add(new Coordinates(0,2));
        caseOne.add(new Coordinates(0,3));
        caseOne.add(new Coordinates(0,4));

        ArrayList<Coordinates> caseTwo = new ArrayList<Coordinates>();
        ArrayList<Coordinates> caseThree = new ArrayList<Coordinates>();
        ArrayList<Coordinates> caseFour = new ArrayList<Coordinates>();

        RowPattern bingoPattern = new RowPattern();
    }
}
