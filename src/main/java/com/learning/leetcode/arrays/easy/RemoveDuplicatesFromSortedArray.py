from typing import List


def removeDuplicates(nums: List[int]) -> int:
    k = 1
    for i in range(1, len(nums)):
        if nums[i] != nums[i - 1]:
            nums[k] = nums[i]
            k += 1
    return k


def main():
    nums = [1, 1, 2]
    print("Before removing duplicates array is " + str(nums))
    k = removeDuplicates(nums)
    print("After removing duplicates array is " + str(nums))
    print("Unique values are filtered until position " + str(k))

    nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    print("Before removing duplicates array is " + str(nums))
    k = removeDuplicates(nums)
    print("After removing duplicates array is " + str(nums))
    print("Unique values are filtered until position " + str(k))


main()
