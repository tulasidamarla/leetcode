## Problem statement

- You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
- On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
- Find and return the maximum profit you can achieve.

Example 1:
```
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
```
```
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
```
```
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
```
```
Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
```

## Solution

```java
import java.util.Arrays;

public class BestTimeBuySellStock2 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for " + Arrays.toString(prices) + " is " + getProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println("Max profit for " + Arrays.toString(prices) + " is " + getProfit(prices));
        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println("Max profit for " + Arrays.toString(prices) + " is " + getProfit(prices));

    }

    private static int getProfit(int[] prices) {
        int totalProfit = 0;
        for(int i = 1; i< prices.length; i++){
            if(prices[i] > prices[i-1]){
                totalProfit += (prices[i]- prices[i-1]);
            }
        }
        return totalProfit;
    }
}
```
```python
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
```