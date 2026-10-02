/*
Problem: Count Number of Nice Subarrays

Description: Given an array of integers nums and an integer k, return the number of contiguous subarrays containing exactly k odd numbers.

--------------------------------------------------
Approach: Optimal (At Most + Sliding Window)
--------------------------------------------------

- Instead of directly counting subarrays with exactly k odd numbers, calculate: Exactly(k) = AtMost(k) - AtMost(k - 1)
- The helper method 'atMost()' counts the number of subarrays containing at most k odd numbers.
- Use a sliding window with two pointers:
    • Expand the window using 'right'.
    • If nums[right] is odd, increment 'oddCount'.
    • If oddCount becomes greater than k, move 'left' forward until the window becomes valid again.
    • For every valid window [left ... right], the number of valid subarrays ending at right is: right - left + 1
- Finally, subtract the number of subarrays having at most k - 1 odd numbers from the number having at most k odd numbers.

Time Complexity  : O(n)
Space Complexity : O(1)

Why is this approach optimal?
- Every element enters the sliding window once.
- Every element leaves the sliding window at most once.
- Therefore, each `atMost()` call takes O(n) time.
- The helper is called twice, so the overall complexity remains O(n).
- No extra data structure is required.

Edge Cases:
- k = 0
- k = 1
- Array contains no odd numbers
- All elements are odd
- Single-element array
*/

package Arrays;
public class CountNumberOfNiceSubarrays {

    // ----------------------------------- Optimal Approach -----------------------------------

    public int numberOfSubarrays(int[] nums, int k) {

        // Exactly(k) = AtMost(k) - AtMost(k - 1)
        return atMost(nums, k) - atMost(nums, k - 1);
    }


    // Counts subarrays containing at most k odd numbers
    private int atMost(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int oddCount = 0;
        for (int right = 0; right < nums.length; right++) {
            // Add current element to the window
            if (nums[right] % 2 != 0) {
                oddCount++;
            }
            // Shrink the window if odd count exceeds k
            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }
            // All subarrays ending at right and starting from left to right are valid
            count += right - left + 1;
        }
        return count;
    }
}