package com.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

/**
 * Unit test for Board.
 */
class BoardTest {
    static int SIZE = App.getSize();

    @BeforeAll
    static void setSize() {
        Board.setSize(SIZE);
    }
    
    /** Test addRandomTwo() method. */
    @Test
    void testAddRandomTwo() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;

        Board.addRandomTwo(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(1, nrOfTwos);
    }

    @Test
    void testAddRandomTwoTwice() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;

        Board.addRandomTwo(tester);
        Board.addRandomTwo(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(2, nrOfTwos);
    }

    @Test
    void testAddRandomTwoToNonEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        tester[1][1] = 2;
        int nrOfTwos = 1;

        Board.addRandomTwo(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (r == 1 && c == 1) {
                    continue;
                }

                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(2, nrOfTwos);
    }

    /** Test shiftLeft() method. */
    @Test
    void testShiftLeftOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;

        Board.shiftLeft(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
    }

    @Test
    void testShiftLeftOnFirstRow() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][SIZE-1] = 4;

        Board.shiftLeft(tester);

        assertEquals(4, tester[0][0]);
    }

    @Test
    void testShiftLeftOnFirstRowAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][SIZE-1] = 4;
        int nrOfTwos = 0;

        Board.shiftLeft(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(1, nrOfTwos);
    }

    @Test
    void testShiftLeftOnFullRow() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 4;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = v;
            v *= 2;
        }

        Board.shiftLeft(tester);

        assertEquals(4, tester[2][0]);
        assertEquals(32, tester[2][SIZE-1]);
    }

    @Test
    void testShiftLeftOnFullRowAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 4;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = v;
            v *= 2;
        }
        int nrOfTwos = 0;

        Board.shiftLeft(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
    }

    @Test
    void testShiftLeftOnNonEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][2] = 4;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = 8;
        }
        tester[3][1] = 2;

        Board.shiftLeft(tester);

        assertEquals(4, tester[0][0]);
        assertEquals(16, tester[2][0]);
        assertEquals(16, tester[2][1]);
        assertEquals(2, tester[3][0]);
    }

    @Test
    void testShiftLeftOnNonEmptyBoardAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][2] = 4;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = 8;
        }
        tester[3][1] = 2;

        Board.shiftLeft(tester);

        int nrOfTwos = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(2, nrOfTwos);
    }

    /** Test shiftRight() method. */
    @Test
    void testShiftRightOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;

        Board.shiftRight(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
    }

    @Test
    void testShiftRightOnFirstRow() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][0] = 4;

        Board.shiftRight(tester);

        assertEquals(4, tester[0][SIZE-1]);
    }

    @Test
    void testShiftRightOnFirstRowAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][0] = 4;
        int nrOfTwos = 0;

        Board.shiftRight(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(1, nrOfTwos);
    }

    @Test
    void testShiftRightOnFullRow() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 4;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = v;
            v *= 2;
        }

        Board.shiftRight(tester);

        assertEquals(4, tester[2][0]);
        assertEquals(32, tester[2][SIZE-1]);
    }

    @Test
    void testShiftRightOnFullRowAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 4;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = v;
            v *= 2;
        }
        int nrOfTwos = 0;

        Board.shiftRight(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
    }

    @Test
    void testShiftRightOnNonEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][2] = 4;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = 8;
        }
        tester[3][1] = 2;

        Board.shiftRight(tester);

        assertEquals(4, tester[0][SIZE-1]);
        assertEquals(16, tester[2][SIZE-1]);
        assertEquals(16, tester[2][SIZE-2]);
        assertEquals(2, tester[3][SIZE-1]);
    }

    @Test
    void testShiftRightOnNonEmptyBoardAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][2] = 4;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = 8;
        }
        tester[3][1] = 2;

        Board.shiftLeft(tester);

        int nrOfTwos = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(2, nrOfTwos);
    }

    /** Test shiftUp() method. */
    @Test
    void testShiftUpOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;

        Board.shiftUp(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
    }

    @Test
    void testShiftUpOnFirstColumn() {
        int[][] tester = new int[SIZE][SIZE];
        tester[2][0] = 4;

        Board.shiftUp(tester);

        assertEquals(4, tester[0][0]);
    }

    @Test
    void testShiftUpOnFirstColumnAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        tester[2][0] = 4;
        int nrOfTwos = 0;

        Board.shiftUp(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(1, nrOfTwos);
    }

    @Test
    void testShiftUpOnFullColumn() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 4;
        for (int r = 0; r < SIZE; r++) {
            tester[r][1] = v;
            v *= 2;
        }

        Board.shiftUp(tester);

        assertEquals(4, tester[0][1]);
        assertEquals(32, tester[SIZE-1][1]);
    }

    @Test
    void testShiftUpOnFullColumnAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 4;
        for (int r = 0; r < SIZE; r++) {
            tester[r][1] = v;
            v *= 2;
        }
        int nrOfTwos = 0;

        Board.shiftUp(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
    }

    @Test
    void testShiftUpOnNonEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            tester[r][0] = 8;
        }
        tester[0][2] = 4;
        tester[3][3] = 2;

        Board.shiftUp(tester);

        assertEquals(16, tester[0][0]);
        assertEquals(16, tester[1][0]);
        assertEquals(4, tester[0][2]);
        assertEquals(2, tester[0][3]);
    }

    @Test
    void testShiftUpOnNonEmptyBoardAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            tester[r][0] = 8;
        }
        tester[0][2] = 4;
        tester[3][3] = 2;

        Board.shiftUp(tester);

        int nrOfTwos = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(2, nrOfTwos);
    }

    /** Test shiftDown() method. */
    @Test
    void testShiftDownOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;

        Board.shiftDown(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
    }

    @Test
    void testShiftDownOnFirstColumn() {
        int[][] tester = new int[SIZE][SIZE];
        tester[2][0] = 4;

        Board.shiftDown(tester);

        assertEquals(4, tester[SIZE-1][0]);
    }

    @Test
    void testShiftDownOnFirstColumnAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        tester[2][0] = 4;
        int nrOfTwos = 0;

        Board.shiftDown(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(1, nrOfTwos);
    }

    @Test
    void testShiftDownOnFullColumn() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 4;
        for (int r = 0; r < SIZE; r++) {
            tester[r][1] = v;
            v *= 2;
        }

        Board.shiftDown(tester);

        assertEquals(4, tester[0][1]);
        assertEquals(32, tester[SIZE-1][1]);
    }

    @Test
    void testShiftDownOnFullColumnAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 4;
        for (int r = 0; r < SIZE; r++) {
            tester[r][1] = v;
            v *= 2;
        }
        int nrOfTwos = 0;

        Board.shiftDown(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
    }

    @Test
    void testShiftDownOnNonEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            tester[r][0] = 8;
        }
        tester[0][2] = 4;
        tester[3][3] = 2;

        Board.shiftDown(tester);

        assertEquals(16, tester[SIZE-2][0]);
        assertEquals(16, tester[SIZE-1][0]);
        assertEquals(4, tester[SIZE-1][2]);
        assertEquals(2, tester[SIZE-1][3]);
    }

    @Test
    void testShiftDownOnNonEmptyBoardAddTwo() {
        int[][] tester = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            tester[r][0] = 8;
        }
        tester[0][2] = 4;
        tester[3][3] = 2;

        Board.shiftDown(tester);

        int nrOfTwos = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                }
            }
        }

        assertEquals(2, nrOfTwos);
    }

    /** Test fullBoard() method. */
    @Test
    void testFullBoardOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];

        assertFalse(Board.fullBoard(tester));
    }

    @Test
    void testFullBoardOnNonEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][2] = 8;

        assertFalse(Board.fullBoard(tester));
    }

    @Test
    void testFullBoardOnFullBoard() {
        int[][] tester = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                tester[r][c] = 2;
            }
        }

        assertTrue(Board.fullBoard(tester));
    }

    /** Test gameWon() method. */
    @Test
    void testGameWonOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];

        assertFalse(Board.gameWon(tester));
    }

    @Test
    void testGameWonOnNonEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][2] = 8;
        tester[3][3] = 1024;

        assertFalse(Board.gameWon(tester));
    }

    @Test
    void testGameWonOnWinningBoard() {
        int[][] tester = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                tester[r][c] = 2;
            }
        }
        tester[2][2] = 2048;

        assertTrue(Board.gameWon(tester));
    }

    /** Test gameLost() method. */
    @Test
    void testGameLostOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];

        assertFalse(Board.gameLost(tester));
    }

    @Test
    void testGameLostOnNonEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][2] = 8;

        assertFalse(Board.gameLost(tester));
    }

    @Test
    void testGameLostOnFullPlayableBoard() {
        int[][] tester = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                tester[r][c] = 2;
            }
        }

        assertFalse(Board.gameLost(tester));
    }

    @Test
    void testGameLostOnFullNonPlayableBoard() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 2;
        for (int r = 0; r < SIZE; r++) {
            int w = v;
            for (int c = 0; c < SIZE; c++) {
                tester[r][c] = w;
                w *= 2;
            }
            v *= 2;
        }

        assertTrue(Board.gameLost(tester));
    }
}
