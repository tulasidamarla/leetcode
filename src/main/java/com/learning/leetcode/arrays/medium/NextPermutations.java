package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class NextPermutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Given sequence " + Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("Next permutation " + Arrays.toString(nums));
        nums = new int[]{1, 3, 5, 4, 2};
        System.out.println("Given sequence " + Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("Next permutation " + Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums){
        int n = nums.length;
        if (nums.length <= 1){
            return;
        }
        int i = nums.length -2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if (i >= 0){
            int j = nums.length-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            //swap
            swap(nums, i, j);
        }
        //reverse from i+1 to end
        reverse(nums, i+1, nums.length-1);
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start++, end--);
        }
    }
}
