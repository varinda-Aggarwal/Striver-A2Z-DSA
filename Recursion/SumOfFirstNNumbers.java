/*
Problem: Find sum of first N natural numbers using recursion

Approach:
- Base case: if n == 0, return 0
- Recursive case: return n + sum(n - 1)

Time Complexity: O(n)
Space Complexity: O(n) (recursion stack)
*/
package Recursion;

public class SumOfFirstNNumbers {
    public int NnumbersSum(int N) {
        if(N<=0) return 0;  // base case
        return N+NnumbersSum(N-1);   // recursive call
    }
}
