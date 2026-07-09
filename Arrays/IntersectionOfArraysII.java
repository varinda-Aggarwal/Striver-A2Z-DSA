/*
Problem: Plus One

Description:
Given a large integer represented as an array of digits increment the integer by one and return the resulting array.

--------------------------------------------------
 APPROACH : TRAVERSE FROM END
--------------------------------------------------
 Traverse from last digit. If digit is less than 9 simply increment and return. If digit is 9 set it to 0 and carry over to next digit. If all digits are 9 create new array of size n+1 with 1 at front.

 Time Complexity  : O(n) → traverse entire array
 Space Complexity : O(1) → in-place modification
                    O(n)  → only if all digits are 9

 Edge Cases:
 - Last digit not 9 → increment and return
 - Last digit is 9 → carry propagates
 - All digits are 9 → new array of size n+1
--------------------------------------------------
*/

package Arrays;

public class IntersectionOfArraysII {
    public int[] plusOne(int[] nums) {
        // traverse from last digit
        for (int i = nums.length - 1; i >= 0; i--) {
            // digit less than 9 — just increment and return
            if (nums[i] < 9) {
                nums[i]++;
                return nums;
            }
            // digit is 9 — set to 0 and carry over
            nums[i] = 0;
        }
        // all digits were 9 — need extra digit at front
        int[] ans = new int[nums.length + 1];
        ans[0] = 1;
        return ans;
    }
}