/*
Problem: Longest Substring Without Repeating Characters

Description:
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input  : "abcabcbb"
Output : 3
Explanation: "abc" is the longest substring without repeating characters.

Example 2:
Input  : "bbbbb"
Output : 1
Explanation: "b" is the longest substring.

Example 3:
Input  : "pwwkew"
Output : 3
Explanation: "wke" is the longest substring without repeating characters.

--------------------------------------------------
Approach 1: Brute Force
--------------------------------------------------
- Start from every possible starting index.
- Use a HashSet to store characters of the current substring.
- Keep adding characters until a duplicate is found.
- When a duplicate appears, stop checking that substring.
- Update the maximum length.

Time Complexity  : O(n²)
Space Complexity : O(n)

--------------------------------------------------
Approach 2: Optimal (Sliding Window + HashMap)
--------------------------------------------------
- Maintain a sliding window using two pointers: left and right.
- Store the frequency of every character currently present in the window.
- Move right forward and add the current character.
- If the current character appears more than once, move left forward until its frequency becomes 1.
- At every step, update the maximum window length.

Time Complexity  : O(n)
Space Complexity : O(n)

Why Optimal?
- Each character is added to and removed from the window at most once.
- Therefore, both pointers move forward at most n times.
- No substring is generated explicitly.

Edge Cases:
- Empty string
- Single character
- All characters are unique
- All characters are the same
- Duplicate characters occurring multiple times
*/

package Strings;
import java.util.HashMap;
import java.util.HashSet;
public class LongestSubstringWithoutRepeatingCharacters {

    // ------------------ Approach 1: Brute Force ------------------

    public int lengthOfLongestSubstringBrute(String s) {
        int maxLen = 0;
        // Try every starting position
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            int count = 0;
            // Build substring from i onwards
            for (int j = i; j < s.length(); j++) {
                // If character is not already present
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    count++;
                }
                else {
                    // Duplicate found
                    break;
                }
            }
            // Update maximum length
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }


    // ---------------------- Approach 2: Optimal Approach ------------------------

    public int lengthOfLongestSubstringOptimal(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        // right pointer traverses the string
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            // Add current character to the frequency map
            map.put(current, map.getOrDefault(current, 0) + 1);
            // Duplicate found → move left pointer
            while (map.get(current) > 1) {
                char remove = s.charAt(left);
                map.put(remove, map.get(remove) - 1);
                left++;
            }
            // Current window contains unique characters
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}