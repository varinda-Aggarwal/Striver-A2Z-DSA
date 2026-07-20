/*
Problem: Rotate String

Description:
Given two strings s and goal, return true if and only if s can become goal after performing any number of left rotations. A left rotation moves the first character of the string to the end.

Example 1:
Input : s = "abcde", goal = "cdeab"
Output : true

Explanation:
abcde
→ bcdea
→ cdeab

Example 2:
Input : s = "abcde", goal = "abced"
Output : false

--------------------------------------------------
Approach 1: Brute Force (Generate All Rotations)
--------------------------------------------------
- If the lengths of both strings are different,
  they can never be rotations.
- Generate every possible left rotation of the string.
- After every rotation, compare it with the goal string.
- If any rotation matches, return true.
- If no rotation matches after n rotations, return false.

Time Complexity  : O(n²)
Space Complexity : O(n)

Why?
- There are n possible rotations.
- Each rotation creates a new string and comparison takes O(n).

--------------------------------------------------
Approach 2: Optimal (String Concatenation)
--------------------------------------------------
- If the lengths of both strings are different, return false.
- Concatenate the string with itself (s + s).
- Every possible rotation of s appears as a substring inside (s + s).
- If goal is a substring of (s + s), return true.
- Otherwise, return false.

Time Complexity  : O(n)
Space Complexity : O(n)

Why Optimal?
- Concatenating the string once contains all possible rotations.
- Only one substring search is required.

Edge Cases:
- Both strings are empty.
- Strings of different lengths.
- Single character strings.
- Strings are already equal.
- Rotation not possible.
*/

package Strings;
public class RotateString {

    // --------------------------- Brute Force Approach -----------------------

    public boolean rotateStringBrute(String s, String goal) {
        // Rotation is impossible if lengths differ
        if (s.length() != goal.length()) {
            return false;
        }
        String current = s;
        // Generate every possible left rotation
        for (int i = 0; i < s.length(); i++) {
            // Rotation matches
            if (current.equals(goal)) {
                return true;
            }
            // Move first character to the end
            current = current.substring(1) + current.charAt(0);
        }
        return false;
    }

    // ------------------------------- Optimal Approach ------------------------------

    public boolean rotateStringOptimal(String s, String goal) {
        // Rotation is impossible if lengths differ
        if (s.length() != goal.length()) {
            return false;
        }
        String doubled = s + s;          // Concatenate the string with itself
        return doubled.contains(goal);   // Check whether goal exists as a substring
    }
}