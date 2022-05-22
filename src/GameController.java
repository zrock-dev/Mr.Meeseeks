import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameController {

    // All methods are protected in case the project will be more complex in the future.
    Printer printer;
    int MAX_VALUE;
    Scanner scanner;
    Random random;

    /*  The limit of attempts and the Printer class are initialized in the constructor
        to be able to use their methods
     */
    GameController(Printer printer){
        this.printer = printer;
        scanner = new Scanner(System.in);
        random = new Random();
        MAX_VALUE = 100;
    }

    private int generateRandomNumber(){
        return random.nextInt(100);
    }

    //Receive the number entered by the user
    private int inputNumber(){
        try {
            printer.askForGuess();
            return scanner.nextInt();
        }catch (InputMismatchException stringInsteadOfInt){
            scanner.nextLine();
            return 0;
        }
    }

    protected boolean isTheHiddenNumber(int userInput, int hiddenNumber){
        // The boolean value is meant to control the guess loop.

        if (userInput == hiddenNumber){
            printer.showCongratulations();
            return true;
        } else{ checkFinals(userInput); }

        if (userInput < hiddenNumber){
            printer.showLessThan();
        }else{
            printer.showMoreThan();
        }
        return false;
    }

    private void checkFinals(int userInput) {
            if (userInput <= 0 || userInput >= (MAX_VALUE + 1)) {
            printer.errorMessage();
            }
    }

    //this method implements the different methods of the classes to start the game
}
