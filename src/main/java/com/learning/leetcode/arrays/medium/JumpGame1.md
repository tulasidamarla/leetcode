## Problem statement
- Given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
- Return true if you can reach the last index, or false otherwise.

Example 1:
```
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```
Example 2:
```
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
```
Constraints:
```
1 <= nums.length <= 104
0 <= nums[i] <= 105
```

## Solution
- Solution uses greedy approach. It traverses the array from the end to see if it reaches the beginning.

```python
from typing import List


def canJump(nums: List[int]) -> bool:
    goal = len(nums) - 1
    for i in range(len(nums) - 2, -1, -1):
        if i + nums[i] >= goal:
            goal = i
    return goal == 0


def main():
    nums = [2, 3, 1, 1, 4]
    print("Given Array: ", nums)
    print(" Can Reach the End", canJump(nums))
    nums = [3, 2, 1, 0, 4]
    print("Given Array: ", nums)
    print(" Can Reach the End", canJump(nums))


main()
```
```java
import java.util.Arrays;

public class JumpGame1 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Can reach the end: " + canJump(nums));
        nums = new int[]{3,2,1,0,4};
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Can reach the end: " + canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0 ; i--){
            if (i + nums[i] >= goal){
                goal = i;
            }
        }
        return goal == 0;
    }
}
```

## Complexity

- Time complexity is O(N) for traversal
- Space complexity is O(1)