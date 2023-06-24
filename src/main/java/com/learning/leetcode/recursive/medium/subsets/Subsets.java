package com.learning.leetcode.recursive.medium.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsetsRec(nums,0,subset,ans);
        System.out.println("");
        System.out.println("Recursive approach");
        ans.stream()
                .forEach(subset2 -> {
                    System.out.println(" ");
                    subset2.stream()
                            .forEach(System.out::print);
                });

    }

    /**
     * refer to official solution here
     *
     * https://leetcode.com/problems/subsets/solutions/464411/subsets/
     *
     * Time complexity: O(N×2^N) to generate all subsets and then copy them into output list.
     *
     * Space complexity: O(N×2^N). This is exactly the number of solutions for subsets multiplied by the number NNN of elements to keep for each subset.
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


    /**
     *  Time complexity O(N2^N) to generate all subsets and then copy them into output list.
     *  Space complexity O(N) using O(N) to maintain current subset
     *
     * @param nums
     * @param i
     * @param subset
     * @param ans
     */
    private static void subsetsRec(int[] nums, int i, List<Integer> subset, List<List<Integer>> ans){
        if (i == nums.length){
            //Add each subset to the answer at the end of the tree
            ans.add(new ArrayList<>(subset));
            return;
        }
        //include ith element to the subset
        subset.add(nums[i]);
        subsetsRec(nums, i+1, subset, ans);
        //remove the ith element from subset and proceed with next element
        subset.remove(subset.size()-1);
        subsetsRec(nums, i+1, subset, ans);
    }



    /**
     *
     * Time complexity:O(N2^N) to generate all subsets and then copy them into output list.
     * Space complexity:O(N2^N) to keep all the subsets of lengthN, since each of N elements could be present or absent.
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> subsetsBitmask(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        //If n = 4, we iterate from 2^4 to 2^5 and remove first character
        // From 10000 to 11111. By calling substring(1), we iterate through
        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }

    private static List<List<Integer>> subsetsBinary(int[] nums){
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;
        for(int i = (int)Math.pow(2,n); i < (int)Math.pow(2, n+1); i++){
            List<Integer> subset = new ArrayList<>();
            String val = Integer.toBinaryString(i).substring(1);
            for(int j = 0; j< n; j++){
                if(val.charAt(j) != '0'){
                    subset.add(nums[j]);
                }
            }
            output.add(subset);
        }
        return output;

    }

}
