## Problem statement
- Given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
- Rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
![Matrix 1 image](./matrix1.jpeg)
```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
```
![Matrix 1 image](./matrix2.jpeg)
```
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
```
Constraints:
```
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
```

## Solution
```java
import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(" Given Array ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        rotateMatrix(matrix);
        System.out.println("90 degrees rotated Array ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println(" Given Array ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        rotateMatrix(matrix);
        System.out.println("90 degrees rotated Array ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));


    }

    private static void rotateMatrix(int[][] matrix){
        //transpose
        // transforms rows to columns
        for(int i=0; i< matrix.length; i++){
            for(int j=i; j< matrix[0].length; j++){
                swap(matrix, i, j);
            }
        }
        System.out.println("Transposed Array ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));

        // reverse rows by swapping until half
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
```
```python
from typing import List


def rotate(matrix: List[List[int]]) -> None:
    # Transpose matrix
    for i in range(len(matrix)):
        for j in range(i, len(matrix)):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    for i in range(len(matrix)):
        for j in range(len(matrix) // 2):
            matrix[i][j], matrix[i][len(matrix) - 1 - j] = matrix[i][len(matrix) - 1 - j], matrix[i][j]


def main():
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print("Given matrix ")
    for row in matrix:
        print(row)
    rotate(matrix)
    print("Clockwise Rotated matrix ")
    for row in matrix:
        print(row)
    matrix = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]
    print("Given matrix ")
    for row in matrix:
        print(row)
    rotate(matrix)
    print("Clockwise Rotated matrix ")
    for row in matrix:
        print(row)


main()
```

## Complexity

- Time complexity is 2 * O(n<sup>2</sup>), which is approximately O(n<sup>2</sup>)
- Space complexity is O(1) except the given input