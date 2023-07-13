## Problem statement

- Given a list of songs where the ith song has a duration of time[i] seconds.
- Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

Example 1:
```
Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
```
Example 2:
```
Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
```
Constraints:
```
1 <= time.length <= 6 * 104
1 <= time[i] <= 500
```

## Solution
```python
from typing import List


def numPairsDivisibleBy60(time: List[int]) -> int:
    arr = [0] * 60
    count = 0
    for t in time:
        if t % 60 == 0:
            count += arr[0]
        else:
            count += arr[60 - t % 60]
        arr[t % 60] += 1
    return count


def main():
    time = [30, 20, 150, 100, 40]
    print("Given Array : ", time)
    print("No of pairs divisible by 60 : ", numPairsDivisibleBy60(time))
    time = [60, 60, 60]
    print("Given Array : ", time)
    print("No of pairs divisible by 60 : ", numPairsDivisibleBy60(time))


main()
```
```java
import java.util.Arrays;

public class PairOfSongs {
    public static void main(String[] args) {
        int[] time = {30, 20, 150, 100, 40};
        System.out.println("Given Array : " + Arrays.toString(time));
        System.out.println("No of pairs divisible by 60 : " + numPairsDivisibleBy60(time));
        time = new int[]{60, 60, 60};
        System.out.println("Given Array : " + Arrays.toString(time));
        System.out.println("No of pairs divisible by 60 : " + numPairsDivisibleBy60(time));

    }

    private static int numPairsDivisibleBy60(int[] time) {
        int[] moduloArr = new int[60];
        int count = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                count += moduloArr[0];
            } else {
                count += moduloArr[60 - t % 60];
            }
            moduloArr[t % 60]++;
        }
        return count;
    }
}
```

## Complexity

- Time complexity is O(N)
- Space complexity is O(1) as no additional space is required other than constant memory of array with 60 size.
