import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean start = false;
    private static GameController gameController = new GameController();

    static void setStart(boolean start) {
        Game.start = start;
    }

    public static void main(String[] args) {
        gameController.showMenu();
        if (start) gameController.startGame(); // для первого запуска игры

        while (start) {
            System.out.println("Начать новую игру? 1 - да, 2 - нет");
            if (scanner.nextInt() == 1) gameController.startGame();
            else start = false;
        }
    }
}
