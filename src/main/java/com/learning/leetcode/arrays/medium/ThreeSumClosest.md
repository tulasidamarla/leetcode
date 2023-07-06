## Problem statement

- Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
- Return the sum of the three integers. Assume that each input would have exactly one solution.

Example 1:
```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```
Example 2:
```
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
```
Constraints:
```
3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
```

## Solution
```python
from typing import List
import sys


def threeSumClosest(nums: List[int], target: int) -> int:
    nums.sort()
    minDiff = sys.maxsize
    resultSum = nums[0] + nums[1] + nums[2]
    for i in range(len(nums)):
        left = i + 1
        right = len(nums) - 1
        while left < right:
            threeSum = nums[i] + nums[left] + nums[right]
            if threeSum == target:
                return threeSum
            elif threeSum < target:
                left += 1
            else:
                right -= 1
            currDiff = abs(threeSum - target)
            if currDiff < minDiff:
                resultSum = threeSum
                minDiff = currDiff
    return resultSum


def main():
    nums = [-1, 2, 1, -4]
    target = 1
    print("Given Array", nums)
    closestSum = threeSumClosest(nums, target)
    print("Threesum closest to target %d is %d" % (target, closestSum))
    nums = [0, 0, 0]
    target = 1
    print("Given Array", nums)
    closestSum = threeSumClosest(nums, target)
    print("Threesum closest to target %d is %d" % (target, closestSum))


main()
```
```java
import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println("Given Array " + Arrays.toString(nums));
        System.out.printf(" Sum closest to target %d is %d ", target, threeSumClosestToTarget(nums, target));
        nums = new int[]{0,0,0};
        target = 1;
        System.out.println();
        System.out.println("Given Array " + Arrays.toString(nums));
        System.out.printf(" Sum closest to target %d is %d ", target, threeSumClosestToTarget(nums, target));

    }

    private static int threeSumClosestToTarget(int[] nums, int target){
        int resultSum = nums[0] + nums[1] + nums[2];
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target){
                    return sum;
                } else if (sum < target){
                    left++;
                } else {
                    right--;
                }
                int currDiff = Math.abs(sum-target);
                if (currDiff < minDiff){
                    resultSum = sum;
                    minDiff = currDiff;
                }
            }
        }
        return resultSum;
    }
}
```

## Complexity

- Time complexity
  - For sorting nlogn
  - For nested for loop n<sup>2</sup>
  - Total time complexity is O(n<sup>2</sup>) ignoring the lower order term nlogn
- Space complexity is O(1) excluding the input
  