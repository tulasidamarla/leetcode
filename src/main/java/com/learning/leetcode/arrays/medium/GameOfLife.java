package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        System.out.println("Given board");
        for (var row : board) {
            System.out.println(Arrays.toString(row));
        }
        gameOfLife(board);
        System.out.println("Game of Life board");
        for (var row : board) {
            System.out.println(Arrays.toString(row));
        }
        board = new int[][]{{1, 1}, {1, 0}};
        System.out.println("Given board");
        for (var row : board) {
            System.out.println(Arrays.toString(row));
        }
        gameOfLife(board);
        System.out.println("Game of Life board");
        for (var row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void gameOfLife(int[][] board) {
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                int liveCount = countLiveNeighbours(board, m, n);
                if (board[m][n] == 0 && liveCount == 3) {
                    board[m][n] = 2;
                }
                if (board[m][n] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[m][n] = -1;
                }
            }
        }
        resetValues(board);
    }

    private static int countLiveNeighbours(int[][] board, int m, int n) {
        // X and Y co-ordinates
        int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};
        int liveCount = 0;
        for (int i = 0; i < 8; i++) {
            final int curr_x = dx[i];
            final int curr_y = dy[i];
            if (isValid(board, curr_x + m, curr_y + n) && Math.abs(board[m + curr_x][n + curr_y]) == 1) {
                liveCount++;
            }
        }
        return liveCount;
    }

    private static boolean isValid(int[][] board, int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }

    private static void resetValues(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] >= 1) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }


}
