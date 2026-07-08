/*
Problem: Merge Sorted Array

Description:
Given two sorted arrays nums1 and nums2 where nums1 has extra space at end to hold nums2 elements, 
merge nums2 into nums1 in sorted order. m and n are the number of elements in nums1 and nums2 respectively.


 APPROACH : TWO POINTER FROM END
--------------------------------------------------
 Start filling nums1 from the end using three pointers. i points to last element of nums1, 
 j points to last element of nums2, k points to last position of nums1.
 Compare from end and place larger element at k. If nums2 elements remain after nums1 is exhausted copy them directly.

 Time Complexity : O(m + n) → single traversal
 Space Complexity : O(1) → in-place merging

 Edge Cases:
 - nums2 empty → nums1 unchanged
 - nums1 empty → copy nums2 to nums1
 - All nums2 > nums1 → nums2 elements fill first
--------------------------------------------------
*/

package Arrays;
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;              // last element of nums1
        int j = n - 1;              // last element of nums2
        int k = nums1.length - 1;   // last position of nums1
        // fill from end by comparing both arrays
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                // nums2 element is larger — place at k
                nums1[k] = nums2[j];
                k--;
                j--;
            }
            else {
                // nums1 element is larger or equal — place at k
                nums1[k] = nums1[i];
                k--;
                i--;
            }
        }

        // copy remaining nums2 elements if any
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}