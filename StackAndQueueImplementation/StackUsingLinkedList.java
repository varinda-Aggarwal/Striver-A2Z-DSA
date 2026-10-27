/*
Problem: Implement Stack Using Linked List

Description: Implement a stack using a singly linked list following the LIFO (Last In, First Out) principle.

Operations:
- push(x): Insert an element at the top of the stack.
- pop(): Remove and return the top element.
- top(): Return the top element without removing it.
- isEmpty(): Check whether the stack is empty.

--------------------------------------------------

Approach: Linked List Implementation

- Each node stores data and a reference to the next node.
- head points to the top element of the stack.
- push(): Insert a new node at the beginning.
- pop(): Remove the first node by updating head.
- size tracks the number of elements in the stack.

Time Complexity:
- push() : O(1)
- pop() : O(1)
- top() : O(1)
- isEmpty() : O(1)

Space Complexity: O(n)

--------------------------------------------------

Edge Cases:
- Popping from an empty stack.
- Accessing the top of an empty stack.
- Pushing multiple elements.
*/

package StackAndQueueImplementation;

// ----------------------------------- Stack Using Linked List -----------------------------------

public class StackUsingLinkedList {

    // ----------------------------------- Node Class -----------------------------------

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    int size = 0;
    public StackUsingLinkedList() {
        head = null;
    }

    // ----------------------------------- Push -----------------------------------

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // ----------------------------------- Pop -----------------------------------

    public int pop() {
        if (head == null) {
            return -1;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // ----------------------------------- Top -----------------------------------

    public int top() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    // ----------------------------------- Is Empty -----------------------------------

    public boolean isEmpty() {
        return size == 0;
    }
}