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
    
    /** Test addRandomNum() method. */
    @Test
    void testAddRandomNum() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.addRandomNum(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 1) ^ (nrOfFours == 1);
        assertTrue(addedRandom);
    }

    @Test
    void testAddRandomNumTwice() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.addRandomNum(tester);
        Board.addRandomNum(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 2) ^ (nrOfFours == 2) ^ 
                ((nrOfTwos == 1) && (nrOfFours == 1));
        assertTrue(addedRandom);
    }

    @Test
    void testAddRandomNumToNonEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        tester[1][1] = 2;
        tester[2][2] = 4;
        int nrOfTwos = 1;
        int nrOfFours = 1;

        Board.addRandomNum(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if ((r == 1 && c == 1) || (r == 2 && c == 2)) {
                    continue;
                }

                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 2) ^ (nrOfFours == 2);
        assertTrue(addedRandom);
    }

    /** Test shiftLeft() method. */
    @Test
    void testShiftLeftOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftLeft(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
        assertEquals(0, nrOfFours);
    }

    @Test
    void testShiftLeftOnFirstRow() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][SIZE-1] = 4;

        Board.shiftLeft(tester);

        assertEquals(4, tester[0][0]);
    }

    @Test
    void testShiftLeftOnFirstRowAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][SIZE-1] = 8;
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftLeft(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 1) ^ (nrOfFours == 1);
        assertTrue(addedRandom);
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
    void testShiftLeftOnFullRowAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 8;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = v;
            v *= 2;
        }
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftLeft(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
        assertEquals(0, nrOfFours);
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
    void testShiftLeftOnNonEmptyBoardAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][2] = 4;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = 8;
        }
        tester[3][1] = 2;

        Board.shiftLeft(tester);

        int nrOfTwos = 0;
        int nrOfFours = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 2) ^ (nrOfFours == 2);
        assertTrue(addedRandom);
    }

    /** Test shiftRight() method. */
    @Test
    void testShiftRightOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftRight(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
        assertEquals(0, nrOfFours);
    }

    @Test
    void testShiftRightOnFirstRow() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][0] = 4;

        Board.shiftRight(tester);

        assertEquals(4, tester[0][SIZE-1]);
    }

    @Test
    void testShiftRightOnFirstRowAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][0] = 16;
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftRight(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 1) ^ (nrOfFours == 1);
        assertTrue(addedRandom);
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
    void testShiftRightOnFullRowAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 8;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = v;
            v *= 2;
        }
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftRight(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
        assertEquals(0, nrOfFours);
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
    void testShiftRightOnNonEmptyBoardAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        tester[0][2] = 4;
        for (int c = 0; c < SIZE; c++) {
            tester[2][c] = 8;
        }
        tester[3][1] = 2;

        Board.shiftLeft(tester);

        int nrOfTwos = 0;
        int nrOfFours = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 2) ^ (nrOfFours == 2);
        assertTrue(addedRandom);
    }

    /** Test shiftUp() method. */
    @Test
    void testShiftUpOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftUp(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
        assertEquals(0, nrOfFours);
    }

    @Test
    void testShiftUpOnFirstColumn() {
        int[][] tester = new int[SIZE][SIZE];
        tester[2][0] = 4;

        Board.shiftUp(tester);

        assertEquals(4, tester[0][0]);
    }

    @Test
    void testShiftUpOnFirstColumnAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        tester[2][0] = 32;
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftUp(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 1) ^ (nrOfFours == 1);
        assertTrue(addedRandom);
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
    void testShiftUpOnFullColumnAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 8;
        for (int r = 0; r < SIZE; r++) {
            tester[r][1] = v;
            v *= 2;
        }
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftUp(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
        assertEquals(0, nrOfFours);
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
    void testShiftUpOnNonEmptyBoardAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            tester[r][0] = 8;
        }
        tester[0][2] = 4;
        tester[3][3] = 2;

        Board.shiftUp(tester);

        int nrOfTwos = 0;
        int nrOfFours = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 2) ^ (nrOfFours == 2);
        assertTrue(addedRandom);
    }

    /** Test shiftDown() method. */
    @Test
    void testShiftDownOnEmptyBoard() {
        int[][] tester = new int[SIZE][SIZE];
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftDown(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
        assertEquals(0, nrOfFours);
    }

    @Test
    void testShiftDownOnFirstColumn() {
        int[][] tester = new int[SIZE][SIZE];
        tester[2][0] = 4;

        Board.shiftDown(tester);

        assertEquals(4, tester[SIZE-1][0]);
    }

    @Test
    void testShiftDownOnFirstColumnAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        tester[2][0] = 8;
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftDown(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 1) ^ (nrOfFours == 1);
        assertTrue(addedRandom);
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
    void testShiftDownOnFullColumnAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        int v = 8;
        for (int r = 0; r < SIZE; r++) {
            tester[r][1] = v;
            v *= 2;
        }
        int nrOfTwos = 0;
        int nrOfFours = 0;

        Board.shiftDown(tester);

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        assertEquals(0, nrOfTwos);
        assertEquals(0, nrOfFours);
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
    void testShiftDownOnNonEmptyBoardAddNum() {
        int[][] tester = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            tester[r][0] = 8;
        }
        tester[0][2] = 4;
        tester[3][3] = 2;

        Board.shiftDown(tester);

        int nrOfTwos = 0;
        int nrOfFours = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tester[r][c] == 2) {
                    nrOfTwos++;
                } else if (tester[r][c] == 4) {
                    nrOfFours++;
                }
            }
        }

        boolean addedRandom = (nrOfTwos == 2) ^ (nrOfFours == 2);
        assertTrue(addedRandom);
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
