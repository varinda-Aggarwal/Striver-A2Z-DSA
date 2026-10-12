/*
Problem: Subarray Product Less Than K
Description: Given an array of positive integers nums and an integer k, return the number of contiguous subarrays whose product is strictly less than k.

Example 1:
Input  : nums = [10, 5, 2, 6], k = 100
Output : 8

Example 2:
Input  : nums = [1, 2, 3], k = 0
Output : 0

--------------------------------------------------

Approach 1: Brute Force

- Start a subarray from every index i.
- Initialize product = 1.
- Extend the subarray using index j and update the product.
- If product < k, increment count.
- Otherwise, break because all numbers are positive integers.

Time Complexity  : O(n^2)
Space Complexity : O(1)

--------------------------------------------------

Approach 2: Optimal Sliding Window

- If k <= 1, return 0 because all nums elements are positive integers.
- Expand the window by multiplying nums[right] into product.
- While product >= k, divide out nums[left] and move left forward.
- Every subarray ending at right and starting from left to right has a product less than k.
- Add right - left + 1 to count.

Time Complexity  : O(n)
Space Complexity : O(1)

--------------------------------------------------

Edge Cases:
- k <= 1.
- Empty array.
- All elements are 1.
- Product becomes equal to k.
*/

package SlidingWindow;

// ----------------------------------- Approach 1: Brute Force -----------------------------------

class SubarrayProductLessThanK{
    public int numSubarrayProductLessThanKBrute(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product = product * nums[j];
                if (product < k) count++;
                else break;
            }
        }
        return count;
    }

// ----------------------------------- Approach 2: Optimal Sliding Window -----------------------------------

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int count = 0;
        int product = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}