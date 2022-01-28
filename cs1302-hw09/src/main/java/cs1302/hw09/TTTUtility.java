package cs1302.hw09;

import java.util.Scanner;

/**
 * Tic Tac Toe Utility class. This class assumes that
 * Tic Tac Toe boards are passed in using an encoded
 * representation. The encoding is a single {@code String}
 * object containing 'X', 'O', and '-' (blank) characters
 * only. For example, the following would be considered
 * acceptable encoded board values: <br><br>
 *    "---------" <br><br>
 *    "XOXOXOXOX" <br><br>
 *    "X-O-X-O-X" <br><br>
 *
 * The encoded boards above represent the following Tic Tac
 * Toe boards:
 *        <br><br>
 *    --- <br>
 *    --- <br>
 *    --- <br>
 *        <br><br>
 *    XOX <br>
 *    OXO <br>
 *    XOX <br>
 *        <br><br>
 *    X-O <br>
 *    -X- <br>
 *    O-X <br>
 */
public class TTTUtility {

    /**
     * Made the constructor private. This class should not
     * be instantiated.
     */
    private TTTUtility() {

    } // TTTUtility

    /**
     * Returns {@code true} if the board is in a valid state.
     * A valid state is one where the board contains 9
     * characters and 'X' has either the same number of
     * moves as 'O' or one higher. Otherwise, players moved
     * out of turn. Assumes 'X' always goes first.
     *
     * @param board the game board.
     * @return {@code true} if the board is in a valid state
     * and false otherwise.
     */
    public static boolean validGame(String board) {
        int xCount = count(board, 'X');
        int oCount = count(board, 'O');
        int blankCount = count(board, '-');

        boolean full = xCount + oCount + blankCount == 9;
        return full && (xCount == oCount || xCount - 1 == oCount);
    } // validGame

    /**
     * Prints the provided board as a square with three
     * characters per row. If provided "XOXOXOXOX", the
     * method would print: <br>
     *   XOX <br>
     *   OXO <br>
     *   XOX <br>
     *
     * @param board the board to print
     */
    public static void printSquare(String board) {
        System.out.println(board.substring(0,3));
        System.out.println(board.substring(3,6));
        System.out.println(board.substring(6,9));
    } // printSquare

    /**
     * Count the number of {@code ch} characters on the board.
     *
     * @param board the game board.
     * @param ch the character to count.
     * @return the number of instances of {@code ch} in the board.
     */
    public static int count(String board, char ch) {
        int count = 0;
        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == ch) {
                count++;
            } // if
        } // for
        return count;
    } // count

    /**
     * Returns the character that should be placed
     * next in the game board.
     * Returns 'X' if the number of 'X' characters
     * on the board is equal to the number of 'O'
     * characters. If the number of 'X' characters
     * is one greater than the number of 'O' characters,
     * 'O' is returned. If the board is invalid, it
     * returns '-' as an error state.
     * Note: A board is valid if the number of 'X'
     * and 'O' turns are equal or 'X' has taken
     * one more turn than 'O' (since x
     * always goes first).
     *
     * @param board the game board
     * @return a character representing whose turn it is
     */
    public static char whoseTurn(String board) {
        int xCount = count(board, 'X');
        int oCount = count(board, 'O');

        if (!validGame(board)) {
            return '-';
        } // if

        if (xCount == oCount) {
            return 'X';
        } // if
        return 'O'; //Since the game is valid, this works
    } // whoseTurn

    /**
     * Returns {@code True} if the specified board represents a
     * tie game. A game is a tie when the board is full and neither
     * 'X' or 'O' has three in a row.
     *
     * @param board the game board
     * @return {@code True} if this game is a tie. False, otherwise.
     */
    public static boolean isCat(String board) {
        int total = count(board, 'X') + count(board, 'O');

        if (total == 9 && !isWinner(board, 'X') && !isWinner(board, 'O')) {
            return true;
        } // if
        return false;
    } // isCat

    /**
     * Returns {@code true} if the provided character value is found
     * in three consecutive spaces (including diagonals) in the provided
     * game board.
     *
     * @return {@code true} if the character is found in three consecutive spots
     * and {@code false} otherwise.
     * @param board the board to check
     * @param ch the character to check
     */
    public static boolean isWinner(String board, char ch) {
        //check rows
        for (int i = 0; i < board.length(); i += 3) {
            if (board.charAt(i) == ch && board.charAt(i + 1) == ch && board.charAt(i + 2) == ch) {
                return true;
            } // if
        } // for

        //check cols
        for (int i = 0; i < 3; i += 1) {
            if (board.charAt(i) == ch && board.charAt(i + 3) == ch && board.charAt(i + 6) == ch) {
                return true;
            } // if
        } // for

        //check diagonals
        if (board.charAt(0) == ch && board.charAt(4) == ch && board.charAt(8) == ch) {
            return true;
        }
        return board.charAt(2) == ch && board.charAt(4) == ch && board.charAt(6) == ch;
    } // isWinner

} // TTTSolver
