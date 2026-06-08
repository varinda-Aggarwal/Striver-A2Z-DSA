/*
Problem: Linked List Cycle Detection

Description:
Given the head of a linked list, determine if the linked list has a cycle in it. Return true if cycle exists, false otherwise.

--------------------------------------------------
 APPROACH : SLOW FAST POINTER (Floyd's Algorithm)
--------------------------------------------------
 Use two pointers — slow moves 1 step and fast moves 2 steps at a time.
If there is a cycle, fast will eventually meet slow inside the cycle. If fast reaches null, there is no cycle.

 Time Complexity : O(n) → single traversal
 Space Complexity : O(1) → only two pointers used

 Edge Cases:
 - Empty list → return false
 - Single node → return false
 - No cycle → return false
--------------------------------------------------
*/

package LinkedList;

public class DetectLoop {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // fast reaches null — no cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;        // move 1 step
            fast = fast.next.next;   // move 2 steps

            // fast met slow — cycle exists
            if (fast == slow) return true;
        }
        return false;
    }
}