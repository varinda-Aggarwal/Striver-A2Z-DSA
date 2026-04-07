/*
Problem: Linear Search

Description:
Given an array of integers and a target value, return the index of the target
if it exists in the array. Otherwise, return -1.

Approach:
- Traverse the array from start to end
- Compare each element with the target
- If found, return the index
- If not found after full traversal, return -1

Time Complexity:
- O(n) → Worst case, traverse entire array

Space Complexity:
- O(1) → No extra space used

Edge Cases:
- Empty array → return -1
- Target not present → return -1
*/

package Arrays;

public class LinearSearch {

    // Function to perform linear search
    public static int linearSearch(int[] nums, int target) {

        // Traverse the array
        for(int i = 0; i < nums.length; i++) {
            // Check if current element matches target
            if(nums[i] == target) {
                return i;
            }
        }
        // Target not found
        return -1;
    }
}