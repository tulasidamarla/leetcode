from typing import List


def subArraysCount(nums: List[int], k: int) -> int:
    sumMap = {}
    sumSoFar = 0
    count = 0
    sumMap[0] = 1
    for i in range(len(nums)):
        sumSoFar += nums[i]
        if (sumSoFar - k) in sumMap:
            count += sumMap[sumSoFar - k]
        sumMap[sumSoFar] = sumMap.get(sumSoFar, 0) + 1
        print(sumMap)
    return count


def main():
    nums = [1, 1, 1]
    k = 2
    print("Given Array " + str(nums))
    print("No of sub arrays for k=%d are %s" % (k, str(subArraysCount(nums, k))))
    nums = [1, 1, 1]
    k = 0
    print("Given Array " + str(nums))
    print("No of sub arrays for k=%d are %s" % (k, str(subArraysCount(nums, k))))
    nums = [1, -1, 0]
    k = 0
    print("Given Array " + str(nums))
    print("No of sub arrays for k=%d are %s" % (k, str(subArraysCount(nums, k))))
    nums = [1, -1, 0]
    k = -1
    print("Given Array " + str(nums))
    print("No of sub arrays for k=%d are %s" % (k, str(subArraysCount(nums, k))))


main()
