/*
Problem: Implement Stack Using Array

Description:
Implement a stack using an array. The stack follows the LIFO (Last In, First Out) principle.

Operations:
- push(x): Insert an element into the stack.
- pop(): Remove and return the top element.
- top(): Return the top element without removing it.
- isEmpty(): Check whether the stack is empty.

--------------------------------------------------

Approach: Array Implementation

- Use an array to store stack elements.
- Use a variable top to track the index of the top element.
- Initialize top = -1 because the stack is initially empty.
- Increment top before inserting an element.
- Decrement top after removing an element.

Time Complexity:
- push() : O(1)
- pop() : O(1)
- top() : O(1)
- isEmpty() : O(1)

Space Complexity: O(capacity)

--------------------------------------------------

Edge Cases:
- Popping from an empty stack.
- Accessing the top of an empty stack.
- Pushing when the stack is full.
*/

package StackAndQueueImplementation;

// ----------------------------------- Stack Using Array -----------------------------------

public class StackUsingArrays {
    int[] arr;
    int capacity;
    int top;

    public StackUsingArrays() {
        capacity = 1000;
        this.arr = new int[capacity];
        this.top = -1;
    }

    // ----------------------------------- Push -----------------------------------

    public void push(int x) {
        if (top == capacity - 1) {
            return;
        }
        top++;
        arr[top] = x;
    }

    // ----------------------------------- Pop -----------------------------------

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int val = arr[top];
        top--;
        return val;
    }

    // ----------------------------------- Top -----------------------------------

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }

    // ----------------------------------- Is Empty -----------------------------------

    public boolean isEmpty() {
        return top == -1;
    }
}