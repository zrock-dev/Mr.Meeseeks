import Game.GameRunner;

/**
 * The Main class.
 * This class is used to instance the GameRunner class and
 * start with the game in console.
 *
 * @see GameRunner
 * @author Mr.Meeseeks
 */
public class Main {
    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();
        gameRunner.runGame();
    }
}
