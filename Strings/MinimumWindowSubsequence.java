/* 
Problem: Minimum Window Subsequence

Description: Given two strings s1 and s2, return the minimum contiguous substring of s1 such that s2 appears as a subsequence within that substring. If there is no such window, return an empty string.

Example 1:
Input  : s1 = "abcdebdde", s2 = "bde"
Output : "bcde"

Explanation:
"bde" is a subsequence of "bcde". Although "bdde" also contains "bde" as a subsequence, "bcde" appears first and has the same minimum length.

Example 2:
Input  : s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl",
         s2 = "u"

Output : ""

--------------------------------------------------
Approach 1: Optimized (Forward + Backward Traversal)
--------------------------------------------------
- Use a pointer right to traverse s1.
- Use pointer j to match characters of s2.

- First perform forward traversal:
    • Move right through s1.
    • Whenever s1.charAt(right) matches s2.charAt(j), increment j.
    • When j reaches s2.length(), it means a valid window containing s2 as a subsequence has been found.

- Then perform backward traversal:
    • Start from the current right position.
    • Start matching s2 from its last character.
    • Move backwards through s1 until all characters of s2 are matched.
    • This gives the smallest possible starting position for the current ending position.

- Calculate the current window length and update the minimum window.
- Start the next search from the current window's start position so that possible smaller windows are not skipped.

Time Complexity  : O(n × m) in the worst case
Space Complexity : O(1)

where:
    n = Length of s1
    m = Length of s2

Edge Cases:
- s2 is not a subsequence of s1
- s1 and s2 are identical
- s2 contains repeated characters
- Only one valid window exists
- Multiple windows have the same minimum length
*/
package Strings;
public class MinimumWindowSubsequence {

    // ----------------------------------- Optimized Approach -----------------------------------

    public String minWindow(String s1, String s2) {
        int right = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        while (right < s1.length()) {

            // Forward traversal: find s2 as a subsequence
            if (s1.charAt(right) == s2.charAt(j)) {
                j++;

                // Complete subsequence found
                if (j == s2.length()) {
                    
                    // Start backward traversal
                    int temp = right;
                    j = s2.length() - 1;

                    // Find the minimum starting point for this window
                    while (j >= 0) {
                        if (s1.charAt(temp) == s2.charAt(j)) {
                            j--;
                        }
                        temp--;
                    }
                    int startIndex = temp + 1;                  // temp is one position before the start
                    int currentLen = right - startIndex + 1;    // Calculate current window length

                    // Update minimum window
                    if (currentLen < minLen) {
                        minLen = currentLen;
                        start = startIndex;
                    }
                    right = startIndex;    // Start next search from the current start position
                    j = 0;                 // Reset s2 pointer
                }  
            }
            right++;
        }

        // No valid window found
        if (start == -1) {
            return "";
        }
        return s1.substring(start, start + minLen);
    }
}