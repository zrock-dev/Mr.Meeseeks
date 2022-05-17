import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BackendTest {
    Backend backend = new Backend(new Printer());
    int hiddenNumber = 10;


    /*
        compareNumbers() Test:
            1  > 10  | returns true to keep the guess loop
            20 > 10  | returns true to keep the guess loop
            10 = 10  | returns false to stop the guess loop
    */
    @Test
    void lessThan() {
        int minorNumber = hiddenNumber - 5;
        assertTrue(backend.compareNumbers(minorNumber, hiddenNumber));
        // prints:
    }

    @Test
    void moreThan() {
        int moreThanHiddenNumber = hiddenNumber + 5;
        assertTrue(backend.compareNumbers(moreThanHiddenNumber, hiddenNumber));
    }

    @Test
    void bothEqual(){
        assertFalse(backend.compareNumbers(hiddenNumber, hiddenNumber));
    }
}