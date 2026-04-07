/*
Problem: Rotate Array to the Right by K Positions

Description:
Given an array, rotate it to the right by k steps.
Modify the array in-place.

Approach (Reversal Algorithm):
1. Reverse the entire array
2. Reverse first k elements
3. Reverse remaining (n-k) elements

Time Complexity:
- O(n)

Space Complexity:
- O(1) → In-place

Edge Cases:
- k > n → take k % n
*/

package Arrays;

public class RotateArrayByk {
    // Function to reverse part of the array
    public static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate array by k steps (right rotation)
    public static void rotate(int[] arr, int k) {
        int n = arr.length;

        // Edge case
        if(n == 0) return;

        // Handle k greater than n
        k = k % n;

        // Step 1: Reverse entire array
        reverse(arr, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(arr, k, n - 1);
    }
}