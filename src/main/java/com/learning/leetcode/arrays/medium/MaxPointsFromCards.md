## Problem Statement
- There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
- In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
- Total score is the sum of the points of the cards taken.
- Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Example 1:
```
Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
```
Example 2:
```
Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
```
Example 3:
```
Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.
```
Constraints:
```
1 <= cardPoints.length <= 105
1 <= cardPoints[i] <= 104
1 <= k <= cardPoints.length
```
## Solution
```python
from typing import List


def maxScore(cardPoints: List[int], k: int) -> int:
    l, r = 0, len(cardPoints) - k
    total = sum(cardPoints[r:])
    result = total
    while r < len(cardPoints):
        total += (cardPoints[l] - cardPoints[r])
        result = max(result, total)
        l += 1
        r += 1
    return result


def main():
    nums = [1, 2, 3, 4, 5, 6, 1]
    k = 3
    print("Given Array: ", nums)
    print("Max points obtained for %d cards is: %d " % (k, maxScore(nums, k)))
    nums = [2, 2, 2]
    k = 2
    print("Given Array: ", nums)
    print("Max points obtained for %d cards is: %d " % (k, maxScore(nums, k)))
    nums = [9, 7, 7, 9, 7, 7, 9]
    k = 7
    print("Given Array: ", nums)
    print("Max points obtained for %d cards is: %d " % (k, maxScore(nums, k)))


main()
```
```java
import java.util.Arrays;

public class MaxPointsFromCards {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Max score obtained in " + k + " steps is " + maxScore(nums, k));
        nums = new int[]{2,2,2};
        k = 2;
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Max score obtained in " + k + " steps is " + maxScore(nums, k));
        nums = new int[]{9,7,7,9,7,7,9};
        k = 7;
        System.out.println("Given Array: " + Arrays.toString(nums));
        System.out.println("Max score obtained in " + k + " steps is " + maxScore(nums, k));
    }

    private static int maxScore(int[] cardPoints, int k) {
        int left = 0, right = cardPoints.length - k;
        int sum=0;
        for(int i = right; i < cardPoints.length; i++){
            sum += cardPoints[i];
        }
        int result = sum;
        while(right < cardPoints.length){
            sum += (cardPoints[left] - cardPoints[right]);
            result = Math.max(result, sum);
            right++;
            left++;
        }
        return result;
    }
}
```
## Complexity
- Time complexity is O(k) because the window slide is happening for k times.
- Space complexity is O(1)
