package org.citykarat_new.snakeexits;

public class SnakeExitFinderTest {

    public static void main(String[] args) {
        char[][] board = {
                {'+', '0', '+', '+'},
                {'+', '0', '0', '+'},
                {'+', '+', '0', '0'},
                {'+', '+', '+', '+'}
        };

        SnakeExitFinder finder = new SnakeExitFinder();

        assertFalse(finder.isInside(board, 1, 4),
                "Column equal to width must be outside");

        Position exit = finder.findNearestExit(board, new Position(0, 1));
        assertEquals(new Position(2, 3), exit,
                "Nearest different reachable exit");

        System.out.println("Snake exit tests completed.");
    }

    private static void assertFalse(boolean value, String message) {
        if (value) throw new AssertionError(message);
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }
}
