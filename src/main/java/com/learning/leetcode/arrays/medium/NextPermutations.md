## Problem statement

- A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
- For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
- The next permutation of arr = [1,2,3] is [1,3,2].
- Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
- The next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.


Example 1:
```
Input: nums = [1,2,3]
Output: [1,3,2]
```
Example 2:
```
Input: nums = [3,2,1]
Output: [1,2,3]
```
Example 3:
```
Input: nums = [1,1,5]
Output: [1,5,1]
```
Constraints:
```
1 <= nums.length <= 100
0 <= nums[i] <= 100
```

## Solution
```java
import java.util.Arrays;

public class NextPermutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Given sequence " + Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("Next permutation " + Arrays.toString(nums));
        nums = new int[]{1, 3, 5, 4, 2};
        System.out.println("Given sequence " + Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("Next permutation " + Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums){
        int n = nums.length;
        if (nums.length <= 1){
            return;
        }
        int i = nums.length -2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if (i >= 0){
            int j = nums.length-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            //swap
            swap(nums, i, j);
        }
        //reverse from i+1 to end
        reverse(nums, i+1, nums.length-1);
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start++, end--);
        }
    }
}
```
```python
from typing import List


def nextPermutation(nums: List[int]) -> None:
    if len(nums) <= 1:
        return
    i = len(nums) - 2
    # Decrement i from the end until nums[i] is less than nums[i+1]
    # Ex: 2 1 5 4 3 (1 is less than 5)
    while i >= 0 and nums[i] >= nums[i + 1]:
        i -= 1
    if i >= 0:
        j = len(nums) - 1
        # In this example j stops at 3 because the condition fails at last index itself
        while nums[j] <= nums[i]:
            j -= 1
        # Swap values at indexes i and j
        # Now the sequence is 2 3 5 4 1
        nums[i], nums[j] = nums[j], nums[i]
    # Reverse all values from i + 1 to the end
    # So final solution is 2 3 1 4 5
    k = len(nums) - 1
    while i < k:
        nums[i + 1], nums[k] = nums[k], nums[i + 1]
        i += 1
        k -= 1


def main():
    nums = [1, 2, 3]
    print("Given array ", nums)
    nextPermutation(nums)
    print("Next permutation ", nums)
    nums = [1, 3, 5, 4, 2]
    print("Given array ", nums)
    nextPermutation(nums)
    print("Next permutation ", nums)
    nums = [2, 1, 5, 4, 3]
    print("Given array ", nums)
    nextPermutation(nums)
    print("Next permutation ", nums)


main()
```

## Complexity
- Time complexity is O(n)
- Space complexity is O(1)