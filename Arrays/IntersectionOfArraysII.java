/*
Problem: Intersection of Two Arrays II

Description:
Given two integer arrays, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays.

--------------------------------------------------
 APPROACH : SORT + TWO POINTER
--------------------------------------------------
 Sort both arrays. Use two pointers to traverse both simultaneously. 
 If elements match add to result and move both pointers. 
 If nums1 element is greater move nums2 pointer. Otherwise move nums1 pointer.

 Time Complexity  : O(n log n + m log m) → sorting
 Space Complexity : O(min(n, m)) → result list

 Edge Cases:
 - No common elements → return empty array
 - All elements same → return all elements
 - One array empty → return empty array
--------------------------------------------------
*/

package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class IntersectionOfArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        // sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        // two pointer traversal
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // common element found
                list.add(nums1[i]);
                i++;
                j++;

            } 
            else if (nums1[i] > nums2[j]) {
                // nums2 element smaller — move j forward
                j++;

            }
            else {
                // nums1 element smaller — move i forward
                i++;
            }
        }
        // convert list to array
        int[] result = new int[list.size()];
        int k = 0;
        for (int num : list) {
            result[k] = num;
            k++;
        }
        return result;
    }
}