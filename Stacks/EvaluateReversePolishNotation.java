
/*
Problem: Evaluate Reverse Polish Notation (LeetCode 150)
Description: You are given an array of strings tokens that represents an arithmetic expression in Reverse Polish Notation (RPN). Evaluate the expression and return an integer representing its value.
Valid operators are '+', '-', '*', and '/'.

Note:
1. Division between two integers truncates toward zero.
2. The given expression is always valid.
3. There will not be any division by zero.

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9

Explanation: (2 + 1) * 3 = 9

Example 2:
Input: tokens = ["4","13","5","/","+"] 
Output: 6

Explanation: 4 + (13 / 5) = 6

Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]

Output: 22

--------------------------------------------------

Approach: Stack

Explanation:
1. Create a Stack of integers to store operands.
2. Traverse the tokens array from left to right.
3. If the current token is a number:
   - Convert it into an integer using Integer.parseInt().
   - Push it into the stack.
4. If the current token is an operator:
   - Pop the first operand (a) from the stack.
   - Pop the second operand (b) from the stack.
   - Perform the required operation:
     - Addition: b + a
     - Subtraction: b - a
     - Multiplication: b * a
     - Division: b / a
   - Push the result back into the stack.
5. After processing all tokens, the stack contains the final result.
6. Return the top element of the stack.

Time Complexity: O(n)
Space Complexity: O(n)

--------------------------------------------------
*/

package Stacks;
import java.util.Stack;
public class EvaluateReversePolishNotation {

    // ------------------------- Approach: Stack -------------------------

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            // Check if the current token is an operator
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")) {
                // Pop two operands
                int a = st.pop();
                int b = st.pop();

                int res = 0;

                // Perform the required operation
                if (tokens[i].equals("+")) {
                    res = b + a;
                }
                else if (tokens[i].equals("-")) {
                    res = b - a;
                }
                else if (tokens[i].equals("/")) {
                    res = b / a;
                }
                else {
                    res = b * a;
                }

                // Push the result back into the stack
                st.push(res);
            }
            else {
                // Convert string into integer and push
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
        }
        // Return the final result
        return st.peek();
    }
}
