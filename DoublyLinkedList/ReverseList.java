/*
Problem: Reverse a Doubly Linked List

Description:
Given the head of a doubly linked list, reverse the list in-place and return the new head.

--------------------------------------------------
 APPROACH : SWAP PREV AND NEXT POINTERS
--------------------------------------------------
 Traverse the list and swap prev and next pointers of every node. After full traversal, temp will be pointing to last node whose prev is the new head.

 Time Complexity : O(n) → single traversal
 Space Complexity : O(1) → only two pointers used

 Edge Cases:
 - Empty list → return null
 - Single node → return head
 - Two nodes → both pointers swapped
--------------------------------------------------
*/
package DoublyLinkedList;

public class ReverseList {
    public ListNode reverseDLL(ListNode head) {
        if (head == null || head.next == null) return head;     // empty list or single node
        ListNode temp = null;
        ListNode curr = head;
        while (curr != null) {
            // swap prev and next pointers
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // move to next node — which is now curr.prev after swap
            curr = curr.prev;
        }
        // temp.prev is the new head
        return temp.prev;
    }
}
