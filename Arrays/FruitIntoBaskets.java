/*
Problem: Fruit Into Baskets

Description: You are given an integer array fruits where fruits[i] represents the type of fruit in the ith tree. You have two baskets, and each basket can hold only one type of fruit. Starting from any tree, you must pick exactly one fruit from every tree while moving to the right.
Return the maximum number of fruits you can collect. In other words, find the longest contiguous subarray containing at most two distinct values.

--------------------------------------------------
Approach 1: Better
--------------------------------------------------
- Use a Sliding Window with a HashMap.
- The HashMap stores the frequency of each fruit type.
- Expand the window using the right pointer.
- If the window contains more than 2 fruit types, move the left pointer until the window becomes valid again.
- Update the maximum window length.

Time Complexity  : O(n)
Space Complexity : O(1) approximately (at most 3 fruit types in the window)

--------------------------------------------------
Approach 2: Most Optimized
--------------------------------------------------
- Use the same Sliding Window + HashMap approach.
- Instead of using a while loop, move the left pointer only once when the window contains more than 2 fruit types.
- Update maxLen only when the window is valid.

Time Complexity  : O(n)
Space Complexity : O(1) approximately

Why Most Optimized?
- Both approaches are O(n).
- The second approach avoids the inner while loop.
- The left pointer moves at most once for every right pointer move.
*/


package Arrays;
import java.util.HashMap;
public class FruitIntoBaskets {

    // ------------------------ Approach 1: Better: Sliding Window + HashMap + While -------------------------------
 
    public int totalFruitBetter(int[] fruits) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();   // Store frequency of fruit types
        int left = 0;

        // Expand window using right pointer
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);  // Add current fruit to the window

            // We can have at most two different fruit types. If there are more than two, shrink the window.
            while (map.size() > 2) {
                int remove = fruits[left];
                map.put(remove, map.get(remove) - 1);
                if (map.get(remove) == 0) map.remove(remove);  // Remove fruit type if its frequency becomes zero
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);   // Update maximum valid window
        }
        return maxLen;
    }


    // ------------------------ Approach 2: Most Optimized: Sliding Window + HashMap + If -------------------------

    public int totalFruit(int[] fruits) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();   // Store frequency of fruit types
        int left = 0;

        // Expand window using right pointer
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);   // Add current fruit

            // Update maximum only when the window contains at most two different fruit types.
            if (map.size() <= 2) maxLen = Math.max(maxLen, right - left + 1);

            // If we have more than two fruit types, move left only once.
            if (map.size() > 2) {
                int remove = fruits[left];
                map.put(remove, map.get(remove) - 1);
                if (map.get(remove) == 0) map.remove(remove);   // Remove fruit type if frequency becomes zero
                left++;
            }
        }
        return maxLen;
    }
}