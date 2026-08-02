/*
Problem: Valid Anagram

Description:
Given two strings s and t, return true if t is an anagram of s, otherwise return false.
An Anagram is a word or phrase formed by rearranging the letters of another word, using all the original letters exactly once.

Example 1:
Input  : s = "anagram", t = "nagaram"
Output : true

Example 2:
Input  : s = "rat", t = "car"
Output : false

--------------------------------------------------
Approach 1: Brute Force (Visited Array)
--------------------------------------------------
- If the lengths of both strings are different, they cannot be anagrams.
- For every character in s, search for an unused matching character in t.
- Mark the matched character as visited.
- If any character cannot be matched, return false.
- If every character is matched exactly once, return true.

Time Complexity  : O(n²)
Space Complexity : O(n)

--------------------------------------------------
Approach 2: Better (HashMap)
--------------------------------------------------
- If the lengths are different, return false.
- Store the frequency of every character of s in a HashMap.
- Traverse string t:
    • If the character exists with frequency greater than 0, decrease its frequency.
    • Otherwise, return false.
- If traversal completes successfully, both strings are anagrams.

Time Complexity  : O(n)
Space Complexity : O(n)

--------------------------------------------------
Approach 3: Optimal (Frequency Array)
--------------------------------------------------
- Applicable when the strings contain only lowercase English letters.
- Create an integer array of size 26.
- Traverse both strings simultaneously:
    • Increment frequency for characters of s.
    • Decrement frequency for characters of t.
- Finally, if every frequency becomes 0, both strings are anagrams.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- Uses a fixed-size array of 26 characters.
- Avoids the overhead of HashMap.
- Constant extra space irrespective of input size.

Edge Cases:
- Strings of different lengths.
- Empty strings.
- Single character strings.
- Repeated characters.
- All characters identical.
*/

package Strings;
import java.util.HashMap;
public class ValidAnagram {

    // ------------------ Brute Force Approach ------------------

    public boolean isAnagramBrute(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Marks whether a character in t has already been matched
        boolean[] visited = new boolean[s.length()];

        // Try matching every character of s
        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = 0; j < t.length(); j++) {
                if (!visited[j] && s.charAt(i) == t.charAt(j)) {
                    visited[j] = true;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    // ------------------ Better Approach ------------------

    public boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        // Store frequency of characters from s
        for (int i = 0; i < s.length(); i++) {
            frequencyMap.put(
                    s.charAt(i),
                    frequencyMap.getOrDefault(s.charAt(i), 0) + 1
            );
        }
        // Match characters from t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (frequencyMap.containsKey(ch) && frequencyMap.get(ch) > 0) {
                frequencyMap.put(ch, frequencyMap.get(ch) - 1);
            }
            else {
                return false;
            }
        }
        return true;
    }

    // ------------------ Optimal Approach ------------------

    public boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // Frequency array for lowercase English letters
        int[] frequency = new int[26];
        // Increase for s and decrease for t simultaneously
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }
        // Every frequency should become zero
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}