package com.learning.leetcode.arrays.easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println("Before removing duplicates array is " + Arrays.toString(nums));
        int k = removeDuplicates(nums);
        System.out.println("After removing duplicates array is " + Arrays.toString(nums));
        System.out.println("Unique values are filtered until position " + k);

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println("Before removing duplicates array is " + Arrays.toString(nums));
        k = removeDuplicates(nums);
        System.out.println("After removing duplicates array is " + Arrays.toString(nums));
        System.out.println("Unique values are filtered until position " + k);
    }

    private static int removeDuplicates(int[] nums){
        int k = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
