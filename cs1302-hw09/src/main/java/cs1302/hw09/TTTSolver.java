package cs1302.hw09;

import java.util.Scanner;
import java.lang.StringBuilder;

/**
 * A Tic-Tac-Toe Solver class.
 */
public class TTTSolver {

    /**
     * The entry point for the program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an initial board state " +
                           "using 9 consecutive characters. Valid "  +
                           "characters are X, O, and -.");
        String board = promptBoard(input);
        System.out.print("Count winning boards for which player (X or O)? ");
        char player = input.next().charAt(0);
        System.out.println("Ways " + player + " can win: " + countAllWinningBoards(board, player));
    } // main

    /**
     * Prompt the user for a valid board configuration.
     * @param input an input scanner
     * @return the board configuration
     */
    public static String promptBoard(Scanner input) {
        String board = input.nextLine();
        while (!TTTUtility.validGame(board)) {
            System.out.println("Invalid board. Try again.");
            board = input.nextLine();
        } // while
        return board;
    } // promptBoard

    /**
     * Given an initial board state, this method prints
     * all board states that can be reached via valid
     * sequence of moves by each player. Therefore, the
     * printout includes both intermediate board states
     * as well as completed board states.
     *
     * @param board the game board
     */
    public static void printAllBoards(String board) {
        for (int i = 0; i < board.length(); i++) {
            if (TTTUtility.isCat(board) || TTTUtility.isWinner(board, 'X') ||
                TTTUtility.isWinner(board, 'O')) {
                return;
            } else if (board.charAt(i) == '-') {
                StringBuilder newBoard = new StringBuilder(board);
                newBoard.setCharAt(i, TTTUtility.whoseTurn(board));
                System.out.println(newBoard);
                printAllBoards(newBoard.toString());
            } // if
        } // for
    } // printAllBoards

    /**
     * Given an initial board state and a player,
     * returns a count of all winning board states
     * for that player that can be reached via a valid
     * sequence of moves by each player.
     *
     * @param board the game board
     * @param player the player to check winning board states
     * @return count the number of win for the {@code player}
     */
    public static int countAllWinningBoards(String board, char player) {
        int count = 0;
        if (TTTUtility.isCat(board) || TTTUtility.isWinner(board, 'X') ||
            TTTUtility.isWinner(board, 'O')) {
            return count;
        } // if

        for (int i = 0; i < board.length(); i++) {
            StringBuilder newBoard = new StringBuilder(board);
            if (board.charAt(i) == '-') {
                newBoard.setCharAt(i, TTTUtility.whoseTurn(board));
                if (TTTUtility.isWinner(newBoard.toString(), player)) {
                    count++;
                } else {
                    count += countAllWinningBoards(newBoard.toString(), player);
                } // if
            } // if
        } // for
        return count;
    } // countAllWinningBoards

} // TTTSolver
