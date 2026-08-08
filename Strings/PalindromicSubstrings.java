/*
Problem: Palindromic Substrings

Description:
Given a string s, return the number of palindromic substrings in it. A palindrome reads the same backward as forward. A substring is a contiguous sequence of characters within the string.

Example 1:
Input  : "abc"
Output : 3
Explanation: "a", "b", "c"

Example 2:
Input  : "aaa"
Output : 6
Explanation: "a", "a", "a", "aa", "aa", "aaa"

--------------------------------------------------
Approach 1: Brute Force
--------------------------------------------------
- Generate every possible substring using two nested loops.
- Check whether each substring is a palindrome.
- If it is a palindrome, increment the count.

Time Complexity  : O(n³)
Space Complexity : O(1)

Why Brute Force?
- There are O(n²) possible substrings.
- Checking each substring for palindrome takes O(n).
- Therefore, total time complexity is O(n³).

--------------------------------------------------
Approach 2: Optimal (Expand Around Center)
--------------------------------------------------
- Every palindrome has a center.
- For every index, consider two possible centers:
    1. (i, i)     → Odd-length palindromes
    2. (i, i + 1) → Even-length palindromes
- Expand outward while the characters are equal.
- Every successful expansion represents one palindromic substring.
- Add the count of palindromes found around each center.

Time Complexity  : O(n²)
Space Complexity : O(1)

Why Optimal?
- No need to generate all substrings separately.
- Palindromes are counted while expanding around their centers.
- Uses only constant extra space.

Edge Cases:
- Empty string
- Single character
- All characters are the same
- No palindrome longer than one character
- Entire string is a palindrome
- Both odd and even length palindromes
*/

package Strings;
public class PalindromicSubstrings {

    // ---------------------------- Brute Force Helper ---------------------------------

    // Checks whether s[left...right] is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // ------------------------------ Brute Force Approach  ---------------------------------

    public int countSubstringsBrute(String s) {
        int count = 0;
        // Generate every possible substring
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                // Check whether current substring is a palindrome
                if (isPalindrome(s, start, end)) {
                    count++;
                }
            }
        }
        return count;
    }


    // -------------------------------- Optimal Helper ----------------------------

    // Expands around the given center and counts all palindromes formed from that center.
    private int countPalindromes(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;     // Current characters form a palindrome

            // Expand outward
            left--;
            right++;
        }
        return count;
    }

    // ---------------------------- Optimal Approach ---------------------------

    public int countSubstringsOptimal(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes
            int odd = countPalindromes(s, i, i);
            // Even-length palindromes
            int even = countPalindromes(s, i, i + 1);
            count = count + odd + even;
        }
        return count;
    }
}