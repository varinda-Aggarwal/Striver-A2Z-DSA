/*
Problem: Linked List Cycle Detection - Find Start of Cycle

Description:
Given the head of a linked list that may contain a cycle, return the node where the cycle begins.
If there is no cycle, return null.

--------------------------------------------------
 APPROACH : FLOYD'S ALGORITHM
--------------------------------------------------
 Step 1 — Detect cycle using slow fast pointer. If fast meets slow, cycle exists.

 Step 2 — Find cycle start. Reset one pointer to head. Move both one step at a time. Where they meet is the cycle start node.

 Why this works —
 Distance from head to cycle start equals distance from meeting point to cycle start. So both pointers reach cycle start at same time.

 Time Complexity : O(n) → single traversal
 Space Complexity : O(1) → only three pointers used

 Edge Cases:
 - Empty list → return null
 - No cycle → return null
 - Cycle at head → return head
--------------------------------------------------
*/

package LinkedList;

public class LinkedListCycleStart {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;        // empty list
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // move 2 steps
            slow = slow.next;       // move 1 step

            // cycle detected
            if (fast == slow) {
                // find cycle start
                // move temp from head and slow from meeting point
                // they will meet at cycle start
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        // no cycle
        return null;
    }
}