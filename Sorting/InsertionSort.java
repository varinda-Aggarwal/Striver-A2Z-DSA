/*
Problem: Insertion Sort

Description:
Sort the given array using Insertion Sort algorithm.

Approach:
- Divide the array into two parts:
  1. Sorted part (left side)
  2. Unsorted part (right side)

- Start from index 1 (second element)
- Take the current element (key)
- Compare it with elements in the sorted part (left side)
- Shift all elements greater than key to one position ahead
- Insert the key at its correct position

Time Complexity:
- Best Case: O(n) (when array is already sorted)
- Average Case: O(n^2)
- Worst Case: O(n^2) (when array is reverse sorted)

Space Complexity:
- O(1) (In-place sorting)
*/

package Sorting;

public class InsertionSort {

    // Function to perform Insertion Sort
    public static int[] insertionSort(int[] nums) {
        // Traverse from second element to end
        for(int i = 1; i < nums.length; i++) {
            int key = nums[i];   // Current element to be inserted
            int j = i - 1;       // Start comparing with previous element

            // Shift elements greater than key to right
            while(j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            // Place key at correct position
            nums[j + 1] = key;
        }
        return nums;
    }
}