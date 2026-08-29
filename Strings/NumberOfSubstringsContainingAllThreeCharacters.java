/*
Problem: Number of Substrings Containing All Three Characters

Description: Given a string s consisting only of characters 'a', 'b', and 'c', return the number of substrings containing at least one occurrence of all three characters.

Example 1:
Input  : s = "abcabc"
Output : 10

Explanation: The substrings containing at least one 'a', 'b', and 'c' are: "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc", and "abc".

Example 2:
Input  : s = "aaacb"
Output : 3

Explanation:The valid substrings are: "aaacb", "aacb", and "acb".

--------------------------------------------------
Approach 1: Optimal (Sliding Window)
--------------------------------------------------
- Use a HashMap to store the frequency of characters in the current window.
- Use two pointers:
    • left  -> starting point of the window
    • right -> ending point of the window
- Expand the window using the right pointer.
- Whenever the window contains all three characters, shrink the window from the left.
- When the window contains all three characters, every substring starting from the current left position up to the current right position and extending towards the end of the string will also contain all three characters.
- Therefore, the number of valid substrings is: s.length() - right
- Add this value to count.
- Continue shrinking the window from the left and count all possible valid starting positions.

Time Complexity  : O(n)
Space Complexity : O(1)
Since the string contains only 'a', 'b', and 'c', the HashMap contains at most 3 characters.

Edge Cases:
- String contains fewer than 3 distinct characters
- All characters are the same
- All three characters appear only once
- Multiple consecutive occurrences of the same character
*/
package Strings;
import java.util.HashMap;
public class NumberOfSubstringsContainingAllThreeCharacters {

    // ----------------------------------- Optimal Approach -----------------------------------

    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;

        // Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);   // Add current character to the window

            // If the window contains all three characters, count all valid substrings.
            while (map.size() == 3) {
                // Once the current window contains a, b and c, every substring extending from right to the end of the string will also contain all three. Number of such substrings = s.length() - right
                count += s.length() - right;
                char remove = s.charAt(left);    // Remove character from the left
                map.put(remove, map.get(remove) - 1);
                if (map.get(remove) == 0) map.remove(remove);    // Remove character if its frequency becomes 0
                left++;
            }
        }
        return count;
    }
}