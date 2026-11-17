
/*
Problem: Sum of Subarray Minimums

Description: Given an array of integers, find the sum of the minimum element of every possible subarray. Return the answer modulo 10^9 + 7.

Example 1:
Input: arr = [3, 1, 2, 4]
Output: 17

Explanation:
Subarrays and their minimums:
[3] -> 3
[1] -> 1
[2] -> 2
[4] -> 4
[3,1] -> 1
[1,2] -> 1
[2,4] -> 2
[3,1,2] -> 1
[1,2,4] -> 1
[3,1,2,4] -> 1

Total = 17

--------------------------------------------------
Approach: Optimal (Contribution Technique + Monotonic Stack)

Explanation:
1. Find the Previous Smaller Element (PSE) index for every element by traversing left to right.
2. Find the Next Smaller Element (NSE) index for every element by traversing right to left.
3. Calculate the number of possible subarrays in which arr[i] is the minimum.
   Left choices  = i - PSE[i]
   Right choices = NSE[i] - i
4. Calculate the contribution of every element: Contribution = arr[i] * Left choices * Right choices
5. Add all contributions and take modulo 10^9 + 7.

Note: For duplicate elements, use >= for PSE and > for NSE to avoid counting the same subarray more than once.

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Stacks;
import java.util.Stack;
public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int[] PSE = new int[arr.length];
        int[] NSE = new int[arr.length];
        int mod = 1000000007;

        Stack<Integer> pse = new Stack<>();

        // Find Previous Smaller Element indices
        for (int i = 0; i < arr.length; i++) {
            while (!pse.isEmpty() && arr[pse.peek()] >= arr[i]) {
                pse.pop();
            }

            if (pse.isEmpty()) PSE[i] = -1; 
            else PSE[i] = pse.peek();
            pse.push(i);
        }

        Stack<Integer> nse = new Stack<>();

        // Find Next Smaller Element indices
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!nse.isEmpty() && arr[nse.peek()] > arr[i]) {
                nse.pop();
            }

            if (nse.isEmpty()) NSE[i] = arr.length;
            else NSE[i] = nse.peek();
            nse.push(i);
        }

        // Calculate contribution of every element
        for (int i = 0; i < arr.length; i++) {
            int l = i - PSE[i];
            int r = NSE[i] - i;
            long contribution = ((long) arr[i] * l % mod * r % mod) % mod;
            sum = (sum + contribution) % mod;
        }
        return (int)sum;
    }
}
