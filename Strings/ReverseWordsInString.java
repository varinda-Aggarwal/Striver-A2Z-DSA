/*
Problem: Reverse Words in a String

Description:
Given an input string, reverse the order of the words.

A word is defined as a sequence of non-space characters.
The returned string should contain exactly one space between words
and should not have leading or trailing spaces.

Example 1:
Input  : "the sky is blue"
Output : "blue is sky the"

Example 2:
Input  : "  hello world  "
Output : "world hello"

Example 3:
Input  : "a good   example"
Output : "example good a"

--------------------------------------------------
Approach 1: Using String (Brute Force)
--------------------------------------------------
- Remove leading and trailing spaces using trim().
- Traverse the string from right to left.
- Build the current word character by character.
- Whenever a space is encountered:
    • Append the completed word to the answer.
    • Ignore multiple consecutive spaces.
- Finally, append the last remaining word.

Time Complexity  : O(n²)
Space Complexity : O(n)

Why O(n²)?
- Java String is immutable.
- Every concatenation creates a new String.
- Repeated concatenations make the overall complexity O(n²).

--------------------------------------------------
Approach 2: Using StringBuilder (Optimal)
--------------------------------------------------
- Remove leading and trailing spaces using trim().
- Traverse the string from right to left.
- Store the current word in a StringBuilder.
- Whenever a space is encountered:
    • Reverse the current word.
    • Append it to the final answer.
    • Reset the current word.
- After traversal, append the final remaining word.

Time Complexity  : O(n)
Space Complexity : O(n)

Why Optimal?
- StringBuilder performs append operations in O(1) amortized time.
- Every character is processed only once.

Edge Cases:
- Empty string
- String with only spaces
- Multiple spaces between words
- Single word
- Leading and trailing spaces
*/

package Strings;
public class ReverseWordsInString {

    // ------------------ Brute Force Approach (Using String) ------------------

    public String reverseWordsBrute(String s) {
        s = s.trim();     // Remove leading and trailing spaces
        String reversed = "";
        String word = "";
        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                word = ch + word;             // Build current word
            }
            else {
                // Append completed word
                if (!word.isEmpty()) {
                    if (reversed.isEmpty()) {
                        reversed = word;
                    }
                    else {
                        reversed = reversed + " " + word;
                    }
                    word = "";
                }
            }
        }

        // Append last remaining word
        if (!word.isEmpty()) {
            if (reversed.isEmpty()) {
                reversed = word;
            }
            else {
                reversed = reversed + " " + word;
            }
        }
        return reversed;
    }

    // ------------------ Optimal Approach (Using StringBuilder) ------------------

    public String reverseWordsOptimal(String str) {
        str = str.trim();             // Remove leading and trailing spaces
        StringBuilder reversed = new StringBuilder();
        StringBuilder word = new StringBuilder();
        // Traverse from right to left
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                // Store current word in reverse order
                word.append(ch);
            }
            else {
                if (word.length() > 0) {
                    word.reverse();              // Reverse current word
                    // Append word to answer
                    if (reversed.length() == 0) {
                        reversed.append(word);
                    }
                    else {
                        reversed.append(" ").append(word);
                    }
                    word.setLength(0);          // Clear current word
                }
            }
        }

        // Append the first word
        if (word.length() > 0) {
            word.reverse();
            if (reversed.length() == 0) {
                reversed.append(word);
            }
            else {
                reversed.append(" ").append(word);
            }
        }
        return reversed.toString();
    }
}