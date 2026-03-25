/*
Problem: Selection Sort

Approach:
- Divide array into two parts:
  1. Sorted part (left side)
  2. Unsorted part (right side)

- For each position i:
  - Find the minimum element from i to n-1
  - Swap it with element at index i

Time Complexity:
- Best Case: O(n^2)
- Average Case: O(n^2)
- Worst Case: O(n^2)

Space Complexity:
- O(1) (in-place sorting)
*/

package Sorting;

public class SelectionSort {
    // Function to swap two elements in array
    public void swap(int[] nums, int i, int min_idx)
    {
        int temp = nums[i];
        nums[i] = nums[min_idx];
        nums[min_idx] = temp;
    }

    // Function to perform selection sort
    public int[] selectionSort(int[] nums) {

        // Outer loop for each position
        for(int i = 0; i < nums.length; i++)
        {
            int min_idx = i;   // Assume current index as minimum

            // Find minimum element in remaining unsorted array
            for(int j = i; j < nums.length; j++)
            {
                if(nums[j] < nums[min_idx])
                {
                    min_idx = j;   // Update index of minimum element
                }
            }

            // Swap minimum element with current position
            swap(nums, i, min_idx);
        }

        return nums;
    }
}

