/*
Problem: Find the Largest Element in an Array

Description:
Given an array of integers, return the largest element present in the array.

Approach:
- Initialize 'max' with the first element of the array.
- Traverse the array from index 1.
- Compare each element with 'max':
    - If current element is greater, update 'max'.
- Return 'max' at the end.

Why nums[0] instead of Integer.MIN_VALUE?
- More natural initialization
- Avoids unnecessary comparison
- Cleaner and preferred in interviews

Time Complexity:
- O(n) → Single traversal

Space Complexity:
- O(1) → No extra space used
*/

package Arrays;

public class LargestElement {

    public static int largestElement(int[] nums) {
        // Edge case: if array is empty
        if(nums.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        // Initialize max with first element
        int max = nums[0];

        // Traverse array from index 1
        for(int i = 1; i < nums.length; i++) {
            // Update max if current element is greater
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}