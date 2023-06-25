class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        totalProfit = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                totalProfit += prices[i] - prices[i - 1]
        return totalProfit


def main():
    sol = Solution()
    prices = [7, 1, 5, 3, 6, 4]
    profit = sol.maxProfit(prices)
    print("Max profit for " + str(prices) + " is " + str(profit))
    prices = [7, 6, 4, 3, 1]
    profit = sol.maxProfit(prices)
    print("Max profit for " + str(prices) + " is " + str(profit))
    prices = [1, 2, 3, 4, 5]
    profit = sol.maxProfit(prices)
    print("Max profit for " + str(prices) + " is " + str(profit))

main()
