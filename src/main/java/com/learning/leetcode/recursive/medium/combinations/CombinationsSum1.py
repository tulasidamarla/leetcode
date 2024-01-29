from typing import List


def combinationSum(arr: List[int], index: int, sumSoFar: int, target: int, path: List[int], result: List[List[int]]):
    if sumSoFar == target:
        result.append(path[:])
        return
    if sumSoFar > target or index == len(arr):
        return
    path.append(arr[index])
    sumSoFar += arr[index]
    combinationSum(arr, index, sumSoFar, target, path, result)
    sumSoFar -= arr[index]
    path.pop()
    combinationSum(arr, index + 1, sumSoFar, target, path, result)


def main():
    nums = [2, 3, 6, 7]
    target = 7
    path, result = [], []
    combinationSum(nums, 0, 0, target, path, result)
    print(result)
    nums = [1, 2, 5]
    target = 7
    path, result = [], []
    combinationSum(nums, 0, 0, target, path, result)
    print(result)



main()
