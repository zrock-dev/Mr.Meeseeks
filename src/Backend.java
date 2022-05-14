import java.util.InputMismatchException;
import java.util.Scanner;

public class Backend {
    protected int inputNumber(Printer printer){
        Scanner scanner = new Scanner(System.in);
        int number;
        while(true)
        {

            try {
                printer.askForGuess();
                number=  scanner.nextInt();
                return number;
            }
            catch (InputMismatchException ex) {
                printer.ErrorMessage();

            }
        }
    }
}
