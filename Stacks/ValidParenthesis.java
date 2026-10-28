/*
Problem: Valid Parentheses

Description: Given a string s containing the characters '(', ')', '{', '}', '[' and ']', determine whether the input string is valid.

A string is valid if:
- Every opening bracket is closed by the same type of bracket.
- Brackets are closed in the correct order.
- Every closing bracket has a corresponding opening bracket.

Example 1:
Input  : s = "()"
Output : true

Example 2:
Input  : s = "()[]{}"
Output : true

Example 3:
Input  : s = "(]"
Output : false

--------------------------------------------------

Approach: Stack

- Traverse every character in the string.
- If it is an opening bracket, push it onto the stack.
- If it is a closing bracket:
  - If the stack is empty, return false.
  - Check whether the top opening bracket matches it.
  - If it matches, pop the opening bracket.
  - Otherwise, return false.
- At the end, the stack must be empty for the string to be valid.

Time Complexity  : O(n)
Space Complexity : O(n)

--------------------------------------------------

Edge Cases:
- Empty string.
- Only opening brackets.
- Only closing brackets.
- Mismatched brackets.
- Correctly nested brackets.
*/

package Stacks;
import java.util.Stack;

// ----------------------------------- Stack Approach -----------------------------------

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If opening bracket, push it onto the stack
            if (ch == '(' || ch == '[' || ch == '{') st.push(ch);

            // If closing bracket
            else {
                if (st.isEmpty()) return false;
                if ((st.peek() == '(' && ch == ')') 
                    || (st.peek() == '{' && ch == '}') 
                    || (st.peek() == '[' && ch == ']')) st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}