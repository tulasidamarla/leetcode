package com.learning.leetcode.arrays.easy;

import java.util.Arrays;

public class BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for " + Arrays.toString(prices) + " is " + getProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println("Max profit for " + Arrays.toString(prices) + " is " + getProfit(prices));
    }

    private static int getProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }
}
