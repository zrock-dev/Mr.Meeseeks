import java.util.InputMismatchException;
import java.util.Scanner;

public class Backend {
    Printer printer;
    int LIMIT_NUMBER;
    int PLAYS_LIMIT;
    Scanner sn;

    Backend(Printer printer){  // Moved here to be able to use input number
        this.printer = printer;
        LIMIT_NUMBER = 100;
        PLAYS_LIMIT = 3;
        sn = new Scanner(System.in);
    }

    private int inputNumber(){
        boolean condition = true;

        while(condition){
            try {
                printer.askForGuess();
                condition = false;
                return sn.nextInt();
            } catch (InputMismatchException ex) {
                printer.ErrorMessage();
                sn.next();
            }
        }

        return 0;
    }

    private int generateRandomNumber(){
        return (int) ((Math.random() * LIMIT_NUMBER) + 1);
    }


    protected boolean compareNumbers(int userNumber, int hiddenNumber){
        // The boolean value is meant to control the guess loop.

        if (userNumber == hiddenNumber){
            printer.showEquals();
            return false;
        } else if (userNumber == 0) {
            return true;
        }

        if (userNumber < hiddenNumber){
            printer.showLessThan();
        }else{
            printer.showMoreThan();
        }
        return true; // The forced exit
    }

    protected void runGame(){
        int plays = 0;
        while(plays != PLAYS_LIMIT){ // Plays loop: is the # of times the user will play the game
            printer.showTitle(LIMIT_NUMBER);
            int hiddenNumber = generateRandomNumber();

            int userNumber = inputNumber();
            int tries = 1;

            while(compareNumbers(userNumber, hiddenNumber)){ // guess loop
                // Keeps going until the user guess the right number.
                userNumber = inputNumber();
                tries ++;
            }
            printer.showAttemptsNumber(tries);
            plays++;
        }
    }
}
