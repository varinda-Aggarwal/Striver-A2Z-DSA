/*
Problem: Subarray Sum Equals K

Description:
Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (Nested Loop)
--------------------------------------------------
 Check every possible subarray and count those whose sum equals k.

 Time Complexity  : O(n²) → nested loop
 Space Complexity : O(1)  → no extra space

 Edge Cases:
 - k = 0 → count subarrays with sum 0
 - Negative numbers → works correctly
 - Single element → works correctly
--------------------------------------------------

--------------------------------------------------
 APPROACH 2 : OPTIMAL (Prefix Sum + HashMap)
--------------------------------------------------
 Maintain prefix sum and store its frequency in HashMap. For every index check if (sum - k) exists in map.
 If yes that many subarrays ending here have sum k. Initialize map with {0, 1} to handle subarrays starting from index 0.

 Time Complexity : O(n) → single traversal
 Space Complexity : O(n) → HashMap stores prefix sums

 Edge Cases:
 - k = 0 → count subarrays with sum 0
 - Negative numbers → HashMap handles correctly
 - Single element → works correctly
--------------------------------------------------
*/

package Arrays;
import java.util.HashMap;
public class SubarraySumEqualsK{
    public int subarraySumBrute(int[] nums, int k) {
        int count = 0;
        // check every possible subarray
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                // subarray sum equals k — increment count
                if (sum == k) count++;
            }
        }
        return count;
    }

    public int subarraySumOptimal(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum   = 0;
        int count = 0;
        // base case — empty subarray has sum 0
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remaining = sum - k;
            // if remaining exists — that many subarrays end here with sum k
            if (map.containsKey(remaining)) {
                count += map.get(remaining);
            }
            // update frequency of current prefix sum
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } 
            else {
                map.put(sum, map.get(sum) + 1);
            }
        }
        return count;
    }
}