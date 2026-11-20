
/*
Problem: Minimum Remove to Make Valid Parentheses (LeetCode 1249)
Description: Given a string containing '(' and ')' parentheses and lowercase English letters, remove the minimum number of parentheses to make the resulting string valid.

Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"

Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:
Input: s = "))(("
Output: ""

==================================================
Approach 1: Optimal (Using Stack + HashSet)

Explanation:
1. Create a Stack to store indices of opening brackets '('.
2. Create a HashSet to store indices of invalid brackets.
3. Pass 1: Traverse the original string.
   - If current character is '(': Push its index into the stack.
   - If current character is ')':
     - If stack is empty, store its index in HashSet.
     - Otherwise, pop the matching opening bracket.
4. After traversal, remaining indices in the stack represent unmatched opening brackets. Move them into the HashSet.
5. Pass 2: Traverse the original string again.
   - Skip indices present in the HashSet.
   - Append all remaining characters to StringBuilder.
6. Return the resulting string.

Time Complexity: O(n) average
Space Complexity: O(n)

==================================================
Approach 2: Optimal (Using Two Passes + StringBuilder)

Explanation:

Pass 1: Left to Right
1. Initialize countBrackets = 0.
2. Traverse the original string.
3. If current character is '(':
   - Append it to StringBuilder.
   - Increment countBrackets.
4. If current character is ')':
   - Append it only if countBrackets > 0.
   - Decrement countBrackets after appending.
5. Append all other characters directly. This removes invalid closing brackets.

Pass 2: Right to Left
1. Traverse the first StringBuilder from right to left.
2. If current character is '(' and countBrackets > 0:
   - Skip the character.
   - Decrement countBrackets.
3. Otherwise, append the character to the answer.
4. Reverse the final StringBuilder and return it.

This removes remaining invalid opening brackets.

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Stacks;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
public class MinRemoveToMakeValid {
    // Approach 1: Stack + HashSet
    public String minRemoveToMakeValidStack(String s) {
        StringBuilder str = new StringBuilder();

        // Stack to store indices of opening brackets
        Stack<Integer> st = new Stack<>();

        // HashSet to store indices of invalid brackets
        Set<Integer> set = new HashSet<>();

        // Pass 1: Identify invalid bracket indices
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') st.push(i);
            else if(ch == ')') {
                if(st.isEmpty()) set.add(i);
                else st.pop();
            }
        }

        // Remaining opening brackets are invalid
        while(!st.isEmpty()) {
            set.add(st.pop());
        }

        // Pass 2: Build the valid string
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(i)) continue;
            str.append(s.charAt(i));
        }
        return str.toString();
    }


    // Approach 2: Two Passes + StringBuilder
    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder();
        int countBrackets = 0;

        // Pass 1: Remove invalid closing brackets
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                str.append(ch);
                countBrackets++;
            }
            else if(ch == ')') {
                if(countBrackets > 0) {
                    str.append(ch);
                    countBrackets--;
                }
            }
            else str.append(ch);
        }

        StringBuilder ans = new StringBuilder();

        // Pass 2: Remove invalid opening brackets
        for(int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if(ch == '(' && countBrackets > 0) countBrackets--;
            else ans.append(ch);
        }
        return ans.reverse().toString();
    }
}
