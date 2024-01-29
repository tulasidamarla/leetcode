import sys


class Solution:

    def dfsBinary(self, coins, index, amount, res, counter):
        if amount == 0:
            res[0] = min(res[0], counter)
            return
        if amount < 0 or index == len(coins):
            return
        amount -= coins[index]
        self.dfsBinary(coins, index, amount, res, counter + 1)
        amount += coins[index]
        self.dfsBinary(coins, index + 1, amount, res, counter)

    def dfs(self, coins, amount, res, counter):
        if amount == 0:
            res[0] = min(res[0], counter)
            return
        if amount < 0:
            return
        for coin in coins:
            amount -= coin
            self.dfs(coins, amount, res, counter + 1)
            amount += coin

    def dp(self, coins, amount) -> int:
        dp = [amount+1] * (amount + 1)
        dp[0] = 0
        for i in range(1, amount+1):
            for c in coins:
                if i - c >= 0:
                    dp[i] = min(dp[i], 1 + dp[i-c])
        return dp[amount] if dp[amount] != amount+1 else -1


def main():
    solution = Solution()
    coins = [1, 2, 5]
    amount = 11
    result = [sys.maxsize]
    # Didn't work
    solution.dfsBinary(coins, 0, amount, result, 0)
    print(result)

    coins = [2]
    amount = 3
    result = [sys.maxsize]
    solution.dfsBinary(coins, 0, amount, result, 0)
    result = result[0] if result[0] != sys.maxsize else -1
    print(result)

    coins = [1, 2, 5]
    amount = 11
    result = [sys.maxsize]

    solution.dfs(coins, amount, result, 0)
    print(result)

    coins = [2]
    amount = 3
    result =[sys.maxsize]
    solution.dfs(coins, amount, result, 0)
    result = result[0] if result[0] != sys.maxsize else -1
    print(result)

    coins = [1, 2, 5]
    amount = 11
    res = solution.dp(coins, amount)
    print(res)

    coins = [2]
    amount = 3
    res = solution.dp(coins, amount)
    print(res)


main()
