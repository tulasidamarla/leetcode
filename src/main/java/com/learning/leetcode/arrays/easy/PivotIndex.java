package com.learning.leetcode.arrays.easy;

import java.util.Arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println("Pivot index for " + Arrays.toString(nums) + " is " + pivotIndex(nums));
        nums = new int[]{1,2,3};
        System.out.println("Pivot index for " + Arrays.toString(nums) + " is " + pivotIndex(nums));
        nums = new int[]{2,1,-1};
        System.out.println("Pivot index for " + Arrays.toString(nums) + " is " + pivotIndex(nums));

    }

    private static int pivotIndex(int[] nums) {
        int left = 0, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for(int i=0;i<nums.length;i++) {
            sum -= nums[i];
            if(sum == left) return i;
            left += nums[i];
        }
        return -1;
    }
}
