
/*
Problem: Continuous Subarray Sum (LeetCode 523)

Description:
Given an integer array nums and an integer k,
return true if nums has a continuous subarray of
at least two elements whose sum is a multiple of k.

Example 1:
Input: nums = [23, 2, 4, 6, 7], k = 6
Output: true

Explanation:
The subarray [2, 4] has sum = 6,
which is a multiple of 6.

Example 2:
Input: nums = [23, 2, 6, 4, 7], k = 13
Output: false

Example 3:
Input: nums = [23, 2, 4, 6, 7], k = 0
Output: false

--------------------------------------------------
Approach: Optimal (Using Prefix Sum + HashMap)

Explanation:
1. Initialize sum = 0.
2. Create a HashMap to store:
   Key: Prefix sum remainder
   Value: First occurrence index.

3. Initially store (0, -1) to handle subarrays
   starting from index 0.

4. Traverse the array and calculate running prefix sum.

5. If k != 0:
   Calculate rem = sum % k.

6. If k == 0:
   Use the prefix sum itself as the key.
   This checks whether a subarray has sum 0.

7. Check whether the remainder already exists:
   - If present, calculate subarray length.
   - If length >= 2, return true.
   - Otherwise, continue.

8. If remainder is not present:
   Store its first occurrence index.

9. Return false if no valid subarray exists.

Time Complexity: O(n) average
Space Complexity: O(n)
*/

package Arrays;

import java.util.HashMap;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        // ------------------------- Optimal Approach: Prefix Sum + HashMap ------------------------
        
        long sum = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long rem = (k == 0) ? sum : sum % k;               // Handle k = 0 separately
            if(map.containsKey(rem)) {
                if(i - map.get(rem) >= 2) return true;
            }
            else map.put(rem, i);
        }
        return false;
    }
}
