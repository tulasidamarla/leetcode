## Problem statement

- Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
- Notice that the solution set must not contain duplicate triplets.
```
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
```
```
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
```
```
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
```
Constraints:
```
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
```

## Solution
```python
from typing import List


def threeSum(nums: List[int]) -> List[List[int]]:
    result = []
    nums.sort()
    n = len(nums)
    i = 0
    while i < n:
        start = i + 1
        end = n - 1
        target = -nums[i]
        while start < end:
            if nums[start] + nums[end] == target:
                result.append([nums[i], nums[start], nums[end]])
                start += 1
                end -= 1
                while start < end and nums[start] == nums[start + 1]:
                    start += 1
                while start < end and nums[end] == nums[end - 1]:
                    end -= 1
            elif nums[start] + nums[end] > target:
                end -= 1
            else:
                start += 1
            while i + 1 < n and nums[i] == nums[i+1]:
                i += 1
        i += 1
    return result


def main():
    nums = [-1, 0, 1, 2, -1, -4]
    print("Given array ", str(nums))
    results = threeSum(nums)
    print("3Sum result", str(results))


main()
```
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Given Array : " + Arrays.toString(nums));
        List<List<Integer>> result = threeSum(nums);
        System.out.print("ThreeSum Result : \t");
        result.forEach(System.out::print);
    }

    private static List<List<Integer>> threeSum(int[] nums){
        final List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int start = i + 1;
            int end = n - 1;
            int target = -nums[i];
            while(start < end){
                if (nums[start] + nums[end] == target){
                    result.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    //Eliminate duplicates for the start element
                    while(start < end && nums[start] == nums[start+1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end-1]){
                        end--;
                    }

                } else if (nums[start] + nums[end] > target){
                    end--;
                } else {
                    start++;
                }
                while(i+1 < n && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
        return result;
    }
}
```

## Complexity

- Time complexity
  - For sorting nlogn
  - For nested loops O(n<sup>2</sup>)  
  - Total time complexity is O(n<sup>2</sup>)
- Space complexity is O(n) which is the size of input array. No additional memory is required.    