package com.learning.leetcode.recursive;

import java.util.*;
import java.util.stream.Collectors;

/*
*
* Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
*
*
*
* Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*
*
* */
public class Permutations2 {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = {1,2,2};
        permutations(nums, 0, result);

    }

    static void permutations(int[] nums, int index, List<List<Integer>> result){
        if(index >= nums.length){
            List<Integer> subList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(subList);
        }
        Set<Integer> posTracker = new HashSet<>();
        for(int i=index; i < nums.length; i++){
            //To not use a value from the same position twice
            //position tracker is used
            if(posTracker.contains(nums[i])){
                continue;
            }
            posTracker.add(nums[i]);
            swap(i, index, nums);
            permutations(nums, index+1, result);
            swap(i, index, nums);
        }

    }

    static void swap(int from, int to, int[] nums){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
