/*
Problem: Best Time to Buy and Sell Stock II
Description: You are given an array prices where prices[i] represents the price of a stock on the ith day. You can buy and sell the stock multiple times. You can only hold at most one share at a time. Find the maximum profit you can achieve.

Example 1:
Input: prices = [7, 1, 5, 3, 6, 4]
Output: 7

Explanation: Buy at price 1 and sell at price 5.
Profit = 5 - 1 = 4

Buy at price 3 and sell at price 6.
Profit = 6 - 3 = 3

Total Profit = 4 + 3 = 7

Example 2:
Input: prices = [1, 2, 3, 4, 5]
Output: 4

Explanation: Buy at price 1 and sell at price 5.
Profit = 5 - 1 = 4

Example 3:
Input: prices = [7, 6, 4, 3, 1]
Output: 0

Explanation: Prices are continuously decreasing. No transaction is performed.

--------------------------------------------------
Approach: Optimal (Using Greedy Algorithm)

Explanation:
1. Initialize profit = 0.
2. Traverse the prices array starting from index 1.
3. Compare the current day's price with the previous day's price.
4. If the current price is greater than the previous price, it means we can make a profit.
5. Add the difference between current and previous prices to the total profit.
6. Continue until the entire array is traversed.
7. Return the maximum profit.

Time Complexity: O(n)
Space Complexity: O(1)
*/

package GreedyProblems;
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            // If current price is greater than previous price, add the difference to the total profit.
            if(prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}