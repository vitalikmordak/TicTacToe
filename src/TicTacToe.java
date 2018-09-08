public class TicTacToe {
    private static TicTacToe ticTacToe;
    private char[][] board;
    private static Player currentPlayer;
    private static Player player1;
    private static Player player2;

    public static TicTacToe getInstance() {
        if (ticTacToe == null)
            ticTacToe = new TicTacToe();
        return ticTacToe;
    }

    public static Player getPlayer1() {
        if (player1 == null) {
            player1 = new Player("", 'X');
        }
        return player1;
    }

    public static Player getPlayer2() {
        if (player2 == null) {
            player2 = new Player("", 'O');
        }
        return player2;
    }

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = player1;
    }

    public void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }
    }

    public String printBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append("+---+---+---+\n");
            for (int j = 0; j < 3; j++) {
                builder.append("| ").append(board[i][j]).append(" ");
            }
            builder.append("|\n");
        }
        builder.append("+---+---+---+");
        System.out.println(builder.toString());
        return builder.toString();
    }

    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.')
                    isFull = false;
            }
        }
        return isFull;
    }

    public boolean isWin() {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (checkCells(board[i][0], board[i][1], board[i][2]))
                return true;
            //Check columns
            if (checkCells(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return checkCells(board[0][0], board[1][1], board[2][2]) || checkCells(board[0][2], board[1][1], board[2][0]);

    }

    public void changePlayer() {
        if (currentPlayer == player1) currentPlayer = player2;
        else currentPlayer = player1;
    }

    public boolean nextStep(int x, int y) {
        try {
            if (board[x][y] == 'X' || board[x][y] == 'O') {
                System.out.println("Нельзя ходить в уже заполненую ячейку. Выберите другую");
                return false;
            } else if (board[x][y] == '.') {
                board[x][y] = currentPlayer.getMark();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Вы поставили " + currentPlayer.getName() + " вне поля");
        }
        return false;
    }

    private boolean checkCells(char c1, char c2, char c3) {
        return c1 != '.' && c1 == c2 && c2 == c3;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

}
