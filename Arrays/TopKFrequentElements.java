
/*
Problem: Top K Frequent Elements
Description: Given an integer array nums and an integer k, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

--------------------------------------------------

Approach: Optimal (Using HashMap + Bucket Sort)

Explanation:
1. Create a HashMap to store each number and its frequency.
2. Create a bucket array of size nums.length + 1. The index of each bucket represents the frequency.
3. Traverse the HashMap and place each number into the bucket corresponding to its frequency.
4. Traverse the buckets from highest frequency to lowest.
5. Add elements to the answer array until k elements have been collected.

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[k];        // Create answer array
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new ArrayList[nums.length + 1];    // Create buckets for every possible frequency

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>();    // Initialize bucket if it is null
        
            buckets[freq].add(key);                // Add number to its frequency bucket
        }

        int idx = 0;

        // Traverse buckets from highest frequency to lowest
        for (int freq = buckets.length - 1; freq >= 1 && idx < k; freq--) {
            if (buckets[freq] != null) {
                for (int num : buckets[freq]) {
                    ans[idx] = num;
                    idx++;
                    if (idx == k) break;
                }
            }
        }
        return ans;
    }
}
