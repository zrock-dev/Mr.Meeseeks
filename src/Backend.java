import java.util.InputMismatchException;
import java.util.Scanner;

public class Backend {
    Printer printer;
    int LIMIT_NUMBER;
    int PLAYS_LIMIT;

    Backend(Printer printer){
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
        // The boolean value is meant to control the guess loop.

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
    // This method controls how many times the user will play the game.
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
