public class Printer {
    private final int CHARACTERS_HEIGHT; //To have a uniform size in the console.

    Printer(){
        CHARACTERS_HEIGHT = 50;
        showTitle(100);
    }

    protected void showAttemptsNumber(int count){
        System.out.println("You tried " + count + " times.");
    }

    // This method shows the title at the start of the game.
    private void showTitle(int numberLimit){
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
        System.out.println("******** Guess the number between 1 - "+numberLimit+" ********");
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
    }

    // This method asks the user to show a title.
    protected void askForGuess(){
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
        System.out.print("Enter a Number: "); // The input will be: Enter a number: 8
    }

    protected void ErrorMessage(){
        System.out.println("You must enter an integer ");
    }

    // In-game messages
    protected final void showMoreThan() {
        System.out.println("Your number is more than the mysterious number");
    }

    protected final void showLessThan() {
        System.out.println("Your number is less than the mysterious number");
    }

    protected final void showEquals(){
        System.out.println("Congratulations, you guessed the number");
    }
}
