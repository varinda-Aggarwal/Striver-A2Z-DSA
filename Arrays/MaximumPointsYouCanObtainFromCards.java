/*
Problem: Maximum Points You Can Obtain from Cards
Description: There are several cards arranged in a row, and each card has an associated number of points. You can take exactly k cards from either the beginning or the end of the row. Return the maximum score you can obtain.

Example 1:
Input  : cardPoints = [1,2,3,4,5,6,1], k = 3
Output : 12

Explanation: Take 1 from the beginning and 6 and 5 from the end. Total = 1 + 6 + 5 = 12.

Example 2:
Input  : cardPoints = [2,2,2], k = 2
Output : 4

--------------------------------------------------
Approach 1: Optimal (Sliding Window / Two Pointers)
--------------------------------------------------
- First take all k cards from the left side.
- Store their sum in `sum`.
- Initially, this is one possible answer, so store it in `maxSum`.
- Now gradually remove one card at a time from the left side.
- At the same time, add one card from the right side.
- This generates all possible combinations of taking cards from the left and right.
- Update `maxSum` after every replacement.

For example, if k = 3:

    Left cards:
    [1, 2, 3]

    Then:
    [1, 2] + [last card]

    Then:
    [1] + [last 2 cards]

    Then:
    [last 3 cards]

- Return the maximum sum found.
Time Complexity  : O(k)
Space Complexity : O(1)

Edge Cases:
- k = 0
- k = cardPoints.length
- All card points are negative
- k = 1
- All elements have the same value
*/
package Arrays;
public class MaximumPointsYouCanObtainFromCards {

    // ----------------------------------- Optimal Approach -----------------------------------

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;   

        // Initially, take all k cards from the left
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int maxSum = sum;
        int right = cardPoints.length - 1;      // Start taking cards from the right side

        // Gradually remove cards from the left and add cards from the right.
        for (int i = k - 1; i >= 0; i--) {
            sum -= cardPoints[i];               // Remove one card from the left
            sum += cardPoints[right];           // Add one card from the right
            right--;
            maxSum = Math.max(maxSum, sum);     // Update maximum score
        }
        return maxSum;
    }
}