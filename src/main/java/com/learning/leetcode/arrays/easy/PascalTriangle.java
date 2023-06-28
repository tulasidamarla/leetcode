package com.learning.leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> result = generatePascalTriangle(5);
        result.forEach(System.out::println);

    }

    private static List<List<Integer>> generatePascalTriangle(int num){
        List<List<Integer>> result = new ArrayList<>();
        if (num == 0){
            return result;
        }
        for(int i = 0; i < num; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    row.add(1);
                } else {
                    row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j) );
                }
            }
            result.add(row);
        }
        return result;
    }
}
