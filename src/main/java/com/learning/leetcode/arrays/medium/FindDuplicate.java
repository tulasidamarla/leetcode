package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Duplicate Number is " + findDuplicate(nums));
        nums = new int[]{3,1,3,4,2};
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Duplicate Number is " + findDuplicate(nums));

    }

    private static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
