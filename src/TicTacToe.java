import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            // Initialize the game board
            char[][] board = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
            };

            char currentPlayer = 'X';
            boolean gameWon = false;
            int moves = 0;

            System.out.println("Let's play Tic-Tac-Toe!");

            // Main game loop
            while (!gameWon && moves < 9) {
                displayBoard(board);
                int[] move = getPlayerMove(scanner, currentPlayer);
                int row = move[0];
                int col = move[1];

                // Check if the selected cell is valid
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    moves++;

                    // Check if the current player has won
                    if (checkWin(board, currentPlayer)) {
                        displayBoard(board);
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameWon = true;
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            if (!gameWon) {
                displayBoard(board);
                System.out.println("It's a draw!");
            }

            // Ask if players want to play again
            System.out.print("Play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thanks for playing Tic-Tac-Toe!");
        scanner.close();
    }

    // Display the Tic-Tac-Toe board
    private static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Get a player's move (row and column)
    private static int[] getPlayerMove(Scanner scanner, char player) {
        int[] move = new int[2];
        System.out.print("Player " + player + ", enter your move (row and column): ");
        move[0] = scanner.nextInt();
        move[1] = scanner.nextInt();
        return move;
    }

    // Check if the current player has won
    private static boolean checkWin(char[][] board, char player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
