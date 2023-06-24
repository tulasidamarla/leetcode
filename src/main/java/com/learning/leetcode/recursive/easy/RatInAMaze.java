package com.learning.leetcode.recursive.easy;

import java.util.*;
import java.io.*;

public class RatInAMaze {
    public static void main(String[] args) {
        // Write your code here.
        int[][] arr = {{1,0,0,0},{1,1,0,0},{1,1,0,0},{0,1,1,1}};
        for(int[] row: arr){
            System.out.println(Arrays.toString(row));
        }
        ArrayList<String> result = new ArrayList<>();
        mazeHelper(0, 0, 4, arr, new ArrayList<>(), result);
        result.forEach(System.out::println);
    }

    static void mazeHelper(int i, int j, int n, int[][] arr, List<String> path, List<String> result) {
        if (i == n - 1 && j == n - 1) {
            result.add(String.join("", path));
        } else if (!(i < 0 || j < 0 || i == n || j == n || arr[i][j] == 0)) {
            //Need this step to stop moving between left and right
            arr[i][j] = 0;
            //Down
            path.add("D");
            mazeHelper(i + 1, j, n, arr, path, result);
            path.remove(path.size() - 1);

            //Left
            path.add("L");
            mazeHelper(i, j - 1, n, arr, path, result);
            path.remove(path.size() - 1);
            //Right
            path.add("R");
            mazeHelper(i, j + 1, n, arr, path, result);
            path.remove(path.size() - 1);
            //Up
            path.add("U");
            mazeHelper(i - 1, j, n, arr, path, result);
            path.remove(path.size() - 1);
            arr[i][j] = 1;
        }
    }
}

