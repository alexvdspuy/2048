package com.game;

import java.awt.event.KeyEvent;

/**
 * Hello world!
 */
public class App {
    private static int SIZE = 4;

    /**
     * Plays the 2048 game.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to 2048!");
        System.out.println();

        Board.setSize(SIZE);
        int[][] board = new int[SIZE][SIZE];
        Board.addRandomNum(board);
        Board.addRandomNum(board);
        Board.printBoard(board);
        Board.initGUI();
        Board.drawBoard(board);

        while (true) {
            if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
                Board.shiftLeft(board);
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
                Board.shiftUp(board);
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
                Board.shiftRight(board);
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
                Board.shiftDown(board);
            } else {
                continue;
            }

            Board.printBoard(board);
            Board.drawBoard(board);

            if (Board.gameWon(board)) {
                System.out.println("You won!");
                Board.drawWin();
                break;
            } else if (Board.gameLost(board)) {
                System.out.println("You lost :(");
                Board.drawLoss();
                break;
            }
        }
    }

    /**
     * Gets the size of the square board.
     * 
     * @return The value of both the length and width of the board.
     */
    public static int getSize() {
        return SIZE;
    }
}
