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