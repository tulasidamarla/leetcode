## Problem statement

- Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
- There is only one repeated number in nums, return this repeated number.
- Solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
```
Input: nums = [1,3,4,2,2]
Output: 2
```
Example 2:
```
Input: nums = [3,1,3,4,2]
Output: 3
```
Constraints:
```
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
```

## Solution
- Solution for this problem is based on linked list cycle detection problem.
- Please refer this link 
[Linked list cycle getLoopStart](https://github.com/tulasidamarla/algorithms-and-data-structures/blob/master/datastructures/src/main/java/com/learning/linkedlists/SingleLinkedList.java#L475)
```python
from typing import List


def findDuplicate(nums: List[int]) -> int:
    slow = 0
    fast = 0
    while True:
        slow = nums[slow]
        fast = nums[nums[fast]]
        if slow == fast:
            break
    slow = 0
    while slow != fast:
        slow = nums[slow]
        fast = nums[fast]
    return slow


def main():
    nums = [1, 3, 4, 2, 2]
    print("Given Array: ", nums)
    print("Duplicate number ", str(findDuplicate(nums)))
    nums = [3, 1, 3, 4, 2]
    print("Given Array: ", nums)
    print("Duplicate number ", str(findDuplicate(nums)))


main()
```  
```java
import java.util.Arrays;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Duplicate Number is " + findDuplicate(nums));
        nums = new int[]{3,1,3,4,2};
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Duplicate Number is " + findDuplicate(nums));

    }

    private static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
```

## Complexity
- Time complexity is O(N) for looping through the cycle
- Space complexity is O(1)
