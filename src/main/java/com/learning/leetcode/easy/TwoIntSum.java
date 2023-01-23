package com.learning.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
* You can return the answer in any order.
* */
public class TwoIntSum {

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int current = nums[i];
            int required = target - current;
            if (indexMap.containsKey(required)){
                return new int[]{i, indexMap.get(required)};
            }
            indexMap.put(current, i);
        }
        return null;
    }

    public static void printTestResult(int[] nums, int[] result, int testCaseNumber, int target){
        System.out.println(result[0] + " " + result[1]);
        if (result[0] != result[1] ){
            if(nums[result[0]] + nums[result[1]] == target) {
                System.out.println("Test case " + testCaseNumber + " is successful ");
            } else {
                System.out.println("Test case " + testCaseNumber + " is failed");
            }
        }
    }

    public static void main(String[] args) {

        //Test case 1
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        printTestResult(nums, result, 1, target);

        //Test case 2
        nums = new int[]{3, 2, 4};
        target = 6;
        result = twoSum(nums, target);
        printTestResult(nums, result, 2, target);

        //Test case 3
        nums = new int[]{3, 3};
        target = 6;
        result = twoSum(nums, target);
        printTestResult(nums, result, 3, target);

    }
}
