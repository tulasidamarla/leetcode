package com.learning.leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Given Array : " + Arrays.toString(nums));
        List<List<Integer>> result = threeSum(nums);
        System.out.print("ThreeSum Result : \t");
        result.forEach(System.out::print);
    }

    private static List<List<Integer>> threeSum(int[] nums){
        final List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int start = i + 1;
            int end = n - 1;
            int target = -nums[i];
            while(start < end){
                if (nums[start] + nums[end] == target){
                    result.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    //Eliminate duplicates for the start element
                    while(start < end && nums[start] == nums[start+1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end-1]){
                        end--;
                    }

                } else if (nums[start] + nums[end] > target){
                    end--;
                } else {
                    start++;
                }
                while(i+1 < n && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
        return result;
    }
}
