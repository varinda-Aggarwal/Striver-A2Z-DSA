/*
Problem: Union of Two Sorted Arrays

Description:
Given two sorted arrays, return their union as a sorted array
containing only distinct elements.
--------------------------------------------------
Approach 1: Brute Force (Tree Set)
--------------------------------------------------
- Use a TreeSet to store all elements from both arrays
- TreeSet automatically removes duplicates and maintains sorted order
- Convert the TreeSet back to an array and return

Time Complexity  : O((m + n) log(m + n))
Space Complexity : O(m + n)

Edge Cases:
- Both arrays empty  → return empty array
- One array empty    → return unique elements of other
- All elements equal → return single element array

--------------------------------------------------
Approach 2: Optimized (Two Pointer)
--------------------------------------------------
- Use two pointers i and j to traverse both sorted arrays
- At each step, pick the smaller element and add to result list
- If both elements are equal, add only once (skip duplicate)
- After main loop, append remaining elements of either array
- Before adding, check last element in list to skip duplicates

Time Complexity  : O(m + n)
Space Complexity : O(m + n)

Edge Cases:
- Both arrays empty  → return empty array
- One array empty    → return unique elements of other
- All elements equal → return single element array
*/

package Arrays;
import java.util.*;

public class UnionOfSortedArray {

    // ------------------ Brute Force Approach ------------------

    public int[] unionBruteForce(int[] nums1, int[] nums2) {
        // TreeSet automatically removes duplicates and sorts in ascending order
        Set<Integer> set = new TreeSet<>();

        // Add all elements of nums1 into set
        for (int num : nums1) {
            set.add(num);
        }
        // Add all elements of nums2 into set
        for (int num : nums2) {
            set.add(num);
        }
        // Convert set to result array
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index] = num;
            index++;
        }
        return result;
    }

    
    // ------------------ Optimized Approach ------------------

    public int[] unionOptimized(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2

        // Traverse both arrays until one is exhausted
        while (i < nums1.length && j < nums2.length) {
            // Both equal → add once (if not duplicate), advance both pointers
            if (nums1[i] == nums2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            } 
             // nums1's element is smaller → add it (if not duplicate), advance i
            else if (nums1[i] < nums2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
            } 
            // nums2's element is smaller → add it (if not duplicate), advance j
            else {
                if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
                    list.add(nums2[j]);
                }
                j++;
            }
        }

        // Add remaining elements of nums1 (skip duplicates)
        while (i < nums1.length) {
            if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                list.add(nums1[i]);
            }
            i++;
        }

        // Add remaining elements of nums2 (skip duplicates)
        while (j < nums2.length) {
            if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
                list.add(nums2[j]);
            }
            j++;
        }

        // Convert List<Integer> to int[] for final result
        int[] result = new int[list.size()];
        int k = 0;
        for (int num : list) {
            result[k] = num;
            k++;
        }
        return result;
    }
}