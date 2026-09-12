package org.citykarat_new.snakeexits;

public class SnakeExitFinder {

    /*
     * Grid:
     * '0' = open
     * '+' = blocked
     *
     * TASK 1:
     * The boundary helper contains a bug.
     * Fix it.
     */
    public boolean isInside(char[][] board, int row, int col) {
        if (board == null || board.length == 0) {
            return false;
        }

        // Existing implementation. Do not assume it is correct.
        return row >= 0
                && row < board.length
                && col >= 0
                && col <= board[0].length;
    }

    /*
     * TASK 2:
     * Starting at start, find the nearest DIFFERENT open cell on the
     * outer edge of the board.
     *
     * Movement: up/down/left/right only.
     * '+' cells cannot be crossed.
     *
     * If multiple exits are the same shortest distance:
     * - smaller row wins
     * - then smaller column
     *
     * Return null if no other exit is reachable.
     *
     * Recommended interview discussion:
     * - BFS vs DFS
     * - visited set/matrix
     * - O(rows * cols)
     */
    public Position findNearestExit(char[][] board, Position start) {
        throw new UnsupportedOperationException("TODO: implement findNearestExit");
    }
}
