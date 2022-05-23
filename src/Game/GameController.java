package Game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import UserView.Printer;

/**
 * This class controls all the parameters of the code.
 * This class controls the comparison between hidden number and the user´s number,
 * the range of the user´s number, gives a random number for the hidden number,
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
     * Class' constructor
     * The constructor was created to instantiate Random and Scanner,
     * also gives a number for MAX_VALUE.
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
     * Generates a random number.
     *
     * @return returns random with the random number in MAX_VALUE
     */
    protected int generateRandomNumber(){
        return random.nextInt(MAX_VALUE);
    }


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
        isTheHiddenNumber = false;

        if (userInput == hiddenNumber){
            printer.showCongratulations();
            isTheHiddenNumber = true;
        }

        if (isNumberInRange(userInput) && !isTheHiddenNumber) {
            if (userInput > hiddenNumber) {
                printer.showLessThan();
            }
            else
            {
                printer.showMoreThan();
            }
        }
        return isTheHiddenNumber;
    }

    public boolean isNumberInRange(int userInput){
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

    //7
}
