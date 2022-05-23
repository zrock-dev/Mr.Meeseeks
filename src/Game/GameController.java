package Game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import UserView.Printer;

/**
 * This class controls all the parameters of the code.
 * This class controls the comparison between hidden number and the user's number,
 * the range of the user's number, gives a random number for the hidden number,
 * receives a number from the user.
 *
 * @author      Mr.Meeseeks
 */
public class GameController {

    protected Printer printer;
    protected Scanner scanner;
    protected Random random;

    private final int MAX_VALUE;
    boolean isTheHiddenNumber;
    boolean validNumber;

    /**
     * The constructor was created to instantiate Random and Scanner,
     * also gives a final value to MAX_VALUE.
     *
     * @param printer calls the Printer class to show the respective message
     */
    protected GameController(Printer printer){
        this.printer = printer;
        scanner = new Scanner(System.in);
        random = new Random();
        MAX_VALUE = 100;
    }

    /**
     * This method generates a random number.
     *
     * @return returns random integer within the range in MAX_VALUE
     */
    protected int generateRandomNumber(){
        return random.nextInt(MAX_VALUE);
    }


    /**
     *Prevent user from entering characters
     *
     * @return returns a value 0, represent a value that cannot be entered by the user
     */
    protected int inputNumber(){
        try {
            printer.askForGuess();
            return scanner.nextInt();
        }catch (InputMismatchException stringInsteadOfInt){
            scanner.nextLine();
            return 0;
        }
    }

    /**
     * Compare the number entered by the user
     *
     * @param userInput is the number entered by the user
     * @param hiddenNumber is the hidden number
     * @return returns a boolean value for the second while of the
     *      runGame method of the GameRunner class.
     */
    protected boolean isTheHiddenNumber(int userInput, int hiddenNumber){
        isTheHiddenNumber = false;

        if (userInput == hiddenNumber){
            printer.showCongratulations();
            isTheHiddenNumber = true;
        }

        if (isNumberInRange(userInput) && !isTheHiddenNumber) {
            if (userInput > hiddenNumber) {
                printer.showLessThan();
            } else {
                printer.showMoreThan();
            }
        }
        return isTheHiddenNumber;
    }

    /**
     * Prevents the user from entering a number outside the range of 0 - 100
     *
     * @param userInput is the number entered by the user
     * @return returns a boolean value for the second if of the isTheHiddenNumber method
     */
    public boolean isNumberInRange(int userInput){
        if (userInput > 0 && userInput < (MAX_VALUE + 1)) {
            validNumber = true;
        } else {
            validNumber = false;
            printer.errorMessage();
        }
        return validNumber;
    }

    /**
     *This is a getter method for the MAX_VALUE variable
     *
     * @return returns the variable MAX_VALUE of type int
     */
    protected int getMAX_VALUE(){
        return MAX_VALUE;
    }

    //7
}
