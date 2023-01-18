package com.game;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

/**
 * 2048 Board
 * This program implements the board methods for the game 2048.
 * 
 * @author Alexandra van der Spuy
 */
public class Board {
    private static int size;
    private static int boardSize;
    private static Color[] colors = {StdDraw.BOOK_RED,
                                     Color.RED,
                                     Color.ORANGE,
                                     Color.YELLOW,
                                     Color.GREEN,
                                     Color.CYAN,
                                     StdDraw.BOOK_LIGHT_BLUE,
                                     StdDraw.BOOK_BLUE,
                                     Color.BLUE,
                                     Color.MAGENTA,
                                     Color.PINK};

    /**
     * Sets the size of the square board.
     * 
     * @param value The value of both the length and width of the board.
     */
    public static void setSize(int value) {
        size = value;
    }
    
    /**
     * Add a piece with value 2 to a random, empty position on the board.
     * 
     * @param board The board.
     */
    public static void addRandomTwo(int[][] board) {
        if (fullBoard(board)) {
            return;
        }

        Random rand = new Random();
        int r, c;
        do {
            r = rand.nextInt(size);
            c = rand.nextInt(size);
        } while (board[r][c] != 0);

        board[r][c] = 2;
    }

    /**
     * Shift all pieces on the board to the left.
     * 
     * @param board The board.
     */
    public static void shiftLeft(int[][] board) {
        boolean moved = false;
        for (int r = 0; r < size; r++) {
            int z = 0;
            boolean merged = false;
            for (int c = 0; c < size; c++) {
                int nc = c - z;

                if (board[r][c] == 0) {
                    z++;
                    continue;
                } else if (z != 0) {
                    board[r][nc] = board[r][c];
                    board[r][c] = 0;
                    moved = true;
                }
                
                if (nc > 0) {
                    if (!merged && (board[r][nc - 1] == board[r][nc])) {
                        board[r][nc - 1] *= 2;
                        board[r][nc] = 0;
                        moved = true;

                        z++;
                        merged = true;
                    } else {
                        merged = false;
                    }
                }
            }
        }

        if (moved) {
            addRandomTwo(board);
        }
    }

    /**
     * Shift all pieces on the board to the right.
     * 
     * @param board The board.
     */
    public static void shiftRight(int[][] board) {
        boolean moved = false;
        for (int r = 0; r < size; r++) {
            int z = 0;
            boolean merged = false;
            for (int c = size - 1; c >= 0; c--) {
                int nc = c + z;

                if (board[r][c] == 0) {
                    z++;
                    continue;
                } else if (z != 0) {
                    board[r][nc] = board[r][c];
                    board[r][c] = 0;
                    moved = true;
                }
                
                if (nc < size - 1) {
                    if (!merged && (board[r][nc + 1] == board[r][nc])) {
                        board[r][nc + 1] *= 2;
                        board[r][nc] = 0;
                        moved = true;
                        
                        z++;
                        merged = true;
                    } else {
                        merged = false;
                    }
                }
            }
        }

        if (moved) {
            addRandomTwo(board);
        }        
    }

    /**
     * Shift all pieces on the board upwards.
     * 
     * @param board The board.
     */
    public static void shiftUp(int[][] board) {
        boolean moved = false;
        for (int c = 0; c < size; c++) {
            int z = 0;
            boolean merged = false;
            for (int r = 0; r < size; r++) {
                int nr = r - z;

                if (board[r][c] == 0) {
                    z++;
                    continue;
                } else if (z != 0) {
                    board[nr][c] = board[r][c];
                    board[r][c] = 0;
                    moved = true;
                }
                
                if (nr > 0) {
                    if (!merged && (board[nr - 1][c] == board[nr][c])) {
                        board[nr - 1][c] *= 2;
                        board[nr][c] = 0;
                        moved = true;

                        z++;
                        merged = true;
                    } else {
                        merged = false;
                    }
                }
            }
        }

        if (moved) {
            addRandomTwo(board);
        }
    }

    /**
     * Shift all pieces on the board downwards.
     * 
     * @param board The board.
     */
    public static void shiftDown(int[][] board) {
        boolean moved = false;
        for (int c = 0; c < size; c++) {
            int z = 0;
            boolean merged = false;
            for (int r = size - 1; r >= 0; r--) {
                int nr = r + z;

                if (board[r][c] == 0) {
                    z++;
                    continue;
                } else if (z != 0) {
                    board[nr][c] = board[r][c];
                    board[r][c] = 0;
                    moved = true;
                }
                
                if (nr < size - 1) {
                    if (!merged && (board[nr + 1][c] == board[nr][c])) {
                        board[nr + 1][c] *= 2;
                        board[nr][c] = 0;
                        moved = true;

                        z++;
                        merged = true;
                    } else {
                        merged = false;
                    }
                }
            }
        }

        if (moved) {
            addRandomTwo(board);
        }        
    }

    /**
     * Check whether there are any empty positions on the board.
     * 
     * @param board The board.
     * @return True if the board is full, False otherwise.
     */
    public static boolean fullBoard(int[][] board) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check whether the game on the board is won.
     * 
     * @param board The board.
     * @return True if there is a piece with value 2048, False otherwise.
     */
    public static boolean gameWon(int[][] board) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[r][c] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check whether the game on the board is lost.
     * 
     * @param board The board.
     * @return True if the board is full and no more moves are possible, False otherwise.
     */
    public static boolean gameLost(int[][] board) {
        if (!fullBoard(board)) {
            return false;
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if ((r < size - 1) && (board[r][c] == board[r+1][c])) {
                    return false;
                } else if ((c < size - 1) && (board[r][c] == board[r][c+1])) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Print the pieces on the board.
     * 
     * @param board The board.
     */
    public static void printBoard(int[][] board) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(String.format("%4d ", board[r][c]));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Initialize the GUI.
     */
    public static void initGUI() {
        boardSize = size + 2;
        StdDraw.setCanvasSize();
        StdDraw.setXscale(0, boardSize);
        StdDraw.setYscale(0, boardSize);
    }

    /**
     * Draw the pieces on the board for the GUI.
     * 
     * @param board The board.
     */
    public static void drawBoard(int[][] board) {
        StdDraw.clear();

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[r][c] != 0) {
                    double x = c + 1.5;
                    double y = boardSize - (r + 1.5);

                    int value = board[r][c];
                    int index = (int) (Math.log(value) / Math.log(2) - 1);

                    StdDraw.setPenColor(colors[index]);
                    StdDraw.filledSquare(x, y, 0.5);
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.square(x, y, 0.5);
                    StdDraw.text(x, y, value + "");
                }
            }
        }

        StdDraw.square(boardSize / 2, boardSize / 2, size / 2);
        StdDraw.show(250);
    }

    /**
     * Display the winning message on the GUI.
     */
    public static void drawWin() {
        StdDraw.show(1000);

        StdDraw.clear();
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 48));
        StdDraw.text(boardSize / 2, boardSize / 2, "YOU WON!");
        StdDraw.show();
    }

    /**
     * Display the losing message on the GUI.
     */
    public static void drawLoss() {
        StdDraw.show(1000);
        
        StdDraw.clear();
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 48));
        StdDraw.text(boardSize / 2, boardSize / 2, "YOU LOST!");
        StdDraw.show();
    }
}
