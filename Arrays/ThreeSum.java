/*
Problem: Three Sum

Description:
Given an integer array, return all triplets [nums[i], nums[j], nums[k]] such that i != j != k and nums[i] + nums[j] + nums[k] == 0.
The solution set must not contain duplicate triplets.

 APPROACH 1 : BRUTE FORCE (3 Nested Loops + Set)
--------------------------------------------------
 Check every possible triplet using three nested loops. Sort each triplet and add to HashSet to avoid duplicates. Convert set to list and return.

 Time Complexity  : O(n³) → three nested loops
 Space Complexity : O(n)  → HashSet stores triplets

 Edge Cases:
 - No valid triplet    → return empty list
 - All zeros → return [[0,0,0]]
--------------------------------------------------


 APPROACH 2 : BETTER (2 Loops + HashSet)
--------------------------------------------------
 For every pair (i, j) calculate required third value. Use HashSet to check if third value exists between i and j. Sort each triplet and add to set to avoid duplicates.

 Time Complexity  : O(n²) → two nested loops
 Space Complexity : O(n) → HashSet stores elements

 Edge Cases:
 - No valid triplet → return empty list
 - All zeros → return [[0,0,0]]

--------------------------------------------------


 APPROACH 3 : OPTIMAL (Sort + Two Pointer)
--------------------------------------------------
 Sort array. Fix one element and use two pointers for remaining two. Skip duplicates at each level to avoid duplicate triplets in result.

 Time Complexity  : O(n²) → sort + two pointer
 Space Complexity : O(1) → no extra space

 Edge Cases:
 - No valid triplet → return empty list
 - All zeros → return [[0,0,0]]
--------------------------------------------------
*/

package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    //  --------------------- Brute Force Approach ------------------

    public List<List<Integer>> threeSumBrute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>>  st  = new HashSet<>();
        // check every possible triplet
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        // sort to avoid duplicate triplets
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }
        ans.addAll(st);
        return ans;
    }

      //  --------------------- Better Approach ------------------

    public List<List<Integer>> threeSumBetter(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>>  st  = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int remaining = -(nums[i] + nums[j]);    // third value needed to make sum zero
                if (seen.contains(remaining)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(remaining);

                    // sort to avoid duplicate triplets
                    Collections.sort(temp);
                    st.add(temp);
                } 
                else {
                    seen.add(nums[j]);
                }
            }
        }
        ans.addAll(st);
        return ans;
    }

    //  --------------------- Optimal Approach ------------------

    public List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);     // step1: sort the array 
        int i = 0;
        while (i < nums.length) {
            // skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);

                    j++;
                    k--;

                    // skip duplicates for j
                    while (j < k && nums[j] == nums[j - 1]) j++;

                    // skip duplicates for k
                    while (j < k && nums[k] == nums[k + 1]) k--;

                } 
                else if (sum < 0) {
                    j++;
                } 
                else {
                    k--;
                }
            }
            i++;
        }
        return ans;
    }
}