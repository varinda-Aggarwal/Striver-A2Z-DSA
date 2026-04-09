/*
Problem: Check if ith Bit is Set

Description:
Given an integer n and an index i, check whether the ith bit is set (1) or not.

Approach:
- Left shift 1 by i positions → (1 << i)
- Perform AND operation with n
- If result is non-zero → ith bit is set
- Otherwise → ith bit is not set

Time Complexity:
- O(1)

Space Complexity:
- O(1)
*/

package BitManipulation;

public class CheckIthBit {

    // Function to check if ith bit is set
    public static boolean isIthBitSet(int n, int i) {

        return (n & (1 << i)) != 0;
    }
}