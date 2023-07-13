## Problem statement
- Given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
- Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
```
0 <= j <= nums[i] and
i + j < n
```
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Example 1:
```
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
```
Example 2:
```
Input: nums = [2,3,0,1,4]
Output: 2
```
Constraints:
```
1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1]
```

## Solution
- Again this used greedy approach to find the solution.

```java
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
```
```python
from typing import List


def jump(nums: List[int]) -> int:
    count = l = r = 0
    while r < len(nums) - 1:
        farthest = 0
        for i in range(l, r + 1):
            farthest = max(farthest, i + nums[i])
        l = r + 1
        r = farthest
        count += 1
        if l > r:
            return None
    return count


def main():
    nums = [2, 3, 1, 1, 4]
    print("Given Array: ", nums)
    print(" Can Reach the end in steps : ", jump(nums))
    nums = [3, 2, 1, 0, 4]
    print("Given Array: ", nums)
    print(" Can Reach the end in steps : ", jump(nums))


main()
```

## Complexity
- Time complexity is O(N) for the traversal
- Space complexity is O(1)