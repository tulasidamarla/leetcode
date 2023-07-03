package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("Given array : " + Arrays.toString(nums));
        System.out.println("Product of array except self : " + Arrays.toString(product(nums)));
        nums = new int[]{1,2,3,4};
        System.out.println("Product of array except self with single pass: " + Arrays.toString(productEff(nums)));
    }

    private static int[] product(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i< n; i++){
            result[i] = 1;
        }

        int product = 1;
        for(int i = 0; i < n; i++){
            result[i] = product;
            product *= nums[i];
        }

        product = 1;
        for(int i = n-1; i >= 0; i--){
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }

    private static int[] productEff(int[] nums){
        int len = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int[] result = new int[len];
        for(int i = 0; i < len; i++){
            result[i] = 1;
        }
        for(int i = 0; i < len; i++){
            result[i] *= leftProduct;
            leftProduct *= nums[i];
            int j = len-1-i;
            result[j] *= rightProduct;
            rightProduct *= nums[j];
        }
        return result;
    }
}
