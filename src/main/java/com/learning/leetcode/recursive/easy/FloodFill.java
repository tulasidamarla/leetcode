package com.learning.leetcode.recursive.easy;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int startingRow = 1;
        int startingColumn = 1;
        int newColor = 2;
        System.out.println("Initial image");
        Arrays.stream(image)
                .forEach(row -> System.out.println(Arrays.toString(row)));
        System.out.println("Starting point: " + startingRow + ", " + startingColumn);
        int oldColor = image[startingRow][startingColumn];
        flood(0, 0, image, oldColor, newColor);
        System.out.println("Post flood fill image");
        Arrays.stream(image)
                .forEach(row -> System.out.println(Arrays.toString(row)));
    }

    private static void flood(int i, int j, int[][] image, int oldColor, int newColor) {
        if (i < 0 || j < 0 || i == image.length || j == image[0].length  || image[i][j] != oldColor) {
            return;
        }
        image[i][j] = newColor;
        flood(i + 1, j, image, oldColor, newColor);
        flood(i - 1, j, image, oldColor, newColor);
        flood(i, j + 1, image, oldColor, newColor);
        flood(i, j - 1, image, oldColor, newColor);
    }

}
