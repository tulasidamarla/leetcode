## Problem statement
- Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
- You may assume that each input would have exactly one solution, and you may not use the same element twice.
- You can return the answer in any order.
```
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```
```
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
```
```
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
```
```
Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
```

## Solution

```java
public class TwoIntSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int required = target - current;
            if (indexMap.containsKey(required)) {
                return new int[]{i, indexMap.get(required)};
            }
            indexMap.put(current, i);
        }
        return null;
    }
}
```

```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_dict={}
        for i in range(len(nums)):
            required = target-nums[i]
            if required in num_dict:
                return [num_dict[required], i]
            num_dict[nums[i]] = i      

```