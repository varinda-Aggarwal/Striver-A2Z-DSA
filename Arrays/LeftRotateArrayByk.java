/*
Problem: Rotate Array to the Left by K Positions

Description:
Given an array, rotate it to the left by k steps.
Modify the array in-place.

Approach (Reversal Algorithm):
1. Reverse first k elements
2. Reverse remaining (n-k) elements
3. Reverse the entire array

Time Complexity:
- O(n)

Space Complexity:
- O(1) → In-place

Edge Cases:
- k > n → take k % n
- k = 0 → array remains unchanged
*/

package Arrays;

public class LeftRotateArrayByk {

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

    // Function to rotate array by k steps (left rotation)
    public static void rotate(int[] arr, int k) {
        int n = arr.length;

        // Edge case
        if(n == 0) return;

        // Handle k greater than n
        k = k % n;

        // Step 1: Reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 2: Reverse remaining elements
        reverse(arr, k, n - 1);

        // Step 3: Reverse entire array
        reverse(arr, 0, n - 1);
    }
}