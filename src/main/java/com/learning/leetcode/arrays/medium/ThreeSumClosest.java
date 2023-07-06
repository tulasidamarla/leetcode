package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println("Given Array " + Arrays.toString(nums));
        System.out.printf(" Sum closest to target %d is %d ", target, threeSumClosestToTarget(nums, target));
        nums = new int[]{0,0,0};
        target = 1;
        System.out.println();
        System.out.println("Given Array " + Arrays.toString(nums));
        System.out.printf(" Sum closest to target %d is %d ", target, threeSumClosestToTarget(nums, target));

    }

    private static int threeSumClosestToTarget(int[] nums, int target){
        int resultSum = nums[0] + nums[1] + nums[2];
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target){
                    return sum;
                } else if (sum < target){
                    left++;
                } else {
                    right--;
                }
                int currDiff = Math.abs(sum-target);
                if (currDiff < minDiff){
                    resultSum = sum;
                    minDiff = currDiff;
                }
            }
        }
        return resultSum;
    }
}
