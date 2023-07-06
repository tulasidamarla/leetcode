from typing import List
import sys


def threeSumClosest(nums: List[int], target: int) -> int:
    nums.sort()
    minDiff = sys.maxsize
    resultSum = nums[0] + nums[1] + nums[2]
    for i in range(len(nums)):
        left = i + 1
        right = len(nums) - 1
        while left < right:
            threeSum = nums[i] + nums[left] + nums[right]
            if threeSum == target:
                return threeSum
            elif threeSum < target:
                left += 1
            else:
                right -= 1
            currDiff = abs(threeSum - target)
            if currDiff < minDiff:
                resultSum = threeSum
                minDiff = currDiff
    return resultSum


def main():
    nums = [-1, 2, 1, -4]
    target = 1
    print("Given Array", nums)
    closestSum = threeSumClosest(nums, target)
    print("Threesum closest to target %d is %d" % (target, closestSum))
    nums = [0, 0, 0]
    target = 1
    print("Given Array", nums)
    closestSum = threeSumClosest(nums, target)
    print("Threesum closest to target %d is %d" % (target, closestSum))


main()
