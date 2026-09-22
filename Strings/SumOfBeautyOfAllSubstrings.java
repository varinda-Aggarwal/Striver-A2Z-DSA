/*
Problem: Sum of Beauty of All Substrings

Description: The beauty of a substring is defined as the difference between the maximum frequency and minimum frequency of any character present in that substring. For every possible substring of the given string, calculate its beauty and return the sum of the beauty of all substrings.

Example 1:
Input  : s = "aabcb"
Output : 5

Explanation:
For every substring, calculate: Beauty = Maximum Frequency - Minimum Frequency The sum of the beauty of all substrings is 5.

Example 2:
Input  : s = "abc"
Output : 0

Explanation: All characters occur with the same frequency in every substring, so the beauty of every substring is 0.

--------------------------------------------------
Approach 1: Optimal (Frequency Map + Expanding Substrings)
--------------------------------------------------
- Fix the starting index of the substring and Create a frequency map for every new starting index.
- Expand the substring one character at a time and Whenever a new character is added, update its frequency in the HashMap.
- After adding each character, find the minimum and maximum frequency among the characters present in the current substring.
- Calculate the beauty:
    Beauty = Maximum Frequency - Minimum Frequency
- Add the beauty of the current substring to the total count.
- Since the string contains only lowercase English letters, the HashMap can contain at most 26 characters.
- Therefore, finding minimum and maximum frequency takes O(26), which is considered O(1).

Time Complexity  : O(n²)
Space Complexity : O(1)

Why is this approach optimal?
- The frequency of characters is maintained while expanding the substring instead of calculating frequencies from scratch.
- There are O(n²) possible substrings.
- The frequency scan is limited to at most 26 characters.
- Therefore, the overall time complexity is O(n²).

--------------------------------------------------

Edge Cases:

- Single character string → beauty is 0
- All characters are identical → beauty is 0
- All characters are different → beauty is 0
- Repeated characters with different frequencies
- String containing only lowercase English letters
*/

package Strings;
import java.util.HashMap;
public class SumOfBeautyOfAllSubstrings {

    // ----------------------------------- Optimal Approach -----------------------------------

    public int beautySum(String s) {
        int count = 0;

        // Fix the starting index
        for (int start = 0; start < s.length(); start++) {
            HashMap<Character, Integer> map = new HashMap<>();

            // Expand the substring
            for (int j = start; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);    // Update frequency of the current character
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                // Find minimum and maximum frequency
                for (int value : map.values()) {
                    min = Math.min(min, value);
                    max = Math.max(max, value);
                }
                count += max - min;        // Add beauty of the current substring
            }
        }
        return count;
    }
}