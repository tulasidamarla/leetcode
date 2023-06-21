package com.learning.leetcode.recursive.medium.subsets;

import java.util.*;

public class PartitionKEqualSubsets {

    public static void main(String[] args) {
       int[] nums = {4,3,2,3,5,2,1};
       int k = 4;
       int sum = Arrays.stream(nums).sum();
       if (sum % k != 0){
           System.out.println("No equal subsets possible");
       }
       System.out.println("Equal subsets size " + sum/k);

       boolean result = partitionKSubsets(0, 1,0, sum/k, k, nums, new HashMap<>());
       System.out.println("No of equal subsets possible " + result);

        int[] nums2 = new int[]{1,2,3,4};
        int k2 = 3;
        int sum2 = Arrays.stream(nums2).sum();
        if (sum2 % k2 != 0){
            System.out.println("No equal subsets possible");
        }
        System.out.println("Equal subsets size " + sum2/k2);

        boolean result2 = partitionKSubsets(0, 1,0, sum2/k2, k2, nums2, new HashMap<>());
        System.out.println("No of equal subsets possible " + result2);
    }

    private static boolean partitionKSubsets(int index, int bucketNumber, int bucketSum, int requiredSum,
                                             int k, int[] nums, Map<Integer, Integer> pickedMap) {

        if (bucketNumber == k+1) return true;
        if (bucketSum == requiredSum){
            return partitionKSubsets(0, bucketNumber+1, 0, requiredSum, k, nums, pickedMap);
        }
        if (bucketSum > requiredSum ) return false;
        if ( index >= nums.length ) return false;
        if (pickedMap.containsKey(index) && pickedMap.get(index) == 1){
            return partitionKSubsets(index+1, bucketNumber, bucketSum, requiredSum, k, nums, pickedMap);
        } else {
                bucketSum += nums[index];
                pickedMap.put(index, 1);
                boolean op1 = partitionKSubsets(index + 1, bucketNumber, bucketSum, requiredSum, k, nums, pickedMap);

                bucketSum -= nums[index];
                pickedMap.put(index, 0);
                boolean op2 = partitionKSubsets(index + 1, bucketNumber, bucketSum, requiredSum, k, nums, pickedMap);

                return op1 | op2;
        }
    }
}
