## Problem statement

- Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
- A sub array is a contiguous non-empty sequence of elements within an array.

Example 1:
```
Input: nums = [1,1,1], k = 2
Output: 2
```
Example 2:
```
Input: nums = [1,2,3], k = 3
Output: 2
```
Constraints:
```
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
```

## Solution
```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println("Given Array " + Arrays.toString(nums));
        System.out.println("No of sub arrays " + noOfSubArraysBruteForce(nums, k));
        nums = new int[]{1,-1,0};
        k = 0;
        System.out.println("Given Array " + Arrays.toString(nums));
        System.out.println("No of sub arrays " + noOfSubArraysBruteForce(nums, k));
        System.out.println("Given Array " + Arrays.toString(nums));
        System.out.println("No of sub arrays using efficient method is " + noOfSubArraysEff(nums, k));

    }

    private static int noOfSubArraysBruteForce(int[] nums, int k){
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum == k){
                    count++;
                }
            }
            sum = 0;
        }
        return count;
    }

    private static int noOfSubArraysEff(int[] nums, int k){
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
```
```python
from typing import List


def subArraysCount(nums: List[int], k: int) -> int:
    sumMap = {}
    sumSoFar = 0
    count = 0
    sumMap[0] = 1
    for i in range(len(nums)):
        sumSoFar += nums[i]
        if (sumSoFar - k) in sumMap:
            count += sumMap[sumSoFar - k]
        sumMap[sumSoFar] = sumMap.get(sumSoFar, 0) + 1
        print(sumMap)
    return count


def main():
    nums = [1, 1, 1]
    k = 2
    print("Given Array " + str(nums))
    print("No of sub arrays for k=%d are %s" % (k, str(subArraysCount(nums, k))))
    nums = [1, -1, 0]
    k = 0
    print("Given Array " + str(nums))
    print("No of sub arrays for k=%d are %s" % (k, str(subArraysCount(nums, k))))
    nums = [1, -1, 0]
    k = -1
    print("Given Array " + str(nums))
    print("No of sub arrays for k=%d are %s" % (k, str(subArraysCount(nums, k))))


main()
```

## Complexity

- Time complexity is O(n)
- Space complexity is O(n) for the map.