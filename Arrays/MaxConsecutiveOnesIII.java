/*
Problem: Max Consecutive Ones III

Description: Given a binary array nums and an integer k, return the maximum number of consecutive 1s in the array if you can flip at most k zeros.

Example 1:
Input  : nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output : 6

Example 2:
Input  : nums = [0,0,1,1,1,0,0], k = 0
Output : 3

--------------------------------------------------
Approach 1: Brute Force
--------------------------------------------------
- Start from every index.
- Extend the subarray towards the right.
- Count the number of zeroes.
- If zeroes become greater than k, stop.
- Otherwise, update the maximum length.

Time Complexity  : O(n²)
Space Complexity : O(1)

--------------------------------------------------
Approach 2: Better
--------------------------------------------------
- Use the Sliding Window technique.
- Maintain a window using left and right pointers.
- Count the number of zeroes inside the window.
- If zeroes become greater than k, move left forward until the window becomes valid again.
- Update the maximum valid window length.

Time Complexity  : O(n)
Space Complexity : O(1)

--------------------------------------------------
Approach 3: Most Optimized
--------------------------------------------------
- Use the same Sliding Window idea.
- Instead of using a while loop to completely restore the window whenever zeroes > k, move left only once.
- The window can temporarily contain k + 1 zeroes.
- Before moving left, update maxLen only when the window is valid.
- Since left moves at most once per right iteration, this avoids the inner while loop.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- Both left and right pointers move only forward.
- No nested loop is required.
- Each element is visited at most a constant number of times.
*/


package Arrays;
public class MaxConsecutiveOnesIII {

    // ----------------------------- Approach 1: Brute Force --------------------------------------

    public int longestOnesBrute(int[] nums, int k) {
        int maxLen = 0;

        // Start from every index
        for (int i = 0; i < nums.length; i++) {
            int zeroCount = 0;
            // Extend the subarray
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) zeroCount++;          // Count zeroes
                if (zeroCount > k) break;               // More than k zeroes are not allowed
                maxLen = Math.max(maxLen, j - i + 1);   // Update maximum length
            }
        }
        return maxLen;
    }


    // -------------------------- Approach 2: Better Solution Sliding Window + While -----------------------------

    public int longestOnesBetter(int[] nums, int k) {
        int left = 0;
        int zeroes = 0;
        int maxLen = 0;

        // Expand window using right pointer
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroes++;    // Add current element

            // If zeroes exceed k, shrink the window until it becomes valid again.
            while (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);    // Update maximum valid window
        }
        return maxLen;
    }


    // ----------------------------- Approach 3: Most Optimized : Sliding Window + If --------------------------------

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroes = 0;
        int maxLen = 0;

        // Expand window using right pointer
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroes++;     // Add current element

            // Update maxLen only when the current window contains at most k zeroes.
            if (zeroes <= k)  maxLen = Math.max(maxLen, right - left + 1);

            // If zeroes exceed k, move left only once. Unlike Approach 2, we don't completely shrink the window here.
            if (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }
        }
        return maxLen;
    }
}