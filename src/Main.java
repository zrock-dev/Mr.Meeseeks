
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        GameController gameController = new GameController(printer);

        gameController.runGame();
    }
}
