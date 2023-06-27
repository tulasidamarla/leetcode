package com.learning.leetcode.arrays.easy;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println("Majority element for " + Arrays.toString(nums) + " is " + majorityElement(nums));
        nums = new int[]{2,2,1,1,2,2,1};
        System.out.println("Majority element for " + Arrays.toString(nums) + " is " + majorityElement(nums));

    }

    private static int majorityElement(int[] nums){
        int candidate = 0;
        int votes = 0;
        for(int num: nums){
            if (votes == 0){
                candidate = num;
            }
            if (candidate == num){
                votes++;
            } else {
                votes--;
            }
        }
        return candidate;
    }


}
