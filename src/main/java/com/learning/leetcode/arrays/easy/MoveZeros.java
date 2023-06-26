package com.learning.leetcode.arrays.easy;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        System.out.println("Before moving zeros " + Arrays.toString(nums));
        moveZeros(nums);
        System.out.println("After moving zeros " + Arrays.toString(nums));
    }

    private static void moveZeros(int[] digits){
        int j = 0;
        for(int i=0; i < digits.length;i++){
            if(digits[i] !=0){
                // post increment operator here increments index post assignment
                digits[j++] = digits[i];
                //j++;
            }
        }
        while(j < digits.length){
            digits[j++] = 0;
            //j++;
        }
    }
}
