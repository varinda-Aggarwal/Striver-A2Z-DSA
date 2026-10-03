/*
Problem: Minimum Size Subarray Sum
Description: Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray whose sum is greater than or equal to target. If no such subarray exists, return 0.

Example 1:
Input  : target = 7, nums = [2,3,1,2,4,3]
Output : 2
Explanation: The subarray [4,3] has a sum of 7, which is greater than or equal to the target, and its length is 2.

Example 2:
Input  : target = 4, nums = [1,4,4]
Output : 1
Explanation: The subarray [4] has a sum of 4, so the minimum length is 1.

Example 3:
Input  : target = 11, nums = [1,1,1,1,1,1,1,1]
Output : 0
Explanation: No subarray has a sum greater than or equal to 11.

--------------------------------------------------
Approach: Optimal (Sliding Window)
--------------------------------------------------
- Use two pointers, `left` and `right`, to maintain a sliding window.
- Expand the window by moving `right` and add nums[right] to the current sum.
- Whenever the sum becomes greater than or equal to target, the current window is valid.
- Update the minimum length of the current window.
- Then shrink the window from the left by removing nums[left].
- Continue shrinking while the sum remains greater than or equal to target.
- Since all elements are positive, removing an element from the left always decreases the sum.
- This allows us to find the minimum valid window efficiently.
Time Complexity  : O(n)
Space Complexity : O(1)
Why is this approach optimal?
- The `right` pointer moves from left to right only once.
- The `left` pointer also moves from left to right only once.
- Therefore, every element is added and removed from the window at most once.
- Overall time complexity is O(n) with O(1) extra space.
--------------------------------------------------

Edge Cases:
- No valid subarray exists → return 0
- Single element is greater than or equal to target
- Entire array is the minimum valid subarray
- target is greater than the total sum
- target is equal to the sum of the entire array
*/

package SlidingWindow;
public class MinimumSizeSubarraySum {
    // ----------------------------------- Optimal Approach -----------------------------------
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        // Expand the window using the right pointer
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // Shrink the window while it is valid
            while (sum >= target) {
                // Update minimum window length
                minLength = Math.min(
                    minLength,
                    right - left + 1
                );
                // Remove the leftmost element
                sum -= nums[left];
                left++;
            }
        }
        // Return 0 if no valid subarray was found
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}