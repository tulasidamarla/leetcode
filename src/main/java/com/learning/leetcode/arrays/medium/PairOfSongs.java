package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class PairOfSongs {
    public static void main(String[] args) {
        int[] time = {30, 20, 150, 100, 40};
        System.out.println("Given Array : " + Arrays.toString(time));
        System.out.println("No of pairs divisible by 60 : " + numPairsDivisibleBy60(time));
        time = new int[]{60, 60, 60};
        System.out.println("Given Array : " + Arrays.toString(time));
        System.out.println("No of pairs divisible by 60 : " + numPairsDivisibleBy60(time));

    }

    private static int numPairsDivisibleBy60(int[] time) {
        int[] moduloArr = new int[60];
        int count = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                count += moduloArr[0];
            } else {
                count += moduloArr[60 - t % 60];
            }
            moduloArr[t % 60]++;
        }
        return count;
    }
}
