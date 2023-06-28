## Problem statement

- Given an integer numRows, return the first numRows of Pascal's triangle.
- In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
![Pascal Triangle](./PascalTriangleAnimated.gif)

Example 1:
```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```
Example 2:
```
Input: numRows = 1
Output: [[1]]
```
Constraints:
```
1 <= numRows <= 30
```

## Solution
```python
from typing import List


def generate(numRows: int) -> List[List[int]]:
    output = []
    prev = []
    for i in range(numRows):
        if i == 0:
            prev = [1]
            output.append(prev)
        else:
            curr = [1]
            j = 1
            # Loop executes only for j value greater than 1
            while j < i:
                curr.append(prev[j - 1] + prev[j])
                j += 1
            curr.append(1)
            output.append(curr)
            prev = curr
    return output


def main():
    result = generate(5)
    for row in result:
        print(row)


main()
```
```java
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> result = generatePascalTriangle(5);
        result.forEach(System.out::println);

    }

    private static List<List<Integer>> generatePascalTriangle(int num){
        List<List<Integer>> result = new ArrayList<>();
        if (num == 0){
            return result;
        }
        for(int i = 0; i < num; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    row.add(1);
                } else {
                    row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j) );
                }
            }
            result.add(row);
        }
        return result;
    }
}
```

## Complexity

- Time complexity is O(n<sup>2</sup>) due to nested loops.
- Space complexity is O(n<sup>2</sup>) because it requires two-dimensional array or list