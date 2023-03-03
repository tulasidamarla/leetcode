package com.learning.leetcode.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = null;

    /*
    subsets = subsetsIterative(nums);
    subsets.stream()
            .forEach(subset -> {
                System.out.println(" ");
                subset.stream()
                        .forEach(System.out::print);
            });*/

        /*subsets = subsetsRec(nums,0);
        subsets.stream()
                .forEach(subset -> {
                    System.out.println(" ");
                    subset.stream()
                            .forEach(System.out::print);
                });*/

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsetsRec2(nums,0,subset,ans);
        ans.stream()
                .forEach(subset2 -> {
                    System.out.println(" ");
                    subset2.stream()
                            .forEach(System.out::print);
                });
        System.out.println("answer size -->" + ans.size());

    /*subsets = subsetsBitmask(nums);
    subsets.stream()
            .forEach(subset -> {
                System.out.println(" ");
                subset.stream()
                        .forEach(System.out::print);
            });*/
    /*subsets = subsetsBinary(nums);
    subsets.stream()
            .forEach(subset -> {
                System.out.println(" ");
                subset.stream()
                        .forEach(System.out::print);
            });*/
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
     * Time complexity O(N2^N) to generate all subsets and then copy them into output list.
     * Space complexity O(N) using O(N) to maintain current subset
     *
     * @param nums
     * @param index
     * @return
     */
    private static List<List<Integer>> subsetsRec(int[] nums, int index){

        if (index == nums.length) {
            //return empty list
            return new ArrayList<>(){{add(new ArrayList<>());}};
        }

        //Recursion to perform sub task
        List<List<Integer>> partialAns = subsetsRec(nums, index+1);

        List<List<Integer>> output = new ArrayList<>();
        // Add subsets to output
        output.addAll(partialAns);

        //Copy the subsets to a new list, add current element and add these lists out output
        for(List<Integer> curr: partialAns){
            output.add(new ArrayList<>(curr) {{ add(nums[index]); }});
        }

        //only the final output is returned to calling method
        //all outputs returned from recursive calls are merged into the final output
        return output;
    }

    private static void subsetsRec2(int[] nums, int i, List<Integer> subset, List<List<Integer>> ans){
        if (i >= nums.length){
            //Add each subset to the answer at the end of the tree
            ans.add(new ArrayList<>(subset));
            return;
        }
        //include ith element to the subset
        subset.add(nums[i]);
        subsetsRec2(nums, i+1, subset, ans);
        //remove the ith element from subset and proceed with next element
        subset.remove(subset.size()-1);
        subsetsRec2(nums, i+1, subset, ans);
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
