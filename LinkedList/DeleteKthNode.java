/*
  Problem: Delete Every Kth Node from Linked List
 
  Description:
  Given the head of a linked list and a number k,
  delete every kth node from the linked list and
  return the head of the modified list.
 
  --------------------------------------------------
   APPROACH : TRAVERSE AND DELETE
  --------------------------------------------------
   Traverse to (k-1)th node, delete the kth node
   and move to next node. Repeat until end of list.
 
   Time Complexity  : O(n) → traverse entire list once
   Space Complexity : O(1) → no extra space used
 
   Edge Cases:
   - Empty list           → return null
   - k greater than list  → no deletion, return head
   - k equals 1           → delete all nodes, return null
   --------------------------------------------------
 */

package LinkedList;

public class DeleteKthNode {
    Node deleteK(Node head, int k) {
        if (head == null) return null;      // if empty list
        Node temp = head;
        while (temp!=null) {
            // traverse to (k-1)th node
            for (int i = 1; i < k - 1; i++) {
                if (temp == null) break;
                temp = temp.next;
            }
            if (temp == null || temp.next == null) break;  // end of list reached
            temp.next = temp.next.next;                    // delete kth node
            temp = temp.next;                        // move to next node for next iteration
        }
        return head;
    }
}