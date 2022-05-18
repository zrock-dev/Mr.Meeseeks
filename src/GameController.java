import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameController {

    // All methods are protected in case the project will be more complex in the future.
    Printer printer;
    int MAX_VALUE;
    int PLAYS_LIMIT;
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
        PLAYS_LIMIT = 3;

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

    //Generate a random number
    private int generateRandomNumber(){
        return random.nextInt(100);
    }

    /*Checks if the number entered by the user is less than, greater than or equal
     to the randomly generated number and returns a boolean value
     */

    protected boolean isTheHiddenNumber(int userInput, int hiddenNumber){
        // The boolean value is meant to control the guess loop.

        if (userInput == hiddenNumber){
            printer.showCongratulations();
            return true;

        } else if (userInput <= 0 || userInput >= (MAX_VALUE + 1)) {
            printer.errorMessage();
            return false;
        }

        if (userInput < hiddenNumber){
            printer.showLessThan();
        }else{
            printer.showMoreThan();
        }
        return false;
    }

    //this method implements the different methods of the classes to start the game
    protected void runGame(){
        int plays = 0;
        while(plays != PLAYS_LIMIT){
            printer.showTitle(MAX_VALUE);
            int hiddenNumber = generateRandomNumber();

            int userInput = inputNumber();
            int numberOfTriesUntilGuess = 1;

            while(!isTheHiddenNumber(userInput, hiddenNumber)){
                userInput = inputNumber();
                numberOfTriesUntilGuess++;
            }
            printer.showNumberOfAttempts(numberOfTriesUntilGuess);
            plays++;
        }
    }
}
