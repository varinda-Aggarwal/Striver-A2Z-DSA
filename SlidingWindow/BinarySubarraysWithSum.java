/*
Problem: Binary Subarrays With Sum

Description: Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum equal to goal. A binary array contains only 0 and 1.

Example 1:
Input  : nums = [1,0,1,0,1], goal = 2
Output : 4

Explanation:
The 4 subarrays having sum 2 are:
[1,0,1]
[1,0,1,0]
[0,1,0,1]
[1,0,1]

Example 2:
Input  : nums = [0,0,0,0,0], goal = 0
Output : 15

--------------------------------------------------
Approach 1: Brute Force (Nested Loops + Early Stopping)
--------------------------------------------------
- Consider every possible starting index of a subarray.
- For every starting index, expand the subarray using another loop.
- Maintain the current sum while expanding.
- If the sum becomes equal to goal, increment the count.
- Since the array contains only 0 and 1, once the sum becomes greater than goal, extending the subarray further cannot decrease the sum.
- Therefore, we can stop the inner loop using break.

Time Complexity  : O(n²)
Space Complexity : O(1)

--------------------------------------------------
Approach 2: Optimal (At Most + Sliding Window)
--------------------------------------------------
- Counting subarrays with sum exactly equal to goal directly using a sliding window is difficult.
- Instead, use the following relation: Exactly(goal) = AtMost(goal) - AtMost(goal - 1)
- Create a helper method `noOfSubarrays()` to count the number of subarrays having sum at most goal.
- Use a sliding window with two pointers:
    • Expand the window using `right`.
    • Add nums[right] to the current sum.
    • If sum becomes greater than goal, move 'left' forward until the window becomes valid again.

- For every valid window [left ... right], the number of subarrays ending at 'right' is: right - left + 1
- Add this value to the total count.
- Finally: AtMost(goal) - AtMost(goal - 1) gives the number of subarrays whose sum is exactly goal.

Time Complexity  : O(n)
Space Complexity : O(1)

Why is this approach optimal?
- Each element is added to the sliding window once.
- Each element is removed from the sliding window at most once.
- Therefore, each helper call takes O(n) time.
- We call the helper twice, so: O(n) + O(n) = O(n)
- No extra data structure is required.

--------------------------------------------------

Edge Cases:

- goal = 0
- goal = 1
- goal < 0 → return 0 in helper method
- Array contains all 0s
- Array contains all 1s
- Single-element array
- goal is greater than the total sum
*/

package SlidingWindow;
public class BinarySubarraysWithSum {

    // ----------------------------------- Brute Force Approach -----------------------------------

    public int numSubarraysWithSumBrute(int[] nums, int goal) {
        int count = 0;
        // Consider every possible starting index
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // Expand the subarray
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal) {
                    count++;
                }
                // Since nums contains only 0 and 1, sum cannot decrease after exceeding goal
                else if (sum > goal) {
                    break;
                }
            }
        }
        return count;
    }

    // ----------------------------------- Optimal Approach -----------------------------------

    public int numSubarraysWithSum(int[] nums, int goal) {
        return noOfSubarrays(nums, goal) - noOfSubarrays(nums, goal - 1);
    }


    // Counts subarrays having sum at most goal
    private int noOfSubarrays(int[] nums, int goal) {
        // No subarray can have a sum <= negative value
        if (goal < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];       // Add current element to the window

            // Shrink the window if sum exceeds goal
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            // All subarrays ending at right and starting from left to right are valid
            count += right - left + 1;
            right++;
        }
        return count;
    }
}