
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Backend backend  = new Backend(printer);

        backend.runGame();
    }
}
