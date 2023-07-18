from typing import List


def nextPermutation(nums: List[int]) -> None:
    if len(nums) <= 1:
        return
    i = len(nums) - 2
    # Decrement i from the end until nums[i] is less than nums[i+1]
    # Ex: 2 1 5 4 3 (1 is less than 5)
    while i >= 0 and nums[i] >= nums[i + 1]:
        i -= 1
    if i >= 0:
        j = len(nums) - 1
        # In this example j stops at 3 because the condition fails at last index itself
        while nums[i] >= nums[j]:
            j -= 1
        # Swap values at indexes i and j
        # Now the sequence is 2 3 5 4 1
        nums[i], nums[j] = nums[j], nums[i]
    # Reverse all values from i + 1 to the end
    # So final solution is 2 3 1 4 5
    k = len(nums) - 1
    while i < k:
        nums[i + 1], nums[k] = nums[k], nums[i + 1]
        i += 1
        k -= 1


def main():
    nums = [1, 2, 3]
    print("Given array ", nums)
    nextPermutation(nums)
    print("Next permutation ", nums)
    nums = [1, 3, 5, 4, 2]
    print("Given array ", nums)
    nextPermutation(nums)
    print("Next permutation ", nums)
    nums = [2, 1, 5, 4, 3]
    print("Given array ", nums)
    nextPermutation(nums)
    print("Next permutation ", nums)


main()
