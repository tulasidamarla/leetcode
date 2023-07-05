package com.learning.leetcode.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println("Given Array " + Arrays.toString(nums));
        System.out.println("No of sub arrays " + noOfSubArraysBruteForce(nums, k));
        nums = new int[]{1,-1,0};
        k = 0;
        System.out.println("Given Array " + Arrays.toString(nums));
        System.out.println("No of sub arrays " + noOfSubArraysBruteForce(nums, k));
        System.out.println("Given Array " + Arrays.toString(nums));
        System.out.println("No of sub arrays using efficient method is " + noOfSubArraysEff(nums, k));

    }

    private static int noOfSubArraysBruteForce(int[] nums, int k){
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum == k){
                    count++;
                }
            }
            sum = 0;
        }
        return count;
    }

    private static int noOfSubArraysEff(int[] nums, int k){
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
