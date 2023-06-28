## Problem statement

- Given an array of intervals where intervals[i] = [start, end], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
```
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
```
Example 2:
```
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```
Constraints:
```
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
```

## Solution
```java
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
```
```python
from typing import List
import operator


def merge(intervals: List[List[int]]) -> List[List[int]]:
    sortedIntervals = sorted(intervals, key=operator.itemgetter(0))

    newIntervals = []
    newInterval = sortedIntervals[0]
    newIntervals.append(newInterval)
    for interval in sortedIntervals:
        if interval[0] <= newInterval[1]:
            newInterval[1] = max(interval[1], newInterval[1])
        else:
            newIntervals.append(interval)
            newInterval = interval
    return newIntervals


def main():
    intervals = [[1, 2], [0, 1], [2, 3]]
    print("Given array" + str(intervals))
    newIntervals = merge(intervals)
    print("Output" + str(newIntervals))


main()
```

## Complexity

- Time complexity is 
  - O(nlogn) due to sorting of array.
  - n for the for loop
  - Total (nlogn + n) which is O(n)
- Space complexity is O(n) for the new sorted array    