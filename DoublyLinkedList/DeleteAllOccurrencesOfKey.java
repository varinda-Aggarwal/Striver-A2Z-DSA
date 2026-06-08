/*
Problem: Delete All Occurrences of Target in Doubly Linked List

Description:
Given the head of a doubly linked list and a target value,
delete all nodes with that value and return the head of
the modified list.

--------------------------------------------------
 APPROACH : SINGLE TRAVERSAL
--------------------------------------------------
 First handle all target nodes at head by moving head
 forward. Then traverse remaining list and skip any
 node whose value matches target by relinking prev
 and next pointers of surrounding nodes.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Empty list              → return null
 - All nodes are target    → return null
 - Target only at head     → return rest of list
 - Target only at tail     → return list without tail
--------------------------------------------------
*/

package DoublyLinkedList;
public class DeleteAllOccurrencesOfKey {
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        // remove all target nodes from head
        while (head != null && head.val == target) {
            head = head.next;
            if (head != null) head.prev = null;
        }

        // empty list after head removal
        if (head == null) return null;
        ListNode curr = head;

        // traverse and delete remaining target nodes
        while (curr != null && curr.next != null) {
            if (curr.next.val == target) {
                // skip target node
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