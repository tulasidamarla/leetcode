package com.learning.leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {


        int[][] intervals = {{1,4},{5,6}};
        System.out.println("Given Array");
        for(int[] row: intervals){
            System.out.println(Arrays.toString(row));
        }
        int[][] result = mergeIntervals(intervals);
        System.out.println("Result");
        for(int[] row: result){
            System.out.println(Arrays.toString(row));
        }
        intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Given Array");
        for(int[] row: intervals){
            System.out.println(Arrays.toString(row));
        }
        result = mergeIntervals(intervals);
        System.out.println("Result");
        for(int[] row: result){
            System.out.println(Arrays.toString(row));
        }
        intervals = new int[][]{{1,4},{0,4}};
        System.out.println("Given Array");
        for(int[] row: intervals){
            System.out.println(Arrays.toString(row));
        }
        result = mergeIntervals(intervals);
        System.out.println("Result");
        for(int[] row: result){
            System.out.println(Arrays.toString(row));
        }
        intervals = new int[][]{{1,4},{0,1}};
        System.out.println("Given Array");
        for(int[] row: intervals){
            System.out.println(Arrays.toString(row));
        }
        result = mergeIntervals(intervals);
        System.out.println("Result");
        for(int[] row: result){
            System.out.println(Arrays.toString(row));
        }
        intervals = new int[][]{{1,4},{0,2},{3,5}};
        System.out.println("Given Array");
        for(int[] row: intervals){
            System.out.println(Arrays.toString(row));
        }
        result = mergeIntervals(intervals);
        System.out.println("Result");
        for(int[] row: result){
            System.out.println(Arrays.toString(row));
        }


    }

    private static int[][] mergeIntervals(int[][] intervals){
        if (intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for(int[] interval: intervals){
            if (interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
