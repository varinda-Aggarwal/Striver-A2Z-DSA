/*
Problem: Longest K Unique Characters Substring

Description:
Given a string s and an integer k, find the length of the longest substring containing exactly k distinct characters. If no such substring exists, return -1.

Example 1:
Input  : s = "aabacbebebe", k = 3
Output : 7
Explanation: "cbebebe" is the longest substring with exactly 3
distinct characters.

Example 2:
Input  : s = "aaaa", k = 2
Output : -1

--------------------------------------------------
Approach 1: Brute Force
--------------------------------------------------
- Start from every possible index.
- Use a HashSet to store distinct characters.
- Extend the substring towards the right.
- If distinct characters become greater than k, stop.
- If distinct characters become exactly k, update the answer.

Time Complexity  : O(n²)
Space Complexity : O(k)

--------------------------------------------------
Approach 2: Optimal (Sliding Window + HashMap)
--------------------------------------------------
- Maintain a sliding window using two pointers.
- Store the frequency of every character in the current window.
- Expand the right pointer.
- If the window contains more than k distinct characters, move the left pointer until the window contains at most k distinct characters.
- Whenever the window contains exactly k distinct characters, update the maximum length.

Time Complexity  : O(n)
Space Complexity : O(k)

Why Optimal?
- Each character enters the window once and leaves the window at most once.
- Therefore, both pointers together traverse the string in O(n).
- No substring is explicitly generated.

Edge Cases:
- Empty string
- k = 0
- k is greater than the number of distinct characters
- String contains only one distinct character
- No substring contains exactly k distinct characters
*/

package Strings;
import java.util.HashMap;
import java.util.HashSet;
public class LongestKUniqueSubstring {

    // ------------------ Approach 1: Brute Force ------------------

    public int longestKSubstrBrute(String s, int k) {
        if (s.length() == 0 || k == 0) {
            return -1;
        }
        int maxLen = -1;
        // Try every starting point
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            // Extend the substring
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                set.add(ch);         // Add character to the set
                // More than k distinct characters
                if (set.size() > k) {
                    break;
                }
                // Exactly k distinct characters
                if (set.size() == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }


    // ------------------ Approach 2: Optimal Approach ----------------------

    public int longestKSubstrOptimal(String s, int k) {

        if (s.length() == 0 || k == 0) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = -1;
        int left = 0;

        // Expand the window using right pointer
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);   // Add current character to the frequency map

            // Shrink window if distinct characters exceed k
            while (map.size() > k) {
                char remove = s.charAt(left);
                map.put(remove, map.get(remove) - 1);

                // Remove character completely if its frequency becomes 0
                if (map.get(remove) == 0) {
                    map.remove(remove);
                }
                left++;
            }

            // Update answer when exactly k distinct characters exist
            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}