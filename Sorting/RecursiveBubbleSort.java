    /*
Problem: Recursive Bubble Sort

Description:
Sort the given array using Bubble Sort algorithm with recursion.

Approach:
- Bubble Sort works by repeatedly comparing adjacent elements
  and swapping them if they are in the wrong order.
- After each pass, the largest element moves to its correct position (end of array).

- In recursive approach:
  1. 'pass' represents the number of completed passes
  2. 'index' represents the current position in the array

- We simulate:
  - Inner loop using recursion on 'index'
  - Outer loop using recursion on 'pass'

Time Complexity:
- Best Case: O(n) (if optimized, but here no early break)
- Average Case: O(n^2)
- Worst Case: O(n^2)

Space Complexity:
- O(n) (due to recursion stack)
*/

package Sorting;
public class RecursiveBubbleSort {

    // Function to swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Recursive function to perform Bubble Sort
    public void bubbleSortRecursive(int[] arr, int pass, int index) {

        // Base case: if all passes are completed
        if (pass == arr.length) return;

        // Inner loop: compare adjacent elements
        if (index < arr.length - pass - 1) {

            // Swap if elements are in wrong order
            if (arr[index] > arr[index + 1]) {
                swap(arr, index, index + 1);
            }

            // Move to next index
            bubbleSortRecursive(arr, pass, index + 1);

        } else {
            // One pass completed, start next pass
            bubbleSortRecursive(arr, pass + 1, 0);
        }
    }

    // Main function to call recursive sort
    public int[] bubbleSort(int[] arr) {
        bubbleSortRecursive(arr, 0, 0);
        return arr;
    }
}

