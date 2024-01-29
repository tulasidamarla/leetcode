def maze_helper(i, j, n, arr, path, result):
    if i == n - 1 and j == n - 1:
        result.append("".join(path))
    elif 0 <= i < n and 0 <= j < n and arr[i][j] != 0:
        # Mark visited node with 0 to stop moving between left and right
        arr[i][j] = 0

        # Down
        path.append("D")
        maze_helper(i + 1, j, n, arr, path, result)
        path.pop()

        # Left
        path.append("L")
        maze_helper(i, j - 1, n, arr, path, result)
        path.pop()

        # Right
        path.append("R")
        maze_helper(i, j + 1, n, arr, path, result)
        path.pop()

        # Up
        path.append("U")
        maze_helper(i - 1, j, n, arr, path, result)
        path.pop()

        arr[i][j] = 1

# Example usage:
n = 4  # Replace with your maze size
arr = [
    [1, 0, 0, 0],
    [1, 1, 0, 1],
    [0, 1, 0, 0],
    [1, 1, 1, 1]
]
path = []
result = []
maze_helper(0, 0, n, arr, path, result)
print(result)
