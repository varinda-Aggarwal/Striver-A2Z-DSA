/*
Problem: Valid Palindrome

Description:
Given a string s, determine whether it is a palindrome, considering only alphanumeric characters and ignoring case.

Example 1:
Input  : "A man, a plan, a canal: Panama"
Output : true

Example 2:
Input  : "race a car"
Output : false

Example 3:
Input  : " "
Output : true

--------------------------------------------------
Approach 1: Better (StringBuilder + Two Pointers)
--------------------------------------------------
- Convert the entire string to lowercase.
- Use StringBuilder to remove all non-alphanumeric characters.
- Use two pointers to check whether the cleaned string is a palindrome.

Time Complexity  : O(n)
Space Complexity : O(n)

Why Better?
- The cleaned string requires O(n) extra space.
- We create an additional StringBuilder instead of working directly on the original string.

--------------------------------------------------
Approach 2: Optimal (Two Pointers)
--------------------------------------------------
- Work directly on the original string.
- Use two pointers: left and right.
- Skip non-alphanumeric characters from both sides.
- Convert only the characters being compared to lowercase.
- If they are different, return false.
- Move both pointers towards the center.
- If all characters match, return true.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- No extra String or StringBuilder is created.
- Each character is visited at most once.
- Only two pointers are used.

Edge Cases:
- Empty string
- Single character
- String containing only spaces/special characters
- Uppercase and lowercase characters
- Spaces and special characters between valid characters
*/

package Strings;
public class ValidPalindrome {

    // ------------------------------- Better Approach --------------------------------------

    public boolean isPalindromeBetter(String s) {
        String lowerCase = s.toLowerCase();        // Convert the entire string to lowercase
        StringBuilder str = new StringBuilder(lowerCase);     // Store only alphanumeric characters
        // Remove non-alphanumeric characters traverse backwards so deletion does not affect the indices of characters that are yet to be checked.
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                str.deleteCharAt(i);
            }
        }
        // Check whether the cleaned string is a palindrome
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    // ---------------------------------- Optimal Approach --------------------------------------

    public boolean isPalindromeOptimal(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from the right
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Compare characters while ignoring case
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}