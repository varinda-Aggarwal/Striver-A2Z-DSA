/*
Problem: Maximum Subarray Sum

Description:
Given an integer array, find the contiguous subarray that has the
largest sum and return that maximum sum.

Example:
Input  : [-2,1,-3,4,-1,2,1,-5,4]
Output : 6

Explanation:
The subarray [4, -1, 2, 1] has the largest sum = 6.

--------------------------------------------------
Approach 1: Better (Nested Loops)
--------------------------------------------------
- Consider every index as the starting point of a subarray.
- Extend the subarray one element at a time.
- Maintain a running sum instead of recalculating it.
- Update the maximum sum whenever a larger sum is found.

Time Complexity  : O(n²)
Space Complexity : O(1)

Why Better?
- Avoids recalculating the subarray sum from scratch.
- Uses only two nested loops instead of three.

Edge Cases:
- Array contains all negative numbers
- Array contains all positive numbers
- Array contains both positive and negative numbers
- Single element array

--------------------------------------------------
Approach 2: Optimal (Kadane's Algorithm)
--------------------------------------------------
Idea:
- Maintain a running sum while traversing the array.
- Add the current element to the running sum.
- Update the maximum sum found so far.
- If the running sum becomes negative,
  discard it and start a new subarray.

Why Reset the Running Sum?
- A negative running sum can never increase the sum of any future subarray.
- Therefore, once the running sum becomes negative,
  it is better to start a new subarray from the next element.

Time Complexity  : O(n)
Space Complexity : O(1)

Edge Cases:
- Array contains all negative numbers
- Array contains all positive numbers
- Maximum subarray starts from index 0
- Maximum subarray ends at the last index
- Single element array
*/

package Arrays;
public class MaximumSubarraySum {

    // ------------------ Better Approach ------------------

    public int maximumSubarrayBetter(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        // Consider every index as the starting point
        for (int start = 0; start < nums.length; start++) {
            int currentSum = 0;
            // Extend the subarray one element at a time
            for (int end = start; end < nums.length; end++) {
                currentSum += nums[end];
                maxSum = Math.max(maxSum, currentSum);       // Update maximum sum
            }
        }
        return maxSum;
    }

    // ------------------ Optimal Approach (Kadane's Algorithm) ------------------

    public int maximumSubarrayOptimal(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;      // Add current element to the running sum
            maxSum = Math.max(maxSum, currentSum);   // Update maximum subarray sum found so far
            // If running sum becomes negative, discard it and start a new subarray
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}