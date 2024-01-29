def topKFrequentElements(nums, k):
    countMap = {}
    for num in nums:
        countMap[num] = 1 + countMap.get(num, 0)
    res = []
    for num in sorted(countMap, key=countMap.get, reverse=True):
        res.append(num)
        if len(res) == k:
            return res


def main():
    nums = [1, 1, 1, 2, 2, 3]
    k = 2
    print(topKFrequentElements(nums, k))


main()
