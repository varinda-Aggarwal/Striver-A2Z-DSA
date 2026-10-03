/*
Problem: Contains Duplicate II
Description: Given an integer array nums and an integer k, return true if there are two distinct indices i and j such that:
    nums[i] == nums[j]
and:
    |i - j| <= k
Otherwise, return false.

--------------------------------------------------
Approach: Optimal (HashMap)
--------------------------------------------------
- Use a HashMap to store each number along with its most recent index.
- Traverse the array from left to right.
- If the current number already exists in the map, calculate the difference between the current index and its previous index.
- If the difference is less than or equal to k, return true.
- Update the index of the current number in the map.
- We store the latest index because for the current index, the closest previous occurrence gives the smallest possible index difference.

Time Complexity  : O(n)
Space Complexity : O(n)

--------------------------------------------------

Edge Cases:

- No duplicate elements
- Duplicate elements within distance k
- Duplicate elements outside distance k
- k = 0
- Duplicate elements at adjacent indices
*/

package Arrays;
import java.util.HashMap;
public class ContainsDuplicateII {

    // ----------------------------------- Optimal Approach -----------------------------------

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Check if the current value has appeared before
            if (map.containsKey(nums[i])) {
               // Check the distance between duplicate indices
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // Store the latest index of the current value
            map.put(nums[i], i);
        }
        return false;
    }
}