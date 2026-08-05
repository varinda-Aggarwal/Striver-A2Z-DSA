/*
Problem: Longest Common Prefix

Description:
Write a function to find the longest common prefix string among an array of strings. If there is no common prefix, return an empty string.

Example 1:
Input  : ["flower", "flow", "flight"]
Output : "fl"

Example 2:
Input  : ["dog", "racecar", "car"]
Output : ""

--------------------------------------------------
Approach 1: Optimal (Character-by-Character Comparison)
--------------------------------------------------
- Take the first string as the reference string.
- Compare each character of the reference string with the corresponding character of every other string.
- Stop immediately when:
    • A mismatch is found, or
    • Any string becomes shorter.
- Return the common prefix obtained so far.

Time Complexity  : O(n × m)
Space Complexity : O(1)

--------------------------------------------------
Approach 2: Optimal (Shortest String + Prefix Shrinking)
--------------------------------------------------
- Find the shortest string in the array.
- Assume it is the longest common prefix.
- Traverse every string in the array.
- While a string does not start with the current prefix, remove the last character from the prefix.
- Continue until every string starts with the same prefix.

Time Complexity  : O(n × m)
Space Complexity : O(1)

Why Both are Optimal?
- Both solutions compare characters only until a mismatch occurs.
- Neither solution uses any extra data structure.
- Both achieve the best possible time complexity of O(n × m),
  where:
    n = Number of strings
    m = Length of the shortest string

Edge Cases:
- Single string
- Empty string present
- No common prefix
- All strings identical
- One string is the prefix of all others
*/

package Strings;
public class LongestCommonPrefix {

    // ----------------------------------- Optimal Approach 1 -----------------------------------

    public String longestCommonPrefixOptimal1(String[] strs) {
        String reference = strs[0];
        int lastMatchedIndex = -1;
        // Compare every character of the reference string
        for (int i = 0; i < reference.length(); i++) {
            boolean matched = true;
            // Compare with every other string
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i ||
                    strs[j].charAt(i) != reference.charAt(i)) {

                    matched = false;
                    break;
                }
            }
            if (matched) {
                lastMatchedIndex = i;
            }
            else {
                break;
            }
        }
        if (lastMatchedIndex == -1) {
            return "";
        }
        return reference.substring(0, lastMatchedIndex + 1);
    }

    // ------------------------------------ Optimal Approach 2 ---------------------------------

    public String longestCommonPrefixOptimal2(String[] strs) {
        // Find the shortest string
        int shortestIndex = 0;
        int minimumLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minimumLength) {
                minimumLength = strs[i].length();
                shortestIndex = i;
            }
        }
        String prefix = strs[shortestIndex];
        // Shrink the prefix until every string starts with it
        for (String str : strs) {
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}