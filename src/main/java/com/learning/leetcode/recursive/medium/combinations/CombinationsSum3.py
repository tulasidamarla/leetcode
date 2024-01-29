from typing import List


def combinationSum(current: int, end: int, sumSoFar: int, target: int, k: int, path: List[int], result: List[List[int]]):

    if k == 0:
        if sumSoFar == target:
            result.append(path[:])
        return
    if sumSoFar > target or current > end:
        return

    path.append(current)
    sumSoFar += current
    combinationSum(current + 1, end, sumSoFar, target, k-1, path, result)
    sumSoFar -= current
    path.pop()
    combinationSum(current+1, end, sumSoFar, target, k, path, result)


def main():
    target = 7
    path, result = [], []
    combinationSum(1, 9, 0, target, 3, path, result)
    print(result)


main()
