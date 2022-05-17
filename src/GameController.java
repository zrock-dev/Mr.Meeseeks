import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {
    // All methods are protected in case the project will be more complex in the future.
    Printer printer;
    int LIMIT_NUMBER;
    int PLAYS_LIMIT;

    /* the limit of attempts and the Printer class are initialized in the constructor
    to be able to use their methods
     */
    GameController(Printer printer){
        this.printer = printer;
        LIMIT_NUMBER = 100;
        PLAYS_LIMIT = 3;
    }

    //Receive the number entered by the user
    private int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        int number;
        while(true){
            try {
                printer.askForGuess();
                return new Scanner(System.in).nextInt();
            } catch (InputMismatchException ex) {
                printer.ErrorMessage();
            }
        }
    }
    //Generate a random number
    private int generateRandomNumber(){
        return (int) ((Math.random() * LIMIT_NUMBER) + 1);
    }

    /*Checks if the number entered by the user is less than, greater than or equal
     to the randomly generated number and returns a boolean value
     */
    protected boolean compareNumbers(int userNumber, int hidden_number){
        if (userNumber == hidden_number){
            printer.showEquals();
            return false;
        }

        if (userNumber > hidden_number){
            printer.showLessThan();
        }else{
            printer.showMoreThan();
        }
        return true;
    }

    //this method implements the different methods of the classes to start the game
    protected void runGame(){
        int plays = 0;
        while(plays != PLAYS_LIMIT){
            printer.showTitle(LIMIT_NUMBER);
            int hidden_number = generateRandomNumber();

            int userNumber = inputNumber();
            int tries = 1;

            while(compareNumbers(userNumber, hidden_number)){
                userNumber = inputNumber();
                tries ++;
            }
            printer.showAttemptsNumber(tries);
            plays++;
        }
    }
}
