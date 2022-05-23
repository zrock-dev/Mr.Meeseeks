package Game;

import UserView.Printer;

public class GameRunner {
    Printer printer;
    int PLAYS_LIMIT;
    GameController gameController;

    public GameRunner(){
        this.PLAYS_LIMIT = 3;
        printer = new Printer();
        gameController = new GameController(printer);
    }


    public void runGame(){
        int plays = 0;
        int hiddenNumber;
        int userInput;
        int numberOfTriesUntilGuess;
        while(plays != PLAYS_LIMIT){
            printer.showTitle(gameController.getMAX_VALUE());
            hiddenNumber = gameController.generateRandomNumber();
            userInput = gameController.inputNumber();
            numberOfTriesUntilGuess = 1;

            while(!gameController.isTheHiddenNumber(userInput, hiddenNumber)){
                userInput = gameController.inputNumber();
                numberOfTriesUntilGuess++;
            }
            printer.showNumberOfAttempts(numberOfTriesUntilGuess);
            plays++;
        }
    }
}
