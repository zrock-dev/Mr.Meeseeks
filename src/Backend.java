import java.util.InputMismatchException;
import java.util.Scanner;

public class Backend {
    protected int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        int number;
        while(true)
        {

            try {
                //message "Enter a Number"
                number=  scanner.nextInt();
                return number;
            }
            catch (InputMismatchException ex) {
                //message "You must enter an integer"
            }
        }
    }

    //One method is declared to return a message in case user's number is major than the mysterious number
    protected final String getMajorNumberMessage() {
        return "Your number is major than the mysterious number";
    }

    //One method is declared to return a message in case user's number is less than the mysterious number
    protected final String getLess_number_message() {
        return "Your number is less than the mysterious number";
    }

    //One method is declared in case the user's number is equals than de mysterious number
    protected final String getEquals_number_message(){
        return "Congratulations, you guessed the number";
    }

}
