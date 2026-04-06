/*
Problem: Remove Duplicates from Sorted Array

Description:
Given a sorted array, remove the duplicates in-place such that each element appears only once.
Return the number of unique elements.

Approach (Two Pointer):
- Use two pointers:
    1. index → points to last unique element
    2. i → traverses the array

- Start index = 0 (first element is always unique)
- Traverse from i = 1 to n-1:
    - If nums[i] != nums[index]:
        - Move index forward
        - Place nums[i] at nums[index]

- At the end:
    - First (index + 1) elements are unique

Time Complexity:
- O(n) → Single traversal

Space Complexity:
- O(1) → In-place modification

Edge Cases:
- Empty array → return 0
- All elements same → return 1
*/

package Arrays;

public class RemoveDuplicates {

    // Function to remove duplicates from sorted array
    public static int removeDuplicates(int[] nums) {
        // Edge case: empty array
        if(nums.length == 0) return 0;

        int index = 0; // points to last unique element

        // Traverse array
        for(int i = 1; i < nums.length; i++) {
            // If new unique element found
            if(nums[i] != nums[index]) {
                index++;               // move index
                nums[index] = nums[i]; // place unique element
            }
        }

        // Number of unique elements = index + 1
        return index + 1;
    }
}