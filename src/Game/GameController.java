package Game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import UserView.Printer;

public class GameController {

    // All methods are protected in case the project will be more complex in the future.
    Printer printer;
    int MAX_VALUE;
    Scanner scanner;
    Random random;

    /*  The limit of attempts and the UserView.Printer class are initialized in the constructor
        to be able to use their methods
     */
    public GameController(Printer printer){
        this.printer = printer;
        scanner = new Scanner(System.in);
        random = new Random();
        MAX_VALUE = 100;
    }

    protected int generateRandomNumber(){
        return random.nextInt(100);
    }

    //Receive the number entered by the user
    protected int inputNumber(){
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
        boolean isHidden = false;
        if (userInput == hiddenNumber){
            printer.showCongratulations();
            isHidden = true;
        }

        if (isNumberInRange(userInput)) {
            if (userInput > hiddenNumber) {
                printer.showLessThan();
            }
            else
            {
                printer.showMoreThan();
            }
        }
        return isHidden;

    }
    public boolean isNumberInRange(int userInput){
        boolean validNumber;
            if (userInput > 0 && userInput < (MAX_VALUE + 1))
            {
             validNumber = true;
            }
            else {
                validNumber = false;
                printer.errorMessage();
            }
        return validNumber;
        }



    protected int getMAX_VALUE(){
        return MAX_VALUE;
    }

    //this method implements the different methods of the classes to start the game
}
