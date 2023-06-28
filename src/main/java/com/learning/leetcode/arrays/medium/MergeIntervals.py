from typing import List
import operator


def merge(intervals: List[List[int]]) -> List[List[int]]:
    sortedIntervals = sorted(intervals, key=operator.itemgetter(0))

    newIntervals = []
    newInterval = sortedIntervals[0]
    newIntervals.append(newInterval)
    for interval in sortedIntervals:
        if interval[0] <= newInterval[1]:
            newInterval[1] = max(interval[1], newInterval[1])
        else:
            newIntervals.append(interval)
            newInterval = interval
    return newIntervals


def main():
    intervals = [[1, 2], [0, 1], [2, 3]]
    print("Given array" + str(intervals))
    newIntervals = merge(intervals)
    print("Output" + str(newIntervals))


main()
