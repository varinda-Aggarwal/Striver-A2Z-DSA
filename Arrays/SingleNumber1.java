/*
Problem: Single Number

Description:
Given a non-empty array of integers nums, every element appears twice except for one.
Find that single one.

--------------------------------------------------
Approach 1: Better (HashMap - Frequency Count)
--------------------------------------------------
- Use a HashMap to store frequency of each element
- Traverse the array and count occurrences
- Traverse the map and return the element with frequency 1

Time Complexity  : O(n)
Space Complexity : O(n)

Why this works:
- HashMap helps track frequency efficiently
- The element with frequency 1 is the required answer

Limitations:
- Uses extra space

Edge Cases:
- Array contains only one element
- Negative numbers also allowed

--------------------------------------------------
Approach 2: Optimal (XOR)
--------------------------------------------------
- XOR all elements of the array
- Duplicate elements cancel out (a ^ a = 0)
- Remaining element is the answer

Time Complexity  : O(n)
Space Complexity : O(1)

Why this works:
- XOR properties:
    a ^ a = 0
    a ^ 0 = a
- All duplicate numbers cancel each other

Edge Cases:
- Works for all integer values
- Works even if numbers are large

*/

package Arrays;
import java.util.*;
public class SingleNumber1 {

    // ------------------ HashMap Approach ------------------

    public int singleNumberUsingHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Step 2: Find element with frequency 1
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1; // fallback (should not occur)
    }

    // ------------------ XOR Approach ------------------

    public int singleNumberUsingXOR(int[] nums) {
        int result = 0;
        // Step 1: XOR all elements
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}