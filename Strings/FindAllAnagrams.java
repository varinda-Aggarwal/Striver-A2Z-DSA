/*
Problem: Find All Anagrams in a String

Description:
Given two strings s and p, return a list of all the starting indices of p's anagrams in s. An anagram is a string formed by rearranging the characters of another string while maintaining the same character frequencies.

Example 1:
Input  : s = "cbaebabacd", p = "abc"
Output : [0, 6]

Example 2:
Input  : s = "abab", p = "ab"
Output : [0, 1, 2]

--------------------------------------------------
Approach 1: Brute Force (Sliding Window + Frequency Array)
--------------------------------------------------
- Generate every possible window of size p.length().
- For every window, create a frequency array.
- Add frequencies of characters from the current window.
- Subtract frequencies of characters from p.
- If every frequency becomes zero, the window is an anagram.

Time Complexity  : O((n - m + 1) * (m + 26)) ≈ O(n * m)

Space Complexity : O(26) = O(1)

Where:
n = length of s
m = length of p

Why Brute Force?
- A new frequency array is created for every window.
- Every window is traversed again to calculate its frequencies.
- The same characters are repeatedly processed in overlapping windows.

--------------------------------------------------
Approach 2: Better (Sliding Window + HashMap)
--------------------------------------------------
- Create a frequency map for p.
- Maintain another frequency map for the current window in s.
- Use a sliding window of size p.length().
- Add the new character when the right pointer moves.
- Remove the leftmost character when the window becomes too large.
- Compare both maps when the window size equals p.length().
- If both maps are equal, the current window is an anagram.

Time Complexity  : O(n * k) in the worst case, where k is the number of distinct characters. For a fixed character set, this is effectively O(n).

Space Complexity : O(k) where k is the number of distinct characters.

Why Better?
- The frequency of the current window is maintained incrementally.
- We don't rebuild the frequency information for every window.
- HashMap.equals() compares the frequency maps instead of manually rebuilding frequencies.

--------------------------------------------------
Approach 3: Optimal (Sliding Window + Frequency Array)
--------------------------------------------------
- Since the problem contains lowercase English letters, use a frequency array of size 26.
- Maintain the frequency difference between the current window and p.
- Slide the window across s.
- Add the entering character and remove the leaving character.
- If all 26 frequencies are zero, the current window is an anagram.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- The sliding window avoids recalculating frequencies from scratch.
- A fixed-size array of 26 is used instead of HashMaps.
- The character set is fixed, so the extra space remains constant.

Edge Cases:
- p is longer than s
- s and p have the same length
- Multiple anagrams occur
- No anagram exists
- Repeated characters in p
*/

package Strings;
import java.util.*;
public class FindAllAnagrams {

    // ------------------ Brute Force Approach ------------------

    public List<Integer> findAnagramsBrute(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int windowSize = p.length();
        // Generate every possible window of size p.length()
        for (int i = 0; i <= s.length() - windowSize; i++) {
            int[] freq = new int[26];
            // Calculate frequency difference between current window and p
            for (int j = i; j < i + windowSize; j++) {
                freq[s.charAt(j) - 'a']++;
                freq[p.charAt(j - i) - 'a']--;
            }
            // Check whether all frequencies are zero
            boolean flag = true;
            for (int count : freq) {
                if (count != 0) {
                    flag = false;
                    break;
                }
            }
            // Current window is an anagram of p
            if (flag) {
                ans.add(i);
            }
        }
        return ans;
    }


    // ------------------ Better Approach ------------------

    public List<Integer> findAnagramsBetter(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        // Frequency map for p
        HashMap<Character, Integer> pMap = new HashMap<>();
        // Frequency map for current window
        HashMap<Character, Integer> sMap = new HashMap<>();
        // Store frequency of characters in p
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        // Sliding window
        while (right < s.length()) {
            char ch = s.charAt(right);
            // Add current character to the window
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            // If window becomes larger than p, remove the leftmost character
            if (right - left + 1 > p.length()) {
                char remove = s.charAt(left);
                sMap.put(remove, sMap.get(remove) - 1);
                // Remove key if its frequency becomes zero
                if (sMap.get(remove) == 0) {
                    sMap.remove(remove);
                }
                left++;
            }
            // Check the window when its size equals p.length()
            if (right - left + 1 == p.length()) {
                // Same frequencies → anagram
                if (pMap.equals(sMap)) {
                    ans.add(left);
                }
            }
            right++;
        }
        return ans;
    }


    // ------------------ Optimal Approach ------------------

    public List<Integer> findAnagramsOptimal(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        // Frequency difference array Only lowercase English letters are present
        int[] freq = new int[26];
        // Store frequency of p
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }
        int left = 0;
        // Sliding window
        for (int right = 0; right < s.length(); right++) {
            // Add character entering the window
            freq[s.charAt(right) - 'a']--;

            // Keep window size equal to p.length()
            if (right - left + 1 > p.length()) {
                freq[s.charAt(left) - 'a']++;
                left++;
            }

            // Check whether current window is an anagram
            if (right - left + 1 == p.length()) {
                boolean isAnagram = true;
                for (int count : freq) {
                    if (count != 0) {
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}