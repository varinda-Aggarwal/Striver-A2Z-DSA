
/*
Problem: Subarray Sums Divisible by K
Description: Given an integer array nums and an integer k, return the total number of non-empty subarrays whose sum is divisible by k.

Example 1:
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7

Example 2:
Input: nums = [-1,2,9], k = 2
Output: 2

--------------------------------------------------

Approach: Optimal (Using Prefix Sum + HashMap)

Explanation:
1. Maintain a running prefix sum while traversing the array.
2. Calculate the normalized remainder using: ((sum % k) + k) % k This handles negative prefix sums correctly.
3. If the same remainder has appeared before, the subarray between those prefix sums has a sum divisible by k.
4. Add the frequency of that remainder to count.
5. Update the frequency of the current remainder in the HashMap.
6. Initialize map with (0, 1) to handle subarrays starting from index 0.

Time Complexity: O(n) average
Space Complexity: O(min(n, k)) for positive k
*/

package Arrays;
import java.util.HashMap;
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {

        //---------------------------- Optimal approach: Prefix Sum + HashMap -----------------------------

        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            int rem = ((sum % k) + k) % k;                      // Normalize remainder to handle negative sums
            if (map.containsKey(rem)) count += map.get(rem);    // If remainder already exists, add its frequency
            map.put(rem, map.getOrDefault(rem, 0) + 1);         // Update frequency of the current remainder
        }
        return count;
    }
}
