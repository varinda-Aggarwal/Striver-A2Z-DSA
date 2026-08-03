/*
Problem: Remove Outermost Parentheses

Description:
A valid parentheses string is either empty "", "(" + A + ")" where A is a valid parentheses string, or A + B where A and B are valid parentheses strings.
A primitive valid parentheses string is a non-empty valid parentheses string that cannot be split into two non-empty valid parentheses strings.
Given a valid parentheses string s, remove the outermost parentheses of every primitive string and return the result.

Example 1:
Input  : "(()())(())"
Output : "()()()"

Explanation:
Primitive strings:
(()()) → ()()
(())   → ()

Result = "()()()"

Example 2:
Input  : "(()())(())(()(()))"
Output : "()()()()(())"

--------------------------------------------------
Approach 1: Brute Force (Stack)
--------------------------------------------------
- Use a stack to identify each primitive parentheses string.
- Simultaneously build the current primitive.
- Whenever the stack becomes empty, one primitive is complete.
- Remove its first and last parentheses.
- Append the remaining substring to the final answer.

Time Complexity  : O(n²)
Space Complexity : O(n)

--------------------------------------------------
Approach 2: Better (Counter + Primitive String)
--------------------------------------------------
- Replace the stack with a counter.
- Increment for '(' and decrement for ')'.
- Store characters of the current primitive.
- Whenever the counter becomes 0, one primitive is complete.
- Remove its first and last parentheses.
- Append the remaining part to the answer.

Time Complexity  : O(n)
Space Complexity : O(n)

--------------------------------------------------
Approach 3: Optimal (Counter Only)
--------------------------------------------------
- Maintain only the nesting depth (counter).
- Ignore the first '(' of every primitive.
- Ignore the last ')' of every primitive.
- Append every other parenthesis directly to the answer.

Time Complexity  : O(n)
Space Complexity : O(n)

Why Optimal?
- No stack is required.
- No temporary primitive string is created.
- Every character is processed exactly once.

Edge Cases:
- Single primitive: "()"
- Multiple primitive strings
- Deeply nested parentheses
- Consecutive primitive strings
*/

package Strings;
import java.util.Stack;
public class RemoveOutermostParentheses {

    // ------------------ Brute Force Approach ------------------

    public String removeOuterParenthesesBrute(String s) {
        Stack<Character> stack = new Stack<>();
        String currentPrimitive = "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                currentPrimitive += ch;
            }
            else {
                stack.pop();
                currentPrimitive += ch;
            }
            // Primitive completed
            if (stack.isEmpty()) {
                result += currentPrimitive.substring(1, currentPrimitive.length() - 1);
                currentPrimitive = "";
            }
        }
        return result;
    }

    // ------------------ Better Approach ------------------

    public String removeOuterParenthesesBetter(String s) {
        int depth = 0;
        StringBuilder primitive = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                depth++;
                primitive.append(ch);
            }
            else {
                depth--;
                primitive.append(ch);
            }
            // Primitive completed
            if (depth == 0) {
                result.append(primitive.substring(1, primitive.length() - 1));
                primitive.setLength(0);
            }
        }
        return result.toString();
    }

    // ------------------ Optimal Approach ------------------

    public String removeOuterParenthesesOptimal(String s) {
        int depth = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (depth > 0) {
                    result.append(ch);
                }
                depth++;
            }
            else {
                depth--;
                if (depth > 0) {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}