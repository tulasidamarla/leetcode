from typing import List


def moveZeroes2(nums: List[int]) -> None:
    j = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[j] = nums[i]
            j += 1
    while j < len(nums):
        nums[j] = 0
        j += 1


def moveZeroes(nums: List[int]) -> None:
    j = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[j], nums[i] = nums[i], nums[j]
            j += 1


def main():
    nums = [0, 1, 0, 3, 12]
    print('Given array %30s' % nums)
    moveZeroes(nums)
    print('After moving zeros %23s' % nums)
    nums = [0, 1, 0, 3, 12]
    print('Given array %30s' % nums)
    moveZeroes2(nums)
    print('After moving zeros %23s' % nums)


main()
