## Problem statement

- The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.
- The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). 
  Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
  - Any live cell with fewer than two live neighbors dies as if caused by under-population.
  - Any live cell with two or three live neighbors lives on to the next generation.
  - Any live cell with more than three live neighbors dies, as if by over-population.
  - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
- The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

![Game of Life](./gameOfLife1.jpeg)

```
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
```
![Game of Life](./gameOfLife2.jpeg)
```
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
```
Constraints:
```
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.
```
## Solution
```java
import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        System.out.println("Given board");
        for (var row : board) {
            System.out.println(Arrays.toString(row));
        }
        gameOfLife(board);
        System.out.println("Game of Life board");
        for (var row : board) {
            System.out.println(Arrays.toString(row));
        }
        board = new int[][]{{1, 1}, {1, 0}};
        System.out.println("Given board");
        for (var row : board) {
            System.out.println(Arrays.toString(row));
        }
        gameOfLife(board);
        System.out.println("Game of Life board");
        for (var row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void gameOfLife(int[][] board) {
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                int liveCount = countLiveNeighbours(board, m, n);
                if (board[m][n] == 0 && liveCount == 3) {
                    board[m][n] = 2;
                }
                if (board[m][n] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[m][n] = -1;
                }
            }
        }
        resetValues(board);
    }

    private static int countLiveNeighbours(int[][] board, int m, int n) {
        // X and Y co-ordinates
        int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};
        int liveCount = 0;
        for (int i = 0; i < 8; i++) {
            final int curr_x = dx[i];
            final int curr_y = dy[i];
            if (isValid(board, curr_x + m, curr_y + n) && Math.abs(board[m + curr_x][n + curr_y]) == 1) {
                liveCount++;
            }
        }
        return liveCount;
    }

    private static boolean isValid(int[][] board, int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }

    private static void resetValues(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] >= 1) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }


}
```
```python
from typing import List


def isValid(board: List[List[int]], row: int, col: int):
    return 0 <= row < len(board) and 0 <= col < len(board[0])


def gameOfLife(board: List[List[int]]) -> None:
    """
    Do not return anything, modify board in-place instead.
    """

    for i in range(len(board)):
        for j in range(len(board[0])):
            dx = [1, 1, 1, 0, -1, -1, -1, 0]
            dy = [1, 0, -1, -1, -1, 0, 1, 1]
            live_count = 0
            for k in range(0, 8):
                if isValid(board, i + dx[k], j + dy[k]) and abs(board[i + dx[k]][j + dy[k]]) == 1:
                    live_count += 1

            if board[i][j] == 1 and (live_count < 2 or live_count > 3):
                board[i][j] = -1
            if board[i][j] == 0 and live_count == 3:
                board[i][j] = 2

    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] >= 1:
                board[i][j] = 1
            else:
                board[i][j] = 0


def main():
    board = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    print("Given Board")
    for row in board:
        print(row)
    print("Game of Life Board")
    gameOfLife(board)
    for row in board:
        print(row)
    board = [[1, 1], [1, 0]]
    print("Given Board")
    for row in board:
        print(row)
    print("Game of Life Board")
    gameOfLife(board)
    for row in board:
        print(row)


main()
```
