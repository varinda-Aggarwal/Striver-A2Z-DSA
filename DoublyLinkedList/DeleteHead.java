/*
Problem: Delete Head in Doubly Linked List

Description:
Given the head of a doubly linked list, delete the
head node and return the new head.

--------------------------------------------------
 APPROACH : MOVE HEAD FORWARD
--------------------------------------------------
 Move head to next node and set its prev to null.
 Old head is automatically garbage collected.

 Time Complexity  : O(1) → direct deletion at front
 Space Complexity : O(1) → no extra space used

 Edge Cases:
 - Empty list        → return null
 - Single node       → return null
 - Two nodes         → second node becomes new head
--------------------------------------------------
*/

package DoublyLinkedList;

public class DeleteHead {
    public ListNode deleteHead(ListNode head) {
        if (head == null || head.next == null) return null; // empty list or single node
        head = head.next;             // move head to next node
        head.prev = null;         // remove prev pointer of new head
        return head;
    }
}