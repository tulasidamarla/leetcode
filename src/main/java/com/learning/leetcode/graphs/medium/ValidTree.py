from typing import List


def validTree(n: int, edges: List[List[int]]) -> bool:
    if not n:
        return True
    adj = {i: [] for i in range(n)}
    for n1, n2 in edges:
        adj[n1].append(n2)
        adj[n2].append(n1)

    visit = set()

    def dfs(i, prev):
        if i in visit:
            return False
        visit.add(i)
        for j in adj[i]:
            if j == prev:
                continue
            if not dfs(j, i):
                return False
        return True

    return dfs(0, -1) and len(visit) == n


def main():
    array = [[0, 1], [1, 2],[3,4]]
    res = validTree(5, array)
    print(res)


main()
