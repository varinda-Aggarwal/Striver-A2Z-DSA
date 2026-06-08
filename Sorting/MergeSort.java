/*
Problem: Sort Array

Description:
Given an array of integers, sort the array in ascending order and return the sorted array.

 APPROACH : MERGE SORT

 Divide array into two halves recursively until each half has single element. 
 Then merge two sorted halves by comparing elements one by one into a temporary list. 
 Copy result back to original array.

 Time Complexity  : O(n log n) → divide and merge
 Space Complexity : O(n) → temporary list

 Edge Cases:
 - Empty array → return as it is
 - Single element → return as it is
 - Already sorted → still runs in O(n log n)
 - All same elements → works correctly
*/

package Sorting;
import java.util.ArrayList;

public class MergeSort {

    private void merge(int[] nums, int left, int mid, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        int low  = left;
        int high = mid + 1;
        // compare and add smaller element to result
        while (low <= mid && high <= right) {
            if (nums[low] <= nums[high]) {
                result.add(nums[low]);
                low++;
            } 
            else {
                result.add(nums[high]);
                high++;
            }
        }

        // add remaining elements of left half
        while (low <= mid) {
            result.add(nums[low]);
            low++;
        }

        // add remaining elements of right half
        while (high <= right) {
            result.add(nums[high]);
            high++;
        }

        // copy sorted result back to original array
        int i = left;
        for (int num : result) {
            nums[i] = num;
            i++;
        }
    }

    private void mergeSort(int[] nums, int left, int right) {
        // base case — single element
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);              // sort left half
        mergeSort(nums, mid + 1, right);         // sort right half
        merge(nums, left, mid, right);           // merge both sorted halves
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}