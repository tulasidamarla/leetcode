package com.learning.leetcode.recursive.medium;

import java.util.Arrays;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        searchWord(board, "ABCCED");
        searchWord(board, "FCEE");
    }

    private static void searchWord(char[][] board, String word){
        int sr = -1;
        int sc = -1;
        boolean wordFound = false;
        for(int i=0; i< board.length; i++){
            for(int j=0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    //Search recursive function is called from every row/column
                    if(search(i,j,board,word,0)){
                        wordFound = true;
                        sr = i;
                        sc = j;
                        break;
                    }
                }
            }
        }
        for(char[] row: board){
            System.out.println(Arrays.toString(row));
        }
        if (wordFound) {
            System.out.println("Word " + word + " found at " + sr + "," + sc);
        } else {
            System.out.println("Word "+ word  + " not found");
        }
    }

    private static boolean search(int sr, int sc, char[][] board, String word, int wordIndex){
        if(wordIndex == word.length()) {
            return true;
        }
        if ( sr < 0 || sc < 0 || sr == board.length || sc == board[0].length || board[sr][sc] != word.charAt(wordIndex) ) {
            return false;
        }
        char ch = board[sr][sc];
        board[sr][sc] = '#';
        boolean op1 = search(sr+1, sc, board, word, wordIndex+1);
        boolean op2 = search(sr, sc+1, board, word, wordIndex+1);
        boolean op3 = search(sr-1, sc, board, word, wordIndex+1);
        boolean op4 = search(sr, sc-1, board, word, wordIndex+1);
        board[sr][sc] = ch;

        return op1 || op2 || op3 || op4;

    }
}
