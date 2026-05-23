/*
Problem: Single Number II

Description:
Given an integer array where every element appears three times except for one element,
which appears exactly once. Find and return that single element.

--------------------------------------------------
 APPROACH : HASHMAP (Frequency Count)
--------------------------------------------------
 Store frequency of every element in HashMap. Return the element whose frequency is exactly 1.

 Time Complexity : O(2n) → one pass to build map, one to find answer
 Space Complexity : O(n)  → HashMap stores all elements

 Edge Cases:
 - Single element → return that element
 - All elements thrice → only one unique element exists
*/

package Arrays;
import java.util.HashMap;
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        // store frequency of every element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // return element with frequency 1
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }
}