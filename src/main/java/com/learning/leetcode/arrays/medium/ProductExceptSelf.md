## Problem statement

- Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
- You must write an algorithm that runs in O(n) time and without using the division operation.
```
Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```
```
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```
```
Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
```

## Solution
```java
import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("Given array : " + Arrays.toString(nums));
        System.out.println("Product of array except self : " + Arrays.toString(product(nums)));
        nums = new int[]{1,2,3,4};
        System.out.println("Product of array except self with single pass: " + Arrays.toString(productEff(nums)));
    }

    private static int[] product(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i< n; i++){
            result[i] = 1;
        }

        int product = 1;
        for(int i = 0; i < n; i++){
            result[i] = product;
            product *= nums[i];
        }

        product = 1;
        for(int i = n-1; i >= 0; i--){
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }

    private static int[] productEff(int[] nums){
        int len = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int[] result = new int[len];
        for(int i = 0; i < len; i++){
            result[i] = 1;
        }
        for(int i = 0; i < len; i++){
            result[i] *= leftProduct;
            leftProduct *= nums[i];
            int j = len-1-i;
            result[j] *= rightProduct;
            rightProduct *= nums[j];
        }
        return result;
    }
}
```
```python
from typing import List


def productExceptSelf(nums: List[int]) -> List[int]:
    n = len(nums)
    leftProduct = 1
    rightProduct = 1
    result = [1] * n
    for i in range(n):
        result[i] *= leftProduct
        leftProduct *= nums[i]
        j = n - 1 - i
        result[j] *= rightProduct
        rightProduct *= nums[j]
    return result


def main():
    nums = [1, 2, 3, 4]
    print("Given Array", nums)
    print("Running sum array: ", productExceptSelf(nums))
    nums = [-1, 1, 0, -3, 3]
    print("Running sum array: ", productExceptSelf(nums))


main()
```

## Complexity

- Time complexity is O(n)
- Space complexity is O(n) for the newly created array