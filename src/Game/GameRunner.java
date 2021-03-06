package Game;
import UserView.Printer;

/**
 * This class is the playing part of the game. It controls the number
 * of times the user is going to play.
 * This class communicates with GameController.
 *<p>
 * @author Mr.Meeseeks
 */
public class GameRunner {
    protected Printer printer;
    protected GameController gameController;
    private final int PLAYS_LIMIT;

    /**
     * This constructor is mainly used to give values to the attributes
     * in the class.
     *<p>
     * @see GameController GameController
     * @see Printer Printer
     */
    public GameRunner(){
        PLAYS_LIMIT = 3;
        printer = new Printer();
        gameController = new GameController(printer);
    }


    /**
     *This method is responsible for combining different methods to run
     * the game, making use of control structures.
     *<p>
     * The method uses a for loop to control the number of times the user
     * has to play the game, within the for loop the variables take returns
     * by calling the methods of other classes, it also has a while structure
     * where if the condition is met, the user must enter another number
     * again , and it also prints on the screen,
     * the attempts in which the user had to find the random number.
     */
    public void runGame(){
        int hiddenNumber;
        int userInput;
        int numberOfTriesUntilGuess;

        for (int plays = 0; plays <= PLAYS_LIMIT; plays++) {
            printer.showTitle(gameController.getMAX_VALUE());
            hiddenNumber = gameController.generateRandomNumber();
            userInput = gameController.inputNumber();
            numberOfTriesUntilGuess = 1;

            while(!gameController.isTheHiddenNumber(userInput, hiddenNumber)){
                userInput = gameController.inputNumber();
                numberOfTriesUntilGuess++;
            }
            printer.showNumberOfAttempts(numberOfTriesUntilGuess);
        }
    }
}
