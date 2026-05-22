/*
  Problem: Find Middle of Linked List
 
  Description:
  Given the head of a linked list, return the middle node.
  If there are two middle nodes, return the second middle node.
 
   APPROACH 1 : BRUTE FORCE (Two Traversals)
  --------------------------------------------------
   First find the length of the list. Then traverse to the (length/2)th node and return it.
 
   Time Complexity  : O(2n) → two separate traversals
   Space Complexity : O(1)  → no extra space used
 
   Edge Cases:
   - Empty list        → return null
   - Single node       → return head
   - Even length list  → return second middle node
 
  --------------------------------------------------
   APPROACH 2 : OPTIMAL (Slow Fast Pointer)
  --------------------------------------------------
   Move fast pointer 2 steps and slow pointer 1 step at a time. 
   When fast reaches end, slow will be at the middle node. Single traversal — no need to find length first.

   Time Complexity  : O(n) → single traversal
   Space Complexity : O(1) → only two pointers used
 
   Edge Cases:
   - Empty list        → return null
   - Single node       → return head
   - Even length list  → return second middle node 
 */

package LinkedList;


public class MiddleOfLinkedListBrute {

    //  ----------------------- BRUTE FORCE APPROACH -----------------------

    public ListNode middleNodeBrute(ListNode head) {
        if (head == null) return null;      // empty list
        int length = 0;                     // find length of list
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int mid = length / 2;           // traverse to middle node
        temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // -------------------------- OPTIMAL APPROACH ------------------------

    public ListNode middleNodeOptimal(ListNode head) {
        if (head == null) return null;        // empty list
        ListNode fast = head;
        ListNode slow = head;

        // fast moves 2 steps — slow moves 1 step
        // when fast reaches end — slow is at middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}