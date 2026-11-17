
/*
Problem: Largest Rectangle in Histogram
Description: Given an array of integers heights representing the histogram's bar heights, find the area of the largest rectangle that can be formed in the histogram.

Example 1:
Input: heights = [2, 1, 5, 6, 2, 3]
Output: 10

Explanation: The largest rectangle is formed using heights 5 and 6.
Width = 2
Height = 5
Area = 5 * 2 = 10

Example 2:
Input: heights = [2, 4]
Output: 4

--------------------------------------------------
Approach: Optimal (Using Monotonic Stack + PSE + NSE)

Explanation:
1. Find the Previous Smaller Element (PSE) index for every bar.
2. Find the Next Smaller Element (NSE) index for every bar.
3. Calculate the width for every bar:
   Left = i - PSE[i]
   Right = NSE[i] - i
   Width = Left + Right - 1
4. Calculate the rectangle area: Area = heights[i] * Width
5. Return the maximum area.

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Stacks;
import java.util.Stack;
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] PSE = new int[n];
        int[] NSE = new int[n];

        Stack<Integer> pse = new Stack<>();

        // Find Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!pse.isEmpty() && heights[pse.peek()] >= heights[i]) pse.pop();
            if (pse.isEmpty()) PSE[i] = -1;
            else PSE[i] = pse.peek();
            pse.push(i);
        }

        Stack<Integer> nse = new Stack<>();

        // Find Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!nse.isEmpty() && heights[nse.peek()] > heights[i]) nse.pop();
            if (nse.isEmpty()) NSE[i] = n;
            else NSE[i] = nse.peek();
            nse.push(i);
        }

        int maxArea = 0;

        // Calculate maximum rectangle area
        for (int i = 0; i < n; i++) {
            int left = i - PSE[i];
            int right = NSE[i] - i;
            int width = left + right - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
