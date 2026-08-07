/*
Problem: Longest Palindromic Substring

Description:
Given a string s, return the longest palindromic substring in s. A palindrome is a string that reads the same forward and backward.

Example 1:
Input  : "babad"
Output : "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input  : "cbbd"
Output : "bb"

--------------------------------------------------
Approach 1: Brute Force
--------------------------------------------------
- Generate every possible substring.
- For each substring, check whether it is a palindrome.
- If it is a palindrome and its length is greater than the current longest palindrome, update the answer.

Time Complexity  : O(n³)
Space Complexity : O(1)

--------------------------------------------------
Approach 2: Optimal (Expand Around Center)
--------------------------------------------------
- Every palindrome has a center.
- For each index, expand around:
    1. Odd-length center  -> (i, i)
    2. Even-length center -> (i, i + 1)
- Expand while both characters are equal.
- Instead of creating substrings during expansion, return only the palindrome length.
- Maintain the starting and ending indices of the longest palindrome.
- Create the answer substring only once at the end.

Time Complexity  : O(n²)
Space Complexity : O(1)

Why Optimal?
- Every character is considered as a possible center.
- No DP table is required.
- No unnecessary substring creation during traversal.
- Only one substring is created at the end.

Edge Cases:
- Empty string
- Single character
- Entire string is palindrome
- Even-length palindrome
- Odd-length palindrome
*/

package Strings;
public class LongestPalindromicSubstring {

    // ------------------ Helper Function ------------------

    // Expands around the given center and returns the length of the palindrome.
    private int expand(int left, int right, String s) {
        while (left >= 0 && right < s.length() &&s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Actual palindrome length
        return right - left - 1;
    }

    // ------------------ Brute Force Helper ------------------

    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // ------------------------------ Brute Force Approach -----------------------------

    public String longestPalindromeBrute(String s) {
        String answer = "";
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(start, end, s)) {
                    if (end - start + 1 > answer.length()) {
                        answer = s.substring(start, end + 1);
                    }
                }
            }
        }
        return answer;
    }

    // -------------------------------- Optimal Approach -----------------------------------

    public String longestPalindromeOptimal(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(i, i, s);            // Odd length palindrome
            int evenLength = expand(i, i + 1, s);       // Even length palindrome
            int currentLength = Math.max(oddLength, evenLength);    // Longer palindrome at current center
            if (currentLength > end - start + 1) {
                start = i - (currentLength - 1) / 2;
                end = i + currentLength / 2;
            }
        }
        return s.substring(start, end + 1);
    }
}