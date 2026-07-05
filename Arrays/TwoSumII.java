/*
Problem: Two Sum II - Input Array Is Sorted

Description:
Given a 1-indexed sorted array of integers and a target,
return indices of two numbers that add up to target.
Each input has exactly one solution and same element
cannot be used twice.

--------------------------------------------------
 APPROACH : TWO POINTER
--------------------------------------------------
 Since array is sorted use two pointers — one at
 start and one at end. If sum equals target return
 indices. If sum greater move right pointer back.
 If sum smaller move left pointer forward.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only two pointers used

 Edge Cases:
 - Always has exactly one solution
 - Return 1-indexed result
--------------------------------------------------
*/

package Arrays;
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i<j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};     // return 1-indexed result
            } 
            else if (numbers[i] + numbers[j] > target) {
                j--;        // sum too large — move right pointer back
            } 
            else {
                i++;        // sum too small — move left pointer forward
            }
        }
        return new int[]{-1, -1};
    }
}