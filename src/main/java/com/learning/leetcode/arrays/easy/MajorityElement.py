from typing import List


def majorityElement(nums: List[int]) -> int:
    candidate = 0
    count = 0
    for num in nums:
        if count == 0:
            candidate = num
        if candidate == num:
            count += 1
        else:
            count -= 1
    return candidate


def main():
    nums = [3, 2, 3]
    print('Majority element for ' + str(nums) + ' is ' + str(majorityElement(nums)))
    nums = [2, 2, 1, 2, 2, 1, 1]
    print('Majority element for ' + str(nums) + ' is ' + str(majorityElement(nums)))


main()
