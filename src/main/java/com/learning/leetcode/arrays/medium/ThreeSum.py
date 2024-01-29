from typing import List


def threeSum(nums: List[int]) -> List[List[int]]:
    result = []
    nums.sort()
    n = len(nums)
    for i in range(n):
        if i > 0 and nums[i] == nums[i-1]:
            i += 1
        start = i + 1
        end = n - 1
        while start < end:
            if nums[i] + nums[start] + nums[end] == 0:
                result.append([nums[i], nums[start], nums[end]])
                start += 1
                end -= 1
                while start < end and nums[start] == nums[start + 1]:
                    start += 1
                while start < end and nums[end] == nums[end - 1]:
                    end -= 1
            elif nums[start] + nums[end] > 0:
                end -= 1
            else:
                start += 1
    return result


def main():
    nums = [-1, 0, 1, 2, -1, -4]
    print("Given array ", str(nums))
    results = threeSum(nums)
    print("3Sum result", str(results))


main()
