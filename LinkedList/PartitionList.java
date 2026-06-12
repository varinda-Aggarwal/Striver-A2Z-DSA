/*
Problem: Partition Linked List

Description:
Given the head of a linked list and a value x, 
partition the list such that all nodes with values less than x come before nodes with values greater than or equal to x.
Preserve the original relative order of nodes in each partition.

--------------------------------------------------
 APPROACH : TWO SEPARATE LISTS
--------------------------------------------------
 Create two separate lists — one for nodes smaller than x and one for nodes greater than or equal to x.
 Traverse original list and add each node to respective list. Finally connect smaller list to larger list.

 Time Complexity : O(n) → single traversal
 Space Complexity : O(n) → new nodes created

 Edge Cases:
 - Empty list → return null
 - All nodes smaller → return head unchanged
 - All nodes larger → return head unchanged
 - Single node → return head
*/

package LinkedList;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;             // empty list

        // dummy nodes for two lists
        ListNode smallDummy = new ListNode(-1);
        ListNode largeDummy = new ListNode(-1);
        ListNode small = smallDummy;
        ListNode large = largeDummy;
        ListNode curr = head;

        // add each node to respective list
        while (curr != null) {
            if (curr.val < x) {
                small.next = new ListNode(curr.val);
                small = small.next;
            } 
            else {
                large.next = new ListNode(curr.val);
                large = large.next;
            }
            curr = curr.next;
        }

        // connect small list to large list
        large.next = null;
        if (smallDummy.next != null) {
            small.next = largeDummy.next;
            return smallDummy.next;
        }
        return largeDummy.next;
    }
}