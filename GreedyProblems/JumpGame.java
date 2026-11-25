
/*
Problem: Jump Game (LeetCode 55)

Description:
You are given an integer array nums. You are initially positioned
at the first index of the array.

Each element represents the maximum jump length from that position.

Return true if you can reach the last index, otherwise return false.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true

Explanation:
Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false

Explanation:
You will always reach index 3, but its value is 0,
so you cannot reach the last index.

--------------------------------------------------

Approach 1: Better (Recursion + Memoization)

Explanation:
1. Start from index 0 and try every possible jump.
2. The maximum jump possible from the current index is nums[index].
3. Recursively check whether any jump can reach the last index.
4. Base case: If index reaches or crosses the last index,
   return true.
5. Store calculated results in the DP array:
   - 1 means reachable.
   - 0 means not reachable.
   - -1 means not calculated.
6. If any recursive call returns true, mark the current
   index as reachable.
7. If no jump works, mark it as unreachable.

Time Complexity: O(n^2)
Space Complexity: O(n) DP array + O(n) recursion stack

--------------------------------------------------

Approach 2: Optimal (Greedy)

Explanation:
1. Maintain maxReach, which stores the farthest index
   that can be reached so far.
2. Traverse the array from left to right.
3. If the current index i is greater than maxReach,
   it means we cannot reach this index, so return false.
4. Otherwise, update maxReach using:
   maxReach = Math.max(maxReach, i + nums[i])
5. If the loop completes, the last index is reachable.

Time Complexity: O(n)
Space Complexity: O(1)
*/

package GreedyProblems;
import java.util.Arrays;
public class JumpGame{

    // ------------------------- Approach 1: Recursion + Memoization ------------------------------

    public boolean isPossible(int[] nums, int index, int[] dp) {

        // Base case: reached or crossed the last index
        if (index >= nums.length - 1) {
            return true;
        }

        // Already calculated
        if (dp[index] != -1) {
            return dp[index] == 1;
        }

        // Try every possible jump
        for (int jump = 1; jump <= nums[index]; jump++) {
            if (isPossible(nums, index + jump, dp)) {
                dp[index] = 1;
                return true;
            }
        }

        // No possible jump can reach the last index
        dp[index] = 0;
        return false;
    }

    public boolean canJumpMemoization(int[] nums) {

        // --------------------- Better approach: Recursion + Memoization --------------------------

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);                 // Initially mark every index as unvisited
        return isPossible(nums, 0, dp);
    }


    // ----------------------------------- Approach 2: Greedy --------------------------------

    public boolean canJumpGreedy(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond maxReach we cannot reach this index
            if (i > maxReach) {
                return false;
            }

            // Update the farthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
