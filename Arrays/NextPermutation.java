/*
Problem: Next Permutation

Description:
Given an array of integers representing a permutation, rearrange the numbers into the next lexicographically greater permutation.
If such a permutation is not possible (i.e., the array is in descending order), rearrange it into the lowest possible order (ascending order).
The rearrangement must be done in-place using constant extra space.

Example 1:
Input  : [1, 2, 3]
Output : [1, 3, 2]

Example 2:
Input  : [3, 2, 1]
Output : [1, 2, 3]

Example 3:
Input  : [1, 1, 5]
Output : [1, 5, 1]

--------------------------------------------------
Approach: Optimal (Pivot + Swap + Reverse)
--------------------------------------------------
1. Traverse the array from right to left and find the first element that is smaller than its next element. This element is called the pivot (breaking point).
2. If no pivot exists, the array is already the last permutation. Reverse the entire array to obtain the first permutation.
3. Otherwise, traverse from the end and find the first element greater than the pivot.
4. Swap the pivot with that element.
5. Reverse the suffix (elements after the pivot) to obtain the next lexicographically smallest permutation.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- Does not generate all permutations.
- Uses only constant extra space.
- Requires at most three linear traversals.

Edge Cases:
- Array already in descending order
- Array already in ascending order
- Duplicate elements
- Single element array
*/

package Arrays;
public class NextPermutation {

    // ------------------------------ Helper Function -------------------------

    // Reverse the array between start and end indices
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // ----------------------------- Optimal Approach ---------------------------------

    public void nextpermutation(int[] nums) {
        // Step 1: Find the pivot (breaking point)
        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: If a pivot exists, find the next greater element from the right and swap it.
        if (pivot != -1) {
            for (int i = nums.length - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
            }
        }

        // Step 3: Reverse the suffix
        reverse(nums, pivot + 1, nums.length - 1);
    }
}