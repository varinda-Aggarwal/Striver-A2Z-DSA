/*
Problem: Daily Temperatures
Description: Given an array of integers temperatures representing the daily temperatures, return an array answer such that: answer[i] = number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, answer[i] = 0.

Example 1:
Input: temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
Output: [1, 1, 4, 2, 1, 1, 0, 0]

Explanation:
- For 73, the next warmer temperature is 74 after 1 day.
- For 74, the next warmer temperature is 75 after 1 day.
- For 75, the next warmer temperature is 76 after 4 days.
- For 71, the next warmer temperature is 72 after 2 days.
- For 69, the next warmer temperature is 72 after 1 day.
- For 72, the next warmer temperature is 76 after 1 day.
- For 76 and 73, no warmer temperature exists.

Example 2:
Input: temperatures = [30, 40, 50, 60]
Output: [1, 1, 1, 0]

Example 3:
Input: temperatures = [30, 60, 90]
Output: [1, 1, 0]

--------------------------------------------------
Approach: Optimal (Using Monotonic Stack)

Explanation:
1. Initialize an empty stack to store indices of temperatures.
2. Create an answer array of the same size as temperatures.
3. Traverse the temperatures array from right to left.
4. For every index i:
   - Remove all indices from the stack whose temperatures are less than or equal to the current temperature.
   - These indices cannot be the next warmer day.
5. If the stack becomes empty:
   - No warmer temperature exists.
   - Set ans[i] = 0.
6. Otherwise:
   - The top of the stack contains the index of the next warmer temperature.
   - Calculate the waiting days: ans[i] = st.peek() - i
7. Push the current index into the stack.
8. Return the answer array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Stacks;
import java.util.Stack;
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];

        // Traverse from right to left
        for(int i = temperatures.length - 1; i >= 0; i--) {
            // Remove indices having smaller or equal temperatures
            while(st.size() > 0 && temperatures[i] >= temperatures[st.peek()]) st.pop();
            if(st.isEmpty()) ans[i] = 0;         // If no warmer temperature exists
            else ans[i] = st.peek() - i;         // Calculate the number of days to wait
            st.push(i);                          // Push current index into stack
        }
        return ans;
    }
}