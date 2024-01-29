from typing import List


class NQueens:
    def solveNQueens(self, n) -> List[List[str]]:

        def backtrack(r):
            if r == n:
                copy = ["".join(row) for row in board]
                res.append(copy)
                return
            for c in range(n):
                if c in cols or (r + c) in posDiag or (r - c) in negDiag:
                    continue
                board[r][c] = 'Q'
                cols.add(c)
                posDiag.add(r + c)
                negDiag.add(r - c)
                backtrack(r + 1)
                cols.remove(c)
                posDiag.remove(r + c)
                negDiag.remove(r - c)
                board[r][c] = '.'

        cols = set()
        posDiag = set()  # (r + c)
        negDiag = set()  # (r - c)
        res = []
        board = [["."] * n for i in range(n)]
        backtrack(0)
        return res


def main():
    nqueens = NQueens()
    result = nqueens.solveNQueens(4)
    print(result)


main()
