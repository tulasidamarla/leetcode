package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(" Given Array ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        rotateMatrix(matrix);
        System.out.println("90 degrees rotated Array ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println(" Given Array ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        rotateMatrix(matrix);
        System.out.println("90 degrees rotated Array ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));


    }

    private static void rotateMatrix(int[][] matrix){
        //transpose
        // transforms rows to columns
        for(int i=0; i< matrix.length; i++){
            for(int j=i; j< matrix[0].length; j++){
                swap(matrix, i, j);
            }
        }
        System.out.println("Transposed Array ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));

        // reverse rows by swapping until half
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
