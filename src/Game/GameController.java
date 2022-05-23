package Game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import UserView.Printer;

public class GameController {

    protected Printer printer;
    protected Scanner scanner;
    protected Random random;

    private final int MAX_VALUE;
    boolean isTheHiddenNumber;
    boolean validNumber;


    protected GameController(Printer printer){
        this.printer = printer;
        scanner = new Scanner(System.in);
        random = new Random();
        MAX_VALUE = 100;
    }

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
