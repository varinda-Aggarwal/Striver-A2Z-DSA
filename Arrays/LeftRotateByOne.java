/*
Problem: Rotate Array to the Left by One

Description:
Given an array, rotate it to the left by one position.
Modify the array in-place.

Approach:
- Store the first element in a temporary variable
- Shift all elements one position to the left
- Place the stored element at the last index

Time Complexity:
- O(n)

Space Complexity:
- O(1)
*/

package Arrays;

public class LeftRotateByOne {

    public static void rotateLeft(int[] nums) {
        // Edge case
        if(nums.length == 0) return;

        // store first element
        int temp = nums[0];

        // shift elements to left
        for(int i=1;i<nums.length;i++) {
            nums[i-1] = nums[i];
        }

        // place first element at end
        nums[nums.length-1] = temp;
    }
}