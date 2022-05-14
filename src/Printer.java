public class Printer {
    private final int CHARACTERS_HEIGHT; //To have a uniform size in the console.

    Printer(){
        CHARACTERS_HEIGHT = 50;
    }


    // This method shows the title at the start of the game.
    private void showTitle(){
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
        System.out.println("******** Guess the number between 1 - 100 ********");
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
    }

    // This method asks the user to show a title.
    protected void askForGuess(){
        System.out.println("*".repeat(CHARACTERS_HEIGHT));
        System.out.print("Enter a Number: "); // The input will be: Enter a number: 8
    }

    //One method is declared to return a message in case user's number is major than the mysterious number
    protected final String getMajorNumberMessage() {
        return "Your number is more than the mysterious number";
    }

    //One method is declared to return a message in case user's number is less than the mysterious number
    protected final String getLess_number_message() {
        return "Your number is less than the mysterious number";
    }

    //One method is declared in case the user's number is equals than de mysterious number
    protected final String getEquals_number_message(){
        return "Congratulations, you guessed the number";
    }

    protected void ErrorMessage(){
        System.out.println("You must enter an integer ");
    }
}
