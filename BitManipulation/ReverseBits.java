/*
Problem: Reverse Bits

Description:
Given a 32-bit integer, reverse its bits and return the result.

Approach:
- Initialize result as 0
- Iterate 32 times (for each bit)
- In each iteration:
    1. Left shift result by 1 → make space for next bit
    2. Extract last bit of n using (n & 1)
    3. Add it to result using OR operation
    4. Right shift n to process next bit

Time Complexity:
- O(32) → constant time

Space Complexity:
- O(1)

Key Insight:
- Extract bits from right and build result from left
*/

package BitManipulation;

public class ReverseBits {

    // Function to reverse bits of a 32-bit integer
    public static int reverseBits(int n) {
        int result = 0;
        
        // Loop through all 32 bits
        for(int i = 0; i < 32; i++) {
            result = result << 1;        // Shift result to left to make space
            result = result | (n & 1);   // Add last bit of n to result
            n = n >> 1;                  // Add last bit of n to result
        }
        return result;
    }
}