/*
Problem: Swap Two Numbers Using XOR

Description:
Given two integers a and b, swap their values without using any extra variable.

Approach:
- Use XOR (^) operator properties:
    1. a = a ^ b
    2. b = a ^ b   → (a ^ b) ^ b = a
    3. a = a ^ b   → (a ^ b) ^ a = b

- After these operations, values of a and b are swapped.

Time Complexity:
- O(1)

Space Complexity:
- O(1)

Key Insight:
- XOR helps swap values without using a temporary variable
*/

package BitManipulation;

public class SwapUsingXOR {

    // Function to swap two numbers
    public static int[] swap(int a, int b) {

        // Step 1: XOR a and b, store in a
        a = a ^ b;

        // Step 2: XOR new a with b → gives original a
        b = a ^ b;

        // Step 3: XOR new a with new b → gives original b
        a = a ^ b;
        
        return new int[]{a, b};
    }
}