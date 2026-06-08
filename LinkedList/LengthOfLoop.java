/*
Problem: Find Length of Loop in Linked List

Description:
Given the head of a linked list that may contain a cycle,
return the length of the cycle. If there is no cycle,
return 0.

--------------------------------------------------
 APPROACH : FLOYD'S ALGORITHM + LOOP COUNT
--------------------------------------------------
 Step 1 — Detect cycle using slow fast pointer.
           If fast meets slow, cycle exists.

 Step 2 — Count cycle length. Keep slow at meeting
           point and move it one step at a time
           counting steps until it comes back
           to meeting point.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only two pointers used

 Edge Cases:
 - Empty list        → return 0
 - No cycle          → return 0
 - Single node cycle → return 1
--------------------------------------------------
*/

package LinkedList;

public class LengthOfLoop {

    public int findLengthOfLoop(ListNode head) {
        if (head == null) return 0;         // empty list
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;       // move 1 step
            fast = fast.next.next;  // move 2 steps
            // cycle detected — count its length
            if (fast == slow) {
                count++;
                slow = slow.next;
                // move slow until it comes back to meeting point
                while (fast != slow) {
                    count++;
                    slow = slow.next;
                }
                break;
            }
        }
        return count;
    }
}