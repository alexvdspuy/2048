package test.java.com.game;

import org.junit.jupiter.api.Test;

import main.java.com.game.Board;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Board.
 */
class BoardTest {
    int size = Board.returnSize();
    
    @Test
    void testInitBoard() {
        Board b = new Board();
        b.initBoard();
        int[][] board = b.returnBoard();

        boolean nonZero = false;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[r][c] != 0) {
                    nonZero = true;
                }
            }
        }

        assertFalse(nonZero);
    }

    @Test
    void testAddRandomTwo() {
        int[][] tester = new int[size][size];
        int nrOfTwos = 0;

        Board.addRandomTwo(tester);

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(1, nrOfTwos);
    }

    @Test
    void testAddRandomTwoTwice() {
        int[][] tester = new int[size][size];
        int nrOfTwos = 0;

        Board.addRandomTwo(tester);
        Board.addRandomTwo(tester);

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(2, nrOfTwos);
    }
}
