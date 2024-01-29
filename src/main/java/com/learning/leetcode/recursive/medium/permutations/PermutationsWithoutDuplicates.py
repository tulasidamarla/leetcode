from typing import List


def permutationsHelper(nums: List[int], index: int, result: List[List[int]]):
    if index == len(nums) - 1:
        result.append(nums[:])
        return
    posTracker = set()
    for i in range(index, len(nums)):
        if nums[i] in posTracker:
            continue
        posTracker.add(nums[i])
        nums[i], nums[index] = nums[index], nums[i]
        permutationsHelper(nums, index + 1, result)
        nums[i], nums[index] = nums[index], nums[i]


def main():
    nums = [1, 2, 2]
    result = []
    permutationsHelper(nums, 0, result)
    for row in result:
        print(row)


main()
