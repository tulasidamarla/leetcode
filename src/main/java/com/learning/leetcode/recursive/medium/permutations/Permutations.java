package com.learning.leetcode.recursive.medium.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(new int[]{1,2,3}, 0, result);
        result.forEach(subset -> {
                    System.out.println(" ");
                    subset.forEach(System.out::print);
                });
        result = permutationsIterative(new int[]{1,2,3});
        System.out.println("Iterative o/p");
        //TODO:  Not completed yet
        result.forEach(subset -> {
            System.out.println(" ");
            subset.forEach(System.out::print);
        });
    }

    private static List<List<Integer>> permutationsIterative(final int[] nums){
        //create final output
        final List<List<Integer>> output = new ArrayList<>();
        //TODO: not completed yet
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length ; j++){
                swap(i, j, nums);
                output.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                swap(i, j, nums);
            }
        }

        return output;
    }


    /**
     * This solution uses backtracking.
     *
     * space complexity is height of the tree. i.e. O(N)
     * Time complexity is n * n!
     *
     * @param nums input array
     * @param index position
     * @param result result array
     */
    static void permutations(int[] nums, int index, List<List<Integer>> result){
        if (index == nums.length){
            final List<Integer> subList = new ArrayList<>();
            Arrays.stream(nums).forEach(subList::add);
            result.add(subList);
            return;
        }

        for(int i = index; i < nums.length; i++){
            //swap integers
            swap(i, index, nums);
            permutations(nums, index + 1, result);
            //swap integers back to keep the original array
            swap(i, index, nums);
        }
    }

    static void swap(final int fromIndex, final int toIndex, final int[] nums)
    {
        final int temp = nums[fromIndex];
        nums[fromIndex] = nums[toIndex];
        nums[toIndex] = temp;
    }

}
