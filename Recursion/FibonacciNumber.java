/*
Problem: Find Fibonacci Number using recursion

Approach:
We use recursion to calculate the nth Fibonacci number.
For every recursive call:
    fib(n) = fib(n-1) + fib(n-2)

This means:
- We break the problem into two smaller subproblems
- Keep calling the function until we reach base cases

Base Case:
When n == 0 → return 0
When n == 1 → return 1

Time Complexity: O(2^n)  (Exponential, due to repeated calculations)
Space Complexity: O(n)   (Recursive call stack)
*/

package Recursion;

public class FibonacciNumber {
     public int fib(int n) {
        if(n==0) return 0;   // base case
        if(n==1) return 1;   // base case
        return fib(n-1) + fib(n-2);  // recursive call
    }
}