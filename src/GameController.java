import java.util.Scanner;

public class GameController {
    private GameHistory gameHistory = new GameHistory();
    private TicTacToe ttt = TicTacToe.getInstance();
    private Player player1 = TicTacToe.getPlayer1();
    private Player player2 = TicTacToe.getPlayer2();

    // Отображаем игровое меню
    void showMenu() {
        String history = gameHistory.read();
        String menu = "1 - Играть\n" + "2 - История\n" + "3 - Выход\n" + "Введите число и нажмите Enter:";
        System.out.println(menu);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case 1:
                    Game.setStart(true);
                    break;
                case 2:
                    System.out.println(history);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Вы ввели не допустимое число");
            }
        }

    }

    // Начало игры
    void startGame() {
        TicTacToe ttt = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        ttt.initBoard();
        System.out.println("Введите имя первого игрока:");
        player1.setName(scanner.next());
        System.out.println("Введите имя второго игрока:");
        player2.setName(scanner.next());
        while (!ttt.isWin() && !ttt.isBoardFull()) {
            ttt.printBoard();
            int x, y;
            do {
                System.out.println(TicTacToe.getCurrentPlayer().getName() + ", введите сначала № строки(начинается с 0)," +
                        " а затем номер столбца(начинается с 0):");
                x = scanner.nextInt();
                y = scanner.nextInt();
            } while ((!ttt.nextStep(x, y)));
            ttt.changePlayer();
        }

        ttt.changePlayer();
        boolean draw = ttt.isBoardFull() && !ttt.isWin();
        gameHistory.write(ttt.printBoard(), draw);
        if (draw) {
            System.out.println("НИЧЬЯ!");
        } else {
            System.out.println(TicTacToe.getCurrentPlayer().getName() + " - ПОБЕДИЛ(A)!");
        }
    }
}
