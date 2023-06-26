## Problem statement
- Given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
- Increment the large integer by one and return the resulting array of digits.

Example 1:
```
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
```
Example 2:
```
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
```
Example 3:
```
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
```
Constraints:
```
1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
```

## Solution
```java
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        System.out.println("Original array" + Arrays.toString(digits));
        System.out.println("Plus one array" + Arrays.toString(plusOne(digits)));
        digits = new int[]{9};
        System.out.println("Original array" + Arrays.toString(digits));
        System.out.println("Plus one array" + Arrays.toString(plusOne(digits)));
        digits = new int[]{9,9};
        System.out.println("Original array" + Arrays.toString(digits));
        System.out.println("Plus one array" + Arrays.toString(plusOne(digits)));

    }

    private static int[] plusOne(int[] digits){
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        System.out.println(Arrays.toString(digits));
        // This is applicable for the scenarios like [9],[9,9],[9,9,9] etc.
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
```
```python
from typing import List


def plusOne(digits: List[int]) -> List[int]:
    for i in range(-1, -len(digits) - 1, -1):
        if digits[i] < 9:
            digits[i] += 1
            return digits
        else:
            digits[i] = 0
    digits = [0] * (len(digits) + 1)
    digits[0] = 1
    return digits


def main():
    digits = [9, 8, 7, 6, 5, 9]
    print('Given -> %20s' % digits)
    print('Plus one  -> %16s' % plusOne(digits))
    digits = [9]
    print('Given -> %20s' % digits)
    print('Plus one  -> %16s' % plusOne(digits))
    digits = [9, 9]
    print('Given -> %20s' % digits)
    print('Plus one  -> %16s' % plusOne(digits))


main()
```