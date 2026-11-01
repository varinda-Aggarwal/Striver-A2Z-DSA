/*
Problem: Implement Queue Using Linked List

Description: Implement a queue using a singly linked list following the FIFO (First In, First Out) principle.

Operations:
- push(x): Insert an element at the rear of the queue.
- pop(): Remove and return the front element.
- peek(): Return the front element without removing it.
- isEmpty(): Check whether the queue is empty.

--------------------------------------------------

Approach: Linked List Implementation

- Each node stores data and a reference to the next node.
- head points to the front of the queue.
- rear points to the last element of the queue.
- push(): Insert a new node at the rear.
- pop(): Remove the node at the head.
- If the last node is removed, set both head and rear to null.

Time Complexity:
- push() : O(1)
- pop() : O(1)
- peek() : O(1)
- isEmpty() : O(1)

Space Complexity: O(n)

--------------------------------------------------

Edge Cases:
- Removing from an empty queue.
- Reading the front of an empty queue.
- Removing the last remaining element.
- Inserting into an empty queue.
*/

package StackAndQueueImplementation;

// ----------------------------------- Queue Using Linked List -----------------------------------

public class QueueUsingLinkedList {

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
    Node rear;

    public QueueUsingLinkedList() {
        this.head = null;
        this.rear = null;
    }

    // ----------------------------------- Push -----------------------------------

    public void push(int x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // ----------------------------------- Pop -----------------------------------

    public int pop() {
        if (head == null) {
            return -1;
        }

        int val = head.data;
        head = head.next;

        if (head == null) {
            rear = null;
        }

        return val;
    }

    // ----------------------------------- Peek -----------------------------------

    public int peek() {
        if (head == null) {
            return -1;
        }

        return head.data;
    }

    // ----------------------------------- Is Empty -----------------------------------

    public boolean isEmpty() {
        return head == null;
    }
}