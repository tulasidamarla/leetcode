from typing import List


def fourSum(nums: List[int], target: int) -> List[List[int]]:
    result = []
    nums.sort()
    n = len(nums)
    for i in range(n):
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        for j in range(i + 1, n):
            if j > i + 1 and nums[j] == nums[j - 1]:
                continue
            k = j + 1
            l = n - 1
            while k < l:
                total = nums[i] + nums[j] + nums[k] + nums[l]
                if total == target:
                    result.append([nums[i], nums[j], nums[k], nums[l]])
                    k += 1
                    l -= 1
                    while k < l and nums[k] == nums[k - 1]:
                        k += 1
                    while k < l and nums[l] == nums[l + 1]:
                        l -= 1
                elif total > target:
                    l -= 1
                else:
                    k += 1
    return result


def main():
    nums = [1, 0, -1, 0, -2, 2]
    target = 0
    print("Given Array is %s and target is %s " % (str(nums), str(target)))
    combinations = fourSum(nums, target)
    print("Result ", combinations)
    nums = [2, 2, 2, 2, 2]
    target = 8
    print("Given Array is %s and target is %s " % (str(nums), str(target)))
    combinations = fourSum(nums, target)
    print("Result ", combinations)


main()
