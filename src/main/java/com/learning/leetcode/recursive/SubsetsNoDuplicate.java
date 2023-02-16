package com.learning.leetcode.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsNoDuplicate {
    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> subsets = subsetsRec(nums,0);
        subsets.stream()
                .forEach(subset -> {
                    System.out.println("");
                    subset.stream()
                            .forEach(System.out::print);
                });

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
        List<List<Integer>> output = new ArrayList<>();

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

            final ArrayList<Integer> newSubList = new ArrayList<>(curr) {{
                add(nums[index]);
            }};


            boolean isDuplicate = false;
            for(List<Integer> exSubset: output){
                if(isDuplicate(exSubset, newSubList)){
                    isDuplicate = true;
                   break;
                }
            }
            if(!isDuplicate)
                output.add(newSubList);

        }

        //only the final output is returned to calling method
        //all outputs returned from recursive calls are merged into the final output
        return output;
    }

    static boolean isDuplicate(List<Integer> list1, List<Integer> list2) {
        // Optional quick test since size must match
        if (list1.size() != list2.size()) {
            return false;
        }
        List<Integer> work = new ArrayList(list2);
        for (Integer element : list1) {
            if (!work.remove(element)) {
                return false;
            }
        }
        return work.isEmpty();
    }

}
