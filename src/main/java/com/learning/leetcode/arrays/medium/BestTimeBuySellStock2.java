package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class BestTimeBuySellStock2 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for " + Arrays.toString(prices) + " is " + getProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println("Max profit for " + Arrays.toString(prices) + " is " + getProfit(prices));
        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println("Max profit for " + Arrays.toString(prices) + " is " + getProfit(prices));

    }

    private static int getProfit(int[] prices) {
        int totalProfit = 0;
        for(int i = 1; i< prices.length; i++){
            if(prices[i] > prices[i-1]){
                totalProfit += (prices[i]- prices[i-1]);
            }
        }
        return totalProfit;
    }
}
