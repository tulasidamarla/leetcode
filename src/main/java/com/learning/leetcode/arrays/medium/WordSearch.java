package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        char[][] matrix = {{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        System.out.println("Given matrix ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        String word = "SEE";
        boolean result = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(matrix[i][j] == word.charAt(0)){
                    result = search(matrix, word, 0, i, j);
                }
            }
        }

        //search(matrix, word, 0, sr, sc)
        System.out.printf("Given word %s found: %s", word, result);

        System.out.println("Given Matrix after search ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    private static boolean search(char[][] matrix, String word, int wordIndex, int sr, int sc){
        if (wordIndex == word.length()){
            return true;
        }

        if (sr < 0 || sc < 0 || sr == matrix.length || sc == matrix[0].length || matrix[sr][sc] != word.charAt(wordIndex)){
            return false;
        }

        char temp = matrix[sr][sc];
        matrix[sr][sc] = '#';
        boolean res1 = search(matrix, word, wordIndex+1, sr+1, sc);
        boolean res2 = search(matrix, word, wordIndex+1, sr, sc+1);
        boolean res3 = search(matrix, word, wordIndex+1, sr-1, sc);
        boolean res4 = search(matrix, word, wordIndex+1, sr, sc-1);
        matrix[sr][sc] = temp;
        return res1 || res2 || res3 || res4;
    }
}
