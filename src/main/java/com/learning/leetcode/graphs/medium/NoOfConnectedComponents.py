from typing import List


def countConnectedComponents(n: int, edges: List[List[int]]) -> int:
    parentArr = [i for i in range(n)]
    rank = [1] * n

    def find(val):
        parent = val

        while parent != parentArr[parent]:
            # Merging the parent nodes
            parentArr[parent] = parentArr[parentArr[parent]]
            parent = parentArr[parent]
        return parent

    def union(n1, n2):
        p1, p2 = find(n1), find(n2)

        if p1 == p2:
            return 0

        if rank[p2] > rank[p1]:
            parentArr[p1] = p2
            rank[p2] += rank[p1]
        else:
            parentArr[p2] = p1
            rank[p1] += rank[p2]
        return 1

    res = n
    for val1, val2 in edges:
        res -= union(val1, val2)
    return res


def main():
    array = [[0, 1], [1, 2], [3, 4], [0, 2], [5, 6]]
    res = countConnectedComponents(7, array)
    print(res)


main()
