/*
Problem: Minimum Window Substring

Description:
Given two strings s and t, return the minimum window substring of s such that every character in t, including duplicates, is included in the window.

If no such substring exists, return "".

Example 1:
Input  : s = "ADOBECODEBANC", t = "ABC"
Output : "BANC"

Example 2:
Input  : s = "a", t = "a"
Output : "a"

Example 3:
Input  : s = "a", t = "aa"
Output : ""

--------------------------------------------------
Approach 1: Brute Force
--------------------------------------------------
- Generate every possible substring of s.
- For every substring whose length is at least t.length(), check whether it contains all characters of t.
- Keep track of the shortest valid substring.

Time Complexity : O(n³) approximately
Space Complexity : O(1) / O(128)

Why Brute?
- Generates all possible substrings.
- Checks each substring separately.
- The same characters are repeatedly traversed.

--------------------------------------------------
Approach 2: Optimal
--------------------------------------------------
- Store the required frequency of every character in t.
- Use a sliding window with two pointers: left and right.
- Expand the window using right.
- Whenever a required character is found, update count.
- When the window contains all characters of t, shrink it from the left to find the smallest valid window.
- Keep updating the minimum window.

Time Complexity  : O(n)
Space Complexity : O(128)

Why Optimal?
- Each character enters the window once.
- Each character leaves the window at most once.
- No substring is repeatedly generated and checked.
*/

package Strings;
import java.util.HashMap;
public class MinimumWindowSubstring {

    // ------------------------------------ Approach 1: Brute Force -----------------------------------

    private boolean containsAll(String str, String t) {
        int[] freq = new int[128];

        // Store frequency of characters in the substring
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        // Check whether all characters of t are present
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (freq[ch] == 0) {
                return false;
            }
            freq[ch]--;
        }
        return true;
    }

    public String minWindowBrute(String s, String t) {
        String ans = "";
        int minLen = Integer.MAX_VALUE;

        // Generate every possible substring
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                // Only check windows large enough to contain t
                if (j - i + 1 >= t.length()) {
                    String str = s.substring(i, j + 1);

                    // Check whether current substring contains t
                    if (containsAll(str, t)) {
                        int len = j - i + 1;
                        // Update minimum window
                        if (len < minLen) {
                            minLen = len;
                            ans = str;
                        }
                    }
                }
            }
        }
        return ans;
    }

    // ------------------------- Approach 2: Optimal: Sliding Window + Frequency Map ---------------------------

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        // Store frequency of characters required by t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;

        // Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Decrease frequency because this character has now entered the current window.
            map.put(ch, map.getOrDefault(ch, 0) - 1);

            // If frequency is still >= 0, this character was actually required by t.
            if (map.get(ch) >= 0) {
                count++;
            }

            // When count == t.length(), the current window contains all required characters.
            while (count == t.length()) {
                int windowLength = right - left + 1;

                // Update minimum window
                if (windowLength < minLen) {
                    minLen = windowLength;
                    startIndex = left;
                }

                // Remove leftmost character
                char remove = s.charAt(left);
                map.put(remove, map.get(remove) + 1);
                left++;

        //If frequency becomes positive, the removedcharacter was required, so the current window is no longer valid.
                if (map.get(remove) > 0) {
                    count--;
                }
            }
        }

        // No valid window found
        if (startIndex == -1) {
            return "";
        }
        return s.substring(startIndex,startIndex + minLen);
    }
}