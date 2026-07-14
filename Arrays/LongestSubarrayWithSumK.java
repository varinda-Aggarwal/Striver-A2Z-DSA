/*
Problem: Longest Subarray With Sum K

Description:
Given an integer array containing positive, negative and zero values,
find the length of the longest subarray whose sum is equal to k.

--------------------------------------------------
Approach 1: Brute Force (Nested Loops)
--------------------------------------------------
- Consider every index as the starting point of a subarray.
- For each starting index, extend the subarray one element at a time.
- Maintain the running sum.
- Whenever the running sum becomes equal to k,
  update the maximum length.

Time Complexity  : O(n²)
Space Complexity : O(1)

Why Brute Force?
- Checks every possible subarray.
- Works for positive, negative and zero values.
- Does not rely on any special property of the array.

Edge Cases:
- Empty array
- No subarray with sum k
- Entire array sum equals k
- Array contains only positive numbers
- Array contains positive, negative and zero values

--------------------------------------------------
Approach 2: Optimized (Prefix Sum + HashMap)
--------------------------------------------------
- Maintain a running prefix sum while traversing the array.
- Store the first occurrence of every prefix sum in a HashMap.
- At every index:
      remaining = prefixSum - k
- If 'remaining' exists in the HashMap,
  then the subarray between
  (remaining index + 1) and current index
  has sum equal to k.
- Store only the first occurrence of each prefix sum,
  since it gives the maximum possible subarray length.

Time Complexity  : O(n)
Space Complexity : O(n)

Why Sliding Window Doesn't Work?
- Sliding Window works only when all array elements are positive.
- With negative numbers, expanding or shrinking the window
  does not guarantee that the sum will move in only one direction.
- Therefore, Prefix Sum + HashMap is the optimal solution.

Edge Cases:
- Array contains negative numbers
- Array contains zero
- Multiple subarrays with sum k
- Longest subarray starts from index 0
*/

package Arrays;
import java.util.HashMap;
public class LongestSubarrayWithSumK {

    // ------------------ Brute Force Approach ------------------

    public int longestSubarrayBruteForce(int[] nums, int k) {

        int maxLength = 0;

        // Consider every index as the starting point
        for (int start = 0; start < nums.length; start++) {

            int sum = 0;

            // Extend the subarray one element at a time
            for (int end = start; end < nums.length; end++) {

                sum += nums[end];

                // If current subarray sum equals k,
                // update the maximum length
                if (sum == k) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }
        }

        return maxLength;
    }

    // ------------------ Optimized Approach ------------------

    public int longestSubarrayOptimized(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            // Calculate running prefix sum
            prefixSum += nums[i];

            // If prefix sum itself equals k,
            // then subarray starts from index 0
            if (prefixSum == k) {
                maxLength = i + 1;
            }

            // Remaining prefix sum required
            int remaining = prefixSum - k;

            // Check whether remaining prefix sum already exists
            if (prefixSumMap.containsKey(remaining)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(remaining));
            }

            // Store only the first occurrence of prefix sum
            // because it gives the longest possible subarray
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}