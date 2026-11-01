/*
Problem: Implement Queue Using Array

Description: Implement a queue using an array following the FIFO (First In, First Out) principle.

Operations:
- push(x): Insert an element at the rear of the queue.
- pop(): Remove and return the front element.
- peek(): Return the front element without removing it.
- isEmpty(): Check whether the queue is empty.

--------------------------------------------------

Approach: Array Implementation
- Use an array to store queue elements.
- front points to the first element.
- rear points to the last inserted element.
- Initially, front = rear = -1.
- On insertion, increment rear and insert the element.
- On removal, increment front.
- Reset both pointers to -1 when the queue becomes empty.

Note: This is a linear queue. Once rear reaches the last array index, unused spaces before front cannot be reused until the queue empties.

Time Complexity:
- push() : O(1)
- pop() : O(1)
- peek() : O(1)
- isEmpty() : O(1)

Space Complexity: O(capacity)

--------------------------------------------------

Edge Cases:
- Removing from an empty queue.
- Reading the front of an empty queue.
- Inserting into a full queue.
- Removing the last remaining element.
*/

package StackAndQueueImplementation;

// ----------------------------------- Array Queue -----------------------------------

public class QueueUsingArrays {
    int[] arr;
    int front;
    int rear;
    int size;

    public QueueUsingArrays() {
        this.size = 100;
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    // ----------------------------------- Push -----------------------------------

    public void push(int x) {
        if (rear == size - 1) return;
        if (front == -1) front = 0;
        rear++;
        arr[rear] = x;
    }

    // ----------------------------------- Pop -----------------------------------

    public int pop() {
        if (isEmpty()) return -1;
        int val = arr[front];
        if (front == rear) front = rear = -1; 
        else  front++;
        return val;
    }

    // ----------------------------------- Peek -----------------------------------

    public int peek() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    // ----------------------------------- Is Empty -----------------------------------

    public boolean isEmpty() {
        return front == -1;
    }
}