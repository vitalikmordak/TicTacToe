import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class GameHistory {
    private String path = "D:/Java/TicTacToe/src/data/gameHistory.txt";

    void write(String gameResult, boolean draw) {
        TicTacToe ttt = TicTacToe.getInstance();
        StringBuilder builder = new StringBuilder(gameResult);
        builder.append("\nПервый игрок: ").append(TicTacToe.getPlayer1().getName());
        builder.append("\nВторой игрок: ").append(TicTacToe.getPlayer2().getName());
        String winner = draw ? "ДРУЖБА" : TicTacToe.getCurrentPlayer().getName();
        builder.append("\nПобедитель: ").append(winner).append("\n");
        builder.append("_____________________________________\n");
        try {
            Files.write(Paths.get(String.valueOf(path)), builder.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String read() {
        String s = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path).toAbsolutePath());
            s = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
