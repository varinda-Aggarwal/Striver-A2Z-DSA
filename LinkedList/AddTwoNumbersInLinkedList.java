/*
Problem: Add Two Numbers

Description:
Given two non-empty linked lists representing two
non-negative integers stored in reverse order,
add the two numbers and return the sum as a linked list.

--------------------------------------------------
 APPROACH : SIMULATE ADDITION WITH CARRY
--------------------------------------------------
 Traverse both lists simultaneously adding digits
 and carry at each step. Create new node for each
 digit of result. Handle remaining carry at end.

 Time Complexity  : O(max(n, m)) → traverse both lists
 Space Complexity : O(max(n, m)) → result list

 Edge Cases:
 - Both lists empty     → return null
 - One list empty       → return other list
 - Carry remaining      → add extra node at end
--------------------------------------------------
*/

package LinkedList;

public class AddTwoNumbersInLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
            temp.next  = new ListNode(sum % 10);
            temp = temp.next;
        }
        return dummy.next;
    }
}