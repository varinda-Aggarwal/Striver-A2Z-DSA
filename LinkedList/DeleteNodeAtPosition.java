/*
  Problem: Delete Node at Given Position in Linked List
 
  Description:
  Given the head of a linked list and a position x, delete the node at position x (1-indexed) 
  and return the head of the modified list.
 
  --------------------------------------------------
   APPROACH : TRAVERSE TO (x-1)th NODE
  --------------------------------------------------
   Traverse to the node just before the target position 
   and skip the target node by pointing next to next of next node.
 
   Time Complexity  : O(n) → traverse to (x-1)th node
   Space Complexity : O(1) → no extra space used
 
   Edge Cases:
   - Empty list          → return null
   - Delete head (x==1)  → return head.next
   - x out of range      → return head unchanged
  --------------------------------------------------
 */

package LinkedList;

public class DeleteNodeAtPosition {
    Node deleteNode(Node head, int x) {
        if (head == null) return null;      // if list is empty
        if (x == 1) return head.next;       // delete head node 
        int count = 1;
        Node temp = head;
        // traverse to (x-1)th node
        while (count<x-1 && temp!=null) {
            temp = temp.next;
            count++;
        }
        if (temp == null || temp.next == null) return head;   // if x is out of range
        temp.next = temp.next.next;     // skip the xth node
        return head;
    }
}