/*
Problem: Isomorphic Strings

Description:
Given two strings s and t, determine whether they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.

Rules:
- Every character in s must map to exactly one character in t.
- No two different characters in s can map to the same character.
- A character may map to itself.

Example 1:
Input  : s = "egg", t = "add"
Output : true

Example 2:
Input  : s = "foo", t = "bar"
Output : false

Example 3:
Input  : s = "paper", t = "title"
Output : true

--------------------------------------------------
Approach: Optimal (Two HashMaps)
--------------------------------------------------
- If the lengths of both strings are different, they cannot be isomorphic.
- Use one HashMap to store the mapping:
      s → t
- Use another HashMap to store the reverse mapping:
      t → s
- Traverse both strings simultaneously.
- For every character:
    • If a mapping does not exist, create it.
    • Otherwise, verify that the existing mapping is valid.
- If any mapping conflicts, return false.
- If traversal completes successfully, return true.

Time Complexity  : O(n)
Space Complexity : O(n)

Why Two HashMaps?
- One HashMap alone cannot prevent two different characters from mapping to the same character.
- The reverse HashMap guarantees one-to-one mapping.

Edge Cases:
- Strings of different lengths.
- Same strings.
- Repeated characters.
- Multiple characters mapping to one character.
- Single character strings.
*/

package Strings;
import java.util.HashMap;
public class IsomorphicStrings {

    // ------------------ Optimal Approach ------------------

    public boolean isIsomorphic(String s, String t) {
        // Strings of different lengths cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> forwardMap = new HashMap<>();    // Maps characters from s → t
        HashMap<Character, Character> reverseMap = new HashMap<>();    // Maps characters from t → s
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            // Check forward mapping
            if (!forwardMap.containsKey(ch1)) {
                forwardMap.put(ch1, ch2);
            }
            else if (forwardMap.get(ch1) != ch2) {
                return false;
            }

            // Check reverse mapping
            if (!reverseMap.containsKey(ch2)) {
                reverseMap.put(ch2, ch1);
            }
            else if (reverseMap.get(ch2) != ch1) {
                return false;
            }
        }
        return true;
    }
}