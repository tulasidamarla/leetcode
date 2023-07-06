## Problem statement

- Given an m x n grid of characters board and a string word, return true if word exists in the grid.
- The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once. 
  
Example 1:

![](word1.jpeg)
```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
```
Example 2:

![](word2.jpeg)
```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
```
Example 3:

![](word3.jpg)
```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
```
Constraints:
```
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
```

## Solution
```python
from typing import List


def exist(board: List[List[str]], word: str) -> bool:
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == word[0]:
                print("search starts at " + str(i) + "," + str(j))
                if search(board, word, 0, i, j):
                    return True
    return False


def search(board: List[List[str]], word: str, wordIndex: int, sr: int, sc: int) -> bool:
    if wordIndex == len(word):
        print("search ends at " + str(sr) + "," + str(sc))
        return True
    if sr < 0 or sc < 0 or sr == len(board) or sc == len(board[0]) or word[wordIndex] != board[sr][sc]:
        return False
    ch = board[sr][sc]
    board[sr][sc] = '#'
    op1 = search(board, word, wordIndex + 1, sr + 1, sc)
    op2 = search(board, word, wordIndex + 1, sr, sc + 1)
    op3 = search(board, word, wordIndex + 1, sr - 1, sc)
    op4 = search(board, word, wordIndex + 1, sr, sc - 1)
    board[sr][sc] = ch
    return op1 or op2 or op3 or op4


def main():
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "SEE"
    res = exist(board, word)
    for row in board:
        print(row)
    print("Word %s exists: %s" % (word, str(res)))
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "ABCCED"
    res = exist(board, word)
    for row in board:
        print(row)
    print("Word %s exists: %s" % (word, str(res)))
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "ABCB"
    res = exist(board, word)
    for row in board:
        print(row)
    print("Word %s exists: %s" % (word, str(res)))


main()
```
```java
import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        char[][] matrix = {{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        System.out.println("Given matrix ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        String word = "SEE";
        boolean result = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(matrix[i][j] == word.charAt(0)){
                    result = search(matrix, word, 0, i, j);
                }
            }
        }

        //search(matrix, word, 0, sr, sc)
        System.out.printf("Given word %s found: %s", word, result);

        System.out.println("Given Matrix after search ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    private static boolean search(char[][] matrix, String word, int wordIndex, int sr, int sc){
        if (wordIndex == word.length()){
            return true;
        }

        if (sr < 0 || sc < 0 || sr == matrix.length || sc == matrix[0].length || matrix[sr][sc] != word.charAt(wordIndex)){
            return false;
        }

        char temp = matrix[sr][sc];
        matrix[sr][sc] = '#';
        boolean res1 = search(matrix, word, wordIndex+1, sr+1, sc);
        boolean res2 = search(matrix, word, wordIndex+1, sr, sc+1);
        boolean res3 = search(matrix, word, wordIndex+1, sr-1, sc);
        boolean res4 = search(matrix, word, wordIndex+1, sr, sc-1);
        matrix[sr][sc] = temp;
        return res1 || res2 || res3 || res4;
    }
}
```

## Complexity

- If m X n is the matrix and search word length is k
- Time complexity
  - For nested for loop m * n
  - For the tree in all 4 directions 4<sup>k</sup>  
  - Total time complexity is O(m*n*4<sup>k</sup>)
- Space complexity is the height of the tree, which is nothing but k. so, space complexity is O(k)