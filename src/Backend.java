import java.util.InputMismatchException;
import java.util.Scanner;

public class Backend {
    Printer printer;
    int hidden_number;
    int LIMIT_NUMBER;

    Backend(Printer printer){  // Moved here to be able to use input number
        this.printer = printer;
        LIMIT_NUMBER = 100;
        generateRandomNumber();
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

    private void generateRandomNumber(){
        hidden_number = (int) ((Math.random() * LIMIT_NUMBER) + 1);
    }


    private boolean compareNumbers(int userNumber){
        if (userNumber == hidden_number){
            printer.showEquals();
            return false;
        }

        if (userNumber > hidden_number){
            printer.showLessThan();

        }else{
           printer.showMoreThan();
        }
        return true; // The forced exit
    }

    protected void runGame(){
        int plays = 0;
        while(plays != 3){ // Plays is the # of times the user will play the game
            generateRandomNumber();
            int userNumber = inputNumber();

            int tries = 1;
            while(compareNumbers(userNumber)){ // Keeps going until the user guess the right number.
                userNumber = inputNumber();
                tries ++;
            }
            printer.showAttemptsNumber(tries);
            plays++;
        }
    }
}
