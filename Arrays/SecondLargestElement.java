/*
Problem: Find Second Largest Element in an Array

Description:
Given an array of integers, return the second largest element.
If no such element exists (all elements are equal or array size < 2), return -1.

Approach:
- Maintain two variables:
    1. max → stores the largest element
    2. secondMax → stores the second largest element

- Traverse the array once:
    1. If current element > max:
        - Update secondMax = max
        - Update max = current element
    2. Else if current element > secondMax AND not equal to max:
        - Update secondMax

- This ensures we find both values in a single traversal.

Time Complexity:
- O(n) → Single traversal

Space Complexity:
- O(1) → No extra space

Edge Cases:
- Array size < 2 → return -1
- All elements equal → return -1
*/

package Arrays;

public class SecondLargestElement {

    public static int secondLargest(int[] nums) {
        // Edge case: if array size is less than 2
        if (nums.length < 2) return -1;

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // Update max and secondMax
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            }
            // Update only secondMax
            else if (nums[i] > secondMax && nums[i] != max) {
                secondMax = nums[i];
            }
        }
        // If secondMax is not updated, return -1 
        if(secondMax == Integer.MIN_VALUE) return -1; 
        return secondMax;
    }
}