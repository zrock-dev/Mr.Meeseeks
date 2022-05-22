public class GameRunner {
    Printer printer;
    int PLAYS_LIMIT;


    protected void runGame(){
        int plays = 0;
        while(plays != PLAYS_LIMIT){
            printer.showTitle(MAX_VALUE);
            int hiddenNumber = generateRandomNumber();

            int userInput = inputNumber();
            int numberOfTriesUntilGuess = 1;

            while(!isTheHiddenNumber(userInput, hiddenNumber)){
                userInput = inputNumber();
                numberOfTriesUntilGuess++;
            }
            printer.showNumberOfAttempts(numberOfTriesUntilGuess);
            plays++;
        }
    }
}
