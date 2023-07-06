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
