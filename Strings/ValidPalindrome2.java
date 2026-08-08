/*
Problem: Valid Palindrome II

Description:
Given a string s, return true if the string can become a palindrome after deleting at most one character.

Example 1:
Input  : "aba"
Output : true

Example 2:
Input  : "abca"
Output : true
Explanation: Remove 'b' or 'c'.

Example 3:
Input  : "abc"
Output : false

--------------------------------------------------
Approach: Optimal (Two Pointers)
--------------------------------------------------
- Use two pointers, left and right.
- Compare characters from both ends.
- If they match, move both pointers inward.
- If a mismatch is found, we are allowed to delete at most one character.
- Try skipping the left character OR the right character.
- Check whether either remaining substring is a palindrome.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- The string is traversed using two pointers.
- No new string or extra data structure is created.
- At most one mismatch requires checking both possibilities.

Edge Cases:
- Already a palindrome
- One character
- Empty string
- Mismatch near the beginning
- Mismatch near the end
- More than one mismatch
*/

package Strings;
public class ValidPalindrome2 {

    // ------------------ Helper Function ------------------

    // Checks whether the substring s[left...right] is a palindrome
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

    // ------------------ Optimal Approach ------------------

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // Characters match, so continue normally
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            // Mismatch: try deleting either left or right character
            else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }
}