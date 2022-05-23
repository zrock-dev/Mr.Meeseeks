package Game;
import UserView.Printer;

public class GameRunner {
    protected Printer printer;
    protected GameController gameController;
    private final int PLAYS_LIMIT;

    public GameRunner(){
        PLAYS_LIMIT = 3;
        printer = new Printer();
        gameController = new GameController(printer);
    }


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
