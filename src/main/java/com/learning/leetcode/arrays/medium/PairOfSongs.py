from typing import List


def numPairsDivisibleBy60(time: List[int]) -> int:
    arr = [0] * 60
    count = 0
    for t in time:
        if t % 60 == 0:
            count += arr[0]
        else:
            count += arr[60 - t % 60]
        arr[t % 60] += 1
    return count


def main():
    time = [30, 20, 150, 100, 40]
    print("Given Array : ", time)
    print("No of pairs divisible by 60 : ", numPairsDivisibleBy60(time))
    time = [60, 60, 60]
    print("Given Array : ", time)
    print("No of pairs divisible by 60 : ", numPairsDivisibleBy60(time))
    time = [60, 60, 60, 60]
    print("Given Array : ", time)
    print("No of pairs divisible by 60 : ", numPairsDivisibleBy60(time))


main()
