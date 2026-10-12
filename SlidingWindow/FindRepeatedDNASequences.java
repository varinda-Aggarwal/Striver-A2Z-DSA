/*
Problem: Repeated DNA Sequences

Description: The DNA sequence is represented by a string containing the characters 'A', 'C', 'G', and 'T'. Given a string s, return all the 10-letter-long sequences (substrings) that occur more than once in the DNA molecule. The answer can be returned in any order, but each repeated sequence must appear only once.

Example 1:
Input  : s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output : ["AAAAACCCCC", "CCCCCAAAAA"]

Example 2:
Input  : s = "AAAAAAAAAAAAA"
Output : ["AAAAAAAAAA"]

--------------------------------------------------
Approach 1: Optimal (Two HashSets + Sliding Window)
--------------------------------------------------
- Use a HashSet named `seen` to store every 10-character substring encountered so far.
- Use another HashSet named `repeated` to ensure that each repeated substring is added to the answer only once.
- Start from index 0 and extract a substring of length 10.
- If the substring already exists in `seen`, it is a repeated sequence.
- Add it to `repeated`. The add() method returns true only if the substring was not already present in that set.
- If it is added successfully, append it to the answer list.
- Add the current substring to `seen` and move the starting index forward by one.
- Continue until fewer than 10 characters remain.

Time Complexity  : O(n) average
Space Complexity : O(n)

Why is this approach optimal?
- Each 10-character substring is processed once.
- HashSet lookups and insertions take O(1) average time.
- Since the substring length is fixed at 10, extracting and comparing each substring takes constant time.

--------------------------------------------------
Approach 2: HashSet + ArrayList
--------------------------------------------------
- Use a HashSet named `seen` to track previously encountered substrings.
- Whenever a substring already exists in `seen`, check whether it is present in the answer list using `ans.contains()`.
- If it is not present, add it to the answer list.
- Add each processed substring to `seen`.
- This approach is correct, but `ans.contains()` requires a linear search through the answer list.

Time Complexity  : O(n²) worst case
Space Complexity : O(n)

Why is this approach slower?
- ArrayList.contains() may scan the entire answer list.
- This repeated search can take O(n²) time in the worst case.
- Using a second HashSet avoids this repeated linear search.

--------------------------------------------------

Edge Cases:

- String length is less than 10 → return an empty list
- No repeated 10-character sequence
- The same sequence appears multiple times
- All characters are identical
- Multiple different sequences repeat
*/

package SlidingWindow;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class FindRepeatedDNASequences {

    // ----------------------------------- Optimal Approach -----------------------------------

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int left = 0;
        // Process every possible substring of length 10
        while (left + 10 <= s.length()) {
            String sub = s.substring(left, left + 10);
            // Check whether this sequence has appeared before
            if (seen.contains(sub)) {
                // Add the sequence to the answer only once
                if (repeated.add(sub)) {
                    ans.add(sub);
                }
            }
            // Store the current sequence
            seen.add(sub);
            left++;
        }
        return ans;
    }

    // ----------------------------------- Second Approach -----------------------------------

    public List<String> findRepeatedDnaSequencesUsingList(String s) {
        HashSet<String> seen = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int left = 0;
        // Process every possible substring of length 10
        while (left + 10 <= s.length()) {
            String sub = s.substring(left, left + 10);
            // Check whether this sequence has appeared before
            if (seen.contains(sub)) {
                // ArrayList.contains() performs a linear search
                if (!ans.contains(sub)) {
                    ans.add(sub);
                }
            }
            seen.add(sub);    // Store the current sequence
            left++;
        }
        return ans;
    }
}