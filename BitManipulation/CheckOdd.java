/*
Problem: Check if a Number is Odd

Description:
Given an integer n, determine whether it is odd using bit manipulation.

Approach:
- Perform AND operation with 1
- If result is non-zero → number is odd
- If result is zero → number is even

Time Complexity:
- O(1)

Space Complexity:
- O(1)
*/

package BitManipulation;

public class CheckOdd {

    // Function to check if number is odd
    public static boolean isOdd(int n) {

        return (n & 1) != 0;
    }
}