/*
Problem: Reverse Nodes in K-Group

Description:
Given the head of a linked list, reverse the nodes of
the list k at a time and return the modified list.
If remaining nodes are less than k, leave them as is.

--------------------------------------------------
 APPROACH : GROUP BY GROUP REVERSAL
--------------------------------------------------
 Traverse list group by group of size k.
 For each group count actual nodes available.
 If count equals k — reverse and connect to result.
 If count less than k — connect as is and stop.
 Use tail pointer to connect groups together.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Empty list          → return null
 - k equals 1         → return head unchanged
 - k equals list size  → reverse entire list
 - Last group < k      → leave as is
--------------------------------------------------
*/

package LinkedList;
public class ReverseKGroup {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;     // empty list
        
        ListNode temp = head;
        ListNode ans  = new ListNode(-100);
        ListNode tail = ans;
        
        while (temp != null) {
            int count = 1;
            ListNode curr = temp;
            // traverse k nodes or until end of list
            while (count != k && temp.next != null) {
                count++;
                temp = temp.next;
            }
            // save next group start
            ListNode nextNode = temp.next;
            temp.next = null;
            if (count == k) {
                // full group — reverse and connect
                ListNode reversed = reverse(curr);
                tail.next = reversed;
                while (tail.next != null) tail = tail.next;
                tail.next = nextNode;
            } 
            // last group smaller than k — leave as is
            else break;
            temp = nextNode;
        }
        return ans.next;
    }
}