/*
  Problem: Insert at End of Linked List
 
  Description:
  Given the head of a linked list and a value x, 
  insert a new node with value x at the end of the linked list and return the head.
 
   APPROACH : TRAVERSE TO LAST NODE
  --------------------------------------------------
   Create a new node with given value. 
   If list is empty return new node as head. Otherwise traverse to the last node and attach new node at the end.
 
   Time Complexity  : O(n) → traverse entire list to reach last node
   Space Complexity : O(1) → only one new node created
 
   Edge Cases:
   - Empty list  → new node becomes head
   - Single node → new node attached after existing node
  --------------------------------------------------
 */

package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class InsertAtEnd {
    public Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);         // create new node with given value
        if (head == null) return newNode;   // if list is empty new node becomes head

        // traverse to last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // attach new node at end
        temp.next = newNode;
        return head;
    }
}