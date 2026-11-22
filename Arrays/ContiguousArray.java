
/*
Problem: Contiguous Array (LeetCode 525)
Description: Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:
Input: nums = [0, 1]
Output: 2

Explanation: The entire array contains one 0 and one 1.

Example 2:
Input: nums = [0, 1, 0]
Output: 2

Explanation: The subarray [0, 1] contains equal number of 0 and 1.

Example 3:
Input: nums = [0, 0, 1, 0, 0, 0, 1, 1]
Output: 6

--------------------------------------------------
Approach: Optimal (Using Prefix Sum + HashMap)

Explanation:
1. Initialize sum = 0 and maxlen = 0.
2. Treat 0 as -1 and 1 as +1.
3. Traverse the array and update the running sum.
4. Store the prefix sum as key and its first occurrence index as value in HashMap.
5. Initially store (0, -1) to handle subarrays starting from index 0.
6. If the current sum already exists in the HashMap:
   - It means the subarray between the previous occurrence and current index has equal number of 0s and 1s.
   - Calculate length = i - map.get(sum).
   - Update maximum length.
7. Otherwise, store the current sum and index.
8. Return maxlen.

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Arrays;
import java.util.HashMap;
public class ContiguousArray {
    public int findMaxLength(int[] nums) {

        // ------------------------ Optimal Approach: Prefix Sum + HashMap ------------------------
        
        int maxlen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            // Treat 0 as -1 and 1 as +1
            if(nums[i] == 0) sum -= 1;
            else sum += 1;

            // Check whether the prefix sum already exists
            if(map.containsKey(sum)) maxlen = Math.max(maxlen, i - map.get(sum));
            else map.put(sum, i);
        }
        return maxlen;
    }
}
