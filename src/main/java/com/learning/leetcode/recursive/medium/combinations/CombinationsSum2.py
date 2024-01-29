from typing import List


def combinationSum(arr: List[int], index: int, sumSoFar: int, target: int, path: List[int], result: List[List[int]]):
    if sumSoFar == target:
        result.append(path[:])
        return
    if sumSoFar > target or index == len(arr):
        return

    path.append(arr[index])
    sumSoFar += arr[index]
    combinationSum(arr, index + 1, sumSoFar, target, path, result)
    sumSoFar -= arr[index]
    path.pop()
    while index + 1 < len(arr) and arr[index] == arr[index + 1]:
        index += 1
    combinationSum(arr, index + 1, sumSoFar, target, path, result)


def combinations(nums, target, index, sum_till_now, subset, result):
    if sum_till_now == target:
        result.append(subset.copy())
        return
    if not sum_till_now > target or not index == len(nums):
        subset.append(nums[index])
        sum_till_now += nums[index]
        combinations(nums, target, index + 1, sum_till_now, subset, result)
        sum_till_now -= nums[index]
        subset.pop()

        while index + 1 < len(nums) and nums[index] == nums[index + 1]:
            index += 1

        combinations(nums, target, index + 1, sum_till_now, subset, result)


def main():
    nums = [10, 1, 2, 7, 6, 1, 5]
    nums.sort()
    target = 8
    path, result = [], []
    combinations(nums, target, 0, 0, path, result)
    #combinationSum(nums, 0, 0, target, path, result)
    print(result)


main()
