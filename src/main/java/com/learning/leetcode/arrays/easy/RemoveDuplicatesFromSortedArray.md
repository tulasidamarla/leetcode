## Problem statement

- Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
- Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
- Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums. Return k.
```
Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```
Example 2:
```
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

Constraints:
```
1 <= nums.length <= 3 * 10^4
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
```

## Solution
```java
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println("Before removing duplicates array is " + Arrays.toString(nums));
        int k = removeDuplicates(nums);
        System.out.println("After removing duplicates array is " + Arrays.toString(nums));
        System.out.println("Unique values are filtered until position " + k);

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println("Before removing duplicates array is " + Arrays.toString(nums));
        k = removeDuplicates(nums);
        System.out.println("After removing duplicates array is " + Arrays.toString(nums));
        System.out.println("Unique values are filtered until position " + k);
    }

    private static int removeDuplicates(int[] nums){
        int k = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
```
```python
from typing import List


def removeDuplicates(nums: List[int]) -> int:
    k = 1
    for i in range(1, len(nums)):
        if nums[i] != nums[i - 1]:
            nums[k] = nums[i]
            k += 1
    return k


def main():
    nums = [1, 1, 2]
    print("Before removing duplicates array is " + str(nums))
    k = removeDuplicates(nums)
    print("After removing duplicates array is " + str(nums))
    print("Unique values are filtered until position " + str(k))

    nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    print("Before removing duplicates array is " + str(nums))
    k = removeDuplicates(nums)
    print("After removing duplicates array is " + str(nums))
    print("Unique values are filtered until position " + str(k))


main()
```

## Complexity
- Time complexity is O(n)
- Space complexity is O(1)