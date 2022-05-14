public class MessageToUser {

    //One method is declared to return a message in case user's number is major than the mysterious number
    public final String getMajorNumberMessage() {
        return "Your number is major than the mysterious number";
    }

    //One method is declared to return a message in case user's number is less than the mysterious number
    public final String getLess_number_message() {
        return "Your number is less than the mysterious number";
    }

    //One method is declared in case the user's number is equals than de mysterious number
    public final String getEquals_number_message(){
        return "Congratulations, you guessed the number";
    }
}

