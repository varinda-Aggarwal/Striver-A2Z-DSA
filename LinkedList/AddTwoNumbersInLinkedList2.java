/*
Problem: Add Two Numbers II

Description:
Given two non-empty linked lists representing two
non-negative integers stored in forward order,
add the two numbers and return the sum as a linked list
in forward order.

--------------------------------------------------
 APPROACH : REVERSE + ADD + REVERSE
--------------------------------------------------
 Step 1 — Reverse both lists so least significant
           digit comes first.
 Step 2 — Add digits with carry just like Add Two
           Numbers I.
 Step 3 — Reverse result list to get answer in
           forward order.

 Time Complexity  : O(n + m) → reverse + traverse + reverse
 Space Complexity : O(max(n, m)) → result list

 Edge Cases:
 - Both lists empty     → return null
 - One list empty       → return other list
 - Carry remaining      → add extra node at end
--------------------------------------------------
*/

package LinkedList;

public class AddTwoNumbersInLinkedList2{
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // step 1 — reverse both lists
        l1 = reverse(l1);
        l2 = reverse(l2);
        // edge cases
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // dummy node to simplify result list building
        ListNode dummy = new ListNode(0);
        ListNode temp  = dummy;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        // step 2 — add digits with carry
        while (temp1 != null || temp2 != null || carry != 0) {
            int sum = carry;
            // add digit from l1
            if (temp1 != null) {
                sum   = sum + temp1.val;
                temp1 = temp1.next;
            }
            // add digit from l2
            if (temp2 != null) {
                sum   = sum + temp2.val;
                temp2 = temp2.next;
            }
            // calculate carry and current digit
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        // step 3 — reverse result to get forward order
        return reverse(dummy.next);
    }
}