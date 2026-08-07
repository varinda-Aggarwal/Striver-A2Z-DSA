/*
Problem: Maximum Nesting Depth of the Parentheses

Description:
Given a valid parentheses string, return the maximum nesting depth of the parentheses. The nesting depth is the maximum number of open parentheses that are nested inside each other at any point.

Example 1:
Input  : "(1+(2*3)+((8)/4))+1"
Output : 3

Example 2:
Input  : "(1)+((2))+(((3)))"
Output : 3

--------------------------------------------------
Approach: Optimal (Counter)
--------------------------------------------------
- Traverse the string once from left to right.
- Maintain a counter representing the current nesting depth.
- Whenever '(' is encountered:
      - Increase the counter.
      - Update the maximum depth.
- Whenever ')' is encountered: Decrease the counter.
- At the end, the maximum value reached by the counter is the maximum nesting depth.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- Every character is visited exactly once.
- No extra data structure (like Stack) is required.
- Uses only a single counter to track the current depth.

Edge Cases:
- Empty string
- String without parentheses
- Single pair "()"
- Deeply nested parentheses
- Multiple independent groups of parentheses
*/

package Strings;
public class MaximumNestingDepth {

    // ---------------------------------- Optimal Approach -------------------------------

    public int maxDepth(String s) {
        int currentDepth = 0;
        int maximumDepth = 0;
        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Opening parenthesis increases depth
            if (ch == '(') {
                currentDepth++;
                maximumDepth = Math.max(maximumDepth, currentDepth);
            }
            // Closing parenthesis decreases depth
            else if (ch == ')') {
                currentDepth--;
            }
        }
        return maximumDepth;
    }
}