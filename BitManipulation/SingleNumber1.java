/*
Problem: Single Number

Description:
Given a non-empty array of integers where every element appears twice except for one,
find that single one.

Approach:
- Use XOR (^) operation:
    a ^ a = 0
    a ^ 0 = a
- When we XOR all elements:
    - Duplicate elements cancel out (become 0)
    - Only the unique element remains

Steps:
1. Initialize a variable (xor) = 0
2. Traverse the array
3. XOR each element with xor
4. Return the final value of xor

Time Complexity: O(n)
Space Complexity: O(1)
*/

package BitManipulation;

public class SingleNumber1 {
     public int singleNumber(int[] nums) {
        int uniqueElement = 0;
        // Traverse array and apply XOR
        for (int num : nums) {
            uniqueElement ^= num;
        }
        return uniqueElement;
    }
}
