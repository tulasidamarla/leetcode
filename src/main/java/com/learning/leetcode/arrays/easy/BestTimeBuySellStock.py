import sys


def maxProfit(prices):
    min_price = sys.maxsize
    profit = 0
    for price in prices:
        min_price = min(min_price, price)
        profit = max(profit, price - min_price)
    return profit


def main():
    prices = [7, 1, 5, 3, 6, 4]
    profit = maxProfit(prices)
    print("Max profit for " + str(prices) + " is " + str(profit))
    prices = [7, 6, 4, 3, 1]
    profit = maxProfit(prices)
    print("Max profit for " + str(prices) + " is " + str(profit))


main()
