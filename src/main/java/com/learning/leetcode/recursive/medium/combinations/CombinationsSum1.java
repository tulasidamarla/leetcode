package com.learning.leetcode.recursive.medium.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSum1 {
    public static void main(String[] args) {
        final List<List<Integer>> result = new ArrayList<>();
        final int[] candidates = {2,3,6,7};
        final int target = 7;
        combinations(candidates, target, 0, 0, new ArrayList<>(), result);
        System.out.println("No of combinations for "+ Arrays.toString(candidates) + " and target " + target + " are "+ result.size());
        result.forEach(System.out::println);
    }

    static void combinations(final int[] nums, final int target, int sumSoFar, int index, final List<Integer> subset, final List<List<Integer>> result){

        if (sumSoFar == target){
            result.add(new ArrayList<>(subset));
            return;
        }

        if (sumSoFar > target){
            return;
        }

        if (index == nums.length){
            return;
        }

        //include the ith element
        subset.add(nums[index]);
        sumSoFar += nums[index];
        //Don't increment index because we want to recursively call with the same index
        combinations(nums, target, sumSoFar, index, subset, result);
        sumSoFar -= nums[index];
        subset.remove(subset.size()-1);
        //skip the ith element
        combinations(nums, target, sumSoFar, index+1, subset, result);

    }
}
