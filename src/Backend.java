import java.util.InputMismatchException;
import java.util.Scanner;

public class Backend {
    Printer printer;

    Backend(Printer printer){  // Moved here to be able to use input number
        this.printer = printer;
    }

    protected int inputNumber(){
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

    private void generateRandomNumber(){
        //logic
    }

    protected boolean compareNumber(int userNumber){
        // Logic
        return false; // just to have output
    }

    protected void runGame(){
        int plays = 0;
        while(plays != 3){ // Plays is the times the user will play the game
            generateRandomNumber();
            int userNumber = inputNumber();

            while(compareNumber(inputNumber())){ // Keeps going until the user guess the right number.
                userNumber = inputNumber();
            }

            plays++;
        }
    }
}
