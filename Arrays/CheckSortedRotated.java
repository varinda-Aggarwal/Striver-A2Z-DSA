/*
Problem: Check if Array Is Sorted and Rotated

Description:
Given an array nums, return true if the array was originally sorted in non-decreasing order and then rotated some number of times. A rotation moves some elements from the beginning of the array to the end.

Example 1:
Input  : [3, 4, 5, 1, 2]
Output : true

Example 2:
Input  : [2, 1, 3, 4]
Output : false

Example 3:
Input  : [1, 1, 1]
Output : true

--------------------------------------------------
Approach 1: Brute Force / Simulation
--------------------------------------------------
- Find the first position where nums[i] > nums[i + 1].
- This position represents the possible breaking point caused by rotation.
- Rotate the array so that the element after the breaking point comes to the beginning.
- Check whether the rotated array is sorted.
- If there is no breaking point, the array is already sorted.

The rotation is performed using three reversals.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Brute / Simulation?
- We actually modify and rotate the array.
- Then we perform another traversal to verify whether the rotated array is sorted.
- Although the complexity is O(n), this approach performs unnecessary array manipulation.

--------------------------------------------------
Approach 2: Optimal
--------------------------------------------------
- Instead of rotating the array, directly count the number of times the order decreases.
- For a sorted and rotated array, there can be at most one such decreasing point.
- Since the array is circular, also check the pair: nums[n - 1] > nums[0]
- If the total number of decreasing points is at most one, the array is sorted and rotated.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- No rotation is required.
- No extra data structure is used.
- Only one traversal is needed.
- Directly checks the property that defines a sorted and rotated array.

Edge Cases:
- Already sorted array
- Completely descending array
- Array with duplicate elements
- Single element array
- All elements equal
- Rotation point at the beginning or end
*/

package Arrays;
public class CheckSortedRotated {

    // ------------------ Approach 1: Brute / Simulation ------------------

    // Reverse the array from start to end
    private void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Rotate the array left by 'start' positions
    private void rotate(int[] nums, int start) {
        int n = nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, n - start - 1);
        reverse(nums, n - start, n - 1);
    }

    public boolean checkBrute(int[] nums) {
        // Find the first breaking point
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }

        // No breaking point means the array is already sorted
        if (index == -1) {
            return true;
        }

        // Rotate the array so that the possible smallest element comes to the beginning
        rotate(nums, index + 1);
        // Check whether the rotated array is sorted
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }


    // --------------------- Approach 2: Optimal Approach ----------------------

    public boolean checkOptimal(int[] nums) {
        int count = 0;
        int n = nums.length;
        // Count decreasing adjacent pairs
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }
        // Check the circular pair: last element -> first element
        if (nums[n - 1] > nums[0]) {
            count++;
        }
        // A sorted and rotated array can have at most one drop
        return count <= 1;
    }
}