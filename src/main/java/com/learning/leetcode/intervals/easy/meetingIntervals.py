from typing import List


class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end


class Solution:

    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        intervals.sort()
        prevEnd = intervals[0][1]
        for i in range(1, len(intervals)):
            if intervals[i][0] < prevEnd:
                return False
            else:
                prevEnd = intervals[i][1]
        return True

    def canAttendMeetings2(self, intervals: List[Interval]) -> bool:
        intervals.sort()
        for i in range(1, len(intervals)):
            i1 = intervals[i-1]
            i2 = intervals[i]
            if i2[0] < i1[1]:
                return False
        return True


def main():
    sol = Solution()
    intervals = [(0, 30), (5, 10), (15, 20)]
    print(sol.canAttendMeetings(intervals))
    print(sol.canAttendMeetings2(intervals))
    intervals = [(5, 8), (9, 15)]
    print(sol.canAttendMeetings(intervals))
    print(sol.canAttendMeetings2(intervals))


main()
