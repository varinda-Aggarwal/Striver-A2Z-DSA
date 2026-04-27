/*
  Problem: Majority Element
 
  Description:
  Given an array of size n, return the majority element.
  The majority element is the element that appears more
  than n/2 times. It is guaranteed that majority element
  always exists in the array.
 
  --------------------------------------------------
   APPROACH 1 : BRUTE FORCE
  --------------------------------------------------
   For every element, count its occurrences using a
   nested loop and track the element with maximum count.
 
   Time Complexity  : O(n²) → nested loop for every element
   Space Complexity : O(1)  → no extra space used
 
   Edge Cases:
   - Single element array   → that element is majority
   - All elements same      → that element is majority
  --------------------------------------------------
 
  --------------------------------------------------
   APPROACH 2 : BETTER (HashMap)
  --------------------------------------------------
   Store frequency of every element in a HashMap.
   Then traverse the map to find element with highest count.
 
   Time Complexity  : O(2n) → one pass to build map, one to find max
   Space Complexity : O(n)  → HashMap stores all distinct elements
 
   Edge Cases:
   - Single element array   → that element is majority
   - All elements same      → map has single entry
  --------------------------------------------------
 
  --------------------------------------------------
   APPROACH 3 : OPTIMAL (Moore's Voting Algorithm)
  --------------------------------------------------
   Maintain a candidate and a count.
   - If current element matches candidate, increment count
   - If count drops to 0, current element becomes new candidate
   - If current element does not match, decrement count
 
   Since majority element appears more than n/2 times,
   it can never be completely cancelled out — it will
   always survive as the final candidate.
 
   Time Complexity  : O(n) → single traversal
   Space Complexity : O(1) → only two variables used
 
   Edge Cases:
   - Single element array   → that element is majority
   - All elements same      → count keeps incrementing
  --------------------------------------------------
 */

package Arrays;
import java.util.HashMap;

public class MajorityElement {
//        ------------------- BRUTE APPROACH -------------------

    public int majorityElementBrute(int[] nums) {
        int maxCount = 0;
        int majorElement = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // count occurrences of nums[i]
            int count = 1;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            // update majority element if higher count found
            if (count > maxCount) {
                maxCount = count;
                majorElement = nums[i];
            }
        }
        return majorElement;
    }

//    ------------------- BETTER APPROACH -------------------

    public int majorityElementBetter(int[] nums) {
        // store frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // find element with highest frequency
        int maxCount = 0;
        int majorElement = Integer.MIN_VALUE;

        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) > maxCount) {
                maxCount = frequencyMap.get(num);
                majorElement = num;
            }
        }
        return majorElement;
    }

//     ------------------- OPTIMAL APPROACH -------------------

    public int majorityElementOptimal(int[] nums) {
        int candidate = nums[0];  // current majority candidate
        int count = 0;        // count of current candidate
        for (int num : nums) {
            if (num == candidate) {
                // current element matches candidate — strengthen it
                count++;
            } 
            else if (count == 0){
                // no strong candidate — pick current element
                candidate = num;
                count     = 1;

            } 
            else {
                // current element cancels one occurrence of candidate
                count--;
            }
        }
        // majority element always exists — candidate is the answer
        return candidate;
    }
}