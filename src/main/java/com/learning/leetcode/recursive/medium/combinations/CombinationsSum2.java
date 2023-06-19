package com.learning.leetcode.recursive.medium.combinations;

import java.util.*;

public class CombinationsSum2 {

    public static void main(String[] args) {
        final List<List<Integer>> result = new ArrayList<>();
        final int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        final int target = 8;
        Arrays.sort(candidates);
        combinations(candidates, target, 0, 0, new ArrayList<>(), result);
        System.out.println("No of combinations for " + Arrays.toString(candidates) + " and target " + target + " are " + result.size());
        result.forEach(System.out::println);
    }

    static void combinations(final int[] nums, final int target, int index, int sumTillNow, final List<Integer> subset, final List<List<Integer>> result) {

        if (sumTillNow == target) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if (sumTillNow > target) {
            return;
        }
        if (index == nums.length) {
            return;
        }

        subset.add(nums[index]);
        sumTillNow += nums[index];
        combinations(nums, target, index + 1, sumTillNow, subset, result);
        sumTillNow -= nums[index];
        subset.remove(subset.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1])
            index++;
        combinations(nums, target, index + 1, sumTillNow, subset, result);
    }
}

