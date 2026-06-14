/*
Problem: Reverse Even Length Groups in Linked List

Description:
Given the head of a linked list where nodes are assigned to groups of lengths 1, 2, 3, 4... reverse the nodes in each group with even length and return the head.

--------------------------------------------------
 APPROACH : GROUP BY GROUP TRAVERSAL
--------------------------------------------------
 Traverse list group by group. For each group count actual nodes available. 
 If count is even reverse that group in-place. If odd keep as is. Connect each group to result using ans pointer.

 Note — Group 1 is always size 1 (odd) so head never changes. Last group may be smaller than expected group size.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Empty list → return null
 - Single node → return head
 - Last group smaller → use actual count
 - Last group odd size → no reversal
--------------------------------------------------
*/

package LinkedList;
public class ReverseEvenLengthGroups {
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode agla = null;
        while (curr != null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null) return null;
        ListNode ans  = new ListNode(-100);
        ListNode temp = head;
        int i = 1;
        while (temp != null) {
            int count = 1;
            ListNode curr  = temp;
            // traverse i nodes or until end of list
            while (count != i && temp.next != null) {
                count++;
                temp = temp.next;
            }
            // save next group start
            ListNode nextNode = temp.next;
            temp.next = null;
            if (count % 2 == 0) {
                // even group — reverse and connect
                ListNode reversed = reverse(curr);
                ans.next = reversed;
                while (ans.next != null) ans = ans.next;
            }
            else {
                // odd group — connect as is
                ans.next = curr;
                while (ans.next != null) ans = ans.next;
            }
            temp = nextNode;
            i++;
        }
        return head;
    }
}