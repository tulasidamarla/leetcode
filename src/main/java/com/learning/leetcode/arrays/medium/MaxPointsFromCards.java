package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class MaxPointsFromCards {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Max score obtained in " + k + " steps is " + maxScore(nums, k));
        nums = new int[]{2,2,2};
        k = 2;
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Max score obtained in " + k + " steps is " + maxScore(nums, k));
        nums = new int[]{9,7,7,9,7,7,9};
        k = 7;
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Max score obtained in " + k + " steps is " + maxScore(nums, k));
    }

    private static int maxScore(int[] cardPoints, int k) {
        int left = 0, right = cardPoints.length - k;
        int sum=0;
        for(int i = right; i < cardPoints.length; i++){
            sum += cardPoints[i];
        }
        int result = sum;
        while(right < cardPoints.length){
            sum += (cardPoints[left] - cardPoints[right]);
            result = Math.max(result, sum);
            right++;
            left++;
        }
        return result;
    }
}
