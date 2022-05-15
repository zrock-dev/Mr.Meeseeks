import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BackendTest {
    Backend backend = new Backend(new Printer());
    int hidden_number = 10;


    /*
        compareNumbers() Test:
            1  > 10  | returns true to keep the guess loop
            20 > 10  | returns true to keep the guess loop
            10 = 10  | returns false to stop the guess loop
    */
    @Test
    void lessThan() {
        int minorNumber = hidden_number - 5;
        assertTrue(backend.compareNumbers(minorNumber, hidden_number));
        // prints:
    }

    @Test
    void moreThan() {
        int minorNumber = hidden_number + 5;
        assertTrue(backend.compareNumbers(minorNumber, hidden_number));
    }

    @Test
    void bothEqual(){
        assertFalse(backend.compareNumbers(hidden_number, hidden_number));
    }
}