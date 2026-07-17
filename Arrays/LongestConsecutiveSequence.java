/*
Problem: Longest Consecutive Sequence

Description:
Given an unsorted array of integers, return the length of the longest sequence of consecutive integers.
A consecutive sequence consists of numbers that follow each other without any gaps.

Example 1:
Input  : [100, 4, 200, 1, 3, 2]
Output : 4
Explanation:
The longest consecutive sequence is [1, 2, 3, 4].

Example 2:
Input  : [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
Output : 9
Explanation:
The longest consecutive sequence is
[0, 1, 2, 3, 4, 5, 6, 7, 8].

--------------------------------------------------
Approach 1: Brute Force (Linear Search)
--------------------------------------------------
- Traverse every element of the array.
- For each element, repeatedly search for the next consecutive element using linear search.
- Continue until the next element is not found.
- Update the maximum sequence length.

Time Complexity  : O(n²)
Space Complexity : O(1)

--------------------------------------------------
Approach 2: Better (Sorting)
--------------------------------------------------
- Sort the array.
- Ignore duplicate elements.
- Count consecutive elements while traversing the array.
- Update the maximum sequence length whenever required.

Time Complexity  : O(n log n)
Space Complexity : O(1)

--------------------------------------------------
Approach 3: Optimal (HashSet)
--------------------------------------------------
- Insert every element into a HashSet.
- Traverse every unique element.
- Start counting only if the current element is the beginning of a sequence (i.e., x - 1 does not exist).
- Keep checking x + 1 until the sequence ends.
- Update the maximum sequence length.

Time Complexity  : O(n)
Space Complexity : O(n)

Why Optimal?
- Every element is inserted into the HashSet once.
- Every sequence is traversed only once.
- HashSet provides O(1) average lookup time.

Edge Cases:
- Empty array
- Single element array
- Array containing duplicates
- All elements consecutive
- No consecutive sequence
*/

package Arrays;
import java.util.*;
public class LongestConsecutiveSequence {
    // ------------------ Helper Function ------------------

    // Performs linear search to check whether value exists in array
    private boolean linearSearch(int[] nums, int value) {
        for (int num : nums) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    // ------------------------- Brute Force Approach -------------------------

    public int longestConsecutiveBrute(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxCount = 1;
        // Try every element as the starting point
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int count = 1;
            // Keep searching for the next consecutive element
            while (linearSearch(nums, current + 1)) {
                current++;
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    // ------------------------ Better Approach -----------------------------

    public int longestConsecutiveBetter(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longest = 1;
        int count = 1;
        int previous = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Ignore duplicate elements
            if (nums[i] == previous) {
                continue;
            }
            // Consecutive element found
            if (nums[i] == previous + 1) {
                count++;
            }
            // Sequence breaks
            else {
                count = 1;
            }
            previous = nums[i];
            longest = Math.max(longest, count);
        }
        return longest;
    }

    // --------------------------- Optimal Approach -------------------------------

    public int longestConsecutiveOptimal(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        // Store every element in the HashSet
        for (int num : nums) {
            set.add(num);
        }
        int longest = 1;
        // Traverse every unique element
        for (int num : set) {
            // Start counting only if it is the first element of a consecutive sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}