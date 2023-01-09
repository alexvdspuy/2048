package main.java.com.game;

import java.util.Random;

/**
 * Board.
 */
public class Board {
    private static int size = 4;
    private int[][] board;

    public Board() {
    }

    public void initBoard() {
        board = new int[size][size];
    }

    public int[][] returnBoard() {
        int[][] copy = new int[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                copy[r][c] = board[r][c];
            }
        }
        return copy;
    }

    public void addRandomTwo() {
        addRandomTwo(board);
    }

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

    public static void printBoard(int[][] board) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int returnSize() {
        return size;
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
