from typing import List


def combinations(start: int, end: int, size: int, path: List[int], result: List[List[int]]):
    if size == 0:
        result.append(path[:])
        return
    if start > end:
        return
    path.append(start)
    combinations(start + 1, end, size - 1, path, result)
    path.pop()
    # without including start
    combinations(start + 1, end, size, path, result)


def main():
    path = []
    result = []
    combinations(1, 4, 2, path, result)
    print(result)


main()
