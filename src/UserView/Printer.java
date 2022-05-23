package UserView;

public class Printer {
    // All methods are protected in case the project will be more complex in the future.
    private final int CHARACTERS_HEIGHT; //To have a uniform size in the console.

    // Defining the size of the game in screen, 50 characters in this case.
    public Printer(){
        CHARACTERS_HEIGHT = 50;
    }

    // Method to show user's attempts number.
    public void showNumberOfAttempts(int totalCount){
        System.out.println("You tried " + totalCount + " times.");
    }

    /**
     *
     * @param numberLimit is a good boy.
     */
    public void showTitle(int numberLimit){
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
        System.out.println("******** Guess the number between 1 - "+ numberLimit +" ********");
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
    }

    public void askForGuess(){
        System.out.println("\n" + "*".repeat(CHARACTERS_HEIGHT));
        System.out.print("Enter a number: "); // The input will be: Enter a number: 8
    }



    public final void errorMessage(){
        System.out.println("You must enter a correct value");
    }
    public final void showMoreThan() {
        System.out.println("Enter a higher number");
    }
    public final void showLessThan() {
        System.out.println("Enter a smaller number");
    }
    public final void showCongratulations(){
        System.out.println("Congratulations, you guessed the hidden number");
    }
}
