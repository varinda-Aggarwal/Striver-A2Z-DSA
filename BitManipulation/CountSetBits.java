/*
Problem: Count Set Bits

Description:
Given an integer n, count the number of set bits (1s) in its binary representation.

--------------------------------------------------
Approach 1: Brute Force (Right Shift)
--------------------------------------------------
- Check last bit using (n & 1)
- If it is 1 → increment count
- Right shift the number by 1
- Repeat until n becomes 0

Time Complexity:
- O(number of bits) → O(32)

Space Complexity:
- O(1)

--------------------------------------------------
Approach 2: Optimized (Brian Kernighan’s Algorithm)
--------------------------------------------------
- In each iteration:
    n = n & (n - 1)
- This removes the rightmost set bit
- Count how many times loop runs

Time Complexity:
- O(number of set bits)

Space Complexity:
- O(1)
*/

package BitManipulation;

public class CountSetBits {

    // ------------------ Brute Force Approach ------------------

    public static int countSetBitsBrute(int n) {
        int count = 0;
        while(n > 0) {
            // Check last bit
            if((n & 1) == 1) {
                count++;
            }
            // Right shift
            n = n >> 1;
        }
        return count;
    }

    // ------------------ Optimized Approach ------------------
    
    public static int countSetBitsOptimal(int n) {
        int count = 0;
        while(n > 0) {
            // Remove lowest set bit
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}