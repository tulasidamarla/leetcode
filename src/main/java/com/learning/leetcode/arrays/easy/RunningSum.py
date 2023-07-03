from typing import List


def runningSum(nums: List[int]) -> List[int]:
    for i in range(1, len(nums)):
        nums[i] += nums[i - 1]
    return nums


def main():
    nums = [1, 2, 3, 4]
    print("Given Array", nums)
    print("Running sum array: ", runningSum(nums))


main()
