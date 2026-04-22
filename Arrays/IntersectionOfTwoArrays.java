/*
Problem: Intersection of Two Arrays (Unique Elements)

Description:
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique, and the result can be returned in any order.

Approach:
1. Sort both arrays to enable two-pointer traversal.
2. Use two pointers to iterate through both arrays.
3. When elements match:
   - Add to result if it's not already included (avoid duplicates).
   - Move both pointers forward.
4. If elements do not match:
   - Move the pointer of the smaller element forward.
5. Convert the result list into an array.

Time Complexity:
O(n log n + m log m)  → due to sorting

Space Complexity:
O(k) → for storing the result (k = number of unique intersection elements)
*/

package Arrays;
import java.util.*;

public class IntersectionOfTwoArrays{
    public int[] intersection(int[] nums1, int[] nums2) {
        // Step 1: Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Step 2: Initialize result list
        List<Integer> result = new ArrayList<>();

        int i = 0; // pointer for nums1
        int j = 0; // pointer for nums2

        // Step 3: Traverse both arrays using two pointers
        while (i < nums1.length && j < nums2.length) {
            // Case 1: Elements are equal
            if (nums1[i] == nums2[j]) {
                // Avoid adding duplicates to result
                if (result.isEmpty() ||
                    result.get(result.size() - 1) != nums1[i]) {
                    result.add(nums1[i]);
                }
                i++;
                j++;
            }
            // Case 2: Element in nums1 is smaller
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            // Case 3: Element in nums2 is smaller
            else {
                j++;
            }
        }

        // Step 4: Convert List to Array
        int[] resultArray = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            resultArray[k] = result.get(i);
        }
        return resultArray;
    }
}