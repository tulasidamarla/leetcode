## Problem statement

- You are given an array prices where prices[i] is the price of a given stock on the ith day.
- You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
- Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
```
Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```
```
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
```
```
Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
```

## Solution
```python
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
```
```java
import java.util.Arrays;

public class BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for " + Arrays.toString(prices) + " is " + getProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println("Max profit for " + Arrays.toString(prices) + " is " + getProfit(prices));
    }

    private static int getProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }
}
```
