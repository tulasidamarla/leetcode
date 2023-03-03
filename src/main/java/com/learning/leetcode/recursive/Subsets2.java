package com.learning.leetcode.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public static void main(String[] args) {
        List<List<Integer>> ans = subsetsWithDup(new int[]{4,1,4,4,4});
        ans.stream()
                .forEach(subset2 -> {
                    System.out.println(" ");
                    subset2.stream()
                            .forEach(System.out::print);
                });
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        //array sorting is required to skip continuous elements with same value
        Arrays.sort(nums);
        subsets(nums, 0, subset, ans);
        return ans;
    }

    private static void subsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> ans){
        if (index >= nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        //push element to the subset
        subset.add(nums[index]);
        subsets(nums, index+1, subset, ans);
        //remove element from the subset
        subset.remove(subset.size()-1);
        //skip index if continuous elements have same value
        while(index+1 < nums.length && nums[index] == nums[index+1])
            index++;
        subsets(nums, index+1, subset, ans);

    }

    /*static List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsets(1, n, k, subset, output);
        return output;
    }

    static void subsets(int i, int n, int k, List<Integer> subset, List<List<Integer>> output) {
        if (i > n) {
            if (k == 0) {
                output.add(new ArrayList(subset));
            }
            return;
        }
        subset.add(i);
        subsets(i + 1, n, k - 1, subset, output);
        subset.remove(subset.size() - 1);
        subsets(i + 1, n, k, subset, output);
    }*/

}
