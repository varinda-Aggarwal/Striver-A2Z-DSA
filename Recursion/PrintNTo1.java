/*
Problem: Print numbers from N to 1 using recursion
Approach:
- Base case: if n == 0, stop recursion
- Print n before recursive call
- Recursive call for n-1

Time Complexity: O(n)
Space Complexity: O(n) (due to recursion stack)
*/

package Recursion;
public class PrintNTo1 {
     public void printNumbers(int n) {
        if(n==0) return;   // base case

        System.out.println(n);  // print before call
        printNumbers(n-1);      // recursive call
    }
}
