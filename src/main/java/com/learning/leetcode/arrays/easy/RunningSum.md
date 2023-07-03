## Problem statement

- Given an array nums. We define a running sum of an array as 
  runningSum[i] = sum(nums[0]…nums[i]). Return the running sum of nums.
```
Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
```
```
Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
```
```
Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
```
Constraints:
```
1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6
```

## Solution

```python
from typing import List


def runningSum(nums: List[int]) -> List[int]:
    for i in range(1, len(nums)):
        nums[i] += nums[i - 1]
    return nums


def main():
    nums = [1, 2, 3, 4]
    print("Given Array", nums)
    print("Running sum array: ", runningSum(nums))


main()
```
```java
import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("Given array : " + Arrays.toString(nums));
        runningSum(nums);
        System.out.println("Running sum array : " + Arrays.toString(nums));
    }

    private static void runningSum(int[] nums){
        for(int i=1; i<nums.length;i++){
            nums[i] += nums[i-1];
        }
    }
}
```

## Complexity

- Time complexity is O(n) for iterating array elements
- Space complexity is O(n) for the given array