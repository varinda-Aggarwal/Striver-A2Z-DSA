/*
Problem: Missing Number

Description:
Given an array containing n distinct numbers in the range [0, n],
find the one number that is missing from the array.

--------------------------------------------------
Approach 1: Better (Sum Formula)
--------------------------------------------------
- Calculate expected sum of numbers from 0 to n:
      expectedSum = n * (n + 1) / 2
- Calculate actual sum of array elements
- Missing number = expectedSum - actualSum

Time Complexity  : O(n)
Space Complexity : O(1)

:- Limitation:
- Can cause integer overflow for large n
- To fix: use long instead of int

Edge Cases:
- Missing number is 0
- Missing number is n

--------------------------------------------------
Approach 2: Optimized (XOR)
--------------------------------------------------
- XOR all array elements and numbers from 1 to n
- Same numbers cancel out (a ^ a = 0)
- Remaining value is the missing number

Time Complexity  : O(n)
Space Complexity : O(1)

Edge Cases:
- Missing number is 0
- Missing number is n
*/

package Arrays;

public class MissingNumber {

    // ------------------ Sum Approach ------------------

    public int missingUsingSum(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for(int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    // ------------------ XOR Approach ------------------

    public int missingUsingXOR(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result = result ^ nums[i] ^ (i + 1);
        }
        return result;
    }
}