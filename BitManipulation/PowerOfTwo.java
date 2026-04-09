/*
Problem: Check if a Number is Power of Two

Description:
Given an integer n, return true if it is a power of two.
Otherwise, return false.

Approach:
- A power of 2 has only one set bit in its binary representation
- For such numbers:
    n & (n - 1) == 0
- Also ensure n > 0 (to exclude 0 and negative numbers)

Time Complexity:
- O(1)

Space Complexity:
- O(1)

Key Insight:
- Power of 2 → only one set bit
*/

package BitManipulation;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}