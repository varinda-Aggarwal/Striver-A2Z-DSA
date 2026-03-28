/*
Problem: Bubble Sort

Description:
Sort the given array using Bubble Sort algorithm.

Approach:
- Repeatedly compare adjacent elements
- Swap them if they are in wrong order
- After each pass, the largest element moves to its correct position (end of array)

- Outer loop runs for n passes
- Inner loop compares adjacent elements and pushes largest to the end

Time Complexity:
- Best Case: O(n) (if optimized with no swaps)
- Average Case: O(n^2)
- Worst Case: O(n^2)

Space Complexity:
- O(1) (In-place sorting)
*/

package Sorting;
public class BubbleSort {

    // Function to swap two elements in array
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Function to perform Bubble Sort
    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        // Outer loop for number of passes
        for(int i = 0; i < n; i++)
        {
            boolean swapped = false;
            // Inner loop for comparing adjacent elements
            for(int j = 0; j < n - i - 1; j++)
            {
                // Swap if elements are in wrong order
                if(nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }

            // If no swaps, array is already sorted
            if(!swapped) break;
        }
        return nums;
    }
}
