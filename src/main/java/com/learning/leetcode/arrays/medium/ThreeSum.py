from typing import List


def threeSum(nums: List[int]) -> List[List[int]]:
    result = []
    nums.sort()
    n = len(nums)
    i = 0
    while i < n:
        start = i + 1
        end = n - 1
        target = -nums[i]
        while start < end:
            if nums[start] + nums[end] == target:
                result.append([nums[i], nums[start], nums[end]])
                start += 1
                end -= 1
                while start < end and nums[start] == nums[start + 1]:
                    start += 1
                while start < end and nums[end] == nums[end - 1]:
                    end -= 1
            elif nums[start] + nums[end] > target:
                end -= 1
            else:
                start += 1
            while i + 1 < n and nums[i] == nums[i+1]:
                i += 1
        i += 1
    return result


def main():
    nums = [-1, 0, 1, 2, -1, -4]
    print("Given array ", str(nums))
    results = threeSum(nums)
    print("3Sum result", str(results))


main()
