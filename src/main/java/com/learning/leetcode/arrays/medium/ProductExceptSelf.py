from typing import List


def productExceptSelf(nums: List[int]) -> List[int]:
    n = len(nums)
    leftProduct = 1
    rightProduct = 1
    result = [1] * n
    for i in range(n):
        result[i] *= leftProduct
        leftProduct *= nums[i]
        j = n - 1 - i
        result[j] *= rightProduct
        rightProduct *= nums[j]
    return result


def main():
    nums = [1, 2, 3, 4]
    print("Given Array", nums)
    print("Running sum array: ", productExceptSelf(nums))
    nums = [-1, 1, 0, -3, 3]
    print("Running sum array: ", productExceptSelf(nums))


main()
