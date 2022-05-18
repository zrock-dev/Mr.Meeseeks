import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompareNumbersTest{
    GameController gameController = new GameController(new Printer());
    int hiddenNumber = 10;

    @Test
    void lessThan() {
        int testNumber = 5;
        boolean controlBoolean = (testNumber > hiddenNumber);
        boolean returnedBoolean = gameController.isTheHiddenNumber(testNumber, hiddenNumber);
        assertEquals(controlBoolean, returnedBoolean);
    }

    @Test
    void moreThan() {
        int testNumber = 20;
        boolean controlBoolean = (testNumber < hiddenNumber);
        boolean returnedBoolean = gameController.isTheHiddenNumber(testNumber, hiddenNumber);
        assertEquals(controlBoolean, returnedBoolean);
    }

    @Test
    void bothEqual(){
        int testNumber = 10;
        boolean controlBoolean = (testNumber == hiddenNumber);
        boolean returnedBoolean = gameController.isTheHiddenNumber(testNumber, hiddenNumber);
        assertEquals(controlBoolean, returnedBoolean);
    }
}