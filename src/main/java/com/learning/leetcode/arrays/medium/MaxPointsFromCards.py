from typing import List


def maxScore(cardPoints: List[int], k: int) -> int:
    l, r = 0, len(cardPoints) - k
    total = sum(cardPoints[r:])
    result = total
    while r < len(cardPoints):
        total += (cardPoints[l] - cardPoints[r])
        result = max(result, total)
        l += 1
        r += 1
    return result


def main():
    nums = [1, 2, 3, 4, 5, 6, 1]
    k = 3
    print("Given Array: ", nums)
    print("Max points obtained for %d cards is: %d " % (k, maxScore(nums, k)))
    nums = [2, 2, 2]
    k = 2
    print("Given Array: ", nums)
    print("Max points obtained for %d cards is: %d " % (k, maxScore(nums, k)))
    nums = [9, 7, 7, 9, 7, 7, 9]
    k = 7
    print("Given Array: ", nums)
    print("Max points obtained for %d cards is: %d " % (k, maxScore(nums, k)))


main()
