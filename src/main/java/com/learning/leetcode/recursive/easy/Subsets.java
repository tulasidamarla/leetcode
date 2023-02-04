package com.learning.leetcode.recursive.easy;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> subsets = subsetsIterative(nums);
        /*subsets.stream()
                .forEach(subset -> {
                    System.out.println(" ");
                    subset.stream()
                            .forEach(System.out::print);
                });*/

        subsets = subsetsRec(nums,0);
        subsets.stream()
                .forEach(subset -> {
                    System.out.println(" ");
                    subset.stream()
                            .forEach(System.out::print);
                });

    }

    /**
     * refer to official solution here
     *
     * https://leetcode.com/problems/subsets/solutions/464411/subsets/
     *
     * Time complexity: O(N×2N) to generate all subsets and then copy them into output list.
     *
     * Space complexity: O(N×2N). This is exactly the number of solutions for subsets multiplied by the number NNN of elements to keep for each subset.
     *
     * For a given number, it could be present or absent (i.e. binary choice) in a subset solution. As as result, for N numbers, we would have in total 2^N choices (solutions).
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> subsetsIterative(int[] nums){
        //create final output
        List<List<Integer>> output = new ArrayList<>();
        //Add empty set
        output.add(new ArrayList<>());

        for(int num: nums){
            //Create newSubsets in each iteration
            List<List<Integer>> newSubsets = new ArrayList<>();
            //clone each subset from output and add current element to it
            for(List<Integer> curr: output){
                newSubsets.add(new ArrayList<>(curr){{add(num);}});
            }
            //Add subsets to output
            for(List<Integer> curr: newSubsets){
                output.add(curr);
            }
        }
        return output;
    }

    private static List<List<Integer>> subsetsRec(int[] nums, int index){
        List<List<Integer>> output = new ArrayList<>();
        //Base condition to add an empty sublist and return
        if (index == nums.length) {
            output.add(new ArrayList<>());
            return output;
        }

        //Recursion to perform sub task
        List<List<Integer>> newSubsets = subsetsRec(nums, index+1);

        // Add subsets to output
        output.addAll(newSubsets);

        //Copy the subsets to a new list, add current element and add these lists out output
        for(List<Integer> curr: newSubsets){
            output.add(new ArrayList<>(curr){{add(nums[index]);}});
        }

        return output;
    }
}
