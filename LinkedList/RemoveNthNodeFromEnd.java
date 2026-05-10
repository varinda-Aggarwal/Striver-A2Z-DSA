/*
  Problem: Remove Nth Node from End of Linked List
 
  Description:
  Given the head of a linked list and a number n,
  remove the nth node from the end of the list
  and return the head of the modified list.
 
  --------------------------------------------------
   APPROACH : TWO POINTERS
  --------------------------------------------------
   Move fast pointer n steps ahead. Then move both
   fast and slow together until fast reaches the last
   node. At this point slow is just before the node
   to be deleted — skip it using slow.next = slow.next.next.
 
   Special case — if fast is null after n steps, the
   head itself needs to be deleted, return head.next.
 
   Time Complexity  : O(n) → single traversal
   Space Complexity : O(1) → only two pointers used
 
   Edge Cases:
   - Delete head node     → fast becomes null after n steps
   - Single node list     → return null
   - n equals list length → delete head
  --------------------------------------------------
 */

package LinkedList;
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        // move fast pointer n steps ahead
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // if fast is null — head needs to be deleted
        if (fast == null) return head.next;

        // move both until fast reaches last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // skip the nth node from end
        slow.next = slow.next.next;
        return head;
    }
}