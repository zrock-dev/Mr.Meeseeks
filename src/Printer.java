public class Printer {
    // All methods are in protected in case the project will be more complex in the future.
    private final int CHARACTERS_HEIGHT; //To have a uniform size in the console.

    // Defining the size of the game in screen, 50 characters in this case.
    Printer(){
        CHARACTERS_HEIGHT = 50;
    }

    // Method to show user's attempts number.
    protected void showAttemptsNumber(int count){
        System.out.println("You tried " + count + " times.");
    }

    // This method shows the title at the start of the game.
    protected void showTitle(int numberLimit){
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
        System.out.println("******** Guess the number between 1 - "+ numberLimit +" ********");
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
    }

    // This method asks the user for a number.
    protected void askForGuess(){
        System.out.println("\n" + "*".repeat(CHARACTERS_HEIGHT));
        System.out.print("Enter a number: "); // The input will be: Enter a number: 8
    }

    // Method defined to show a message about out of range input .
    protected void ErrorMessage(){
        System.out.println("You must enter an integer");
    }

    // In-game messages to show each possibility resultant of comparing the numbers.
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
