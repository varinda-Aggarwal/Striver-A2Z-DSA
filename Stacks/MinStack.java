
/*
Problem: Min Stack

Description: Design a stack that supports the following operations in O(1) time:
1. push(value): Push an element onto the stack.
2. pop(): Remove the top element.
3. top(): Return the top element.
4. getMin(): Return the minimum element in the stack.

--------------------------------------------------
Approach: Optimal (Using Two Stacks)

Explanation:
1. st stores all elements.
2. minStack stores the minimum elements.
3. During push, add the value to minStack if:
   - minStack is empty, or
   - value is less than or equal to the current minimum.
4. During pop, remove the value from st. If it matches the top of minStack, remove it from minStack too.
5. getMin() returns the top of minStack. The >= condition handles duplicate minimum values correctly.

Time Complexity:
push()  : O(1)
pop()   : O(1)
top()   : O(1)
getMin(): O(1)

Space Complexity: O(n)
*/

package Stacks;
import java.util.Stack;
public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element onto stack
    public void push(int value) {
        st.push(value);
        // Store value if it is the current minimum
        if (minStack.isEmpty() || minStack.peek() >= value) {
            minStack.push(value);
        }
    }

    // Remove top element
    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        int val = st.pop();
        // Remove from minStack if it is the current minimum
        if (!minStack.isEmpty() && minStack.peek() == val) {
            minStack.pop();
        }
    }

    // Return top element
    public int top() {
        return st.peek();
    }

    // Return minimum element
    public int getMin() {
        return minStack.peek();
    }
}
