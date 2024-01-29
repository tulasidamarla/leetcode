from typing import List


class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end


def minNoOfMeetingRooms(intervals: List[Interval]) -> int:
    start = sorted([i[0] for i in intervals])
    end = sorted([i[1] for i in intervals])
    s, e = 0, 0
    res, count = 0, 0
    while s < len(intervals):
        if start[s] < end[e]:
            count += 1
            s += 1
        else:
            count -= 1
            e += 1
        res = max(res, count)
    return res


def main():
    intervals = [(0, 30), (5, 10), (15, 20)]
    print(minNoOfMeetingRooms(intervals))
    intervals = [(5, 8), (9, 15)]
    print(minNoOfMeetingRooms(intervals))


main()
