/*
Problem: Count frequencies of elements in an array using hashing

Approach:
We use a hash array (frequency array) to store how many times each element appears.

Steps:
1. First, find the maximum element in the array
   → This helps decide the size of the hash array.

2. Create a hash array of size (max + 1)
   → Each index represents the element
   → Value at index stores its frequency

3. Traverse the original array
   → For each element nums[i], increment hashArray[nums[i]]

4. Traverse the hash array
   → If frequency > 0, store:
       [element, frequency] in result list

Base Case:
No explicit base case, but:
- If array is empty → result will be empty list

Time Complexity: O(n + max)
Space Complexity: O(max)

Note:
This approach works efficiently when elements are non-negative and not too large.
*/

package BasicHashing;
import java.util.*;

public class CountingFrequencies{
    public List<List<Integer>> countFrequencies(int[] nums) {
        // step 1: Find max element
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

        //Step 3: Create Result List
        List<List<Integer>> result = new ArrayList<>();

        //Step 4: Fill result
        for(int i=0;i<hashArray.length;i++)
        {
            if(hashArray[i]>0)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);              // add element
                temp.add(hashArray[i]);   // add frequency
                result.add(temp);
            }
        }

        return result;
    }
}