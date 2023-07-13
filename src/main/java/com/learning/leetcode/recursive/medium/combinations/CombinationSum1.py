from typing import List


def combinationSumHelper(candidates: List[int], current: List[int], result: List[List[int]], target: int, index: int,
                         sumSoFar: int):
    if sumSoFar > target:
        return
    if index == len(candidates):
        return

    if sumSoFar == target:
        result.append(current[:])
        return
    current.append(candidates[index])
    sumSoFar += candidates[index]
    combinationSumHelper(candidates, current, result, target, index, sumSoFar)
    current.remove(candidates[index])
    sumSoFar -= candidates[index]
    combinationSumHelper(candidates, current, result, target, index + 1, sumSoFar)


def main():
    result = []
    current = []
    candidates = [2, 3, 6, 7]
    target = 7
    print("Given Array: ", candidates)
    print("Target: ", target)
    combinationSumHelper(candidates, current, result, target, 0, 0)
    print("Combinations: ", result)
    candidates = [2, 3, 5]
    target = 8
    print("Given Array: ", candidates)
    print("Target: ", target)
    combinationSumHelper(candidates, current, result, target, 0, 0)
    print("Combinations: ", result)
    candidates = [2]
    target = 1
    print("Given Array: ", candidates)
    print("Target: ", target)
    combinationSumHelper(candidates, current, result, target, 0, 0)
    print("Combinations: ", result)


main()
