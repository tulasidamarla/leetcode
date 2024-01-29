def backtrack(nums, index, subset, result):
    if index >= len(nums):
        result.append(subset[:])
        return
    subset.append(nums[index])
    backtrack(nums, index + 1, subset, result)
    subset.pop()
    while index + 1 < len(nums) and nums[index] == nums[index+1]:
        index += 1
    backtrack(nums, index + 1, subset, result)


def main():
    nums = [1, 2, 2]
    nums.sort()
    res = []
    backtrack(nums, 0, [], res)
    print(res)


main()
