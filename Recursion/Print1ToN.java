/*
Problem: Print numbers from 1 to N using recursion
Approach:
- Base case: if n == 0, stop recursion
- Recursive call for n-1
- Print n after recursive call (backtracking phase)

Time Complexity: O(n)
Space Complexity: O(n) (due to recursion stack)
*/

package Recursion;

public class Print1ToN {
    public static void printNumbers(int n) {
        if (n == 0) return;   // base case

        printNumbers(n - 1);   // recursive call
        System.out.println(n);  // print after call
    }
}

