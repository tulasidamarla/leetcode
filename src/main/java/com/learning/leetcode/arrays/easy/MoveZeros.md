## Problem statement
- Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
- Note that you must do this in-place without making a copy of the array.
```
Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```
```
Example 2:

Input: nums = [0]
Output: [0]
```
```
Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
```

## Solution
```python
from typing import List


def moveZeroes2(nums: List[int]) -> None:
    j = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[j] = nums[i]
            j += 1
    while j < len(nums):
        nums[j] = 0
        j += 1


def moveZeroes(nums: List[int]) -> None:
    j = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[j], nums[i] = nums[i], nums[j]
            j += 1


def main():
    nums = [0, 1, 0, 3, 12]
    print('Given array %30s' % nums)
    moveZeroes(nums)
    print('After moving zeros %23s' % nums)
    nums = [0, 1, 0, 3, 12]
    print('Given array %30s' % nums)
    moveZeroes2(nums)
    print('After moving zeros %23s' % nums)


main()
```
```java
import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        System.out.println("Before moving zeros " + Arrays.toString(nums));
        moveZeros(nums);
        System.out.println("After moving zeros " + Arrays.toString(nums));
    }

    private static void moveZeros(int[] digits){
        int j = 0;
        for(int i=0; i < digits.length;i++){
            if(digits[i] !=0){
                // post increment operator here increments index post assignment
                digits[j++] = digits[i];
                //j++;
            }
        }
        while(j < digits.length){
            digits[j++] = 0;
            //j++;
        }
    }
}
```