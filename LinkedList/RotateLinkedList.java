/*
Problem: Rotate Linked List to the Right

Description:
Given the head of a linked list and an integer k,
rotate the list to the right by k places.

--------------------------------------------------
 APPROACH : TWO POINTER
--------------------------------------------------
 Find size of list. If k >= size, take k = k % size.
 Move fast pointer k steps ahead. Then move both
 slow and fast together until fast reaches last node.
 At this point slow is at (size-k)th node.
 Connect last node to head and break list at slow.

 Time Complexity  : O(n) → two traversals
 Space Complexity : O(1) → only two pointers used

 Edge Cases:
 - Empty list        → return null
 - Single node       → return head
 - k equals size     → return head unchanged
 - k is 0            → return head unchanged
--------------------------------------------------
*/

package LinkedList;
public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        // find size of list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        // empty or single node
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        // normalize k
        if (k >= size) k = k % size;

        // no rotation needed
        if (k == 0) return head;

        // move fast k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast != null) fast = fast.next;
        }

        // move both until fast reaches last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // connect last node to head
        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;

        return newHead;
    }
}