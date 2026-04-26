/*
Problem: Two Sum

Description:
Given an array of integers and a target, return the indices of the two numbers that add up to the target.
Each input has exactly one solution, and the same element cannot be used twice.

Note: Two pointer approach is also possible after sorting
      but it loses original indices unless we store them
      separately — making it more complex with no real
      benefit over the HashMap approach.

 --------------------------------------------------
   APPROACH 1 : BRUTE FORCE
--------------------------------------------------
 Check every possible pair in the array and return the indices of the pair that adds up to the target.
  Time Complexity  : O(n²) → nested loop over all pairs
  Space Complexity : O(1)  → no extra space used

  Edge Cases:
   - No valid pair exists     → return {-1, -1}
   - Array size less than 2   → return {-1, -1}
 --------------------------------------------------

 --------------------------------------------------
    APPROACH 2 : BETTER (HashMap)
 --------------------------------------------------
  For every element, we need (target - current element) to exist
  in the array. Instead of searching the whole array again,
  we store each element and its index in a HashMap as we go.
  This way we can check in O(1) if the required value exists.
 
  Time Complexity  : O(n)  → single traversal
  Space Complexity : O(n)  → HashMap stores n elements
 
  Edge Cases:
  - No valid pair exists     → return {-1, -1}
  - Array size less than 2   → return {-1, -1}
 --------------------------------------------------
 */

package Arrays;
import java.util.HashMap;
public class TwoSum {

         // -------------Brute Force approach ------------

    public int[] twoSum(int[] nums, int target) {
        // check every possible pair
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                // if pair sums to target return their indices
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // no valid pair found
        return new int[]{-1, -1};
    }
    
    
    // ------------- Better approach ------------
    
    public int[] twosum(int[] nums, int target) {
        // stores element value and its index
        HashMap<Integer, Integer> elementIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // value needed to reach target
            int complement = target - nums[i];
            // if complement already exists in map we found our pair
            if (elementIndexMap.containsKey(complement)) {
                return new int[]{i, elementIndexMap.get(complement)};
            }
            // store current element and its index for future lookups
            elementIndexMap.put(nums[i], i);
        }
        // no valid pair found
        return new int[]{-1, -1};
    }
}
