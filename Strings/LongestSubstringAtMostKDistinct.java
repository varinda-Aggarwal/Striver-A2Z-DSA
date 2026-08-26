/*
Problem: Longest Substring with At Most K Distinct Characters

Approach: Optimal - Sliding Window + HashMap

1. Use a HashMap to store the frequency of characters inside the current window.
2. Use two pointers:
   - left  -> starting point of the window
   - right -> ending point of the window
3. Expand the window using right.
4. If the number of distinct characters becomes greater than k, move left forward until the window becomes valid.
5. Update the maximum length of the valid window.
--------------------------------------------------
Time Complexity  : O(n)
Space Complexity : O(k)
--------------------------------------------------
*/

package Strings;
import java.util.HashMap;
public class LongestSubstringAtMostKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        int left = 0;

        // HashMap to store frequency of characters present in the current window
        HashMap<Character, Integer> map = new HashMap<>();

        // Traverse the string using right pointer
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Add current character to the window
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If distinct characters exceed k, shrink the window from the left
            while (map.size() > k) {
                char remove = s.charAt(left);
                map.put(remove,map.get(remove) - 1);   // Decrease frequency of the character
                if (map.get(remove) == 0) map.remove(remove);   // Remove character if its frequency becomes 0
                left++;
            }

            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}