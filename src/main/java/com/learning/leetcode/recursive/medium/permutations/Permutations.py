from typing import List


def permutationsHelper(nums: List[int], index: int, result: List[List[int]]):
    if index == len(nums) - 1:
        result.append(nums[:])
        return

    for i in range(index, len(nums)):
        #print('exchanging %d, %d'%(i, index))
        nums[i], nums[index] = nums[index], nums[i]
        permutationsHelper(nums, index + 1, result)
        nums[i], nums[index] = nums[index], nums[i]


def main():
    nums = [1, 2, 3]
    result = []
    permutationsHelper(nums, 0, result)
    for row in result:
        print(row)


main()
