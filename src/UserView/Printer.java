package UserView;

/**
 * The class of aesthetics.
 * This class contains all methods that the game
 * will use to print different types of messages according
 * to the situation of the game: the title, user's attempts,
 * input requests and the messages for notify the comparison between
 * user's number and generated number.
 *
 * @author      Mr.Meeseeks
 */
public class Printer {
    // All methods are protected in case the project will be more complex in the future.
    private final int CHARACTERS_HEIGHT; //To have a uniform size in the console.

    /**
     * The constructor is created beside a specific value for the
     * CHARACTERS_HEIGHT variable, in this way all the size-in-screen game will be set
     * by only a number.
     */
    public Printer(){
        CHARACTERS_HEIGHT = 50;
    }

    /**
     * Method to show user's attempts number.
     * Prints a message that notify the user the number of attempts for
     * guess the generated number in one game.
     *
     * @param totalCount is the int parameter that represents the attempts in the message.
     */
    public void showNumberOfAttempts(int totalCount){
        System.out.println("You tried " + totalCount + " times.");
    }

    /**
     * Shows the game's title.
     * Starts the game with a message that contains
     * the lesser number in the game: 1, and the greatest
     * one: variable by the code, the beginning and ending of the message
     * are delimited by *.
     *
     * @param numberLimit is the limit for the generation of the mysterious number.
     */
    public void showTitle(int numberLimit){
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
        System.out.println("******** Guess the number between 1 - "+ numberLimit +" ********");
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
    }

    /**
     * Prints a request of an input number.
     * Makes a pass line, repeats *'s according to the
     * defined variable and ask the user for enter a number.
     */
    public void askForGuess(){
        System.out.println("\n" + "*".repeat(CHARACTERS_HEIGHT));
        System.out.print("Enter a number: "); // The input will be: Enter a number: 8
    }

    /**
     * Prints a response of an input error.
     * This method will be call if the user introduces an incorrect value like a String.
     */
    public final void errorMessage(){
        System.out.println("You must enter a correct value");
    }

    /**
     * Prints the possibility of greater number.
     * In case the user introduces a number that is greater
     * than the generated number, this method will be called.
     */
    public final void showMoreThan() {
        System.out.println("Enter a higher number");
    }

    /**
     * Prints the possibility of lesser number.
     * In case the user introduces a number that is lesser
     * than the generated number, this method will be called.
     */
    public final void showLessThan() {
        System.out.println("Enter a smaller number");
    }

    /**
     * Prints the possibility of equals number.
     * In case the user introduces a number that is equals to
     * the generated number, a message notifying the victory
     * will appear.
     */
    public final void showCongratulations(){
        System.out.println("Congratulations, you guessed the hidden number");
    }
}
