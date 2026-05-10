/*
  Problem: Insert at Front of Linked List

  Description:
  Given the head of a linked list and a value x,
  insert a new node with value x at the front of the linked list and return the new head.
 
  --------------------------------------------------
   APPROACH : NEW NODE AT FRONT
  --------------------------------------------------
   Create a new node with given value, point its next to current head, and return new node as new head.
 
   Time Complexity  : O(1) → direct insertion at front
   Space Complexity : O(1) → only one new node created
 
   Edge Cases:
   - Empty list    → new node becomes head
   - Single node   → new node inserted before existing node
 */

package LinkedList;

// node structure for linked list
class Node {
        int data;
        Node next;

        // contructor
        Node(int x) {
            data = x;
            next = null;
        }
    }

public class InsertAtHead {
    public Node insertAtFront(Node head, int x) {
        Node newNode = new Node(x);   // create new node with given value
        newNode.next = head;          // point new node to current head
        return newNode;               // new node is now the head
    }
}
