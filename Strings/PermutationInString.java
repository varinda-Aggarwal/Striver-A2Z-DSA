/*
Problem: Permutation in String

Description: Given two strings s1 and s2, return true if s2 contains a permutation of s1 as a substring.

Example 1:
Input  : s1 = "ab", s2 = "eidbaooo"
Output : true
Explanation: "ba" is a permutation of "ab" and occurs in s2.

Example 2:
Input  : s1 = "ab", s2 = "eidboaoo"
Output : false

--------------------------------------------------
Approach 1: Brute Force
--------------------------------------------------
- Generate all possible permutations of s1 using recursion.
- Store the generated permutations in a HashSet.
- Check whether any generated permutation exists inside s2.

Time Complexity  : O(m! * m + m! * n)
Space Complexity : O(m! * m)

where:
m = length of s1
n = length of s2

Why Brute Force?
- Generates every possible permutation of s1.
- Most of these permutations are unnecessary.
- Time complexity grows factorially.

--------------------------------------------------
Approach 2: Better
--------------------------------------------------
- Store the frequency of characters of s1 in freq1.
- Maintain the frequency of the current sliding window of s2 in freq2.
- Keep the window size equal to s1.length().
- Compare freq1 and freq2 using Arrays.equals().
- If both frequency arrays are equal, the window is a permutation of s1.

Time Complexity  : O(n * 26) ≈ O(n)
Space Complexity : O(26) = O(1)

Why Better?
- No permutations are generated.
- Sliding window avoids checking every possible substring from scratch.
- However, the two frequency arrays are compared for every window.

--------------------------------------------------
Approach 3: Optimal
--------------------------------------------------
- Use one frequency array of size 26.
- Initially store the frequency of characters in s1.
- While traversing s2, decrease the frequency of characters entering the window.
- When a character leaves the window, restore its frequency.
- Maintain a count representing how many characters are still required.
- When count becomes 0, the current window is a permutation of s1.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- Only one frequency array is used.
- No repeated Arrays.equals() comparison.
- Each character enters and leaves the window at most once.
- No permutations are generated.

Edge Cases:
- s1 is longer than s2
- Both strings have the same length
- Duplicate characters in s1
- No permutation exists
*/

package Strings;
import java.util.*;
public class PermutationInString {

    // ----------------------- Approach 1: Brute Force --------------------

    private void generate(String s, String current, boolean[] used, HashSet<String> set) {

        // Base case
        if (current.length() == s.length()) {
            set.add(current);
            return;
        }

        // Try every character
        for (int i = 0; i < s.length(); i++) {
            if (used[i]) continue;

            // Mark character as used
            used[i] = true;

            // Add character and continue recursion
            generate(s, current + s.charAt(i), used, set);

            // Backtracking
            used[i] = false;
        }
    }

    public boolean checkInclusionBrute(String s1, String s2) {
        // Generate all permutations of s1
        HashSet<String> set = new HashSet<>();
        boolean[] used = new boolean[s1.length()];
        generate(s1, "", used, set);
        // Check whether any permutation occurs in s2
        for (String permutation : set) {
            if (s2.contains(permutation)) {
                return true;
            }
        }
        return false;
    }


    // -------------- Approach 2: Better Approach: Sliding Window + Two Frequency Arrays -----------------

    public boolean checkInclusionBetter(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Store frequency of s1
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
        }
        int left = 0;

        // Sliding window
        for (int right = 0; right < s2.length(); right++) {
            // Add current character
            freq2[s2.charAt(right)-'a']++;

            // Maintain window size
            if (right-left+1 > s1.length()) {
                freq2[s2.charAt(left)-'a']--;
                left++;
            }

            // Compare when window size equals s1 length
            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(freq1, freq2)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // ------------------ Approach 3: Optimal Approach: Sliding Window + One Frequency Array ----------------

    public boolean checkInclusionOptimal(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freq = new int[26];

        // Store frequency of characters in s1
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int left = 0;

        // Number of characters still required
        int count = s1.length();

        for (int right = 0; right < s2.length(); right++) {
            int index = s2.charAt(right) - 'a';

            // If this character was still required, we have successfully matched one character.
            if (freq[index] > 0) {
                count--;
            }

            // Add current character to the window
            freq[index]--;

            // Window size should not exceed s1.length()
            if (right - left + 1 > s1.length()) {
                int removeIndex = s2.charAt(left) - 'a';

                //If frequency is >= 0 before restoring, it means this character was contributing to the current matching window.
                if (freq[removeIndex] >= 0) {
                    count++;
                }

                // Remove character from window
                freq[removeIndex]++;
                left++;
            }

            // All characters of s1 are matched
            if (count == 0) {
                return true;
            }
        }
        return false;
    }
}