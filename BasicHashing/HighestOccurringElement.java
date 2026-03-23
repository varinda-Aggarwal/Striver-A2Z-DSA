/*
Problem: Find the highest occurring (most frequent) element in an array

Approach:
We use a hash array (frequency array) to count occurrences of each element.

Steps:
1. Find the maximum element in the array
   → This determines the size of the hash array

2. Create a hash array of size (max + 1)
   → Each index represents the element
   → Value at index stores its frequency

3. Traverse the original array
   → Increment frequency: hashArray[nums[i]]++

4. Traverse the hash array
   → Keep track of:
       - maxValue (highest frequency)
       - idx (element with highest frequency)

5. Return the index (element) with maximum frequency

Base Case:
No explicit base case, but:
- If array is empty → behavior should be handled separately

Time Complexity: O(n + max)
Space Complexity: O(max)

Note:
- If multiple elements have same highest frequency,
  this returns the smallest one (due to left-to-right traversal)
- Works best when elements are non-negative and not too large
*/

package BasicHashing;

public class HighestOccurringElement {
    class Solution {
        public int mostFrequentElement(int[] nums) {
            // Step 1: find max element
            int max = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++)
            {
                max = Math.max(max,nums[i]);
            }

            // Step 2: Create Hash Array
            int[] hashArray = new int[max+1];
            for(int i=0;i<nums.length;i++)
            {
                hashArray[nums[i]]++;
            }

            int maxValue = 0;
            int idx = 0;

            // Step 3: Find element with highest frequency
            for(int i=0;i<hashArray.length;i++)
            {
                if(hashArray[i] > maxValue)
                {
                    maxValue = hashArray[i];
                    idx = i;
                }
            }

            return idx;
        }
    }
}