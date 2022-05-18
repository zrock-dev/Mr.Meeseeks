import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

    // All methods are protected in case the project will be more complex in the future.
    Printer printer;
    int LIMIT_NUMBER;
    int PLAYS_LIMIT;
    Scanner scanner;

    /*  The limit of attempts and the Printer class are initialized in the constructor
        to be able to use their methods
     */
    GameController(Printer printer){
        this.printer = printer;
        LIMIT_NUMBER = 100;
        PLAYS_LIMIT = 3;
        scanner = new Scanner(System.in);
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
        return (int) ((Math.random() * LIMIT_NUMBER) + 1);
    }

    /*Checks if the number entered by the user is less than, greater than or equal
     to the randomly generated number and returns a boolean value
     */
    protected boolean isTheHiddenNumber(int userInput, int hiddenNumber){
        // The boolean value is meant to control the guess loop.

        if (userInput == hiddenNumber){
            printer.showCongratulations();
            return true;

        } else if (userInput == 0) {
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
            printer.showTitle(LIMIT_NUMBER);
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
