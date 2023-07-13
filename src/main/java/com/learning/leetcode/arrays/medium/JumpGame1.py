from typing import List


def canJump(nums: List[int]) -> bool:
    goal = len(nums) - 1
    for i in range(len(nums) - 2, -1, -1):
        if i + nums[i] >= goal:
            goal = i
    return goal == 0


def main():
    nums = [2, 3, 1, 1, 4]
    print("Given Array: ", nums)
    print(" Can Reach the End", canJump(nums))
    nums = [3, 2, 1, 0, 4]
    print("Given Array: ", nums)
    print(" Can Reach the End", canJump(nums))


main()
