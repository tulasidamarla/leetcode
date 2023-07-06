package com.learning.leetcode.recursive.hard;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        //List<List<String>> result = nQueens.solveNQueens(4);
        List<List<String>> result = nQueens.solveNQueensEfficient(4);
        result.forEach(System.out::println);
    }

    public List<List<String>> solveNQueensEfficient(int n){
        String[][] chessBoard = new String[n][n];
        for(int i=0; i < n; i++){
            for(int j=0; j<n; j++){
                chessBoard[i][j] = ".";
            }
        }
        // col[] vector will help us determine if any Queen is already placed in that particular column or not in O(1) Time Complexity

        int[] cols = new int[n];

        // topLeft[] vector will help us to check in the Top Left / Upper Left Direction in O(1) Time Complexity
        // We use the formula (i - j + n - 1) for mapping any index in topLeft with it's corresponding (i , j) in our ChessBoard

        int[] topLeft = new int[2*n];


        // topRight[] vector will help us to check in the Top Right / Upper Right Direction in O(1) Time Complexity
        // We use the formula (i + j) for mapping any index in topRight with it's corresponding (i , j) in our ChessBoard

        int[] topRight = new int[2*n];

        List<List<String>> ans = new ArrayList<>();
        solveNQueensHelperEfficient(0, n, chessBoard, ans, cols, topLeft, topRight);
        return ans;
    }

    private void solveNQueensHelperEfficient(int i, int n, String[][] chessBoard, List<List<String>> ans, int[] cols, int[] topLeft, int[] topRight){
        if(i == n){
            addSolution(chessBoard, ans);
            return;
        }
        for(int j = 0; j < n; j++){
            if(( cols[j] == 0 ) && ( topLeft[i - j + n - 1] == 0 ) && ( topRight[i + j] == 0 )){
                chessBoard[i][j] = "Q";
                //Fill these values inorder to verify safety with constant speed
                cols[j] = 1 ;
                topLeft[i - j + n - 1] = 1 ;
                topRight[i + j] = 1 ;
                solveNQueensHelperEfficient(i+1, n, chessBoard, ans, cols, topLeft, topRight);
                // reset the changes done in
                chessBoard[i][j] = ".";
                cols[j] = 0 ;
                topLeft[i - j + n - 1] = 0 ;
                topRight[i + j] = 0 ;
            }
        }
    }

    private void solveNQueensHelper(int i, int n, String[][] chessBoard, List<List<String>> ans){
        if(i == n){
            addSolution(chessBoard, ans);
            return;
        }
        for(int j = 0; j < n; j++){
            System.out.println("calling isSafe() "+  i + "," + j);
            if(isSafe(i, j, n, chessBoard)){
                chessBoard[i][j] = "Q";
                solveNQueensHelper(i+1, n, chessBoard, ans);
                chessBoard[i][j] = "."; //reset
            }
        }
    }

    private boolean isSafe(int i, int j, int n, String[][] current){
        //UP
        for(int k = i; k >= 0; k--){
            if(current[k][j].equals("Q")){
                return false;
            }
        }

        //Up right
        for(int k = i, l = j; k >= 0 && l <= n-1; k--, l++){
            if(current[k][l].equals("Q")){
                return false;
            }
        }

        //Up left
        for(int k = i, l = j; k >= 0 && l >= 0; k--, l--){
            if(current[k][l].equals("Q")){
                return false;
            }
        }

        return true;
    }

    private void addSolution(String[][] chessBoard, List<List<String>> ans) {
        List<String> solution = new ArrayList<>();
        for (String[] row : chessBoard) {
            StringBuilder rowData = new StringBuilder();
            for (String col : row) {
                rowData.append(col);
            }
            solution.add(rowData.toString());
        }
        ans.add(solution);
    }

    public List<List<String>> solveNQueens(int n) {
        String[][] chessBoard = new String[n][n];
        for(int i=0; i < n; i++){
            for(int j=0; j<n; j++){
                chessBoard[i][j] = ".";
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solveNQueensHelper(0, n, chessBoard, ans);
        return ans;
    }
}
