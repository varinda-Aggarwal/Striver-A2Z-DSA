/*
Problem: Four Sum

Description:
Given an integer array and a target, return all unique quadruplets [nums[i], nums[j], nums[k], nums[l]] such that i, j, k, l are distinct and their sum equals target.

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (4 Nested Loops + Set)
--------------------------------------------------
 Check every possible quadruplet using four nested loops. Sort each quadruplet and add to HashSet to avoid duplicates.

 Time Complexity  : O(n⁴) → four nested loops
 Space Complexity : O(n)  → HashSet stores quadruplets

 Edge Cases:
 - No valid quadruplet  → return empty list
 - Duplicate values → HashSet handles duplicates

--------------------------------------------------
 APPROACH 2 : BETTER (3 Loops + HashSet)
--------------------------------------------------
 For every triplet (i, j, k) calculate required fourth value. 
 Use HashSet to check if fourth value exists. Sort each quadruplet and add to set to avoid duplicates.

 Time Complexity  : O(n³) → three nested loops
 Space Complexity : O(n) → HashSet stores elements

 Edge Cases:
 - No valid quadruplet → return empty list
 - Integer overflow → use long for sum

--------------------------------------------------
 APPROACH 3 : OPTIMAL (Sort + Two Pointer)
--------------------------------------------------
 Sort array. Fix two elements and use two pointers for remaining two. 
 Skip duplicates at each level to avoid duplicate quadruplets in result.

 Time Complexity  : O(n³) → sort + two pointer
 Space Complexity : O(1) → no extra space

 Edge Cases:
 - No valid quadruplet → return empty list
 - Integer overflow → use long for sum
--------------------------------------------------
*/

package Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class FourSum{

    // -------------------------- BRUTE FROCE APPROACH ---------------------------
    
    public List<List<Integer>> fourSumBrute(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> st  = new HashSet<>();
        // check every possible quadruplet
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            // sort to avoid duplicate quadruplets
                            Collections.sort(temp);
                            st.add(temp);
                        }
                    }
                }
            }
        }
        ans.addAll(st);
        return ans;
    }

     // --------------------------- BETTER APPROACH ------------------------------
    
    public List<List<Integer>> fourSumBetter(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>>  st  = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Set<Integer> seen = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) { 
                    long sum   = (long) nums[i] + nums[j] + nums[k];
                    long value = (long) target - sum;
                    // check if fourth value is valid integer and exists
                    if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE && seen.contains((int) value)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) value);
                        Collections.sort(temp);
                        st.add(temp);
                    } 
                    else {
                        seen.add(nums[k]);
                    }
                }
            }
        }
        ans.addAll(st);
        return ans;
    }

    // ----------------------------- OPTIMAL APPROACH ----------------------------------
    
    public List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // skip duplicates for i
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                // skip duplicates for j
                if (i + 1 < j && nums[j - 1] == nums[j]) continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        // skip duplicates for k
                        while (k < l && nums[k - 1] == nums[k]) k++;
                        // skip duplicates for l
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                    else if (sum > target) l--;
                    else k++;
                }
            }
        }
        return ans;
    }
}