/*
Problem: Reverse an array using recursion

Approach:
We use one pointer (i) starting from left side.
For every recursive call:
    swap(arr[i], arr[n-i-1])
Then move pointer forward (i+1)

Base Case:
When i reaches middle of array (i >= n/2), array is fully reversed.

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Recursion;

public class ReverseAnArray{
    public void reverse(int[] arr, int n) {
        reverseArray(arr,0,n);  
        return;
    }

    public void reverseArray(int[] arr, int i, int n)
    {
        if(i>=n/2) return;    // base case
        swap(arr,i,n-i-1);     // swap function
        reverseArray(arr,i+1,n);    // recursive call
    }

    public static void swap(int[] arr, int start , int end)
    {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        return;
    }
}
