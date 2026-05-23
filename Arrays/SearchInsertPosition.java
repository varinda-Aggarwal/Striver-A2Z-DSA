/*
Problem: Search Insert Position

Description:
Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be inserted in order.

--------------------------------------------------
 APPROACH : LINEAR SEARCH
--------------------------------------------------
 Traverse the array and return index of first element that is greater than or equal to target.
 If target is greater than all elements, insert at end.

 Time Complexity : O(n) → traverse entire array
 Space Complexity : O(1) → no extra space used

 Edge Cases:
 - Target smaller than all → return 0
 - Target greater than all → return nums.length
 - Target exists in array → return its index
--------------------------------------------------
*/

package Arrays;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // find first element greater than or equal to target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        // target is greater than all elements — insert at end
        return nums.length;
    }
}