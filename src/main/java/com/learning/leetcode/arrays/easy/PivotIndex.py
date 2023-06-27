from typing import List


def pivotIndex(nums: List[int]) -> int:
    left = 0
    total = sum(nums)
    for i in range(len(nums)):
        total -= nums[i]
        if total == left:
            return i
        left += nums[i]
    return -1


def main():
    nums = [1, 7, 3, 6, 5, 6]
    print('Pivot Index for ' + str(nums) + ' is ' + str(pivotIndex(nums)))
    nums = [1, 2, 3]
    print('Pivot Index for ' + str(nums) + ' is ' + str(pivotIndex(nums)))
    nums = [2, 1, -1]
    print('Pivot Index for ' + str(nums) + ' is ' + str(pivotIndex(nums)))


main()
