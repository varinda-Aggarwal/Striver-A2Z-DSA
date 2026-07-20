/*
Problem: Largest Odd Number in String

Description:
Given a string num representing a large integer, return the largest-valued odd integer (as a string) that is a non-empty substring of num. If no odd integer exists, return an empty string.

Example 1:
Input  : "52"
Output : "5"

Example 2:
Input  : "4206"
Output : ""

Example 3:
Input  : "35427"
Output : "35427"

--------------------------------------------------
Approach 1: Brute Force (Generate All Substrings)
--------------------------------------------------
- Generate every possible substring.
- Check whether the last digit of the substring is odd.
- If it is odd, compare it with the current answer.
- Update the answer if:
    • the substring is longer, or
    • both have the same length and the substring is lexicographically larger.

Time Complexity  : O(n³)
Space Complexity : O(n)

Why?
- There are O(n²) substrings.
- Creating each substring takes O(n).
- Hence overall complexity becomes O(n³).

--------------------------------------------------
Approach 2: Optimal (Traverse from Right)
--------------------------------------------------
- Traverse the string from right to left.
- Find the first odd digit.
- Return the substring from index 0 to that digit.
- If no odd digit exists, return an empty string.

Time Complexity  : O(n)
Space Complexity : O(1)
(Note: Ignoring the space required for the returned string.)

Why Optimal?
- We only need the largest-valued odd substring.
- Any valid answer must be a prefix ending at an odd digit.
- The rightmost odd digit gives the longest possible valid prefix.

Edge Cases:
- No odd digit present.
- Entire string is already odd.
- Single digit string.
- Leading zeros.
*/

package Strings;
public class LargestOddNumberInString {

    // ------------------ Brute Force Approach ------------------

    public String largestOddNumberBrute(String num) {
        String answer = "";
        // Generate every possible substring
        for (int i = 0; i < num.length(); i++) {
            for (int j = i; j < num.length(); j++) {
                String substring = num.substring(i, j + 1);
                char lastDigit = substring.charAt(substring.length() - 1);
                // Check whether the substring represents an odd number
                if ((lastDigit - '0') % 2 != 0) {
                    // Prefer longer substring
                    if (substring.length() > answer.length()) {
                        answer = substring;
                    }
                    // If lengths are equal, choose the larger value
                    else if (substring.length() == answer.length() && substring.compareTo(answer) > 0) {
                        answer = substring;
                    }
                }
            }
        }
        return answer;
    }

    // -------------------------- Optimal Approach ----------------------------

    public String largestOddNumberOptimal(String num) {
        // Traverse from the end to find the first odd digit
        for (int i = num.length() - 1; i >= 0; i--) {
            char digit = num.charAt(i);
            if ((digit - '0') % 2 != 0) {
                // Return the longest prefix ending at an odd digit
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}