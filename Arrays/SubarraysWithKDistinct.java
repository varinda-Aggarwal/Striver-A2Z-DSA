/*
Problem: Subarrays with K Different Integers

Description: Given an integer array nums and an integer k, return the number of good subarrays of nums. A subarray is called good if it contains exactly k distinct integers.

Example:
Input  : nums = [1, 2, 1, 2, 3], k = 2
Output : 7

--------------------------------------------------
Approach 1: Brute Force
--------------------------------------------------
- Generate every possible subarray.
- Use a HashSet to store distinct elements in the current subarray.
- If the number of distinct elements becomes exactly k, increment count.
- If the number of distinct elements becomes greater than k, stop extending the current subarray.

Time Complexity  : O(n²)
Space Complexity : O(k) approximately

--------------------------------------------------
Approach 2: Optimal
--------------------------------------------------
To find the number of subarrays having exactly k distinct elements:
    Exactly K = AtMost(K) - AtMost(K - 1)

Why?
AtMost(K) gives the number of subarrays having at most K distinct elements.
AtMost(K - 1) gives the number of subarrays having at most K - 1 distinct elements. Subtracting them leaves exactly K distinct elements.

For AtMost(K):
- Use Sliding Window + HashMap.
- Expand the window using right.
- If distinct elements become greater than k, move left until the window becomes valid.
- For every right, all subarrays from left to right are valid.
- Therefore, add (right - left + 1) to count.

Time Complexity  : O(n)
Space Complexity : O(k) approximately
*/


package Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class SubarraysWithKDistinct {

    // ---------------------------------- Approach 1: Brute Force -----------------------------------------

    public int subarraysWithKDistinctBrute(int[] nums, int k) {
        int count = 0;

        // Generate every possible subarray
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                set.add(nums[j]);               // Add current element
                if (set.size() == k) count++;   // Exactly k distinct elements

                // More than k distinct elements means that extending this subarray further cannot make it valid again.
                if (set.size() > k) break;
            }
        }
        return count;
    }


    // ---------------------------- Approach 2: Optimal: AtMost(K) - AtMost(K - 1) -----------------------------

    private int atMost(int[] nums, int k) {
        if (k < 0) return 0;    // If k becomes negative, no valid subarray exists.
        int left = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Expand window using right pointer
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);   // Add current element

            // If distinct elements become greater than k, shrink the window.
            while (map.size() > k) {
                int remove = nums[left];
                map.put(remove,map.get(remove) - 1);
                if (map.get(remove) == 0) map.remove(remove);   // Remove element completely if frequency becomes 0
                left++;
            }

            /*
             All subarrays ending at right and starting from left to right have at most k distinct elements.
             Example:
             left = 2, right = 5
             Valid subarrays:
             [2..5], [3..5], [4..5], [5..5]
             Total = right - left + 1
            */
            count += right - left + 1;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        // Exactly K distinct elements = AtMost(K) - AtMost(K - 1)
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}