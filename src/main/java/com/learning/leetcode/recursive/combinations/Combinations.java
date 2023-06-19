package com.learning.leetcode.recursive.combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int n = 4;
        int k = 2;
        int[] nums = IntStream.iterate(1, i -> i + 1)
                .limit(n)
                .toArray();
        combinations(nums, 2, 0, new ArrayList<>(), result);
        System.out.println("no of combinations: " + result.size());
        result.forEach(subset -> {
                    System.out.println(" ");
                    subset.forEach(System.out::print);
                });
        System.out.println("Memory optimized approach");
        result = new ArrayList<>();
        combinations2(1, 4, 2, new ArrayList<>(), result);
        System.out.println("no of combinations: " + result.size());
        result.forEach(subset -> {
            System.out.println(" ");
            subset.forEach(System.out::print);
        });
    }

    private static void combinations(int[] nums, int k, int index, List<Integer> subset, List<List<Integer>> result){
        if (subset.size() == k){
            result.add(new ArrayList<>(subset));
            return;
        }

        if (index+1 <= nums.length) {
            subset.add(nums[index]);
            combinations(nums, k, index + 1, subset, result);
            subset.remove(subset.size() - 1);
            combinations(nums, k, index + 1, subset, result);
        }
    }

    private static void combinations2(int index, int n, int k, List<Integer> subset, List<List<Integer>> result){
        if ( index > n){
            if (k == 0){
                result.add(new ArrayList<>(subset));
            }
            return;
        }

        subset.add(index);
        combinations2(index+1, n , k-1, subset, result);
        //Remove the previously added element
        // It should be k now not k-1 because element is removed
        subset.remove(subset.size()-1);
        combinations2(index+1, n, k, subset, result);
    }
}
