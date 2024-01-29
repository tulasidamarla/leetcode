def backtrack(nums, index, subset, result):
    if index == len(nums):
        result.append(subset[:])
        return
    subset.append(nums[index])
    backtrack(nums, index + 1, subset, result)
    subset.pop()
    backtrack(nums, index + 1, subset, result)


def main():
    nums = [1, 2, 3]
    res = []
    backtrack(nums, 0, [], res)
    print(res)


main()
