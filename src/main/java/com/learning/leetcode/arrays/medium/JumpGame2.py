from typing import List


def jump(nums: List[int]) -> int:
    count = l = r = 0
    while r < len(nums) - 1:
        farthest = 0
        for i in range(l, r + 1):
            farthest = max(farthest, i + nums[i])
        l = r + 1
        r = farthest
        count += 1
        if l > r:
            return None
    return count


def main():
    nums = [2, 3, 1, 1, 4]
    print("Given Array: ", nums)
    print(" Can Reach the end in steps : ", jump(nums))
    nums = [3, 2, 1, 0, 4]
    print("Given Array: ", nums)
    print(" Can Reach the end in steps : ", jump(nums))


main()
