package com.learning.leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        Arrays.sort(nums);
        System.out.println("Given array is " + Arrays.toString(nums));
        System.out.println("Target is " + target);
        List<List<Integer>> result = fourSumHelper(nums, target);
        result.forEach(System.out::println);
        nums = new int[]{2, 2, 2, 2, 2};
        target = 8;
        System.out.println("Given array is " + Arrays.toString(nums));
        System.out.println("Target is " + target);
        result = fourSumHelper(nums, target);
        result.forEach(System.out::println);

    }

    private static List<List<Integer>> fourSumHelper(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length -1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        result.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }

                }
            }
        }
        return result;
    }
}
