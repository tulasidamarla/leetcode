package com.learning.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while(left <= right && top <= bottom){
            for(int i = left; i <= right ; i++){
                result.add(matrix[top][i]);
            }
            top++;

            for(int i = top ; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for( int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }


    public static void main(String[] args){
        //Test case 1
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> expected = List.of(1,2,3,6,9,8,7,4,5);
        List<Integer> result = spiralOrder(matrix);
        System.out.println("Test case 1 is successful: " + expected.equals(result));

        //Test case 2
        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        expected = List.of(1,2,3,4,8,12,11,10,9,5,6,7);
        result = spiralOrder(matrix);
        System.out.println("Test case 1 is successful: " + expected.equals(result));
    }
}
