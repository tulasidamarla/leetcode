package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class JumpGame1 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Can reach the end: " + canJump(nums));
        nums = new int[]{3,2,1,0,4};
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Can reach the end: " + canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0 ; i--){
            if (i + nums[i] >= goal){
                goal = i;
            }
        }
        return goal == 0;
    }
}
