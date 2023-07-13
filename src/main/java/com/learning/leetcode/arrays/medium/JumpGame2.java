package com.learning.leetcode.arrays.medium;

import java.util.Arrays;

public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Can reach the end in steps: " + jump(nums));
        nums = new int[]{3,2,1,0,4};
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Can reach the end in steps: " + jump(nums));
    }

    private static int jump(int[] nums) {
        int count = 0, l = 0, r = 0;
        while(r < nums.length - 1){
            int farthest = 0;
            for (int i = l; i < r +1; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;

            if(l > r)
                return -1;
            count++;
        }
        return count;
    }
}
