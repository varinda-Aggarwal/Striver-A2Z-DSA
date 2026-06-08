/*
Problem: Remove Duplicates from Sorted Doubly Linked List

Description:
Given the head of a sorted doubly linked list, remove
all duplicate nodes so that each value appears only once.
Return the head of the modified list.

--------------------------------------------------
 APPROACH : SINGLE TRAVERSAL
--------------------------------------------------
 Traverse the list and compare each node with its next.
 If values are equal, skip next node by relinking
 curr.next to curr.next.next and update prev pointer.
 If values differ, move curr forward.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Empty list           → return null
 - Single node          → return head
 - All nodes duplicate  → return single node
 - No duplicates        → return head unchanged
--------------------------------------------------
*/

package DoublyLinkedList;
public class RemoveDuplicates {
    public ListNode removeDuplicates(ListNode head) {
        // empty or single node
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // skip duplicate node
                curr.next = curr.next.next;
                if (curr.next != null) curr.next.prev = curr;

            } 
            else {
                curr = curr.next;
            }
        }
        return head;
    }
}