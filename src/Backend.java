import java.util.InputMismatchException;
import java.util.Scanner;

public class Backend {
    Printer printer;
    int LIMIT_NUMBER;
    int PLAYS_LIMIT;

    Backend(Printer printer){  // Moved here to be able to use input number
        this.printer = printer;
        LIMIT_NUMBER = 100;
        PLAYS_LIMIT = 3;
    }

    private int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        int number;
        while(true){
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

    private int generateRandomNumber(){
        return (int) ((Math.random() * LIMIT_NUMBER) + 1);
    }


    protected boolean compareNumbers(int userNumber, int hidden_number){
        // The boolean value is meant to control the guess loop.

        if (userNumber == hidden_number){
            printer.showEquals();
            return false;
        }

        if (userNumber > hidden_number){
            printer.showMoreThan();

        }else{
            printer.showLessThan();
        }
        return true; // The forced exit
    }

    protected void runGame(){
        int plays = 0;
        while(plays != PLAYS_LIMIT){ // Plays loop: is the # of times the user will play the game
            printer.showTitle(LIMIT_NUMBER);
            int hidden_number = generateRandomNumber();

            int userNumber = inputNumber();
            int tries = 1;

            while(compareNumbers(userNumber, hidden_number)){ // guess loop
                // Keeps going until the user guess the right number.
                userNumber = inputNumber();
                tries ++;
            }
            printer.showAttemptsNumber(tries);
            plays++;
        }
    }
}
