package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class ContainerWithMaxWater {
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Given heights : " + Arrays.toString(heights));
        System.out.println("Max area is : " + containerWithMaxWater(heights));
        heights = new int[]{1, 1};
        System.out.println("Given heights : " + Arrays.toString(heights));
        System.out.println("Max area is : " + containerWithMaxWater(heights));
    }

    private static int containerWithMaxWater(int[] heights) {
        int leftIndex = 0;
        int rightIndex = heights.length - 1;
        int maxArea = 0;
        while (leftIndex < rightIndex) {
            int currArea = (rightIndex - leftIndex) * Math.min(heights[leftIndex], heights[rightIndex]);
            maxArea = Math.max(maxArea, currArea);
            if (heights[leftIndex] < heights[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxArea;
    }
}
