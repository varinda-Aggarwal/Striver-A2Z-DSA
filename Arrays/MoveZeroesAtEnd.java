/*
Problem: Move Zeroes

Description:
Given an integer array nums, move all 0's to the end of it 
while maintaining the relative order of the non-zero elements.
Modify the array in-place.

Approach:
1. Use a pointer (index) to track position for next non-zero element
2. Traverse the array:
   - If element is non-zero → place it at index and increment index
3. After traversal, fill remaining positions with 0

Time Complexity:
- O(n)

Space Complexity:
- O(1) → In-place

Edge Cases:
- All elements are 0 → array remains same
- No zero present → array remains same
*/
package Arrays; 
public class MoveZeroesAtEnd {

    public void MoveZeroes(int[] nums) {
        int index = 0;

        // Step 1: Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Step 2: Fill remaining positions with zeroes
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}