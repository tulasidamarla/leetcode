## Problem statement

- Given an array nums of size n, return the majority element.
- The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
```
Example 1:

Input: nums = [3,2,3]
Output: 3
```
```
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
```
Constraints:
```
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
```

## Solution
```java
import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println("Majority element for " + Arrays.toString(nums) + " is " + majorityElement(nums));
        nums = new int[]{2,2,1,1,2,2,1};
        System.out.println("Majority element for " + Arrays.toString(nums) + " is " + majorityElement(nums));

    }

    private static int majorityElement(int[] nums){
        int candidate = 0;
        int votes = 0;
        for(int num: nums){
            if (votes == 0){
                candidate = num;
            }
            if (candidate == num){
                votes++;
            } else {
                votes--;
            }
        }
        return candidate;
    }


}
```
```python
from typing import List


def majorityElement(nums: List[int]) -> int:
    candidate = 0
    votes = 0
    for num in nums:
        if votes == 0:
            candidate = num
        if candidate == num:
            votes += 1
        else:
            votes -= 1
    return candidate


def main():
    nums = [3, 2, 3]
    print('Majority element for ' + str(nums) + ' is ' + str(majorityElement(nums)))
    nums = [2, 2, 1, 2, 2, 1, 1]
    print('Majority element for ' + str(nums) + ' is ' + str(majorityElement(nums)))


main()
```
## Complexity
- Time complexity is O(n) because array is visited once.
- Space complexity is O(1) as no additional space is consumed.