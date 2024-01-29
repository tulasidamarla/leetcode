def longestCommonSubsequence(text1: str, text2: str) -> int:
    board = [[0] * (len(text1) + 1) for i in range(len(text2) + 1)]
    for i in range(len(text2) - 1, -1, -1):
        for j in range(len(text1) - 1, -1, -1):
            if text2[i] == text1[j]:
                board[i][j] = 1 + board[i + 1][j + 1]
            else:
                board[i][j] = max(board[i][j + 1], board[i + 1][j])
    return board[0][0]


def bruteForce(text1, text2, index1, index2):
    if index1 == len(text1) or index2 == len(text2):
        return 0
    if text1[index1] == text2[index2]:
        return 1 + bruteForce(text1, text2, index1 + 1, index2 + 1)
    if text1[index1] != text2[index2]:
        val1 = bruteForce(text1, text2, index1 + 1, index2)
        val2 = bruteForce(text1, text2, index1, index2 + 1)
        return max(val1, val2)


def main():
    text1 = "abcde"
    text2 = "ace"
    res = longestCommonSubsequence(text1, text2)
    print(f"longest subsequence of {text1} and {text2} is {res}")
    text1 = "abc"
    text2 = "abc"
    res = longestCommonSubsequence(text1, text2)
    print(f"longest subsequence of {text1} and {text2} is {res}")
    text1 = "abc"
    text2 = "def"
    res = longestCommonSubsequence(text1, text2)
    print(f"longest subsequence of {text1} and {text2} is {res}")

    text1 = "abcde"
    text2 = "ace"
    res = bruteForce(text1, text2, 0, 0)
    print(f"longest subsequence of {text1} and {text2} is {res}")
    text1 = "abc"
    text2 = "abc"
    res = bruteForce(text1, text2, 0, 0)
    print(f"longest subsequence of {text1} and {text2} is {res}")
    text1 = "abc"
    text2 = "def"
    res = bruteForce(text1, text2, 0, 0)
    print(f"longest subsequence of {text1} and {text2} is {res}")


main()
