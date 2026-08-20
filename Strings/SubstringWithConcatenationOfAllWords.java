/*
Problem: Substring with Concatenation of All Words

Description:
Given a string s and an array of strings words, where all words have the same length, find all starting indices of substrings in s that are a concatenation of every word in words exactly once, in any order.

Example:
Input:
s = "barfoothefoobarman"
words = ["foo", "bar"]

Output:
[0, 9]

Explanation:
"barfoo" starts at index 0.
"foobar" starts at index 9.

--------------------------------------------------
Approach 1: Brute Force
--------------------------------------------------
- Generate all possible permutations of words.
- Concatenate every permutation into a string.
- Store them in a HashSet to avoid duplicates.
- Search every generated string inside s.

Problem:
Generating permutations takes factorial time. Therefore, this approach can result in TLE.

Time Complexity : O(m! × N × L) approximately
Space Complexity: O(m! × L)

where:
m = number of words
N = length of s
L = total length of all words

--------------------------------------------------
Approach 2: Optimal
--------------------------------------------------
- Store the required frequency of every word in a HashMap.
- Since every word has the same length, process s in word-sized chunks.
- Try every possible starting offset from 0 to wordSize - 1.
- Maintain a sliding window using start and end.
- Store the frequency of words currently inside the window.
- If a word occurs more times than required, move start forward until the frequency becomes valid.
- When the window contains exactly wordCount words, add start to the answer.
- If a word is not present in the required map, reset the window.

Time Complexity : O(N) approximately
Space Complexity: O(m)

Why Optimal?
- Does not generate permutations.
- Processes words directly using a sliding window.
- Each word is added and removed from the current window efficiently.
*/

package Strings;
import java.util.*;
public class SubstringWithConcatenationOfAllWords {

    // -------------------------- Approach 1: Brute Force ------------------------------

    private void generate(String[] words, String current, boolean[] used, HashSet<String> set) {

        // Base case
        if (current.length() == words.length * words[0].length()) {
            set.add(current);
            return;
        }

        // Try every word
        for (int i = 0; i < words.length; i++) {
            if (used[i]) continue;
            used[i] = true;  // Choose
            generate(words, current + words[i], used, set);   // Explore
            used[i] = false;    // Backtrack
        }
    }

    public List<Integer> findSubstringBrute(String s,String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0) {
            return ans;
        }

        boolean[] used = new boolean[words.length];   // Used array for permutation generation
        HashSet<String> set = new HashSet<>();        // Store all possible concatenated strings
        generate(words, "", used, set);      // Generate permutations

        // Check every generated string in s
        for (String str : set) {
            for (int i = 0; i <= s.length() - str.length(); i++) {
                if (s.startsWith(str, i)) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }


    // ---------------------- Approach 2: Optimal: Sliding Window + HashMap --------------------------

    public List<Integer> findSubstring(String s,String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) {
            return ans;
        }

        // Frequency of required words
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int wordSize = words[0].length();
        int wordCount = words.length;
        int n = s.length();

        /*
         * We need to try different starting offsets because words have fixed length.
         
         * Example:
         * wordSize = 3
         
         * offsets:
         * 0 → 0, 3, 6, 9...
         * 1 → 1, 4, 7, 10...
         * 2 → 2, 5, 8, 11...
         */

        for (int offset = 0; offset < wordSize; offset++) {
            HashMap<String, Integer> currentCount = new HashMap<>();
            int start = offset;
            int count = 0;

            // Move end one complete word at a time
            for (int end = offset; end + wordSize <= n;end += wordSize) {
                String currWord = s.substring(end, end + wordSize);

                // Case 1: Current word exists in required map
                if (map.containsKey(currWord)) {

                    // Add current word to current window
                    currentCount.put( currWord, currentCount.getOrDefault(currWord, 0) + 1);
                    count++;

                    // If current word occurs more times than required, remove words from the left until the window becomes valid again.
                    while (currentCount.get(currWord) > map.get(currWord)) {
                        String startWord = s.substring(start,start + wordSize);
                        currentCount.put(startWord, currentCount.get(startWord) - 1);
                        start += wordSize;
                        count--;
                    }

                    //Window contains exactly all required words.
                    if (count == wordCount) {
                        ans.add(start);
                    }
                }

                // Case 2: Current word does not exist
                else {
                    //This word can never be part of a valid concatenation, so reset the window.
                    count = 0;
                    start = end + wordSize;
                    currentCount.clear();
                }
            }
        }
        return ans;
    }
}