/*
Problem: Find Factorial of given Number using recursion

Approach:
- Base case: if n == 0, return 1
- Recursive case: return n * factorial(n - 1)

Time Complexity: O(n)
Space Complexity: O(n) (recursion stack)
*/


package Recursion;

public class FactorialOfNumber {
    public int factorial(int n) {
        if(n==0) return 1;        // base case
        return n*factorial(n-1);  // recursive call
    }
}
