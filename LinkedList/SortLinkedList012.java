/*
Problem: Sort Linked List of 0s, 1s and 2s

Description:
Given the head of a linked list consisting of only 0, 1 or 2, sort the list in ascending order. 
Do it in-place by relinking nodes without creating new nodes.

--------------------------------------------------
 APPROACH : THREE SEPARATE LISTS
--------------------------------------------------
 Create three dummy nodes for 0s, 1s and 2s. 
 Traverse original list and attach each node to its respective list directly without creating new nodes.
Finally connect three lists together.

 Time Complexity : O(n) → single traversal
 Space Complexity : O(1) → no new nodes created

 Edge Cases:
 - Empty list → return null
 - All same values  → return head unchanged
 - No 0s or no 2s → connect remaining lists
--------------------------------------------------
*/

package LinkedList;
public class SortLinkedList012 {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;

        // dummy nodes for three lists
        ListNode zeroDummy = new ListNode(-1);
        ListNode oneDummy  = new ListNode(-1);
        ListNode twoDummy  = new ListNode(-1);

        ListNode zero = zeroDummy;
        ListNode one = oneDummy;
        ListNode two = twoDummy;

        ListNode temp = head;

        // attach each node to respective list
        while (temp != null) {
            ListNode next = temp.next;  // save next before relinking
            if (temp.val == 0) {
                zero.next = temp;
                zero = zero.next;

            } 
            else if (temp.val == 1) {
                one.next = temp;
                one = one.next;

            } 
            else {
                two.next = temp;
                two = two.next;
            }
            temp = next;
        }

        // connect three lists together
        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next  = twoDummy.next;
        two.next  = null;

        // return first non empty list
        if (zeroDummy.next != null) return zeroDummy.next;
        if (oneDummy.next != null) return oneDummy.next;
        return twoDummy.next;
    }
}