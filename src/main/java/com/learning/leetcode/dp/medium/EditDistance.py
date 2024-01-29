def minDistance(word1: str, word2: str) -> int:
    board = [[float("inf")] * (len(word2) + 1) for i in range(len(word1) + 1)]

    # Initialize last row and column
    # hoz is word2 and ver is word1
    for i in range(len(word2) + 1):
        board[len(word1)][i] = len(word2) - i
    for j in range(len(word1) + 1):
        board[j][len(word2)] = len(word1) - j
    #print(board)
    # i represent row, j represent column
    for i in range(len(word1) - 1, -1, -1):
        for j in range(len(word2) - 1, -1, -1):
            if word1[i] == word2[j]:
                board[i][j] = board[i+1][j+1]
            else:
                board[i][j] = 1 + min(board[i][j+1], board[i+1][j], board[i+1][j+1])
    return board[0][0]



def main():
    word1 = "horse"
    word2 = "ros"
    res = minDistance(word1, word2)
    print(res)

main()
