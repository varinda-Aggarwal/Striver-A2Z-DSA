
/*
Problem: Search in Rotated Sorted Array (LeetCode 33)

Description: You are given an integer array nums sorted in ascending order with distinct values, which is possibly rotated at an unknown pivot. Given a target value, return its index if it exists in the array. Otherwise, return -1.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

--------------------------------------------------

Approach 1: Brute Force (Linear Search)

Explanation:
1. Traverse the complete array from index 0.
2. Compare every element with the target.
3. If the target is found, return its index.
4. If the target is not found, return -1.

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------

Approach 2: Optimal (Modified Binary Search)

Explanation:
1. Initialize low = 0 and high = nums.length - 1.
2. Calculate mid and check whether nums[mid] equals target.
3. Identify which half of the array is sorted:
   - If nums[low] <= nums[mid], the left half is sorted.
   - Otherwise, the right half is sorted.
4. Check whether the target lies within the sorted half.
5. If it does, eliminate the other half.
6. Otherwise, search in the remaining half.
7. Repeat until the target is found or low exceeds high.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

package Arrays;
public class SearchInRotatedSortedArray {

    // ------------------------- Approach 1: Brute Force (Linear Search) -------------------------

    public int searchBruteForce(int[] nums, int target) {
        int val = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                val = i;
                break;
            }
        }
        return val;
    }


    // ------------------------- Approach 2: Optimal (Modified Binary Search) -------------------------

    public int searchOptimal(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // If mid element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }
            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                // Check whether target lies in the left sorted half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } 
                else {
                    low = mid + 1;
                }
            }
            else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
