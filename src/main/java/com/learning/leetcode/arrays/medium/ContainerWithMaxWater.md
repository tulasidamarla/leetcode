## Problem statement

- Given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
- Find two lines that together with the x-axis form a container, such that the container contains the most water.
- Return the maximum amount of water a container can store.
- Notice that you may not slant the container.

 ![Container with water](./container.jpg)

Example 1:
```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
```
Example 2:
```
Input: height = [1,1]
Output: 1
```
Constraints:
```
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
```

## Solution
```python
from typing import List


def containerWithMaxWater(heights: List[int]) -> int:
    left_index = 0
    right_index = len(heights) - 1
    maxArea = 0
    while left_index < right_index:
        left_height = heights[left_index]
        right_height = heights[right_index]
        min_height = min(left_height, right_height)
        curr_area = (right_index - left_index) * min_height
        maxArea = max(curr_area, maxArea)
        if left_height < right_height:
            left_index += 1
        else:
            right_index -= 1
    return maxArea


def main():
    heights = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print("Given heights : ", heights)
    print("Max area is : ", str(containerWithMaxWater(heights)))
    heights = [1, 1]
    print("Given heights : ", heights)
    print("Max area is : ", str(containerWithMaxWater(heights)))


main()
```
```java
import java.util.Arrays;

public class ContainerWithMaxWater {
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Given heights : " + Arrays.toString(heights));
        System.out.println("Max area is : " + containerWithMaxWater(heights));
        heights = new int[]{1, 1};
        System.out.println("Given heights : " + Arrays.toString(heights));
        System.out.println("Max area is : " + containerWithMaxWater(heights));
    }

    private static int containerWithMaxWater(int[] heights) {
        int leftIndex = 0;
        int rightIndex = heights.length - 1;
        int maxArea = 0;
        while (leftIndex < rightIndex) {
            int currArea = (rightIndex - leftIndex) * Math.min(heights[leftIndex], heights[rightIndex]);
            maxArea = Math.max(maxArea, currArea);
            if (heights[leftIndex] < heights[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxArea;
    }
}
```

## Complexity
- Time complexity is O(n)
- Space complexity is O(1) except for the input