from typing import List


def findDuplicate(nums: List[int]) -> int:
    slow = 0
    fast = 0
    while True:
        slow = nums[slow]
        fast = nums[nums[fast]]
        if slow == fast:
            break
    slow = 0
    while slow != fast:
        slow = nums[slow]
        fast = nums[fast]
    return slow


def main():
    nums = [1, 3, 4, 2, 2]
    print("Given Array: ", nums)
    print("Duplicate number ", str(findDuplicate(nums)))
    nums = [3, 1, 3, 4, 2]
    print("Given Array: ", nums)
    print("Duplicate number ", str(findDuplicate(nums)))


main()
