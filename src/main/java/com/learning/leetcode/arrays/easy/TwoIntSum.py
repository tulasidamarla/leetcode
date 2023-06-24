from typing import List


def twosum(nums: List[int], target: int) -> List[int]:
    num_dict = {}
    for i in range(len(nums)):
        required = target - nums[i]
        if required in num_dict:
            return [num_dict[required], i]
        num_dict[nums[i]] = i


def main():
    nums = [2, 3, 6, 7]
    result = twosum(nums, 5)
    print('Input -> %20s' % nums)
    print('Positions -> %16s' % result)
    nums = [3, 2, 3]
    result = twosum(nums, 6)
    print('Input -> %20s' % nums)
    print('Positions -> %16s' % result)


main()
