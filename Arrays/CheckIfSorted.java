/*
Problem: Check if Array is Sorted

Description:
Given an ArrayList of integers, check whether the array is sorted in non-decreasing order.

Approach:
- Traverse the array from index 0 to n-2
- Compare each element with the next element
- If any element is greater than the next one, return false
- If no such pair is found, return true

Time Complexity:
- O(n) → Single traversal

Space Complexity:
- O(1)

Edge Cases:
- Empty or single element array → always sorted
*/

package Arrays;
import java.util.ArrayList;
public class CheckIfSorted {

    // Function to check if the array is sorted
    public static boolean isSorted(ArrayList<Integer> nums) {

        // Traverse till second last element
        for(int i = 0; i < nums.size() - 1; i++) {

            // If current element is greater than next → not sorted
            if(nums.get(i) > nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}