import java.util.InputMismatchException;
import java.util.Scanner;

public class Backend {
<<<<<<< Updated upstream
    Printer printer;

    Backend(Printer printer){  // Moved here to be able to use input number
        this.printer = printer;
=======
    int number,hiddennumber;

    Backend(){
        generateRandomNumber();

>>>>>>> Stashed changes
    }

    protected int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        int number;
        while(true)
        {
            try {
                printer.askForGuess();
                number=  scanner.nextInt();
                return number;
            }
            catch (InputMismatchException ex) {
                printer.ErrorMessage();
            }
        }
    }
    private int generateRandomNumber(){
        hiddennumber = (int) ((Math.random() * 100) + 1);
        return hiddennumber;
    }
    private boolean compareNumbers(int number,int hiddennumber){
        this.number= number;
        this.hiddennumber=hiddennumber;
        if (number == hiddennumber){
            return false;
        }if (number>hiddennumber)
        {
            System.out.println("The number is less than yours");
            return true;
        } else
        {
            System.out.println("The number is major than yours");
            return true;
        }
    }

    private void generateRandomNumber(){
        //logic
    }

    protected boolean compareNumber(int userNumber){
        // Logic
        return false; // just to have output
    }

    protected void runGame(){
        int plays = 0;
        while(plays != 3){ // Plays is the times the user will play the game
            generateRandomNumber();
            int userNumber = inputNumber();

            while(compareNumber(inputNumber())){ // Keeps going until the user guess the right number.
                userNumber = inputNumber();
            }

            plays++;
        }
    }
}
