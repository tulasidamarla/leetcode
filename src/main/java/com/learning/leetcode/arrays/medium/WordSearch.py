from typing import List


def exist(board: List[List[str]], word: str) -> bool:
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == word[0]:
                print("search starts at " + str(i) + "," + str(j))
                if search(board, word, 0, i, j):
                    return True
    return False


def search(board: List[List[str]], word: str, wordIndex: int, sr: int, sc: int) -> bool:
    if wordIndex == len(word):
        print("search ends at " + str(sr) + "," + str(sc))
        return True
    if sr < 0 or sc < 0 or sr == len(board) or sc == len(board[0]) or word[wordIndex] != board[sr][sc]:
        return False
    ch = board[sr][sc]
    board[sr][sc] = '#'
    op1 = search(board, word, wordIndex + 1, sr + 1, sc)
    op2 = search(board, word, wordIndex + 1, sr, sc + 1)
    op3 = search(board, word, wordIndex + 1, sr - 1, sc)
    op4 = search(board, word, wordIndex + 1, sr, sc - 1)
    board[sr][sc] = ch
    return op1 or op2 or op3 or op4


def main():
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "SEE"
    res = exist(board, word)
    for row in board:
        print(row)
    print("Word %s exists: %s" % (word, str(res)))
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "ABCCED"
    res = exist(board, word)
    for row in board:
        print(row)
    print("Word %s exists: %s" % (word, str(res)))
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "ABCB"
    res = exist(board, word)
    for row in board:
        print(row)
    print("Word %s exists: %s" % (word, str(res)))


main()
