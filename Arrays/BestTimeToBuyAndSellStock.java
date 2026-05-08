/*
  Problem: Best Time to Buy and Sell Stock
 
  Description:
  Given an array of stock prices where prices[i] is the price on the ith day, 
  return the maximum profit you can achieve by buying on one day and selling on a later day.
  If no profit is possible, return 0.
 
  --------------------------------------------------
   APPROACH 1 : BRUTE FORCE
  --------------------------------------------------
   Check every possible buy and sell pair.
   For every index i (buy day), check all j > i (sell day) and track the maximum profit.
 
   Note: This gives TLE on LeetCode for large inputs but is correct conceptually.
 
   Time Complexity  : O(n²) → nested loop over all pairs
   Space Complexity : O(1)  → no extra space used
 
   Edge Cases:
   - Prices always decreasing  → no profit, return 0
   - Single element array      → no transaction, return 0
   - All prices same           → no profit, return 0
 
  --------------------------------------------------
   APPROACH 2 : OPTIMAL
  --------------------------------------------------
   Track the minimum buy price seen so far while traversing. 
   At each day calculate profit if we sell today and update maximum profit accordingly.
   Single pass — no nested loop needed.
 
   Time Complexity  : O(n) → single traversal
   Space Complexity : O(1) → only two variables used
 
   Edge Cases:
   - Prices always decreasing  → minBuyPrice keeps updating, profit stays 0
   - Single element array      → loop does not execute, return 0
   - All prices same           → currentProfit always 0, return 0
  --------------------------------------------------
 */

package Arrays;
public class BestTimeToBuyAndSellStock {

    public int maxProfitBrute(int[] prices) {
        int maxProfit = 0;

        // check every possible buy and sell pair
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // profit if bought at i and sold at j
                int currentProfit = prices[j] - prices[i];
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfitOptimal(int[] prices) {
        int minBuyPrice = prices[0];  // minimum price seen so far
        int maxProfit   = 0;          // maximum profit seen so far
        for (int i = 1; i < prices.length; i++) {
            // update minimum buy price seen so far
            if (prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            }
            // update max profit if selling today gives more
            int currentProfit = prices[i] - minBuyPrice;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }
}