package com.learning.leetcode.arrays.easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        System.out.println("Original array" + Arrays.toString(digits));
        System.out.println("Plus one array" + Arrays.toString(plusOne(digits)));
        digits = new int[]{9};
        System.out.println("Original array" + Arrays.toString(digits));
        System.out.println("Plus one array" + Arrays.toString(plusOne(digits)));
        digits = new int[]{9,9};
        System.out.println("Original array" + Arrays.toString(digits));
        System.out.println("Plus one array" + Arrays.toString(plusOne(digits)));

    }

    private static int[] plusOne(int[] digits){
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        System.out.println(Arrays.toString(digits));
        // This is only for the scenarios like [9],[9,9],[9,9,9] etc.
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
