/*
Problem: Odd Even Linked List

Description:
Given the head of a singly linked list, group all nodes
with odd indices together followed by nodes with even
indices and return the reordered list.
First node is considered odd index (1-indexed).

--------------------------------------------------
 APPROACH : SEPARATE ODD EVEN LISTS
--------------------------------------------------
 Create two separate lists — one for odd indexed nodes
 and one for even indexed nodes. Traverse original list
 and add each node to respective list based on index.
 Finally connect odd list end to even list start.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(n) → new nodes created for each element

 Edge Cases:
 - Empty list        → return null
 - Single node       → return head
 - Two nodes         → return as is
--------------------------------------------------
*/

package LinkedList;
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        // dummy nodes for odd and even lists
        ListNode oddDummy  = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode odd  = oddDummy;
        ListNode even = evenDummy;
        ListNode temp  = head;
        int count = 1;
        // separate nodes into odd and even index lists
        while (temp != null) {
            ListNode newNode = new ListNode(temp.val);
            if (count % 2 != 0) {
                // odd index node
                odd.next = newNode;
                odd = odd.next;
            } else {
                // even index node
                even.next = newNode;
                even = even.next;
            }
            count++;
            temp = temp.next;
        }

        // connect odd list end to even list start
        odd.next = evenDummy.next;
        even.next = null;

        return oddDummy.next;
    }
}