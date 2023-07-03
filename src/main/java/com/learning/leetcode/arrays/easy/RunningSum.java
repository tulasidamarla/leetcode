package com.learning.leetcode.arrays.easy;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("Given array : " + Arrays.toString(nums));
        runningSum(nums);
        System.out.println("Running sum array : " + Arrays.toString(nums));
    }

    private static void runningSum(int[] nums){
        for(int i=1; i<nums.length;i++){
            nums[i] += nums[i-1];
        }
    }
}
