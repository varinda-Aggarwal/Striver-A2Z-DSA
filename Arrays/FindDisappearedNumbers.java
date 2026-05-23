/*
Problem: Find All Numbers Disappeared in an Array

Description:
Given an array of n integers where each integer is in range [1, n], 
return all the integers in range [1, n] that do not appear in the array.

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (Nested Loop)
--------------------------------------------------
 For every number from 1 to n, search the entire array to check if it exists. 
 If not found, add to result. Gives TLE on large inputs.

 Time Complexity  : O(n²) → nested loop
 Space Complexity : O(1) → no extra space

 Edge Cases:
 - All numbers present → return empty list
 - All numbers same → return all missing numbers

--------------------------------------------------
 APPROACH 2 : BETTER (HashMap)
--------------------------------------------------
 Store frequency of all elements in HashMap. 
 Then check which numbers from 1 to n are missing from the map.

 Time Complexity  : O(n) → two separate traversals
 Space Complexity : O(n) → HashMap stores all elements

 Edge Cases:
 - All numbers present   → return empty list
 - All numbers same → return all missing numbers
*/

package Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbersBrute(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        // check every number from 1 to n
        for (int i = 1; i <= nums.length; i++) {
            boolean found = false;
            // search entire array for current number
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) ans.add(i);
        }
        return ans;
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // store frequency of every element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // check which numbers from 1 to n are missing
        for (int i = 1; i <= nums.length; i++) {
            if (!frequencyMap.containsKey(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
