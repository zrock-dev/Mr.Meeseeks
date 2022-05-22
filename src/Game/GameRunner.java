package Game;

import UserView.Printer;

public class GameRunner {
    Printer printer;
    int PLAYS_LIMIT;
    GameController gameController;

    public GameRunner(){
        printer = new Printer();
        gameController = new GameController(printer);
    }


    public void runGame(){
        int plays = 0;
        while(plays != PLAYS_LIMIT){
            printer.showTitle(gameController.getMAX_VALUE());
            int hiddenNumber = gameController.generateRandomNumber();
            int userInput = gameController.inputNumber();
            int numberOfTriesUntilGuess = 1;

            while(!gameController.isTheHiddenNumber(userInput, hiddenNumber)){
                userInput = gameController.inputNumber();
                numberOfTriesUntilGuess++;
            }
            printer.showNumberOfAttempts(numberOfTriesUntilGuess);
            plays++;
        }
    }
}
