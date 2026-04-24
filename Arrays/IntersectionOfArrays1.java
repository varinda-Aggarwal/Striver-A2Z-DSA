/*
Problem: Intersection of Two Arrays

Description:
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.

--------------------------------------------------
Approach 1: Optimal (HashSet)
--------------------------------------------------
- Store all elements of nums1 in a HashSet
- Traverse nums2 and check if element exists in set
- If yes, add to result set (ensures uniqueness automatically)
- Convert result set to array

Time Complexity  : O(n + m)
Space Complexity : O(n)

Why this works:
- HashSet provides O(1) lookup
- Duplicate elements are automatically ignored

Edge Cases:
- No common elements → return empty array
- All elements same → return single element
- Arrays of different sizes

--------------------------------------------------
Approach 2: Sorting + Two Pointer
--------------------------------------------------
- Sort both arrays
- Use two pointers to traverse both arrays
- If elements match → add to result (avoid duplicates manually)
- Move pointers accordingly

Time Complexity  : O(n log n + m log m)
Space Complexity : O(1) (excluding output)

Why this works:
- Sorting allows efficient comparison
- Two pointers reduce unnecessary checks

Edge Cases:
- Duplicate elements → handled using check before adding
- One array empty → return empty array

*/
package Arrays;
import java.util.*;
public class IntersectionOfArrays1 {

    // ------------------ HashSet Approach ------------------

    public int[] intersectionUsingHashSet(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        // Store elements of nums1
        for (int num : nums1) {
            set.add(num);
        }
        // Check elements of nums2
        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }
        // Convert set to array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        return result;
    }

    // ------------------ Two Pointer Approach ------------------

    public int[] intersectionUsingTwoPointers(int[] nums1, int[] nums2) {
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





